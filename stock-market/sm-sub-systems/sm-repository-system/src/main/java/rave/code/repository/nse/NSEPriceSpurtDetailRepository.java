package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;

import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

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

    private List<NSEPriceSpurtDetailEntity> findDistinctPriceSpurtDetails(String spurtType) {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSEPriceSpurtDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEPriceSpurtDetailEntity.class);
        Root<NSEPriceSpurtDetailEntity> root = criteriaQuery.from(NSEPriceSpurtDetailEntity.class);

        // Sub query to get max created_date per symbol
        Subquery<Date> subQuery = criteriaQuery.subquery(Date.class);
        Root<NSEPriceSpurtDetailEntity> subRoot = subQuery.from(NSEPriceSpurtDetailEntity.class);
        Predicate spurtTypePredicate = criteriaBuilder.equal(root.get("spurtType"), spurtType);
        Predicate symbolPredicate = criteriaBuilder.equal(subRoot.get("symbol"), root.get("symbol"));
        Expression<Date> createdDateExpression = subRoot.get("createdDate");
        subQuery.select(criteriaBuilder.greatest(createdDateExpression))
                .where(criteriaBuilder.and(spurtTypePredicate, symbolPredicate));

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