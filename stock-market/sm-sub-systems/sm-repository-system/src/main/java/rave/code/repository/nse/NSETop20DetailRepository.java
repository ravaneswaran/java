package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSETop20DetailEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class NSETop20DetailRepository extends AbstractNSERepositoryManager<NSETop20DetailEntity> {

    public NSETop20DetailRepository() {
        super(NSETop20DetailEntity.class);
    }

    public List<NSETop20DetailEntity> findTop20NiftyFifty(){
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSETop20DetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSETop20DetailEntity.class);
        Root<NSETop20DetailEntity> root = criteriaQuery.from(NSETop20DetailEntity.class);
        Predicate top20SubTypePredicate = criteriaBuilder.equal(root.get("top20SubType"), "NIFTY50");
        criteriaQuery.select(root).where(top20SubTypePredicate);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public List<NSETop20DetailEntity> findTop20NiftyNext50(){
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSETop20DetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSETop20DetailEntity.class);
        Root<NSETop20DetailEntity> root = criteriaQuery.from(NSETop20DetailEntity.class);
        Predicate top20SubTypePredicate = criteriaBuilder.equal(root.get("top20SubType"), "NIFTYNEXT50");
        criteriaQuery.select(root).where(top20SubTypePredicate);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public List<NSETop20DetailEntity> findTop20BankNifty(){
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSETop20DetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSETop20DetailEntity.class);
        Root<NSETop20DetailEntity> root = criteriaQuery.from(NSETop20DetailEntity.class);
        Predicate top20SubTypePredicate = criteriaBuilder.equal(root.get("top20SubType"), "BANKNIFTY");
        criteriaQuery.select(root).where(top20SubTypePredicate);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public List<NSETop20DetailEntity> findTop20SecurityLWR20(){
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSETop20DetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSETop20DetailEntity.class);
        Root<NSETop20DetailEntity> root = criteriaQuery.from(NSETop20DetailEntity.class);
        Predicate top20SubTypePredicate = criteriaBuilder.equal(root.get("top20SubType"), "SECURITY<20");
        criteriaQuery.select(root).where(top20SubTypePredicate);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public List<NSETop20DetailEntity> findTop20SecurityGTR20(){
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSETop20DetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSETop20DetailEntity.class);
        Root<NSETop20DetailEntity> root = criteriaQuery.from(NSETop20DetailEntity.class);
        Predicate top20SubTypePredicate = criteriaBuilder.equal(root.get("top20SubType"), "SECURITY>20");
        criteriaQuery.select(root).where(top20SubTypePredicate);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public List<NSETop20DetailEntity> findTop20FOSecurities(){
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSETop20DetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSETop20DetailEntity.class);
        Root<NSETop20DetailEntity> root = criteriaQuery.from(NSETop20DetailEntity.class);
        Predicate top20SubTypePredicate = criteriaBuilder.equal(root.get("top20SubType"), "FOSecurity");
        criteriaQuery.select(root).where(top20SubTypePredicate);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }
}
