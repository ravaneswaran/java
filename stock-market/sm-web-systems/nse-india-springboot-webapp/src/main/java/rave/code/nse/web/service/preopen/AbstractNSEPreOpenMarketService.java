package rave.code.nse.web.service.preopen;

import rave.code.data.model.web.nse.NSEPreOpenMarketModel;
import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.nse.web.service.AbstractNSEService;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNSEPreOpenMarketService<W> extends AbstractNSEService<NSEPreOpenMarketDetailEntity, NSEPreOpenMarketModel, W> {

    @Override
    public List<NSEPreOpenMarketModel> transformEntities(List<NSEPreOpenMarketDetailEntity> entities) {
        List<NSEPreOpenMarketModel> nsePreOpenMarketModels = new ArrayList<>();
        for (NSEPreOpenMarketDetailEntity nsePreOpenMarketDetailEntity: entities) {
            NSEPreOpenMarketModel nsePreOpenMarketModel = new NSEPreOpenMarketModel();
            nsePreOpenMarketModel.setStockDivId(nsePreOpenMarketDetailEntity.getId());
            nsePreOpenMarketModel.setBusinessDate(nsePreOpenMarketDetailEntity.getBusinessDate());
            nsePreOpenMarketModel.setPreOpenType(nsePreOpenMarketDetailEntity.getPreOpenType());
            nsePreOpenMarketModel.setFinalPrice(nsePreOpenMarketDetailEntity.getFinalPrice());
            nsePreOpenMarketModel.setFinalQuantity(nsePreOpenMarketDetailEntity.getFinalQuantity());
            nsePreOpenMarketModel.setNewMarket52WeekHigh(nsePreOpenMarketDetailEntity.getNewMarket52WeekHigh());
            nsePreOpenMarketModel.setFreeFloatMarketCapitalization(nsePreOpenMarketDetailEntity.getFreeFloatMarketCapitalization());
            nsePreOpenMarketModel.setNewMarket52WeekLow(nsePreOpenMarketDetailEntity.getNewMarket52WeekLow());
            nsePreOpenMarketModel.setPreviousClose(nsePreOpenMarketDetailEntity.getPreviousClose());
            nsePreOpenMarketModel.setPriceChange(nsePreOpenMarketDetailEntity.getPriceChange());
            nsePreOpenMarketModel.setPricePercentageChange(nsePreOpenMarketDetailEntity.getPricePercentageChange());
            nsePreOpenMarketModel.setSymbol(nsePreOpenMarketDetailEntity.getSymbol());
            nsePreOpenMarketModel.setIndicativeEquilibriumPrice(nsePreOpenMarketDetailEntity.getIndicativeEquilibriumPrice());
            nsePreOpenMarketModel.setNewMarket52WeekHigh(nsePreOpenMarketDetailEntity.getNewMarket52WeekHigh());
            nsePreOpenMarketModels.add(nsePreOpenMarketModel);
        }
        return nsePreOpenMarketModels;
    }
}
