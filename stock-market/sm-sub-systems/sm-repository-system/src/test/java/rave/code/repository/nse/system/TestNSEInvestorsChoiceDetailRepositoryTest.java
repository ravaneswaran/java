package rave.code.repository.nse.system;

import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.entity.nse.system.NSEInvestorsChoiceDetailEntity;
import rave.code.repository.nse.NSERepositoryTestCase;

public class TestNSEInvestorsChoiceDetailRepositoryTest extends NSERepositoryTestCase {

    private NSEInvestorsChoiceDetailRepository nseInvestorsChoiceDetailRepository = new NSEInvestorsChoiceDetailRepository();

    public void testSaveNSEInvestorsChoiceDetailEntity() {
        NSEStockBaseEntity nseStockBaseEntity = this.createNSEStockBaseEntity();

        NSEInvestorsChoiceDetailEntity nseInvestorsChoiceDetailEntity = new NSEInvestorsChoiceDetailEntity();
        nseInvestorsChoiceDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);

        this.nseInvestorsChoiceDetailRepository.save(nseInvestorsChoiceDetailEntity);
        NSEInvestorsChoiceDetailEntity findFromDB = this.nseInvestorsChoiceDetailRepository.findBy(nseInvestorsChoiceDetailEntity.getId());

        assertNotNull(findFromDB);
        assertTrue(nseInvestorsChoiceDetailEntity.getId().equals(findFromDB.getId()));
    }
}
