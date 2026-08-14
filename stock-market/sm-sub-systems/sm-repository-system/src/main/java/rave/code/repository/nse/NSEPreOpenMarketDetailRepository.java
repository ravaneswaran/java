package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEPreOpenMarketDetailRepository extends AbstractNSERepositoryManager<NSEPreOpenMarketDetailEntity> {

    public static final Logger LOGGER = Logger.getLogger(NSEPreOpenMarketDetailRepository.class.getName());

    public NSEPreOpenMarketDetailRepository() {
        super(NSEPreOpenMarketDetailEntity.class);
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

    public List<NSEPreOpenMarketDetailEntity> findBySymbolOnADay(String symbol, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(date);
        String dateStringWithOutTime = dateString.split(" ")[0];
        String morningAt_09_00 = String.format("%s %s", dateStringWithOutTime, "09:00:00");
        String morningAt_09_10 = String.format("%s %s", dateStringWithOutTime, "09:10:00");

        try {
            Date from = simpleDateFormat.parse(morningAt_09_00);
            Date to = simpleDateFormat.parse(morningAt_09_10);
            CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
            CriteriaQuery<NSEPreOpenMarketDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEPreOpenMarketDetailEntity.class);
            Root<NSEPreOpenMarketDetailEntity> root = criteriaQuery.from(NSEPreOpenMarketDetailEntity.class);
            Predicate symbolPredicate = criteriaBuilder.equal(root.get("symbol"), symbol);
            Predicate betweenDatePredicate = criteriaBuilder.between(root.get("createdDate"), from, to);
            Order ascendingOrder = criteriaBuilder.asc(root.get("createdDate"));

            criteriaQuery.select(root).where(symbolPredicate, betweenDatePredicate).orderBy(ascendingOrder);

            return this.getEntityManager().createQuery(criteriaQuery).getResultList();
        } catch (ParseException parseException) {
            LOGGER.log(Level.SEVERE, parseException.getMessage());
            return List.of();
        }
    }

    public List<String> findDistinctSymbolsOnADay(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(date);
        String dateStringWithOutTime = dateString.split(" ")[0];
        String morningAt_09_00 = String.format("%s %s", dateStringWithOutTime, "09:00:00");
        String morningAt_09_10 = String.format("%s %s", dateStringWithOutTime, "09:10:00");
        try {
            Date from = simpleDateFormat.parse(morningAt_09_00);
            Date to = simpleDateFormat.parse(morningAt_09_10);
            CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
            CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
            Root<NSEPreOpenMarketDetailEntity> root = criteriaQuery.from(NSEPreOpenMarketDetailEntity.class);
            Predicate betweenDatePredicate = criteriaBuilder.between(root.get("createdDate"), from, to);
            Order bySymbol = criteriaBuilder.asc(root.get("symbol"));
            criteriaQuery.select(root.get("symbol")).distinct(true).where(betweenDatePredicate).orderBy(bySymbol);

            return this.getEntityManager().createQuery(criteriaQuery).getResultList();
        } catch (ParseException parseException) {
            LOGGER.log(Level.SEVERE, parseException.getMessage());
            return List.of();
        }
    }

    public List<NSEPreOpenMarketDetailEntity> findEntitiesOnADay(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(date);
        String dateStringWithOutTime = dateString.split(" ")[0];
        String morningAt_09_00 = String.format("%s %s", dateStringWithOutTime, "09:00:00");
        String morningAt_09_10 = String.format("%s %s", dateStringWithOutTime, "09:10:00");
        try {
            Date from = simpleDateFormat.parse(morningAt_09_00);
            Date to = simpleDateFormat.parse(morningAt_09_10);
            CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
            CriteriaQuery<NSEPreOpenMarketDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEPreOpenMarketDetailEntity.class);
            Root<NSEPreOpenMarketDetailEntity> root = criteriaQuery.from(NSEPreOpenMarketDetailEntity.class);
            Predicate betweenDatePredicate = criteriaBuilder.between(root.get("createdDate"), from, to);
            Order symbol = criteriaBuilder.asc(root.get("symbol"));
            Order createdDate = criteriaBuilder.asc(root.get("createdDate"));
            criteriaQuery.select(root).where(betweenDatePredicate).orderBy(symbol, createdDate);

            return this.getEntityManager().createQuery(criteriaQuery).getResultList();
        } catch (ParseException parseException) {
            LOGGER.log(Level.SEVERE, parseException.getMessage());
            return List.of();
        }
    }
}
