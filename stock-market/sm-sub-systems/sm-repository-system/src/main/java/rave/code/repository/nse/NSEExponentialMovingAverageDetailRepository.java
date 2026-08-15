package rave.code.repository.nse;

import rave.code.entity.nse.technical.NSEExponentialMovingAverageDetailEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class NSEExponentialMovingAverageDetailRepository extends AbstractNSERepositoryManager<NSEExponentialMovingAverageDetailEntity> {

    public NSEExponentialMovingAverageDetailRepository() {
        super(NSEExponentialMovingAverageDetailEntity.class);
    }

    @Override
    public List<NSEExponentialMovingAverageDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return List.of();
    }

    public NSEExponentialMovingAverageDetailEntity findByForeignKey(String foreignKey) {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSEExponentialMovingAverageDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEExponentialMovingAverageDetailEntity.class);

        Root<NSEExponentialMovingAverageDetailEntity> nseExponentialMovingAverageDetailEntityRoot = criteriaQuery.from(NSEExponentialMovingAverageDetailEntity.class);
        criteriaQuery.where(criteriaBuilder.equal(nseExponentialMovingAverageDetailEntityRoot.get("nseStockBaseEntity").get("id"), foreignKey));

        List<NSEExponentialMovingAverageDetailEntity> nseExponentialMovingAverageDetailEntities = this.getEntityManager().createQuery(criteriaQuery).getResultList();

        if (nseExponentialMovingAverageDetailEntities.size() == 1) {
            NSEExponentialMovingAverageDetailEntity nseExponentialMovingAverageDetailEntity = nseExponentialMovingAverageDetailEntities.getFirst();
            nseExponentialMovingAverageDetailEntity.setNewEntity(false);
            return nseExponentialMovingAverageDetailEntity;
        } else {
            return null;
        }
    }
}
