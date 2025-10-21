package rave.code.bse.web.service;

import org.springframework.stereotype.Service;
import rave.code.bse.web.service.algorithms.sort.LastPriceComparator;
import rave.code.bse.web.service.decorators.*;
import rave.code.data.model.web.bse.BSEStockModel;
import rave.code.data.model.web.bse.TopDividendDetailModel;
import rave.code.data.model.web.bse.page.BSEWebPage;
import rave.code.stockmarket.entity.BSETopDividendEntity;
import rave.code.stockmarket.repository.BSETopDividendRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BSETopDividendService extends AbstractBSEService<BSETopDividendEntity, TopDividendDetailModel> {

    private static final Logger LOGGER = Logger.getLogger(BSETopDividendService.class.getName());

    @Override
    public BSEWebPage getWebPage() {
        BSEWebPage webPage = super.getWebPage();
        webPage.setTopDividendLinkStyle("font-weight: bold;");
        return webPage;
    }

    @Override
    public List<BSETopDividendEntity> getEntities() {
        BSETopDividendRepository moneyControlBSETopDividendDataAccess = new BSETopDividendRepository();
        return moneyControlBSETopDividendDataAccess.findAll();
    }

    @Override
    public List<TopDividendDetailModel> transformEntities(List<BSETopDividendEntity> entities) {

        StockTitleDecorator stockTitleDecorator = new StockTitleDecorator();
        StockTitleContainerDecorator stockTitleContainerDecorator = new StockTitleContainerDecorator();
        StockChartContainerDecorator stockChartContainerDecorator = new StockChartContainerDecorator();
        StockPBRatioDecorator stockPBRatioDecorator = new StockPBRatioDecorator();
        StockLastPriceDecorator stockLastPriceDecorator = new StockLastPriceDecorator();
        StockPercentageGainOrChangeDecorator stockPercentageGainOrChangeDecorator = new StockPercentageGainOrChangeDecorator();
        StockPERatioDecorator stockPERatioDecorator = new StockPERatioDecorator();

        List<TopDividendDetailModel> stocks = new ArrayList<>();
        for (BSETopDividendEntity entity : entities) {
            TopDividendDetailModel stock = new TopDividendDetailModel();

            stock.setDisplayName(entity.getStockName());
            stock.setCategory(BSEStockModel.NO_CATEGORY_STOCK);
            String toolTip = String.format("%s", entity.getStockName());
            stock.setToolTip(toolTip);

            try {
                String lastPrice = entity.getLastPrice();
                if (null != lastPrice) {
                    stock.setLastPrice(Double.parseDouble(lastPrice));
                } else {
                    stock.setLastPrice(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setLastPrice(0.0);
            }
            try {
                String dividendYieldPercentage52High = entity.getDividendYieldPercentage52High();
                if (null != dividendYieldPercentage52High) {
                    stock.setDividendYieldPercentage52High(Double.parseDouble(dividendYieldPercentage52High));
                } else {
                    stock.setDividendYieldPercentage52High(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDividendYieldPercentage52High(0.0);
            }
            try {
                String dividendYieldPercentage52Low = entity.getDividendYieldPercentage52Low();
                if (null != dividendYieldPercentage52Low) {
                    stock.setDividendYieldPercentage52Low(Double.parseDouble(dividendYieldPercentage52Low));
                } else {
                    stock.setDividendYieldPercentage52Low(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDividendYieldPercentage52Low(0.0);
            }
            try {
                String dividendYieldPercentageAtCurrent = entity.getDividendYieldPercentageAtCurrent();
                if (null != dividendYieldPercentageAtCurrent) {
                    stock.setDividendYieldPercentageAtCurrent(Double.parseDouble(dividendYieldPercentageAtCurrent));
                } else {
                    stock.setDividendYieldPercentageAtCurrent(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDividendYieldPercentageAtCurrent(0.0);
            }

            stockTitleDecorator.decorate(stock);
            stockTitleContainerDecorator.decorate(stock);
            stockChartContainerDecorator.decorate(stock);
            stockPBRatioDecorator.decorate(stock);
            stockLastPriceDecorator.decorate(stock);
            stockPERatioDecorator.decorate(stock);


            stocks.add(stock);
        }

        Collections.sort(stocks, new LastPriceComparator());
        return stocks;
    }
}
