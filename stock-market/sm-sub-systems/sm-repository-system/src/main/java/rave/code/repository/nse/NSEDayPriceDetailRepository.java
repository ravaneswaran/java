package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEDayPriceDetailEntity;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEDayPriceDetailRepository extends AbstractNSERepository<NSEDayPriceDetailEntity> {

    private static final Logger LOGGER = Logger.getLogger(NSEDayPriceDetailRepository.class.getName());

    public NSEDayPriceDetailRepository() {
        super(NSEDayPriceDetailEntity.class);
    }

    @Override
    public Map<String, NSEDayPriceDetailEntity> getEntityMap() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT nseDayPriceDetailEntity FROM NSEDayPriceDetailEntity nseDayPriceDetailEntity");
        Query query = this.getEntityManager().createQuery(queryBuilder.toString());

        List<NSEDayPriceDetailEntity> nseDayPriceDetailEntities = query.getResultList();
        LOGGER.log(Level.INFO, String.format("the query(<<< %s >>>) did find %s item(s) in the repository...", query.toString(), nseDayPriceDetailEntities.size()));

        Map<String, NSEDayPriceDetailEntity> dayPriceDetailEntityMap = new HashMap<>();
        for (NSEDayPriceDetailEntity nseDayPriceDetailEntity : nseDayPriceDetailEntities) {
            String key = String.format("%s:%s:%s", nseDayPriceDetailEntity.getSymbol(), nseDayPriceDetailEntity.getCompanyName(), nseDayPriceDetailEntity.getSeries());
            dayPriceDetailEntityMap.put(key, nseDayPriceDetailEntity);
        }

        return dayPriceDetailEntityMap;
    }
}
