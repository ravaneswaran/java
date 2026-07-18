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
        CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSESimpleMovingAverageDetailEntity> cq = cb.createQuery(NSESimpleMovingAverageDetailEntity.class);

        Root<NSESimpleMovingAverageDetailEntity> nseSimpleMovingAverageDetailEntityRoot = cq.from(NSESimpleMovingAverageDetailEntity.class);
        cq.where(cb.equal(nseSimpleMovingAverageDetailEntityRoot.get("nseStockBaseEntity").get("id"), foreignKey));

        List<NSESimpleMovingAverageDetailEntity> nseSimpleMovingAverageDetailEntities = this.getEntityManager().createQuery(cq).getResultList();

        if (nseSimpleMovingAverageDetailEntities.size() == 1) {
            return nseSimpleMovingAverageDetailEntities.get(0);
        } else {
            return null;
        }
    }
}
