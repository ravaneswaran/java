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

        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getStockName());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getCategory());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getSector());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getCurrentPrice());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getPreviousPrice());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getPercentageChange());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getAverageVolume5Days());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getAverageVolume10Days());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getAverageVolume30Days());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getDisplacedMovingAverage30D());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getDisplacedMovingAverage50D());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getDisplacedMovingAverage150D());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getDisplacedMovingAverage200D());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getPriceToEarningRatio());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getPriceToBookRatio());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getLowerCircuit());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getUpperCircuit());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getCreatedDate());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getCreatedBy());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getModifiedDate());
        System.out.println("------------------------>>>>>>> " + bsePriceShockerEntity.getModifiedBy());

        bsePriceShockerRepository.save(bsePriceShockerEntity);
        BSEPriceShockerEntity returnElement = bsePriceShockerRepository.findBy(bsePriceShockerEntity.getStockName());
        assertNotNull(returnElement);
    }

}
