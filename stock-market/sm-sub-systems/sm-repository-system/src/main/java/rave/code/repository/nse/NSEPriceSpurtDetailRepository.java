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
        /*CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSEPriceSpurtDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEPriceSpurtDetailEntity.class);
        Root<NSEPriceSpurtDetailEntity> root = criteriaQuery.from(NSEPriceSpurtDetailEntity.class);
        Predicate spurtTypePredicate = criteriaBuilder.equal(root.get("spurtType"), "STOCK-PRICE<20");
        criteriaQuery.select(root).where(spurtTypePredicate);
        return this.getEntityManager().createQuery(criteriaQuery).getResultList();*/

        return this.findDistinctPriceSpurtDetails("STOCK-PRICE<20");
    }

    public List<NSEPriceSpurtDetailEntity> findPriceSpurtsGTR20() {
        /*CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSEPriceSpurtDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEPriceSpurtDetailEntity.class);
        Root<NSEPriceSpurtDetailEntity> root = criteriaQuery.from(NSEPriceSpurtDetailEntity.class);
        Predicate spurtTypePredicate = criteriaBuilder.equal(root.get("spurtType"), "STOCK-PRICE>20");
        criteriaQuery.select(root).where(spurtTypePredicate);
        return this.getEntityManager().createQuery(criteriaQuery).getResultList();*/

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

}