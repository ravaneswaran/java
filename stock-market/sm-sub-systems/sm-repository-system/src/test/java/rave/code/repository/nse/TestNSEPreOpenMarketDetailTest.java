package rave.code.repository.nse;

import junit.framework.TestCase;
import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;

import java.math.BigDecimal;
import java.util.Date;

public class TestNSEPreOpenMarketDetailTest extends TestCase {

    NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    public NSEStockBaseEntity createNSEStockBaseEntity(){
        NSEStockBaseEntity nseStockBaseEntity = new NSEStockBaseEntity();

        Date now = new Date();
        nseStockBaseEntity.setSymbol(String.format("%s-%s", "QWERTY", now.getTime()));
        nseStockBaseEntity.setISINumber(String.valueOf(now.getTime()));
        nseStockBaseEntity.setCompanyName(String.format("Mannar-and-Mannar-%s", now.getTime()));
        nseStockBaseEntity.setDateOfListing(new Date());
        nseStockBaseEntity.setPaidUpValue(34);
        nseStockBaseEntity.setFaceValue(345);
        nseStockBaseEntity.setMarketLot(30);

        return this.nseStockBaseRepository.save(nseStockBaseEntity);
    }

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
        NSEPreOpenMarketDetailEntity returnEntity = this.nsePreOpenMarketDetailRepository.findBy(nsePreOpenMarketDetailEntity.getId());
        assertNotNull(returnEntity);
    }
}
