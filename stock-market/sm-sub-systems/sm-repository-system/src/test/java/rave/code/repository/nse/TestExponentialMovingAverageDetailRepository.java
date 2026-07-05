package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.entity.nse.technical.NSEExponentialMovingAverageDetailEntity;

public class TestExponentialMovingAverageDetailRepository extends NSERepositoryTestCase{

    NSEExponentialMovingAverageDetailRepository nseEXponentialMovingAverageDetailRepository = new NSEExponentialMovingAverageDetailRepository();

    public void testSaveMethod() {
        NSEStockBaseEntity nseStockBaseEntity = this.createNSEStockBaseEntity();
        NSEExponentialMovingAverageDetailEntity nseExponentialMovingAverageDetailEntity = this.getNSEExponentialMovingAverageDetailEntity(nseStockBaseEntity);

        this.nseEXponentialMovingAverageDetailRepository.save(nseExponentialMovingAverageDetailEntity);

        NSEExponentialMovingAverageDetailEntity findFromDB = this.nseEXponentialMovingAverageDetailRepository.findBy(nseExponentialMovingAverageDetailEntity.getId());

        assertNotNull(findFromDB);
    }

    private NSEExponentialMovingAverageDetailEntity getNSEExponentialMovingAverageDetailEntity(NSEStockBaseEntity nseStockBaseEntity) {
        NSEExponentialMovingAverageDetailEntity nseExponentialMovingAverageDetailEntity = new NSEExponentialMovingAverageDetailEntity();
        nseExponentialMovingAverageDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);

        nseExponentialMovingAverageDetailEntity.setEMA5D(0.123);
        nseExponentialMovingAverageDetailEntity.setEMA10D(0.123);
        nseExponentialMovingAverageDetailEntity.setEMA20D(0.123);
        nseExponentialMovingAverageDetailEntity.setEMA50D(0.123);
        nseExponentialMovingAverageDetailEntity.setEMA100D(0.123);
        nseExponentialMovingAverageDetailEntity.setEMA200D(0.123);

        return nseExponentialMovingAverageDetailEntity;
    }
}

