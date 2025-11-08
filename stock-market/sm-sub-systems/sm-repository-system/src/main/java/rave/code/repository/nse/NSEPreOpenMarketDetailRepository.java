package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.entity.nse.csv.NSETop20DetailEntity;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NSEPreOpenMarketDetailRepository extends AbstractNSERepositoryManager<NSEPreOpenMarketDetailEntity> {

    public NSEPreOpenMarketDetailRepository() {
        super(NSEPreOpenMarketDetailEntity.class);
    }

    public Query getQuery(String preOpenType){
        String query = "SELECT * FROM NSEPreOpenMarketDetailEntity openMarketEntity WHERE openMarketEntity.preOpenType = :preOpenType";
        Query preOpenMarketDetailQuery = this.getEntityManager().createQuery(query);
        preOpenMarketDetailQuery.setParameter("preOpenType", preOpenType);

        return preOpenMarketDetailQuery;
    }

    public List<NSEPreOpenMarketDetailEntity> findPreOpenMarketFOs(){
        return this.findPreOpenMarketDetails("FO");
    }

    public List<NSEPreOpenMarketDetailEntity> findPreOpenMarketOthers(){
        return this.findPreOpenMarketDetails("OTHERS");
    }

    public List<NSEPreOpenMarketDetailEntity> findPreOpenMarketSMEs(){
        return this.findPreOpenMarketDetails("SME");
    }

    public List<NSEPreOpenMarketDetailEntity> findPreOpenMarketBankNiftys(){
        return this.findPreOpenMarketDetails("BANKNIFTY");
    }

    public List<NSEPreOpenMarketDetailEntity> findPreOpenMarketNIfty50s(){
        return this.findPreOpenMarketDetails("NIFTY");
    }

    private List<NSEPreOpenMarketDetailEntity> findPreOpenMarketDetails(String preOpenType){

        Date from = null;
        Date to = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowString = simpleDateFormat.format(new Date());
        String nowStringWithOutTime = nowString.split(" ")[0];
        String todayMorningAt_09_00 = String.format("%s %s", nowStringWithOutTime, "09:00:00");
        String todayMorningAt_09_08 = String.format("%s %s", nowStringWithOutTime, "09:08:00");
        try {
            from = simpleDateFormat.parse(todayMorningAt_09_00);
            to = simpleDateFormat.parse(todayMorningAt_09_08);

            CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
            CriteriaQuery<NSEPreOpenMarketDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEPreOpenMarketDetailEntity.class);
            Root<NSEPreOpenMarketDetailEntity> root = criteriaQuery.from(NSEPreOpenMarketDetailEntity.class);
            Predicate preOpenMarketTypePredicate = criteriaBuilder.equal(root.get("preOpenType"), preOpenType);
            //Predicate createdDatePredicate = criteriaBuilder.between(root.get("createdDate"), from, to);
            //Predicate indicativeEquilibriumPricePredicate = criteriaBuilder.lessThanOrEqualTo(root.get("indicativeEquilibriumPrice"), 20);
            //Predicate finalPricePredicate = criteriaBuilder.greaterThan(root.get("finalPrice"), 0);
            //Predicate pricePercentageChangePredicate = criteriaBuilder.greaterThan(root.get("pricePercentageChange"), 0);
            //Predicate whereClausePredicate = criteriaBuilder.and(preOpenMarketTypePredicate, createdDatePredicate);
            //Predicate whereClausePredicate = criteriaBuilder.and(preOpenMarketTypePredicate, createdDatePredicate, indicativeEquilibriumPricePredicate, finalPricePredicate, pricePercentageChangePredicate);
            criteriaQuery.select(root).where(preOpenMarketTypePredicate).orderBy(criteriaBuilder.asc(root.get("pricePercentageChange")));

            return this.getEntityManager().createQuery(criteriaQuery).getResultList();

        } catch (ParseException exception) {
            return new ArrayList<>();
        }
    }
}
