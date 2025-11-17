package rave.code.nse.web.service.top20;

import rave.code.data.model.web.nse.NSEStockModel;
import rave.code.entity.nse.csv.NSETop20DetailEntity;
import rave.code.nse.web.service.AbstractNSEService;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNSETop20Service<T, W> extends AbstractNSEService<NSETop20DetailEntity, T, W> {

    public abstract List<T> transformEntities(List<NSETop20DetailEntity> nseTop20DetailEntities);

    @Override
    public List<NSEStockModel> getNSEStockModels(List<NSETop20DetailEntity> entities) {
        List<NSEStockModel> nseStockModels = new ArrayList<>();
        for (NSETop20DetailEntity nseTop20DetailEntity: entities) {
            NSEStockModel nseStockModel = new NSEStockModel();
            nseStockModel.setStockDivId(nseTop20DetailEntity.getId());
            nseStockModel.setSymbol(nseTop20DetailEntity.getSymbol());
            nseStockModel.setPreviousClosePrice(nseTop20DetailEntity.getPreviousClosePrice());
            nseStockModel.setPercentageChange(nseTop20DetailEntity.getPercentageChange());
            nseStockModel.setOpenPrice(nseTop20DetailEntity.getOpenPrice());
            nseStockModel.setLastTradedPrice(nseTop20DetailEntity.getLastTradedPrice());
            nseStockModels.add(nseStockModel);
        }
        return nseStockModels;
    }

}
