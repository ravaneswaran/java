package rave.code.stockmarket.repository;

import junit.framework.TestCase;
import rave.code.stockmarket.entity.BSEMidCapGainerEntity;

import java.util.Date;

public class TestBSEMidCapGainerRepository extends TestCase {

    public void testSaveMethod() {
        BSEMidCapGainerEntity bseMidCapGainerEntity = new BSEMidCapGainerEntity();

        bseMidCapGainerEntity.setStockName("test-company-" + new Date().getTime());
        bseMidCapGainerEntity.setHigh("20");
        bseMidCapGainerEntity.setLow("10");
        bseMidCapGainerEntity.setVariation("34");
        bseMidCapGainerEntity.setLastPrice("45");
        bseMidCapGainerEntity.setPercentageGain("2.1");
        bseMidCapGainerEntity.setPreviousClose("23");
        Date toDate = new Date();
        bseMidCapGainerEntity.setCreatedDate(toDate);
        bseMidCapGainerEntity.setModifiedDate(toDate);
        bseMidCapGainerEntity.setCreatedBy("SYSTEM");
        bseMidCapGainerEntity.setModifiedBy("SYSTEM");

        BSEMidCapGainerRepository bseMidCapGainerRepository = new BSEMidCapGainerRepository(BSEMidCapGainerEntity.class);

        System.out.println("------------------------>>>>>>> " + bseMidCapGainerEntity.getVariation());
        System.out.println("------------------------>>>>>>> " + bseMidCapGainerEntity.getStockName());
        System.out.println("------------------------>>>>>>> " + bseMidCapGainerEntity.getHigh());
        System.out.println("------------------------>>>>>>> " + bseMidCapGainerEntity.getLastPrice());
        System.out.println("------------------------>>>>>>> " + bseMidCapGainerEntity.getPercentageGain());
        System.out.println("------------------------>>>>>>> " + bseMidCapGainerEntity.getPreviousClose());
        System.out.println("------------------------>>>>>>> " + bseMidCapGainerEntity.getLow());
        System.out.println("------------------------>>>>>>> " + bseMidCapGainerEntity.getCreatedDate());
        System.out.println("------------------------>>>>>>> " + bseMidCapGainerEntity.getCreatedBy());
        System.out.println("------------------------>>>>>>> " + bseMidCapGainerEntity.getModifiedDate());
        System.out.println("------------------------>>>>>>> " + bseMidCapGainerEntity.getModifiedBy());

        bseMidCapGainerRepository.save(bseMidCapGainerEntity);
        BSEMidCapGainerEntity returnElement = bseMidCapGainerRepository.findBy(bseMidCapGainerEntity.getStockName());
        assertNotNull(returnElement);
    }

}
