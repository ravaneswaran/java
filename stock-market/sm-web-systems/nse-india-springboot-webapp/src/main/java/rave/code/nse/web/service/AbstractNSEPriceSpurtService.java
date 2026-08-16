package rave.code.nse.web.service;

import rave.code.data.model.web.nse.NSEPriceSpurtDetailModel;
import rave.code.data.model.web.nse.NSEStockModel;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.repository.nse.NSEPriceSpurtDetailRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNSEPriceSpurtService<W> extends AbstractNSEService<NSEPriceSpurtDetailEntity, NSEPriceSpurtDetailModel, W> {

    protected NSEPriceSpurtDetailRepository nsePriceSpurtDetailRepository = new NSEPriceSpurtDetailRepository();

    @Override
    public List<NSEPriceSpurtDetailEntity> getEntities() {
        return this.nsePriceSpurtDetailRepository.findDistinctNSEPricePriceSpurtDetails();
    }

    public NSEPriceSpurtDetailModel transformEntity(NSEPriceSpurtDetailEntity nsePriceSpurtDetailEntity) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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
        NSEStockBaseEntity nseStockBaseEntity = nsePriceSpurtDetailEntity.getNseStockBaseEntity();
        String series = "";
        if (null != nseStockBaseEntity) {
            series = nsePriceSpurtDetailEntity.getNseStockBaseEntity().getSeries();
        }

        if (null != series && !series.equals("null") && !"".equals(series)) {
            nsePriceSpurtDetailModel.setTitle(String.format("%s : %s", series.trim(), nsePriceSpurtDetailEntity.getSymbol()));
        } else {
            nsePriceSpurtDetailModel.setTitle(nsePriceSpurtDetailEntity.getSymbol());
        }

        String time = simpleDateFormat.format(nsePriceSpurtDetailEntity.getCreatedDate()).split(" ")[1];
        nsePriceSpurtDetailModel.setAt(String.format("%s %s", "at ", time));

        return nsePriceSpurtDetailModel;
    }

    @Override
    public List<NSEPriceSpurtDetailModel> transformEntities(List<NSEPriceSpurtDetailEntity> entities) {
        List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels = new ArrayList();

        for (NSEPriceSpurtDetailEntity nsePriceSpurtDetailEntity : entities) {
            NSEPriceSpurtDetailModel nsePriceSpurtDetailModel = this.transformEntity(nsePriceSpurtDetailEntity);
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
