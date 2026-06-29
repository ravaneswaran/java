package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;

import java.math.BigDecimal;

public class TestNSEPreOpenMarketDetailTest extends NSERepositoryTestCase {

    NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    public void testSaveMethod() {
        NSEStockBaseEntity nseStockBaseEntity = this.createNSEStockBaseEntity();

        NSEPreOpenMarketDetailEntity nsePreOpenMarketDetailEntity = new NSEPreOpenMarketDetailEntity();
        nsePreOpenMarketDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
        nsePreOpenMarketDetailEntity.setSymbol(nseStockBaseEntity.getSymbol());
        nsePreOpenMarketDetailEntity.setPreviousClose(234.00);
        nsePreOpenMarketDetailEntity.setIndicativeEquilibriumPrice(143.00);
        nsePreOpenMarketDetailEntity.setPriceChange(4.0);
        nsePreOpenMarketDetailEntity.setPricePercentageChange(5.0);
        nsePreOpenMarketDetailEntity.setFinalPrice(56.00);
        nsePreOpenMarketDetailEntity.setValueInCrores(new BigDecimal(3456.90));
        nsePreOpenMarketDetailEntity.setFreeFloatMarketCapitalization(new BigDecimal(453.00));
        nsePreOpenMarketDetailEntity.setNewMarket52WeekHigh(456.00);
        nsePreOpenMarketDetailEntity.setNewMarket52WeekLow(345.00);

        this.nsePreOpenMarketDetailRepository.save(nsePreOpenMarketDetailEntity);

        NSEPreOpenMarketDetailEntity findFromDB = this.nsePreOpenMarketDetailRepository.findBy(nsePreOpenMarketDetailEntity.getId());
        assertNotNull(findFromDB);
    }
}
