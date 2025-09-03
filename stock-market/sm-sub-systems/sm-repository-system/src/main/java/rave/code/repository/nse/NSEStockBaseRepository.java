package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEStockBaseEntity;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEStockBaseRepository extends AbstractNSERepository<NSEStockBaseEntity> {

    private static final Logger LOGGER = Logger.getLogger(NSEStockBaseRepository.class.getName());

    public NSEStockBaseRepository() {
        super(NSEStockBaseEntity.class);
    }

    @Override
    public Map<String, NSEStockBaseEntity> getEntityMap() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT nseStockBaseEntity FROM NSEStockBaseEntity nseStockBaseEntity");
        Query query = this.getEntityManager().createQuery(queryBuilder.toString());

        List<NSEStockBaseEntity> nseStockBaseEntities = query.getResultList();
        LOGGER.log(Level.INFO, String.format("the query(<<< %s >>>) did find %s item(s) in the repository...", query.toString(), nseStockBaseEntities.size()));

        Map<String, NSEStockBaseEntity> mappedStockBaseEntity = new HashMap<>();
        for (NSEStockBaseEntity nseStockBaseEntity : nseStockBaseEntities) {
            String key = String.format("%s:%s:%s:%s", nseStockBaseEntity.getSymbol(), nseStockBaseEntity.getCompanyName(), nseStockBaseEntity.getSeries(), nseStockBaseEntity.getISINumber());
            mappedStockBaseEntity.put(key, nseStockBaseEntity);
        }

        return mappedStockBaseEntity;
    }

    public Map<String, NSEStockBaseEntity> getEntityMapForDayPriceDetails() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT nseStockBaseEntity FROM NSEStockBaseEntity nseStockBaseEntity");
        Query query = this.getEntityManager().createQuery(queryBuilder.toString());

        List<NSEStockBaseEntity> nseStockBaseEntities = query.getResultList();
        LOGGER.log(Level.INFO, String.format("the query(<<< %s >>>) did find %s item(s) in the repository...", query.toString(), nseStockBaseEntities.size()));

        Map<String, NSEStockBaseEntity> mappedStockBaseEntity = new HashMap<>();
        for (NSEStockBaseEntity nseStockBaseEntity : nseStockBaseEntities) {
            String key = String.format("%s:%s:%s", nseStockBaseEntity.getSymbol(), nseStockBaseEntity.getCompanyName(), nseStockBaseEntity.getSeries());
            mappedStockBaseEntity.put(key, nseStockBaseEntity);
        }

        return mappedStockBaseEntity;
    }

    public Map<String, NSEStockBaseEntity> getEntityMapForPreOpenMarketDetails() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT nseStockBaseEntity FROM NSEStockBaseEntity nseStockBaseEntity");
        Query query = this.getEntityManager().createQuery(queryBuilder.toString());

        List<NSEStockBaseEntity> nseStockBaseEntities = query.getResultList();
        LOGGER.log(Level.INFO, String.format("the query(<<< %s >>>) did find %s item(s) in the repository...", query.toString(), nseStockBaseEntities.size()));

        Map<String, NSEStockBaseEntity> mappedStockBaseEntity = new HashMap<>();
        for (NSEStockBaseEntity nseStockBaseEntity : nseStockBaseEntities) {
            String key = String.format("%s", nseStockBaseEntity.getSymbol());
            mappedStockBaseEntity.put(key, nseStockBaseEntity);
        }

        return mappedStockBaseEntity;
    }
}
