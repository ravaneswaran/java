package rave.code.quartz.jobs.history;

import rave.code.entity.bse.BSEVolumeShockerEntity;
import rave.code.entity.bse.BSEVolumeShockerHistoryEntity;
import rave.code.repository.bse.StockMarketHistoryEnabledRepository;

public class BSEVolumeShockersHistoryJob extends AbstractHistoryEntityMakerJob<BSEVolumeShockerEntity, BSEVolumeShockerHistoryEntity>{

    @Override
    public void loadHistoryAndClearSource() {
        final String MOVE_TO_HISTORY_QUERY = "INSERT INTO bse_volume_shockers_history(SELECT * FROM bse_volume_shockers)";
        final String DELETE_FROM_SOURCE_QUERY = "DELETE FROM bse_volume_shockers";
        StockMarketHistoryEnabledRepository stockMarketHistoryEnabledRepository = new StockMarketHistoryEnabledRepository(BSEVolumeShockerHistoryEntity.class);

        stockMarketHistoryEnabledRepository.moveToHistoryAndDeleteSource(MOVE_TO_HISTORY_QUERY, DELETE_FROM_SOURCE_QUERY);
    }
}
