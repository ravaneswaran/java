package rave.code.repository.bse;

import junit.framework.TestCase;
import rave.code.entity.bse.BSESmallCapGainerEntity;
import rave.code.java.date.StockMarketDate;
import rave.code.repository.bse.BSESmallCapGainerRepository;

import java.util.Date;

public class TestBSESmallCapGainerRepository extends TestCase {

    public void testSaveMethod() {
        BSESmallCapGainerEntity bseSmallCapGainerEntity = new BSESmallCapGainerEntity();

        bseSmallCapGainerEntity.setStockName("test-" + StockMarketDate.getInstance().now().getTime());
        bseSmallCapGainerEntity.setHigh("20");
        bseSmallCapGainerEntity.setLow("10");
        bseSmallCapGainerEntity.setVariation("2");
        bseSmallCapGainerEntity.setLastPrice("34");
        bseSmallCapGainerEntity.setPercentageGain("4");
        bseSmallCapGainerEntity.setPreviousClose("21");
        Date toDate = StockMarketDate.getInstance().now();
        bseSmallCapGainerEntity.setCreatedDate(toDate);
        bseSmallCapGainerEntity.setModifiedDate(toDate);
        bseSmallCapGainerEntity.setCreatedBy("SYSTEM");
        bseSmallCapGainerEntity.setModifiedBy("SYSTEM");

        BSESmallCapGainerRepository bseSmallCapGainerRepository = new BSESmallCapGainerRepository(BSESmallCapGainerEntity.class);
        bseSmallCapGainerRepository.save(bseSmallCapGainerEntity);
        BSESmallCapGainerEntity returnElement = bseSmallCapGainerRepository.findBy(bseSmallCapGainerEntity.getStockName());

        assertNotNull(returnElement);
    }
}
