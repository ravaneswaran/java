package rave.code.stockmarket.repository;

import junit.framework.TestCase;
import rave.code.entity.bse.BSEPriceShockerEntity;
import rave.code.repository.bse.BSEPriceShockerRepository;

import java.util.Date;

public class TestBSEPriceShockerRepository extends TestCase {

    public void testSaveMethod() {
        BSEPriceShockerEntity bsePriceShockerEntity = new BSEPriceShockerEntity();

        bsePriceShockerEntity.setStockName("test-company" + new Date().getTime());
        bsePriceShockerEntity.setSector("some-sector");
        bsePriceShockerEntity.setCategory("some-category");
        bsePriceShockerEntity.setCurrentPrice("123");
        bsePriceShockerEntity.setPreviousPrice("102");
        bsePriceShockerEntity.setPercentageChange("3");
        bsePriceShockerEntity.setAverageVolume5Days("20");
        bsePriceShockerEntity.setAverageVolume10Days("30");
        bsePriceShockerEntity.setAverageVolume30Days("40");
        bsePriceShockerEntity.setDisplacedMovingAverage30D("200");
        bsePriceShockerEntity.setDisplacedMovingAverage50D("5300");
        bsePriceShockerEntity.setDisplacedMovingAverage150D("400");
        bsePriceShockerEntity.setDisplacedMovingAverage200D("500");
        bsePriceShockerEntity.setPriceToEarningRatio("4.5");
        bsePriceShockerEntity.setPriceToBookRatio("5.4");
        bsePriceShockerEntity.setUpperCircuit("23");
        bsePriceShockerEntity.setLowerCircuit("45");
        bsePriceShockerEntity.setVolumeWeightedAveragePrice("45");

        Date toDate = new Date();
        bsePriceShockerEntity.setCreatedDate(toDate);
        bsePriceShockerEntity.setModifiedDate(toDate);
        bsePriceShockerEntity.setCreatedBy("SYSTEM");
        bsePriceShockerEntity.setModifiedBy("SYSTEM");

        BSEPriceShockerRepository bsePriceShockerRepository = new BSEPriceShockerRepository(BSEPriceShockerEntity.class);
        bsePriceShockerRepository.save(bsePriceShockerEntity);
        BSEPriceShockerEntity returnElement = bsePriceShockerRepository.findBy(bsePriceShockerEntity.getStockName());

        assertNotNull(returnElement);
    }
}
