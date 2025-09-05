package rave.code.repository.bse;

import rave.code.entity.bse.csv.BSEDayPriceDetailEntity;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSEDayPriceDetailRepository extends AbstractBSERepository<BSEDayPriceDetailEntity> {

    private static final Logger LOGGER = Logger.getLogger(BSEDayPriceDetailRepository.class.getName());

    public BSEDayPriceDetailRepository() {
        super(BSEDayPriceDetailEntity.class);
    }

    @Override
    public Map<String, BSEDayPriceDetailEntity> getEntityMap() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT bseDayPriceDetailEntity FROM BSEDayPriceDetailEntity bseDayPriceDetailEntity");
        Query query = this.getEntityManager().createQuery(queryBuilder.toString());

        List<BSEDayPriceDetailEntity> bseDayPriceDetailEntities = query.getResultList();
        LOGGER.log(Level.INFO, String.format("the query(<<< %s >>>) did find %s item(s) in the repository...", query.toString(), bseDayPriceDetailEntities.size()));

        Map<String, BSEDayPriceDetailEntity> dayPriceDetailEntityMap = new HashMap<>();
        for (BSEDayPriceDetailEntity bseDayPriceDetailEntity : bseDayPriceDetailEntities) {
            String key = String.format("%s", bseDayPriceDetailEntity.getISINumber());
            dayPriceDetailEntityMap.put(key, bseDayPriceDetailEntity);
        }

        return dayPriceDetailEntityMap;
    }
}
