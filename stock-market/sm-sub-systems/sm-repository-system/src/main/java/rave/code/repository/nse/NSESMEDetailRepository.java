package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSESMEDetailEntity;

import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

public class NSESMEDetailRepository extends AbstractNSERepositoryManager<NSESMEDetailEntity> {

    public NSESMEDetailRepository() {
        super(NSESMEDetailEntity.class);
    }

    @Override
    public List<NSESMEDetailEntity> findAll() {
        return this.findDistinctSMEDetails();
    }

    private List<NSESMEDetailEntity> findDistinctSMEDetails() {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSESMEDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSESMEDetailEntity.class);
        Root<NSESMEDetailEntity> root = criteriaQuery.from(NSESMEDetailEntity.class);

        // Sub query to get max created_date per symbol
        Subquery<Date> subQuery = criteriaQuery.subquery(Date.class);
        Root<NSESMEDetailEntity> subRoot = subQuery.from(NSESMEDetailEntity.class);
        Predicate symbolPredicate = criteriaBuilder.equal(subRoot.get("symbol"), root.get("symbol"));
        Expression<Date> createdDateExpression = subRoot.get("createdDate");
        subQuery.select(criteriaBuilder.greatest(createdDateExpression))
                .where(symbolPredicate);

        // Main query: select rows where createdDate = sub-query result
        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.get("createdDate"), subQuery));

        // If you want sorting:
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createdDate")));

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }
}
