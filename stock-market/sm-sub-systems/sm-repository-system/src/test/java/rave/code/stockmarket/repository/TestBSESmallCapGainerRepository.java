package rave.code.stockmarket.repository;

import junit.framework.TestCase;
import rave.code.stockmarket.entity.BSESmallCapGainerEntity;

import java.util.Date;

public class TestBSESmallCapGainerRepository extends TestCase {

    public void testSaveMethod() {
        BSESmallCapGainerEntity bseSmallCapGainerEntity = new BSESmallCapGainerEntity();

        bseSmallCapGainerEntity.setStockName("test-" + new Date().getTime());
        bseSmallCapGainerEntity.setHigh("20");
        bseSmallCapGainerEntity.setLow("10");
        bseSmallCapGainerEntity.setVariation("2");
        bseSmallCapGainerEntity.setLastPrice("34");
        bseSmallCapGainerEntity.setPercentageGain("4");
        bseSmallCapGainerEntity.setPreviousClose("21");
        Date toDate = new Date();
        bseSmallCapGainerEntity.setCreatedDate(toDate);
        bseSmallCapGainerEntity.setModifiedDate(toDate);
        bseSmallCapGainerEntity.setCreatedBy("SYSTEM");
        bseSmallCapGainerEntity.setModifiedBy("SYSTEM");

        BSESmallCapGainerRepository bseSmallCapGainerRepository = new BSESmallCapGainerRepository(BSESmallCapGainerEntity.class);

        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getVariation());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getStockName());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getHigh());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getLastPrice());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getPercentageGain());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getPreviousClose());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getLow());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getCreatedDate());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getCreatedBy());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getModifiedDate());
        System.out.println("------------------------>>>>>>> " + bseSmallCapGainerEntity.getModifiedBy());

        bseSmallCapGainerRepository.save(bseSmallCapGainerEntity);
        BSESmallCapGainerEntity returnElement = bseSmallCapGainerRepository.findBy(bseSmallCapGainerEntity.getStockName());
        assertNotNull(returnElement);
    }

}
