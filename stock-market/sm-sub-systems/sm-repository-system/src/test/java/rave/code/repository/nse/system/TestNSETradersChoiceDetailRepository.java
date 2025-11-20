package rave.code.repository.nse.system;

import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.entity.nse.system.NSETradersChoiceDetailEntity;
import rave.code.repository.nse.NSERepositoryTestCase;

public class TestNSETradersChoiceDetailRepository extends NSERepositoryTestCase {

    private NSETradersChoiceDetailRepository nseTradersChoiceDetailRepository = new NSETradersChoiceDetailRepository();

    public void testSaveNSETradersChoiceDetailEntity(){
        NSEStockBaseEntity nseStockBaseEntity = this.createNSEStockBaseEntity();

        NSETradersChoiceDetailEntity nseTradersChoiceDetailEntity = new NSETradersChoiceDetailEntity();
        nseTradersChoiceDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);

        this.nseTradersChoiceDetailRepository.save(nseTradersChoiceDetailEntity);
        NSETradersChoiceDetailEntity findFromDB = this.nseTradersChoiceDetailRepository.findBy(nseTradersChoiceDetailEntity.getId());

        assertNotNull(findFromDB);
        assertTrue(nseTradersChoiceDetailEntity.getId().equals(findFromDB.getId()));

    }

}