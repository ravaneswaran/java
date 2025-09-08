package rave.code.quartz.jobs.history;

import rave.code.stockmarket.entity.BSEActive500Entity;
import rave.code.stockmarket.entity.BSEActive500HistoryEntity;
import rave.code.stockmarket.repository.StockMarketHistoryEnabledRepository;

public class BSEActive500HistoryJob extends AbstractHistoryEntityMakerJob<BSEActive500Entity, BSEActive500HistoryEntity> {

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO bse_active_500_history(SELECT * FROM bse_active_500)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM bse_active_500";
        StockMarketHistoryEnabledRepository stockMarketHistoryEnabledRepository = new StockMarketHistoryEnabledRepository(BSEActive500HistoryEntity.class);

        stockMarketHistoryEnabledRepository.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
