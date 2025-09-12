package rave.code.stockmarket.repository;

import junit.framework.TestCase;
import rave.code.stockmarket.entity.BSEVolumeShockerEntity;

import java.util.Date;

public class TestBSEVolumeShockerRepository extends TestCase {

    public void testSaveMethod() {
        BSEVolumeShockerEntity bseVolumeShockerEntity = new BSEVolumeShockerEntity();

        bseVolumeShockerEntity.setStockName("test-company" + new Date().getTime());
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

        Date toDate = new Date();
        bseVolumeShockerEntity.setCreatedDate(toDate);
        bseVolumeShockerEntity.setModifiedDate(toDate);
        bseVolumeShockerEntity.setCreatedBy("SYSTEM");
        bseVolumeShockerEntity.setModifiedBy("SYSTEM");

        BSEVolumeShockerRepository bseVolumeShockerRepository = new BSEVolumeShockerRepository(BSEVolumeShockerEntity.class);

        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getStockName());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getCategory());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getSector());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getLastPrice());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getPercentageChange());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getAverageVolume5Days());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getAverageVolume10Days());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getAverageVolume30Days());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getDisplacedMovingAverage30D());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getDisplacedMovingAverage50D());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getDisplacedMovingAverage150D());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getDisplacedMovingAverage200D());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getPriceToEarningRatio());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getPriceToBookRatio());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getLowerCircuit());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getUpperCircuit());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getModifiedDate());
        System.out.println("------------------------>>>>>>> " + bseVolumeShockerEntity.getModifiedBy());

        bseVolumeShockerRepository.save(bseVolumeShockerEntity);
        BSEVolumeShockerEntity returnElement = bseVolumeShockerRepository.findBy(bseVolumeShockerEntity.getStockName());
        assertNotNull(returnElement);
    }

}
