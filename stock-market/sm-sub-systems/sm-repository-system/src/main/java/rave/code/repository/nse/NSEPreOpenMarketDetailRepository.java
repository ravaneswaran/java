package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NSEPreOpenMarketDetailRepository extends AbstractNSERepositoryManager<NSEPreOpenMarketDetailEntity> {

    public NSEPreOpenMarketDetailRepository() {
        super(NSEPreOpenMarketDetailEntity.class);
    }

    public Query getQuery(String preOpenType) {
        String query = "SELECT * FROM NSEPreOpenMarketDetailEntity openMarketEntity WHERE openMarketEntity.preOpenType = :preOpenType";
        Query preOpenMarketDetailQuery = this.getEntityManager().createQuery(query);
        preOpenMarketDetailQuery.setParameter("preOpenType", preOpenType);

        return preOpenMarketDetailQuery;
    }

    public List<NSEPreOpenMarketDetailEntity> findPreOpenMarketFOs() {
        return this.findDistinctPreOpenMarketDetails("FO");
    }

    public List<NSEPreOpenMarketDetailEntity> findPreOpenMarketOthers() {
        return this.findDistinctPreOpenMarketDetails("OTHERS");
    }

    public List<NSEPreOpenMarketDetailEntity> findPreOpenMarketSMEs() {
        return this.findDistinctPreOpenMarketDetails("SME");
    }

    public List<NSEPreOpenMarketDetailEntity> findPreOpenMarketBankNiftys() {
        return this.findDistinctPreOpenMarketDetails("BANKNIFTY");
    }

    public List<NSEPreOpenMarketDetailEntity> findPreOpenMarketNIfty50s() {
        return this.findDistinctPreOpenMarketDetails("NIFTY");
    }

    private List<NSEPreOpenMarketDetailEntity> findPreOpenMarketDetails(String preOpenType) {

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

    private List<NSEPreOpenMarketDetailEntity> findDistinctPreOpenMarketDetails(String preOpenType) {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSEPreOpenMarketDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEPreOpenMarketDetailEntity.class);
        Root<NSEPreOpenMarketDetailEntity> root = criteriaQuery.from(NSEPreOpenMarketDetailEntity.class);

        // Sub query to get max created_date per symbol
        Subquery<Date> subQuery = criteriaQuery.subquery(Date.class);
        Root<NSEPreOpenMarketDetailEntity> subRoot = subQuery.from(NSEPreOpenMarketDetailEntity.class);
        Predicate preOpenMarketTypePredicate = criteriaBuilder.equal(root.get("preOpenType"), preOpenType);
        Predicate symbolPredicate = criteriaBuilder.equal(subRoot.get("symbol"), root.get("symbol"));
        Expression<Date> createdDateExpression = subRoot.get("createdDate");
        subQuery.select(criteriaBuilder.greatest(createdDateExpression))
                .where(criteriaBuilder.and(preOpenMarketTypePredicate, symbolPredicate));

        // Main query: select rows where createdDate = sub-query result
        criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.get("createdDate"), subQuery));

        // If you want sorting:
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createdDate")));

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<NSEPreOpenMarketDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return new ArrayList<>();
    }
}
