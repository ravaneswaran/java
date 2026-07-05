package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.entity.nse.technical.NSESimpleMovingAverageDetailEntity;

public class TestNSESimpleMovingAverageDetailRepositoryTest extends NSERepositoryTestCase{

    NSESimpleMovingAverageDetailRepository nseSimpleMovingAverageDetailRepository = new NSESimpleMovingAverageDetailRepository();

    public void testSaveMethod() {
        NSEStockBaseEntity nseStockBaseEntity = this.createNSEStockBaseEntity();
        NSESimpleMovingAverageDetailEntity nseSimpleMovingAverageDetailEntity = this.getNseSimpleMovingAverageDetailEntity(nseStockBaseEntity);

        this.nseSimpleMovingAverageDetailRepository.save(nseSimpleMovingAverageDetailEntity);

        NSESimpleMovingAverageDetailEntity findFromDB = this.nseSimpleMovingAverageDetailRepository.findBy(nseSimpleMovingAverageDetailEntity.getId());
        assertNotNull(findFromDB);
    }

    private NSESimpleMovingAverageDetailEntity getNseSimpleMovingAverageDetailEntity(NSEStockBaseEntity nseStockBaseEntity) {
        NSESimpleMovingAverageDetailEntity nseSimpleMovingAverageDetailEntity = new NSESimpleMovingAverageDetailEntity();
        nseSimpleMovingAverageDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);

        nseSimpleMovingAverageDetailEntity.setSMA5D(0.123);
        nseSimpleMovingAverageDetailEntity.setSMA10D(0.123);
        nseSimpleMovingAverageDetailEntity.setSMA20D(0.123);
        nseSimpleMovingAverageDetailEntity.setSMA50D(0.123);
        nseSimpleMovingAverageDetailEntity.setSMA100D(0.123);
        nseSimpleMovingAverageDetailEntity.setSMA200D(0.123);

        return nseSimpleMovingAverageDetailEntity;
    }
}
