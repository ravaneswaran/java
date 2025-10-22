package rave.code.bse.web.service;

import org.springframework.stereotype.Service;
import rave.code.bse.web.service.algorithms.sort.LastPriceComparator;
import rave.code.bse.web.service.decorators.*;
import rave.code.data.model.web.bse.BSEStockModel;
import rave.code.data.model.web.bse.CapitalGainerDetailModel;
import rave.code.data.model.web.bse.page.MidCapGainerWebPage;
import rave.code.entity.bse.BSEMidCapGainerEntity;
import rave.code.repository.bse.BSEMidCapGainerRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BSEMidCapGainerService extends AbstractBSEService<BSEMidCapGainerEntity, CapitalGainerDetailModel, MidCapGainerWebPage> {

    private static final Logger LOGGER = Logger.getLogger(BSEMidCapGainerService.class.getName());

    @Override
    public MidCapGainerWebPage getWebPage() {
        MidCapGainerWebPage midCapGainerWebPage = new MidCapGainerWebPage();
        midCapGainerWebPage.setCapitalGainerDetailModels(this.transformEntities(this.getEntities()));
        return midCapGainerWebPage;
    }

    @Override
    public List<BSEMidCapGainerEntity> getEntities() {
        return new BSEMidCapGainerRepository().findAll();
    }

    @Override
    public List<CapitalGainerDetailModel> transformEntities(List<BSEMidCapGainerEntity> entities) {

        StockTitleDecorator stockTitleDecorator = new StockTitleDecorator();
        StockTitleContainerDecorator stockTitleContainerDecorator = new StockTitleContainerDecorator();
        StockChartContainerDecorator stockChartContainerDecorator = new StockChartContainerDecorator();
        StockPBRatioDecorator stockPBRatioDecorator = new StockPBRatioDecorator();
        StockLastPriceDecorator stockLastPriceDecorator = new StockLastPriceDecorator();
        StockPercentageGainOrChangeDecorator stockPercentageGainOrChangeDecorator = new StockPercentageGainOrChangeDecorator();
        StockPERatioDecorator stockPERatioDecorator = new StockPERatioDecorator();

        List<CapitalGainerDetailModel> stocks = new ArrayList<>();
        for (BSEMidCapGainerEntity entity : entities) {
            CapitalGainerDetailModel stock = new CapitalGainerDetailModel();

            stock.setDisplayName(entity.getStockName());
            stock.setCategory(BSEStockModel.NO_CATEGORY_STOCK);
            String toolTip = String.format("%s", entity.getStockName());
            stock.setToolTip(toolTip);

            String value = "";
            try {
                value = entity.getHigh();
                if (null != value) {
                    stock.setHigh(Double.parseDouble(value));
                } else {
                    stock.setHigh(0.0);
                }
                ;
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setHigh(0.0);
            }
            try {
                value = entity.getLow();
                if (null != value) {
                    stock.setLow(Double.parseDouble(value));
                } else {
                    stock.setLow(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setLow(0.0);
            }
            try {
                value = entity.getLastPrice();
                if (null != value) {
                    stock.setLastPrice(Double.parseDouble(value));
                } else {
                    stock.setLastPrice(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setLastPrice(0.0);
            }
            try {
                value = entity.getPreviousClose();
                if (null != value) {
                    stock.setPreviousClose(Double.parseDouble(value));
                } else {
                    stock.setPreviousClose(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPreviousClose(0.0);
            }
            try {
                value = entity.getVariation();
                if (null != value) {
                    stock.setVariation(Double.parseDouble(value));
                } else {
                    stock.setVariation(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setVariation(0.0);
            }
            try {
                value = entity.getPercentageGain();
                if (null != value) {
                    stock.setPercentageGain(Double.parseDouble(value));
                } else {
                    stock.setPercentageGain(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPercentageGain(0.0);
            }
            //---------------------------------------
            try {
                value = entity.getAverageVolume5Days();
                if (null != value) {
                    stock.setAverageVolume5Days(Double.parseDouble(value));
                } else {
                    stock.setAverageVolume5Days(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setAverageVolume5Days(0.0);
            }
            try {
                value = entity.getAverageVolume10Days();
                if (null != value) {
                    stock.setAverageVolume10Days(Double.parseDouble(value));
                } else {
                    stock.setAverageVolume10Days(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setAverageVolume10Days(0.0);
            }
            try {
                value = entity.getAverageVolume30Days();
                if (null != value) {
                    stock.setAverageVolume30Days(Double.parseDouble(value));
                } else {
                    stock.setAverageVolume30Days(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setAverageVolume30Days(0.0);
            }
            try {
                value = entity.getPriceToEarningRatio();
                if (null != value) {
                    stock.setPriceToEarningRatio(Double.parseDouble(value));
                } else {
                    stock.setPriceToEarningRatio(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPriceToEarningRatio(0.0);
            }
            try {
                value = entity.getPriceToBookRatio();
                if (null != value) {
                    stock.setPriceToBookRatio(Double.parseDouble(value));
                } else {
                    stock.setPriceToBookRatio(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPriceToBookRatio(0.0);
            }
            try {
                value = entity.getLowerCircuit();
                if (null != value) {
                    stock.setLowerCircuit(Double.parseDouble(value));
                } else {
                    stock.setLowerCircuit(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setLowerCircuit(0.0);
            }
            try {
                value = entity.getUpperCircuit();
                if (null != value) {
                    stock.setUpperCircuit(Double.parseDouble(value));
                } else {
                    stock.setUpperCircuit(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setUpperCircuit(0.0);
            }
            try {
                value = entity.getVolumeWeightedAveragePrice();
                if (null != value) {
                    stock.setVolumeWeightedAveragePrice(Double.parseDouble(value));
                } else {
                    stock.setVolumeWeightedAveragePrice(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setVolumeWeightedAveragePrice(0.0);
            }
            try {
                value = entity.getDisplacedMovingAverage30D();
                if (null != value) {
                    stock.setDisplacedMovingAverage30Days(Double.parseDouble(value));
                } else {
                    stock.setDisplacedMovingAverage30Days(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage30Days(0.0);
            }
            try {
                value = entity.getDisplacedMovingAverage50D();
                if (null != value) {
                    stock.setDisplacedMovingAverage50Days(Double.parseDouble(value));
                } else {
                    stock.setDisplacedMovingAverage50Days(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage50Days(0.0);
            }
            try {
                value = entity.getDisplacedMovingAverage150D();
                if (null != value) {
                    stock.setDisplacedMovingAverage150Days(Double.parseDouble(value));
                } else {
                    stock.setDisplacedMovingAverage150Days(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage150Days(0.0);
            }
            try {
                value = entity.getDisplacedMovingAverage200D();
                if (null != value) {
                    stock.setDisplacedMovingAverage150Days(Double.parseDouble(value));
                } else {
                    stock.setDisplacedMovingAverage150Days(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage150Days(0.0);
            }

            stockTitleDecorator.decorate(stock);
            stockTitleContainerDecorator.decorate(stock);
            stockChartContainerDecorator.decorate(stock);
            stockPBRatioDecorator.decorate(stock);
            stockLastPriceDecorator.decorate(stock);
            stockPercentageGainOrChangeDecorator.decorate(stock);
            stockPERatioDecorator.decorate(stock);

            stocks.add(stock);
        }
        Collections.sort(stocks, new LastPriceComparator());
        return stocks;
    }
}
