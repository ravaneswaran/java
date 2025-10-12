package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class NSEPriceSpurtDetailRepository extends AbstractNSERepositoryManager<NSEPriceSpurtDetailEntity> {

    public NSEPriceSpurtDetailRepository() {
        super(NSEPriceSpurtDetailEntity.class);
    }

    public List<NSEPriceSpurtDetailEntity> findPriceSpurtsLWR20() {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSEPriceSpurtDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEPriceSpurtDetailEntity.class);
        Root<NSEPriceSpurtDetailEntity> root = criteriaQuery.from(NSEPriceSpurtDetailEntity.class);
        Predicate spurtTypePredicate = criteriaBuilder.equal(root.get("spurtType"), "STOCK-PRICE<20");
        criteriaQuery.select(root).where(spurtTypePredicate);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public List<NSEPriceSpurtDetailEntity> findPriceSpurtsGTR20() {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSEPriceSpurtDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEPriceSpurtDetailEntity.class);
        Root<NSEPriceSpurtDetailEntity> root = criteriaQuery.from(NSEPriceSpurtDetailEntity.class);
        Predicate spurtTypePredicate = criteriaBuilder.equal(root.get("spurtType"), "STOCK-PRICE>20");
        criteriaQuery.select(root).where(spurtTypePredicate);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

}