package rave.code.repository.nse;

import junit.framework.TestCase;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.java.date.StockMarketDate;

import java.util.Date;

public abstract class NSERepositoryTestCase extends TestCase {

    protected NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();

    protected NSEStockBaseEntity createNSEStockBaseEntity(){
        NSEStockBaseEntity nseStockBaseEntity = new NSEStockBaseEntity();

        Date now = StockMarketDate.getInstance().now();
        nseStockBaseEntity.setSymbol(String.format("%s-%s", "TEST-STOCK-BASE-ENTITY", now.getTime()));
        nseStockBaseEntity.setISINumber(String.valueOf(now.getTime()));
        nseStockBaseEntity.setCompanyName(String.format("TEST-COMPANY-%s", now.getTime()));
        nseStockBaseEntity.setDateOfListing(StockMarketDate.getInstance().now());
        nseStockBaseEntity.setPaidUpValue(34);
        nseStockBaseEntity.setFaceValue(345);
        nseStockBaseEntity.setMarketLot(30);

        return this.nseStockBaseRepository.save(nseStockBaseEntity);
    }

}
