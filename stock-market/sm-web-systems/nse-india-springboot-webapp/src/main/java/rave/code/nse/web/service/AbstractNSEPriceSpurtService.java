package rave.code.nse.web.service;

import rave.code.data.model.web.nse.NSEPriceSpurtDetailModel;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;
import rave.code.repository.nse.NSEPriceSpurtDetailRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNSEPriceSpurtService<W> extends AbstractNSEService<NSEPriceSpurtDetailEntity, NSEPriceSpurtDetailModel, W>{

    protected NSEPriceSpurtDetailRepository nsePriceSpurtDetailRepository = new NSEPriceSpurtDetailRepository();

    @Override
    public List<NSEPriceSpurtDetailModel> transformEntities(List<NSEPriceSpurtDetailEntity> entities) {
        List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels = new ArrayList();
        for (NSEPriceSpurtDetailEntity nsePriceSpurtDetailEntity: entities) {
            NSEPriceSpurtDetailModel nsePriceSpurtDetailModel = new NSEPriceSpurtDetailModel();

            nsePriceSpurtDetailModel.setStockDivId(nsePriceSpurtDetailEntity.getId());
            nsePriceSpurtDetailModel.setSymbol(nsePriceSpurtDetailEntity.getSymbol());
            nsePriceSpurtDetailModel.setOpenPrice(nsePriceSpurtDetailEntity.getOpenPrice());
            nsePriceSpurtDetailModel.setHighPrice(nsePriceSpurtDetailEntity.getHighPrice());
            nsePriceSpurtDetailModel.setLowPrice(nsePriceSpurtDetailEntity.getLowPrice());
            nsePriceSpurtDetailModel.setPreviousClosePrice(nsePriceSpurtDetailEntity.getPreviousClosePrice());
            nsePriceSpurtDetailModel.setPercentageChange(nsePriceSpurtDetailEntity.getPercentageChange());
            nsePriceSpurtDetailModel.setLastTradedPrice(nsePriceSpurtDetailEntity.getLastTradedPrice());
            nsePriceSpurtDetailModel.setValue(nsePriceSpurtDetailEntity.getValue());
            nsePriceSpurtDetailModel.setVolume(nsePriceSpurtDetailEntity.getVolume());

            nsePriceSpurtDetailModels.add(nsePriceSpurtDetailModel);
        }

        return nsePriceSpurtDetailModels;
    }
}
