package rave.code.repository.nse;

import rave.code.entity.nse.histories.NSEPreOpenMarketDetailHistoryEntity;

import javax.persistence.criteria.*;
import java.util.List;

public class NSEPreOpenMarketDetailHistoryRepository extends AbstractNSERepositoryManager<NSEPreOpenMarketDetailHistoryEntity> {

    public NSEPreOpenMarketDetailHistoryRepository() {
        super(NSEPreOpenMarketDetailHistoryEntity.class);
    }

    @Override
    public List<NSEPreOpenMarketDetailHistoryEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return List.of();
    }

    public List<NSEPreOpenMarketDetailHistoryEntity> findBySymbol(String symbol) {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSEPreOpenMarketDetailHistoryEntity> criteriaQuery = criteriaBuilder.createQuery(NSEPreOpenMarketDetailHistoryEntity.class);
        Root<NSEPreOpenMarketDetailHistoryEntity> root = criteriaQuery.from(NSEPreOpenMarketDetailHistoryEntity.class);
        Predicate symbolPredicate = criteriaBuilder.equal(root.get("symbol"), symbol);
        Order ascendingOrder = criteriaBuilder.asc(root.get("createdDate"));
        criteriaQuery.select(root).where(symbolPredicate).orderBy(ascendingOrder);

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }
}
