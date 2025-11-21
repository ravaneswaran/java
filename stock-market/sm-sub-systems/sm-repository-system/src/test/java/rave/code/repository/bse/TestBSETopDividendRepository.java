package rave.code.repository.bse;

import junit.framework.TestCase;
import rave.code.entity.bse.BSETopDividendEntity;
import rave.code.repository.bse.BSETopDividendRepository;

import java.util.Date;

public class TestBSETopDividendRepository extends TestCase {

    public void testSaveMethod() {
        BSETopDividendEntity bseTopDividendEntity = new BSETopDividendEntity();

        bseTopDividendEntity.setStockName("test-company-" + new Date().getTime());
        bseTopDividendEntity.setLastPrice("23");

        bseTopDividendEntity.setLatestDividendPercentage("4");
        bseTopDividendEntity.setDividendYieldPercentage52High("23");
        bseTopDividendEntity.setDividendYieldPercentage52Low("32");
        bseTopDividendEntity.setDividendYieldPercentageAtCurrent("23");

        Date toDate = new Date();
        bseTopDividendEntity.setCreatedDate(toDate);
        bseTopDividendEntity.setModifiedDate(toDate);
        bseTopDividendEntity.setCreatedBy("SYSTEM");
        bseTopDividendEntity.setModifiedBy("SYSTEM");

        BSETopDividendRepository bseTopDividendRepository = new BSETopDividendRepository(BSETopDividendEntity.class);
        bseTopDividendRepository.save(bseTopDividendEntity);
        BSETopDividendEntity returnElement = bseTopDividendRepository.findBy(bseTopDividendEntity.getStockName());

        assertNotNull(returnElement);
    }
}
