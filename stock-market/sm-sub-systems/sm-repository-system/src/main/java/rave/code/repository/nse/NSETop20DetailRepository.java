package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSETop20DetailEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NSETop20DetailRepository extends AbstractNSERepositoryManager<NSETop20DetailEntity> {

    private Date from;
    private Date to;

    public NSETop20DetailRepository() {
        super(NSETop20DetailEntity.class);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowString = simpleDateFormat.format(new Date());
        String nowStringWithOutTime = nowString.split(" ")[0];
        String todayMorningAt_09_15 = String.format("%s %s", nowStringWithOutTime, "09:15:00");
        String todayNoonAt_13_30 = String.format("%s %s", nowStringWithOutTime, "13:30:00");
        try {
            this.from = simpleDateFormat.parse(todayMorningAt_09_15);
            this.to = simpleDateFormat.parse(todayNoonAt_13_30);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<NSETop20DetailEntity> findTop20NiftyFifty() {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSETop20DetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSETop20DetailEntity.class);
        Root<NSETop20DetailEntity> root = criteriaQuery.from(NSETop20DetailEntity.class);
        Predicate top20SubTypePredicate = criteriaBuilder.equal(root.get("top20SubType"), "NIFTY50");
        Predicate createdDatePredicate = criteriaBuilder.between(root.get("createdDate"), this.from, this.to);
        Predicate whereClausePredicate = criteriaBuilder.and(top20SubTypePredicate, createdDatePredicate);
        criteriaQuery.select(root).where(whereClausePredicate);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public List<NSETop20DetailEntity> findTop20NiftyNext50() {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSETop20DetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSETop20DetailEntity.class);
        Root<NSETop20DetailEntity> root = criteriaQuery.from(NSETop20DetailEntity.class);
        Predicate top20SubTypePredicate = criteriaBuilder.equal(root.get("top20SubType"), "NIFTYNEXT50");
        Predicate createdDatePredicate = criteriaBuilder.between(root.get("createdDate"), this.from, this.to);
        Predicate whereClausePredicate = criteriaBuilder.and(top20SubTypePredicate, createdDatePredicate);
        criteriaQuery.select(root).where(whereClausePredicate);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public List<NSETop20DetailEntity> findTop20BankNifty() {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSETop20DetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSETop20DetailEntity.class);
        Root<NSETop20DetailEntity> root = criteriaQuery.from(NSETop20DetailEntity.class);
        Predicate top20SubTypePredicate = criteriaBuilder.equal(root.get("top20SubType"), "BANKNIFTY");
        Predicate createdDatePredicate = criteriaBuilder.between(root.get("createdDate"), this.from, this.to);
        Predicate whereClausePredicate = criteriaBuilder.and(top20SubTypePredicate, createdDatePredicate);
        criteriaQuery.select(root).where(whereClausePredicate);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public List<NSETop20DetailEntity> findTop20SecurityLWR20() {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSETop20DetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSETop20DetailEntity.class);
        Root<NSETop20DetailEntity> root = criteriaQuery.from(NSETop20DetailEntity.class);
        Predicate top20SubTypePredicate = criteriaBuilder.equal(root.get("top20SubType"), "SECURITY<20");
        Predicate createdDatePredicate = criteriaBuilder.between(root.get("createdDate"), this.from, this.to);
        Predicate whereClausePredicate = criteriaBuilder.and(top20SubTypePredicate, createdDatePredicate);
        criteriaQuery.select(root).where(whereClausePredicate);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public List<NSETop20DetailEntity> findTop20SecurityGTR20() {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSETop20DetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSETop20DetailEntity.class);
        Root<NSETop20DetailEntity> root = criteriaQuery.from(NSETop20DetailEntity.class);
        Predicate top20SubTypePredicate = criteriaBuilder.equal(root.get("top20SubType"), "SECURITY>20");
        Predicate createdDatePredicate = criteriaBuilder.between(root.get("createdDate"), this.from, this.to);
        Predicate whereClausePredicate = criteriaBuilder.and(top20SubTypePredicate, createdDatePredicate);
        criteriaQuery.select(root).where(whereClausePredicate);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public List<NSETop20DetailEntity> findTop20FOSecurities() {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSETop20DetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSETop20DetailEntity.class);
        Root<NSETop20DetailEntity> root = criteriaQuery.from(NSETop20DetailEntity.class);
        Predicate top20SubTypePredicate = criteriaBuilder.equal(root.get("top20SubType"), "FOSecurity");
        Predicate createdDatePredicate = criteriaBuilder.between(root.get("createdDate"), this.from, this.to);
        Predicate whereClausePredicate = criteriaBuilder.and(top20SubTypePredicate, createdDatePredicate);
        criteriaQuery.select(root).where(whereClausePredicate);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }
}
