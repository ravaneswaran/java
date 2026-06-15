package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;

import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public Map<String, List<NSEPriceSpurtDetailEntity>> findForMarketOnOpen() {

        SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
        String toDateString = simpleDateFormatWithoutTime.format(new Date());
        String toDateStartTimeString = String.format("%s %s", toDateString, "09:15:00");
        String toDateEndTimeString = String.format("%s %s", toDateString, "10:00:00");

        SimpleDateFormat simpleDateFormatWithTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDateTime = null;
        Date endDateTime = null;
        try {
            startDateTime = simpleDateFormatWithTime.parse(toDateStartTimeString);
        } catch (ParseException parseException) {
            throw new RuntimeException(parseException);
        }
        try {
            endDateTime = simpleDateFormatWithTime.parse(toDateEndTimeString);
        } catch (ParseException parseException) {
            throw new RuntimeException(parseException);
        }

        CriteriaBuilder mainCriteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSEPriceSpurtDetailEntity> mainCriteriaQuery = mainCriteriaBuilder.createQuery(NSEPriceSpurtDetailEntity.class);
        Root<NSEPriceSpurtDetailEntity> mainRoot = mainCriteriaQuery.from(NSEPriceSpurtDetailEntity.class);
        Predicate dateRangePredicate = mainCriteriaBuilder.between(mainRoot.get("createdDate"), startDateTime, endDateTime);
        mainCriteriaQuery.select(mainRoot);
        mainCriteriaQuery.where(dateRangePredicate).orderBy(mainCriteriaBuilder.asc(mainRoot.get("symbol")));

        List<NSEPriceSpurtDetailEntity> nsePriceSpurtDetailEntities = this.getEntityManager().createQuery(mainCriteriaQuery).getResultList();

        Map<String, List<NSEPriceSpurtDetailEntity>> resultList = new HashMap<>();
        for (NSEPriceSpurtDetailEntity nsePriceSpurtDetailEntity : nsePriceSpurtDetailEntities) {
            String symbol = nsePriceSpurtDetailEntity.getSymbol();

            CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
            CriteriaQuery<NSEPriceSpurtDetailEntity> criteriaQuery = mainCriteriaBuilder.createQuery(NSEPriceSpurtDetailEntity.class);
            Root<NSEPriceSpurtDetailEntity> root = criteriaQuery.from(NSEPriceSpurtDetailEntity.class);
            Predicate symbolPredicate = criteriaBuilder.equal(root.get("symbol"), symbol);
            criteriaQuery.select(root).where(criteriaBuilder.and(dateRangePredicate, symbolPredicate));

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
        if (null != spurtType) {
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
