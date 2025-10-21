package rave.code.bse.web.service;

import rave.code.data.model.web.bse.page.PriceShockerWebPage;
import rave.code.data.model.web.bse.stock.PriceShockerStock;
import rave.code.bse.web.service.algorithms.sort.CurrentPriceComparator;
import rave.code.bse.web.service.decorators.*;
import rave.code.stockmarket.repository.BSEPriceShockerRepository;
import rave.code.stockmarket.entity.BSEPriceShockerEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PriceShockerService extends AbstractService<BSEPriceShockerEntity, PriceShockerStock> {

    private static final Logger LOGGER = Logger.getLogger(VolumeShockerService.class.getName());

    public PriceShockerWebPage getPageModel() {
        PriceShockerWebPage priceShockerWebPage = new PriceShockerWebPage();
        priceShockerWebPage.setPriceShockersLinkStyle("font-weight: bold;");

        List<BSEPriceShockerEntity> entities = this.getEntities();
        priceShockerWebPage.setPriceShockerStocks(this.getStocks(entities));

        return priceShockerWebPage;
    }

    public List<BSEPriceShockerEntity> getEntities() {
        BSEPriceShockerRepository moneyControlBSEPriceShockerDataAccess = new BSEPriceShockerRepository();
        return moneyControlBSEPriceShockerDataAccess.findAll();
    }

    public List<PriceShockerStock> getStocks(List<BSEPriceShockerEntity> entities) {

        StockTitleDecorator stockTitleDecorator = new StockTitleDecorator();
        StockTitleContainerDecorator stockTitleContainerDecorator = new StockTitleContainerDecorator();
        StockChartContainerDecorator stockChartContainerDecorator = new StockChartContainerDecorator();
        StockPBRatioDecorator stockPBRatioDecorator = new StockPBRatioDecorator();
        StockLastPriceDecorator stockLastPriceDecorator = new StockLastPriceDecorator();
        StockPercentageGainOrChangeDecorator stockPercentageGainOrChangeDecorator = new StockPercentageGainOrChangeDecorator();
        StockPERatioDecorator stockPERatioDecorator = new StockPERatioDecorator();

        List<PriceShockerStock> priceShockerStocks = new ArrayList<>();
        for (BSEPriceShockerEntity entity : entities) {
            PriceShockerStock stock = new PriceShockerStock();

            stock.setDisplayName(entity.getStockName());
            String toolTip = String.format("%s (%s)", entity.getStockName(), entity.getCategory());
            stock.setToolTip(toolTip);
            stock.setCategory(entity.getCategory());

            String sector = entity.getSector();
            stock.setSectorToolTip(sector);

            if (null != sector && sector.length() > 6) {
                sector = sector.substring(0, 4) + "..";
            }
            stock.setSector(sector);
            
            try {
                String currentPrice = entity.getCurrentPrice();
                if (null != currentPrice) {
                    stock.setCurrentPrice(Double.parseDouble(currentPrice));
                } else {
                    stock.setCurrentPrice(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setCurrentPrice(0.0);
            }
            try {
                String previousPrice = entity.getPreviousPrice();
                if (null != previousPrice) {
                    stock.setPreviousPrice(Double.parseDouble(previousPrice));
                } else {
                    stock.setPreviousPrice(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPreviousPrice(0.0);
            }
            try {
                String upperCircuit = entity.getUpperCircuit();
                if (null != upperCircuit) {
                    stock.setUpperCircuit(Double.parseDouble(upperCircuit));
                } else {
                    stock.setUpperCircuit(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setUpperCircuit(0.0);
            }
            try {
                String lowerCircuit = entity.getLowerCircuit();
                if (null != lowerCircuit) {
                    stock.setLowerCircuit(Double.parseDouble(lowerCircuit));
                } else {
                    stock.setLowerCircuit(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setLowerCircuit(0.0);
            }

            try {
                String percentageChange = entity.getPercentageChange();
                if (null != percentageChange) {
                    stock.setPercentageChange(Double.parseDouble(percentageChange));
                } else {
                    stock.setPercentageChange(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPercentageChange(0.0);
            }

            try {
                String averageVolume5D = entity.getAverageVolume5Days();
                if (null != averageVolume5D) {
                    stock.setAverageVolume5D(Double.parseDouble(averageVolume5D));
                } else {
                    stock.setAverageVolume5D(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setAverageVolume5D(0.0);
            }
            try {
                String averageVolume10D = entity.getAverageVolume10Days();
                if (null != averageVolume10D) {
                    stock.setAverageVolume10D(Double.parseDouble(averageVolume10D));
                } else {
                    stock.setAverageVolume10D(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setAverageVolume10D(0.0);
            }
            try {
                String averageVolume30D = entity.getAverageVolume30Days();
                if (null != averageVolume30D) {
                    stock.setAverageVolume30D(Double.parseDouble(entity.getAverageVolume30Days()));
                } else {
                    stock.setAverageVolume30D(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setAverageVolume30D(0.0);
            }
            try {
                String displacedMovingAverage30D = entity.getDisplacedMovingAverage30D();
                if (null != displacedMovingAverage30D) {
                    stock.setDisplacedMovingAverage30D(Double.parseDouble(displacedMovingAverage30D));
                } else {
                    stock.setDisplacedMovingAverage30D(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage30D(0.0);
            }
            try {
                String displacedMovingAverage50D = entity.getDisplacedMovingAverage50D();
                if (null != entity.getDisplacedMovingAverage50D()) {
                    stock.setDisplacedMovingAverage50D(Double.parseDouble(displacedMovingAverage50D));
                } else {
                    stock.setDisplacedMovingAverage50D(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage50D(0.0);
            }
            try {
                String displacedMovingAverage150D = entity.getDisplacedMovingAverage150D();
                if (null != displacedMovingAverage150D) {
                    stock.setDisplacedMovingAverage150D(Double.parseDouble(displacedMovingAverage150D));
                } else {
                    stock.setDisplacedMovingAverage150D(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage150D(0.0);
            }
            try {
                String displacedMovingAverage200D = entity.getDisplacedMovingAverage200D();
                if (null != displacedMovingAverage200D) {
                    stock.setDisplacedMovingAverage200D(Double.parseDouble(displacedMovingAverage200D));
                } else {
                    stock.setDisplacedMovingAverage200D(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setDisplacedMovingAverage200D(0.0);
            }
            try {
                String peRatio = entity.getPriceToEarningRatio();
                if (null != peRatio) {
                    stock.setPriceToEarningRatio(Double.parseDouble(peRatio));
                } else {
                    stock.setPriceToEarningRatio(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPriceToEarningRatio(0.0);
            }
            try {
                String pbRatio = entity.getPriceToBookRatio();
                if (null != pbRatio) {
                    stock.setPriceToBookRatio(Double.parseDouble(pbRatio));
                } else {
                    stock.setPriceToBookRatio(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setPriceToBookRatio(0.0);
            }
            try {
                String vwap = entity.getVolumeWeightedAveragePrice();
                if (null != vwap) {
                    stock.setVolumeWeightedAveragePrice(Double.parseDouble(vwap));
                } else {
                    stock.setVolumeWeightedAveragePrice(0.0);
                }
            } catch (NumberFormatException nfe) {
                LOGGER.log(Level.SEVERE, nfe.getMessage(), nfe);
                stock.setVolumeWeightedAveragePrice(0.0);
            }

            stockTitleDecorator.decorate(stock);
            stockTitleContainerDecorator.decorate(stock);
            stockChartContainerDecorator.decorate(stock);
            stockPBRatioDecorator.decorate(stock);
            stockLastPriceDecorator.decorate(stock);
            stockPercentageGainOrChangeDecorator.decorate(stock);
            stockPERatioDecorator.decorate(stock);

            priceShockerStocks.add(stock);
        }

        Collections.sort(priceShockerStocks, new CurrentPriceComparator());

        return priceShockerStocks;
    }

}
