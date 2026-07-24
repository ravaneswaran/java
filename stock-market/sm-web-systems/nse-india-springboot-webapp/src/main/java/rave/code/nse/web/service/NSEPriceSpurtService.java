package rave.code.nse.web.service;

import org.springframework.stereotype.Service;
import rave.code.data.model.web.nse.NSEPriceSpurtDetailModel;
import rave.code.data.model.web.nse.page.PriceSpurtsWebPage;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;
import rave.code.tech.analysis.candle.Candle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class NSEPriceSpurtService extends AbstractNSEPriceSpurtService<PriceSpurtsWebPage> {

    @Override
    public PriceSpurtsWebPage getWebPage() {
        List<NSEPriceSpurtDetailEntity> entities = this.getEntities().stream().sorted(Comparator.comparing(NSEPriceSpurtDetailEntity::getOpenPrice)).toList();
        entities = entities.stream().filter(entity -> entity.getOpenPrice() >= 500).toList();
        return this.getPriceSpurtsWebPage(entities);
    }

    public PriceSpurtsWebPage getOpenPriceWebPage(int lowerOpenPriceLimit, int upperOpenPriceLimit) {
        List<NSEPriceSpurtDetailEntity> entities = this.nsePriceSpurtDetailRepository.findDistinctOpenPricePriceSpurtDetails(lowerOpenPriceLimit, upperOpenPriceLimit);
        return this.getPriceSpurtsWebPage(entities);
    }

    public PriceSpurtsWebPage getPercentageChangeWebPage(int lowerPercentageChangeLimit, int upperPercentageChangeLimit) {
        List<NSEPriceSpurtDetailEntity> entities = this.nsePriceSpurtDetailRepository.findDistinctPercentageChangePriceSpurtDetails(lowerPercentageChangeLimit, upperPercentageChangeLimit);
        return this.getPriceSpurtsWebPage(entities);
    }

    private PriceSpurtsWebPage getPriceSpurtsWebPage(List<NSEPriceSpurtDetailEntity> nsePriceSpurtDetailEntities) {

        PriceSpurtsWebPage priceSpurtsWebPage = new PriceSpurtsWebPage();
        priceSpurtsWebPage.setPriceSpurt(false);

        List<NSEPriceSpurtDetailModel> nsePriceSpurtDetailModels = new ArrayList<>();
        for (NSEPriceSpurtDetailEntity nsePriceSpurtDetailEntity : nsePriceSpurtDetailEntities) {
            String symbol = nsePriceSpurtDetailEntity.getSymbol();
            NSEPriceSpurtDetailModel nsePriceSpurtDetailModel = this.transformEntity(nsePriceSpurtDetailEntity);

            List<NSEPriceSpurtDetailModel> historyModels = new ArrayList<>();
            List<NSEPriceSpurtDetailEntity> histories = this.nsePriceSpurtDetailRepository.findPriceSpurtDetailsForASymbol(symbol);
            histories = histories.stream().sorted(Comparator.comparing(NSEPriceSpurtDetailEntity::getCreatedDate)).toList();

            for (NSEPriceSpurtDetailEntity history : histories) {
                NSEPriceSpurtDetailModel historyModel = this.transformEntity(history);
                historyModel.setMinuteMomentumCss(this.getMinuteMomentumCss(historyModel));
                historyModels.add(historyModel);
            }

            nsePriceSpurtDetailModel.setHistory(historyModels);
            nsePriceSpurtDetailModels.add(nsePriceSpurtDetailModel);
        }

        for (NSEPriceSpurtDetailModel nsePriceSpurtDetailModel : nsePriceSpurtDetailModels) {
            List<NSEPriceSpurtDetailModel> histories = nsePriceSpurtDetailModel.getHistory();
            for (int index = histories.size() - 1; index > 0; index--) {
                NSEPriceSpurtDetailModel currentHistory = histories.get(index);
                int progress = getLTPProgress(histories, index, currentHistory);
                currentHistory.setLtpBackgroundCss(progress == 1 ? "trade-popup-container-stock-td green-bg" : ((progress == -1) ? "trade-popup-container-stock-td red-bg" : "trade-popup-container-stock-td"));
            }
        }

        priceSpurtsWebPage.setNsePriceSpurtDetailModels(nsePriceSpurtDetailModels);
        return priceSpurtsWebPage;
    }

    private int getLTPProgress(List<NSEPriceSpurtDetailModel> histories, int index, NSEPriceSpurtDetailModel currentHistory) {
        NSEPriceSpurtDetailModel previousHistory = histories.get(index - 1);
        Candle currentCandle = new Candle(currentHistory.getOpenPrice(), currentHistory.getHighPrice(), currentHistory.getLowPrice(), currentHistory.getLastTradedPrice());
        Candle previousCandle = new Candle(previousHistory.getOpenPrice(), previousHistory.getHighPrice(), previousHistory.getLowPrice(), previousHistory.getLastTradedPrice());
        return currentCandle.getLTPProgress(previousCandle);
    }

    private String getMinuteMomentumCss(NSEPriceSpurtDetailModel nsePriceSpurtDetailModel) {
        double momentum = ((nsePriceSpurtDetailModel.getLastTradedPrice() - nsePriceSpurtDetailModel.getOpenPrice()) / nsePriceSpurtDetailModel.getOpenPrice()) * 100;
        return (momentum > 4) ? "arrow up green" : "arrow down red";
    }
}
