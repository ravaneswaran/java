package rave.code.repository.nse;

import rave.code.entity.nse.technical.NSESimpleMovingAverageDetailEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class NSESimpleMovingAverageDetailRepository extends AbstractNSERepositoryManager<NSESimpleMovingAverageDetailEntity> {

    public NSESimpleMovingAverageDetailRepository() {
        super(NSESimpleMovingAverageDetailEntity.class);
    }

    @Override
    public List<NSESimpleMovingAverageDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return List.of();
    }

    public NSESimpleMovingAverageDetailEntity findByForeignKey(String foreignKey) {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSESimpleMovingAverageDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSESimpleMovingAverageDetailEntity.class);

        Root<NSESimpleMovingAverageDetailEntity> nseSimpleMovingAverageDetailEntityRoot = criteriaQuery.from(NSESimpleMovingAverageDetailEntity.class);
        criteriaQuery.where(criteriaBuilder.equal(nseSimpleMovingAverageDetailEntityRoot.get("nseStockBaseEntity").get("id"), foreignKey));

        List<NSESimpleMovingAverageDetailEntity> nseSimpleMovingAverageDetailEntities = this.getEntityManager().createQuery(criteriaQuery).getResultList();

        if (nseSimpleMovingAverageDetailEntities.size() == 1) {
            NSESimpleMovingAverageDetailEntity nseSimpleMovingAverageDetailEntity = nseSimpleMovingAverageDetailEntities.getFirst();
            nseSimpleMovingAverageDetailEntity.setNewEntity(false);
            return nseSimpleMovingAverageDetailEntity;
        } else {
            return null;
        }
    }
}
