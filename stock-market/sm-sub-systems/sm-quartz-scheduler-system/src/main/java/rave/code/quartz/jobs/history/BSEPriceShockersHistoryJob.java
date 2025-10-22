package rave.code.quartz.jobs.history;

import rave.code.entity.bse.BSEPriceShockerEntity;
import rave.code.entity.bse.BSEPriceShockerHistoryEntity;
import rave.code.repository.bse.StockMarketHistoryEnabledRepository;

public class BSEPriceShockersHistoryJob extends AbstractHistoryEntityMakerJob<BSEPriceShockerEntity, BSEPriceShockerHistoryEntity> {

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO bse_price_shockers_history(SELECT * FROM bse_price_shockers)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM bse_price_shockers";
        StockMarketHistoryEnabledRepository stockMarketHistoryEnabledRepository = new StockMarketHistoryEnabledRepository(BSEPriceShockerHistoryEntity.class);

        stockMarketHistoryEnabledRepository.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
