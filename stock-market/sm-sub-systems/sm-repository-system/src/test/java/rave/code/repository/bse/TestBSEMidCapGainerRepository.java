package rave.code.repository.bse;

import junit.framework.TestCase;
import rave.code.entity.bse.BSEMidCapGainerEntity;
import rave.code.java.date.StockMarketDate;
import rave.code.repository.bse.BSEMidCapGainerRepository;

import java.util.Date;

public class TestBSEMidCapGainerRepository extends TestCase {

    public void testSaveMethod() {
        BSEMidCapGainerEntity bseMidCapGainerEntity = new BSEMidCapGainerEntity();

        bseMidCapGainerEntity.setStockName("test-company-" + StockMarketDate.getInstance().now().getTime());
        bseMidCapGainerEntity.setHigh("20");
        bseMidCapGainerEntity.setLow("10");
        bseMidCapGainerEntity.setVariation("34");
        bseMidCapGainerEntity.setLastPrice("45");
        bseMidCapGainerEntity.setPercentageGain("2.1");
        bseMidCapGainerEntity.setPreviousClose("23");
        Date toDate = StockMarketDate.getInstance().now();
        bseMidCapGainerEntity.setCreatedDate(toDate);
        bseMidCapGainerEntity.setModifiedDate(toDate);
        bseMidCapGainerEntity.setCreatedBy("SYSTEM");
        bseMidCapGainerEntity.setModifiedBy("SYSTEM");

        BSEMidCapGainerRepository bseMidCapGainerRepository = new BSEMidCapGainerRepository(BSEMidCapGainerEntity.class);
        bseMidCapGainerRepository.save(bseMidCapGainerEntity);
        BSEMidCapGainerEntity returnElement = bseMidCapGainerRepository.findBy(bseMidCapGainerEntity.getStockName());

        assertNotNull(returnElement);
    }
}
