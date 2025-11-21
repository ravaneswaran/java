package rave.code.stockmarket.repository;

import junit.framework.TestCase;
import rave.code.entity.bse.BSEActive200Entity;
import rave.code.repository.bse.BSEActive200Repository;

import java.util.Date;

public class TestBSEActive200Repository extends TestCase {

    public void testSaveMethod() {
        BSEActive200Entity bseActive200Entity = new BSEActive200Entity();

        bseActive200Entity.setStockName("test-company" + new Date().getTime());
        bseActive200Entity.setHigh("20");
        bseActive200Entity.setLow("10");
        bseActive200Entity.setCategory("some-category");
        bseActive200Entity.setLastPrice("34.5");
        bseActive200Entity.setPercentageChange("2.1");
        bseActive200Entity.setValueInCrores("23");
        Date toDate = new Date();
        bseActive200Entity.setCreatedDate(toDate);
        bseActive200Entity.setModifiedDate(toDate);
        bseActive200Entity.setCreatedBy("SYSTEM");
        bseActive200Entity.setModifiedBy("SYSTEM");

        BSEActive200Repository bseActive200Repository = new BSEActive200Repository(BSEActive200Entity.class);
        bseActive200Repository.save(bseActive200Entity);
        BSEActive200Entity returnElement = bseActive200Repository.findBy(bseActive200Entity.getStockName());

        assertNotNull(returnElement);
    }

}
