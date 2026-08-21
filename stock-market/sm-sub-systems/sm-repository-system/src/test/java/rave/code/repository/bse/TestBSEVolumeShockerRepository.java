package rave.code.repository.bse;

import junit.framework.TestCase;
import rave.code.entity.bse.BSEVolumeShockerEntity;
import rave.code.java.date.StockMarketDate;
import rave.code.repository.bse.BSEVolumeShockerRepository;

import java.util.Date;

public class TestBSEVolumeShockerRepository extends TestCase {

    public void testSaveMethod() {
        BSEVolumeShockerEntity bseVolumeShockerEntity = new BSEVolumeShockerEntity();

        bseVolumeShockerEntity.setStockName("test-company" + StockMarketDate.getInstance().now().getTime());
        bseVolumeShockerEntity.setSector("some-sector");
        bseVolumeShockerEntity.setCategory("some-category");
        bseVolumeShockerEntity.setLastPrice("123");
        bseVolumeShockerEntity.setPercentageChange("3");
        bseVolumeShockerEntity.setAverageVolume5Days("20");
        bseVolumeShockerEntity.setAverageVolume10Days("30");
        bseVolumeShockerEntity.setAverageVolume30Days("40");
        bseVolumeShockerEntity.setDisplacedMovingAverage30D("200");
        bseVolumeShockerEntity.setDisplacedMovingAverage50D("5300");
        bseVolumeShockerEntity.setDisplacedMovingAverage150D("400");
        bseVolumeShockerEntity.setDisplacedMovingAverage200D("500");
        bseVolumeShockerEntity.setPriceToEarningRatio("4.5");
        bseVolumeShockerEntity.setPriceToBookRatio("5.4");
        bseVolumeShockerEntity.setUpperCircuit("23");
        bseVolumeShockerEntity.setLowerCircuit("45");
        bseVolumeShockerEntity.setVolumeWeightedAveragePrice("45");

        Date toDate = StockMarketDate.getInstance().now();
        bseVolumeShockerEntity.setCreatedDate(toDate);
        bseVolumeShockerEntity.setModifiedDate(toDate);
        bseVolumeShockerEntity.setCreatedBy("SYSTEM");
        bseVolumeShockerEntity.setModifiedBy("SYSTEM");

        BSEVolumeShockerRepository bseVolumeShockerRepository = new BSEVolumeShockerRepository(BSEVolumeShockerEntity.class);
        bseVolumeShockerRepository.save(bseVolumeShockerEntity);
        BSEVolumeShockerEntity returnElement = bseVolumeShockerRepository.findBy(bseVolumeShockerEntity.getStockName());

        assertNotNull(returnElement);
    }
}
