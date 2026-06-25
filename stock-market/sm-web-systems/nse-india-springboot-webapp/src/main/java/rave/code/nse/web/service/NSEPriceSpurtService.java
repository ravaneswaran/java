package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.NSEPriceSpurtDetailModel;
import rave.code.data.model.web.nse.page.PriceSpurtsWebPage;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class NSEPriceSpurtService extends AbstractNSEPriceSpurtService<PriceSpurtsWebPage> {

    @Override
    public PriceSpurtsWebPage getWebPage() {
        List<NSEPriceSpurtDetailEntity> entities = this.getEntities().stream().sorted(Comparator.comparing(NSEPriceSpurtDetailEntity::getOpenPrice)).toList();
        PriceSpurtsWebPage priceSpurtsWebPage = new PriceSpurtsWebPage();
        priceSpurtsWebPage.setPriceSpurt(false);

        List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels = new ArrayList<>();
        for (NSEPriceSpurtDetailEntity nsePriceSpurtDetailEntity : entities) {
            String symbol = nsePriceSpurtDetailEntity.getSymbol();
            NSEPriceSpurtDetailModel nsePriceSpurtDetailModel = this.transformEntity(nsePriceSpurtDetailEntity);

            List<NSEPriceSpurtDetailModel> historyModels = new ArrayList<>();
            List<NSEPriceSpurtDetailEntity> histories = this.nsePriceSpurtDetailRepository.findPriceSpurtDetailsForASymbol(symbol);
            for (NSEPriceSpurtDetailEntity history : histories) {
                NSEPriceSpurtDetailModel historyModel = this.transformEntity(history);
                historyModels.add(historyModel);
            }

            nsePriceSpurtDetailModel.setHistory(historyModels);
            nsePriceSpurtDetailModels.add(nsePriceSpurtDetailModel);
        }

        priceSpurtsWebPage.setNsePriceSpurtDetailModels(nsePriceSpurtDetailModels);
        return priceSpurtsWebPage;
    }

    @Override
    public List<NSEPriceSpurtDetailEntity> getEntities() {
        return this.nsePriceSpurtDetailRepository.findTodayDistinctPriceSpurtDetails();
    }
}
