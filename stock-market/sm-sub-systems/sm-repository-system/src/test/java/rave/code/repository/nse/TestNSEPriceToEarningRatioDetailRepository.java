package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPriceToEarningRatioDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;

public class TestNSEPriceToEarningRatioDetailRepository extends NSERepositoryTestCase {

    private NSEPriceToEarningRatioDetailRepository nsePriceToEarningRatioDetailRepository = new NSEPriceToEarningRatioDetailRepository();

    public void testSaveNSEPriceToEarningRatioDetailEntity() {
        NSEStockBaseEntity nseStockBaseEntity = this.createNSEStockBaseEntity();

        NSEPriceToEarningRatioDetailEntity nsePriceToEarningRatioDetailEntity = new NSEPriceToEarningRatioDetailEntity();
        nsePriceToEarningRatioDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
        nsePriceToEarningRatioDetailEntity.setSymbol(nseStockBaseEntity.getSymbol());
        nsePriceToEarningRatioDetailEntity.setSymbolPE(60.95);
        nsePriceToEarningRatioDetailEntity.setAdjustedPE(60.95);

        this.nsePriceToEarningRatioDetailRepository.save(nsePriceToEarningRatioDetailEntity);
        NSEPriceToEarningRatioDetailEntity findFromDB = this.nsePriceToEarningRatioDetailRepository.findBy(nsePriceToEarningRatioDetailEntity.getId());

        assertNotNull(findFromDB);
        assertTrue(nsePriceToEarningRatioDetailEntity.getId().equals(findFromDB.getId()));
        assertNotNull(findFromDB.getNseStockBaseEntity());
    }
}
