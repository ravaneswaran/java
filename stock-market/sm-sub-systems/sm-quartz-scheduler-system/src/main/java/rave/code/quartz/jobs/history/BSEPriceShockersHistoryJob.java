package rave.code.quartz.jobs.history;

import rave.code.stockmarket.repository.StockMarketHistoryEnabledRepository;
import rave.code.stockmarket.entity.BSEPriceShockerEntity;
import rave.code.stockmarket.entity.BSEPriceShockerHistoryEntity;

public class BSEPriceShockersHistoryJob extends AbstractHistoryEntityMakerJob<BSEPriceShockerEntity, BSEPriceShockerHistoryEntity> {

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO bse_price_shockers_history(SELECT * FROM bse_price_shockers)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM bse_price_shockers";
        StockMarketHistoryEnabledRepository stockMarketHistoryEnabledRepository = new StockMarketHistoryEnabledRepository(BSEPriceShockerHistoryEntity.class);

        stockMarketHistoryEnabledRepository.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
