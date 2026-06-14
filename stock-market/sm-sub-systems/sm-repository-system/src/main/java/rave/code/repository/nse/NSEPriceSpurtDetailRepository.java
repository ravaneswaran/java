package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;

import javax.persistence.criteria.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NSEPriceSpurtDetailRepository extends AbstractNSERepositoryManager<NSEPriceSpurtDetailEntity> {

    public NSEPriceSpurtDetailRepository() {
        super(NSEPriceSpurtDetailEntity.class);
    }

    public List<NSEPriceSpurtDetailEntity> findPriceSpurtsLWR20() {
        return this.findDistinctPriceSpurtDetails("STOCK-PRICE<20");
    }

    public List<NSEPriceSpurtDetailEntity> findPriceSpurtsGTR20() {
        return this.findDistinctPriceSpurtDetails("STOCK-PRICE>20");
    }

    public Map<String, List<NSEPriceSpurtDetailEntity>> findForMarketOnOpen(){

        CriteriaBuilder mainCriteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSEPriceSpurtDetailEntity> mainCriteriaQuery = mainCriteriaBuilder.createQuery(NSEPriceSpurtDetailEntity.class);
        Root<NSEPriceSpurtDetailEntity> mainRoot = mainCriteriaQuery.from(NSEPriceSpurtDetailEntity.class);

        mainCriteriaQuery.select(mainRoot);
        mainCriteriaQuery.orderBy(mainCriteriaBuilder.asc(mainRoot.get("symbol")));
        List<NSEPriceSpurtDetailEntity> nsePriceSpurtDetailEntities = this.getEntityManager().createQuery(mainCriteriaQuery).getResultList();

        Map<String, List<NSEPriceSpurtDetailEntity>> resultList = new HashMap<>();
        for (NSEPriceSpurtDetailEntity nsePriceSpurtDetailEntity : nsePriceSpurtDetailEntities){
            String symbol = nsePriceSpurtDetailEntity.getSymbol();
            CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
            CriteriaQuery<NSEPriceSpurtDetailEntity> criteriaQuery = mainCriteriaBuilder.createQuery(NSEPriceSpurtDetailEntity.class);
            Root<NSEPriceSpurtDetailEntity> root = criteriaQuery.from(NSEPriceSpurtDetailEntity.class);
            Predicate symbolPredicate = criteriaBuilder.equal(root.get("symbol"), symbol);
            criteriaQuery.select(root).where(symbolPredicate);
            List<NSEPriceSpurtDetailEntity> priceSpurtDetailEntities = this.getEntityManager().createQuery(criteriaQuery).getResultList();
            resultList.put(symbol, priceSpurtDetailEntities);
        }

        return resultList;
    }

    @Override
    public List<NSEPriceSpurtDetailEntity> findAll() {
        return this.findDistinctPriceSpurtDetails(null);
    }

    private List<NSEPriceSpurtDetailEntity> findDistinctPriceSpurtDetails(String spurtType) {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSEPriceSpurtDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEPriceSpurtDetailEntity.class);
        Root<NSEPriceSpurtDetailEntity> root = criteriaQuery.from(NSEPriceSpurtDetailEntity.class);

        // Sub query to get max created_date per symbol
        Subquery<Date> subQuery = criteriaQuery.subquery(Date.class);
        Root<NSEPriceSpurtDetailEntity> subRoot = subQuery.from(NSEPriceSpurtDetailEntity.class);

        Predicate symbolPredicate = criteriaBuilder.equal(subRoot.get("symbol"), root.get("symbol"));
        Expression<Date> createdDateExpression = subRoot.get("createdDate");

        // condition introduced for mail details...
        if(null != spurtType){
            Predicate spurtTypePredicate = criteriaBuilder.equal(root.get("spurtType"), spurtType);
            subQuery.select(criteriaBuilder.greatest(createdDateExpression))
                    .where(criteriaBuilder.and(spurtTypePredicate, symbolPredicate));
        } else {
            subQuery.select(criteriaBuilder.greatest(createdDateExpression))
                    .where(symbolPredicate);
        }

        // Main query: select rows where createdDate = sub-query result
        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.get("createdDate"), subQuery));

        // If you want sorting:
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createdDate")));

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<NSEPriceSpurtDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSEPriceSpurtDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEPriceSpurtDetailEntity.class);
        Root<NSEPriceSpurtDetailEntity> root = criteriaQuery.from(NSEPriceSpurtDetailEntity.class);

        Predicate symbolPredicate = criteriaBuilder.equal(root.get("symbol"), symbol);
        Predicate seriesPredicate = criteriaBuilder.equal(root.get("series"), "EQ");

        criteriaQuery.select(root).where(criteriaBuilder.and(symbolPredicate, seriesPredicate));
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("businessDate")));

        return this.getEntityManager().createQuery(criteriaQuery).setMaxResults(limit).getResultList();
    }

}