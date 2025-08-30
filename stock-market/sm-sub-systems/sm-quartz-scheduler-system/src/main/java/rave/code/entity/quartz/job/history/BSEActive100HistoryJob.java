package rave.code.entity.quartz.job.history;

import rave.code.stockmarket.repository.StockMarketHistoryEnabledRepository;
import rave.code.stockmarket.entity.BSEActive100Entity;
import rave.code.stockmarket.entity.BSEActive100HistoryEntity;

public class BSEActive100HistoryJob extends AbstractHistoryEntityMakerJob<BSEActive100Entity, BSEActive100HistoryEntity> {

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO bse_active_100_history(SELECT * FROM bse_active_100)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM bse_active_100";
        StockMarketHistoryEnabledRepository stockMarketHistoryEnabledRepository = new StockMarketHistoryEnabledRepository(BSEActive100HistoryEntity.class);

        stockMarketHistoryEnabledRepository.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
