package rave.code.repository.bse;

import rave.code.entity.bse.csv.BSEStockBaseEntity;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSEStockBaseRepository extends AbstractBSERepository<BSEStockBaseEntity> {

    private static final Logger LOGGER = Logger.getLogger(BSEStockBaseRepository.class.getName());

    public BSEStockBaseRepository() {
        super(BSEStockBaseEntity.class);
    }

    @Override
    public Map<String, BSEStockBaseEntity> getEntityMap() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT bseStockBaseEntity FROM BSEStockBaseEntity bseStockBaseEntity");
        Query query = this.getEntityManager().createQuery(queryBuilder.toString());

        List<BSEStockBaseEntity> bseStockBaseEntities = query.getResultList();
        LOGGER.log(Level.INFO, String.format("the query(<<< %s >>>) did find %s item(s) in the repository...", query.toString(), bseStockBaseEntities.size()));

        Map<String, BSEStockBaseEntity> mappedStockBaseEntity = new HashMap<>();
        for (BSEStockBaseEntity bseStockBaseEntity : bseStockBaseEntities) {
            mappedStockBaseEntity.put(bseStockBaseEntity.getISINumber(), bseStockBaseEntity);
        }

        return mappedStockBaseEntity;
    }
}
