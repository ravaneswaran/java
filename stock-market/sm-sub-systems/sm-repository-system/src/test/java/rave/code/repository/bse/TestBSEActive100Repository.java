package rave.code.repository.bse;

import junit.framework.TestCase;
import rave.code.entity.bse.BSEActive100Entity;
import rave.code.repository.bse.BSEActive100Repository;

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
        bseActive100Repository.save(bseActive100Entity);
        BSEActive100Entity returnElement = bseActive100Repository.findBy(bseActive100Entity.getStockName());
        
        assertNotNull(returnElement);
    }
}
