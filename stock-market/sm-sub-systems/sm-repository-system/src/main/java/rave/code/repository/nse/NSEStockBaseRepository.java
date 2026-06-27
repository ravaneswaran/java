package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEStockBaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEStockBaseRepository extends AbstractNSERepositoryManager<NSEStockBaseEntity> {

    private static final Logger LOGGER = Logger.getLogger(NSEStockBaseRepository.class.getName());

    public NSEStockBaseRepository() {
        super(NSEStockBaseEntity.class);
    }

    @Override
    public Map<String, NSEStockBaseEntity> getEntityMap() {
        EntityManager entityManager = this.getEntityManager();
        Query query = entityManager.createQuery("SELECT nseStockBaseEntity FROM NSEStockBaseEntity nseStockBaseEntity");
        Map<String, NSEStockBaseEntity> mappedStockBaseEntity = new HashMap<>();
        if (null != query) {
            List<NSEStockBaseEntity> nseStockBaseEntities = query.getResultList();
            LOGGER.log(Level.INFO, String.format("the query(<<< %s >>>) did find %s item(s) in the repository...", query, nseStockBaseEntities.size()));
            for (NSEStockBaseEntity nseStockBaseEntity : nseStockBaseEntities) {
                String key = String.format("%s:%s:%s:%s", nseStockBaseEntity.getSymbol(), nseStockBaseEntity.getCompanyName(), nseStockBaseEntity.getSeries(), nseStockBaseEntity.getISINumber());
                if (key != null) {
                    mappedStockBaseEntity.put(key, nseStockBaseEntity);
                } else {
                    LOGGER.log(Level.INFO, String.format("key is found to be null.."));
                }
                mappedStockBaseEntity.put(key, nseStockBaseEntity);
            }
        }
        return mappedStockBaseEntity;
    }

    @Override
    public List<NSEStockBaseEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return new ArrayList<>();
    }

    public Map<String, NSEStockBaseEntity> getEntityMapForDayPriceDetails() {
        EntityManager entityManager = this.getEntityManager();
        Query query = entityManager.createQuery("SELECT nseStockBaseEntity FROM NSEStockBaseEntity nseStockBaseEntity");
        Map<String, NSEStockBaseEntity> mappedStockBaseEntity = new HashMap<>();
        if (null != query) {
            List<NSEStockBaseEntity> nseStockBaseEntities = query.getResultList();
            LOGGER.log(Level.INFO, String.format("the query(<<< %s >>>) did find %s item(s) in the repository...", query, nseStockBaseEntities.size()));
            for (NSEStockBaseEntity nseStockBaseEntity : nseStockBaseEntities) {
                String key = String.format("%s:%s:%s", nseStockBaseEntity.getSymbol(), nseStockBaseEntity.getCompanyName(), nseStockBaseEntity.getSeries());
                if (key != null) {
                    mappedStockBaseEntity.put(key, nseStockBaseEntity);
                } else {
                    LOGGER.log(Level.INFO, String.format("key is found to be null.."));
                }
                mappedStockBaseEntity.put(key, nseStockBaseEntity);
            }
        }
        return mappedStockBaseEntity;
    }

    public Map<String, NSEStockBaseEntity>  mapSymbolToStockBaseEntities() {
        EntityManager entityManager = this.getEntityManager();
        Query query = entityManager.createQuery("SELECT nseStockBaseEntity FROM NSEStockBaseEntity nseStockBaseEntity");
        Map<String, NSEStockBaseEntity> mappedStockBaseEntity = new HashMap<>();
        if (null != query) {
            List<NSEStockBaseEntity> nseStockBaseEntities = query.getResultList();
            LOGGER.log(Level.INFO, String.format("the query(<<< %s >>>) did find %s item(s) in the repository...", query, nseStockBaseEntities.size()));
            for (NSEStockBaseEntity nseStockBaseEntity : nseStockBaseEntities) {
                String key = String.format("%s", nseStockBaseEntity.getSymbol());
                if (key != null) {
                    mappedStockBaseEntity.put(key, nseStockBaseEntity);
                } else {
                    LOGGER.log(Level.INFO, String.format("key is found to be null.."));
                }
            }
        }
        return mappedStockBaseEntity;
    }
}
