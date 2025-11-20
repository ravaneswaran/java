package rave.code.nse.web.service;

import rave.code.data.model.web.nse.NSEPriceSpurtDetailModel;
import rave.code.data.model.web.nse.NSEStockModel;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;
import rave.code.repository.nse.NSEPriceSpurtDetailRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNSEPriceSpurtService<W> extends AbstractNSEService<NSEPriceSpurtDetailEntity, NSEPriceSpurtDetailModel, W> {

    protected NSEPriceSpurtDetailRepository nsePriceSpurtDetailRepository = new NSEPriceSpurtDetailRepository();

    @Override
    public List<NSEPriceSpurtDetailModel> transformEntities(List<NSEPriceSpurtDetailEntity> entities) {
        List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels = new ArrayList();
        for (NSEPriceSpurtDetailEntity nsePriceSpurtDetailEntity : entities) {
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
            String series = nsePriceSpurtDetailEntity.getNseStockBaseEntity().getSeries();
            if (null != series && !series.equals("null") && !"".equals(series)) {
                nsePriceSpurtDetailModel.setTitle(String.format("%s:%s", series, nsePriceSpurtDetailEntity.getSymbol()));
            } else {
                nsePriceSpurtDetailModel.setTitle(nsePriceSpurtDetailEntity.getSymbol());
            }

            nsePriceSpurtDetailModels.add(nsePriceSpurtDetailModel);
        }

        return nsePriceSpurtDetailModels;
    }

    @Override
    public List<NSEStockModel> getNSEStockModels(List<NSEPriceSpurtDetailEntity> entities) {
        List<NSEStockModel> nseStockModels = new ArrayList<>();
        for (NSEPriceSpurtDetailEntity nsePriceSpurtDetailEntity : entities) {
            NSEStockModel nseStockModel = new NSEStockModel();
            nseStockModel.setStockDivId(nsePriceSpurtDetailEntity.getId());
            nseStockModel.setSymbol(nsePriceSpurtDetailEntity.getSymbol());
            nseStockModel.setPreviousClosePrice(nsePriceSpurtDetailEntity.getPreviousClosePrice());
            nseStockModel.setPercentageChange(nsePriceSpurtDetailEntity.getPercentageChange());
            nseStockModel.setOpenPrice(nsePriceSpurtDetailEntity.getOpenPrice());
            nseStockModel.setLastTradedPrice(nsePriceSpurtDetailEntity.getLastTradedPrice());
            nseStockModels.add(nseStockModel);
        }
        return nseStockModels;
    }
}
