package rave.code.repository.bse;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StockMarketHistoryEnabledRepository<T> extends StockMarketRepository<T> {

    public StockMarketHistoryEnabledRepository(Class<T> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<T> entities) {
        throw new RuntimeException("Yet to implement....");
    }

    public void moveToHistoryAndDeleteSource(final String MOVE_TO_HISTORY_QUERY, final String DELETE_SOURCE_QUERY) {
        EntityManager entityManager = this.getEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery(MOVE_TO_HISTORY_QUERY);
        int result = query.executeUpdate();
        if (result > 0) {
            query = entityManager.createNativeQuery(DELETE_SOURCE_QUERY);
            result = query.executeUpdate();
        }

        entityManager.getTransaction().commit();
    }
}
