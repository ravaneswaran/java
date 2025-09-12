package rave.code.stockmarket.repository;

import junit.framework.TestCase;
import rave.code.stockmarket.entity.BSEActive100Entity;

import java.util.Date;

public class TestBSEActive100Repository extends TestCase {

    public void testSaveMethod() {
        BSEActive100Entity bseActive100Entity = new BSEActive100Entity();

        bseActive100Entity.setStockName("test-company" + new Date().getTime());
        bseActive100Entity.setHigh("20");
        bseActive100Entity.setLow("10");
        bseActive100Entity.setCategory("some-category");
        bseActive100Entity.setLastPrice("34.5");
        bseActive100Entity.setPercentageChange("2.1");
        bseActive100Entity.setValueInCrores("23");
        Date toDate = new Date();
        bseActive100Entity.setCreatedDate(toDate);
        bseActive100Entity.setModifiedDate(toDate);
        bseActive100Entity.setCreatedBy("SYSTEM");
        bseActive100Entity.setModifiedBy("SYSTEM");

        BSEActive100Repository bseActive100Repository = new BSEActive100Repository(BSEActive100Entity.class);

        System.out.println("------------------------>>>>>>> " + bseActive100Entity.getStockName());
        System.out.println("------------------------>>>>>>> " + bseActive100Entity.getCategory());
        System.out.println("------------------------>>>>>>> " + bseActive100Entity.getHigh());
        System.out.println("------------------------>>>>>>> " + bseActive100Entity.getLastPrice());
        System.out.println("------------------------>>>>>>> " + bseActive100Entity.getPercentageChange());
        System.out.println("------------------------>>>>>>> " + bseActive100Entity.getValueInCrores());
        System.out.println("------------------------>>>>>>> " + bseActive100Entity.getLow());
        System.out.println("------------------------>>>>>>> " + bseActive100Entity.getCreatedDate());
        System.out.println("------------------------>>>>>>> " + bseActive100Entity.getCreatedBy());
        System.out.println("------------------------>>>>>>> " + bseActive100Entity.getModifiedDate());
        System.out.println("------------------------>>>>>>> " + bseActive100Entity.getModifiedBy());

        bseActive100Repository.save(bseActive100Entity);
        BSEActive100Entity returnElement = bseActive100Repository.findBy(bseActive100Entity.getStockName());
        assertNotNull(returnElement);
    }

}
