package rave.code.quartz.job.moneycontrol.trading;

import org.quartz.DisallowConcurrentExecution;
import rave.code.data.parser.html.moneycontrol.BSEActive200Parser;
import rave.code.stockmarket.repository.BSEActive200Repository;
import rave.code.stockmarket.entity.BSEActive200Entity;
import rave.code.website.data.model.moneycontrol.BSEGenericActiveModel;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@DisallowConcurrentExecution
public class BSEActive200Job extends AbstractTradingEntityMakerJob<BSEGenericActiveModel, BSEActive200Entity> {

    private static final Logger LOGGER = Logger.getLogger(BSEActive200Job.class.getName());

    private BSEActive200Repository bseActive200Repository = new BSEActive200Repository(BSEActive200Entity.class);

    @Override
    public List<BSEGenericActiveModel> getDataFromSource() {
        BSEActive200Parser bseActive200Parser = new BSEActive200Parser();
        List<BSEGenericActiveModel> bseActive200Models = bseActive200Parser.parse();
        return bseActive200Models;
    }

    @Override
    public List<BSEActive200Entity> transformSourceData(List<BSEGenericActiveModel> sourceData) {

        List<BSEActive200Entity> bseActive200Entities = new ArrayList<>();
        NumberFormat format = NumberFormat.getInstance();

        for (BSEGenericActiveModel bseActive200Model : sourceData) {

            BSEActive200Entity bseActive200Entity = this.bseActive200Repository.findBy(bseActive200Model.getStockName().trim());
            if (null == bseActive200Entity) {
                bseActive200Entity = new BSEActive200Entity();
                bseActive200Entity.setStockName(bseActive200Model.getStockName().trim());
            }
            bseActive200Entity.setCategory(bseActive200Model.getGroup());
            Number value = null;

            try {
                value = format.parse(bseActive200Model.getHigh());
                bseActive200Entity.setHigh(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setHigh(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getLow());
                bseActive200Entity.setLow(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setLow(String.valueOf(0.00));
            }

            try {
                String lastPrice = bseActive200Model.getLastPrice();
                if(null != lastPrice && !"".equals(lastPrice)){
                    value = format.parse(lastPrice);
                    lastPrice = String.valueOf(value.doubleValue());
                    bseActive200Entity.setLastPrice(lastPrice);
                    if (bseActive200Entity.isNewEntity()) {
                        bseActive200Entity.setLastPriceMovement(lastPrice);
                    } else {
                        String lastPriceMovement = bseActive200Entity.getLastPriceMovement();
                        if(!lastPriceMovement.contains(lastPrice)) {
                            bseActive200Entity.setLastPriceMovement(String.format("%s -> %s", lastPriceMovement, lastPrice));
                        }
                    }
                } else {
                    LOGGER.log(Level.SEVERE, "LAST PRICE : is found to be null or empty... setting last price to 0.0");
                    bseActive200Entity.setLastPrice(String.valueOf(0.00));
                }
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setLastPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getPercentageChange());
                bseActive200Entity.setPercentageChange(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setPercentageChange(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getValueInCrores());
                bseActive200Entity.setValueInCrores(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setValueInCrores(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getAverageVolume5Days());
                bseActive200Entity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setAverageVolume5Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getAverageVolume10Days());
                bseActive200Entity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setAverageVolume10Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getAverageVolume30Days());
                bseActive200Entity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setAverageVolume30Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getPriceToEarningRatio());
                bseActive200Entity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setPriceToEarningRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getPriceToBookRatio());
                bseActive200Entity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setPriceToBookRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getUpperCircuit());
                bseActive200Entity.setUpperCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setUpperCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getLowerCircuit());
                bseActive200Entity.setLowerCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setLowerCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getVolumeWeightedAveragePrice());
                bseActive200Entity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getDisplacedMovingAverage30D());
                bseActive200Entity.setDisplacedMovingAverage30D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setDisplacedMovingAverage30D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getDisplacedMovingAverage50D());
                bseActive200Entity.setDisplacedMovingAverage50D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setDisplacedMovingAverage50D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getDisplacedMovingAverage150D());
                bseActive200Entity.setDisplacedMovingAverage150D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setDisplacedMovingAverage150D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive200Model.getDisplacedMovingAverage200D());
                bseActive200Entity.setDisplacedMovingAverage200D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive200Entity.setDisplacedMovingAverage200D(String.valueOf(0.00));
            }

            Date toDate = new Date();
            bseActive200Entity.setCreatedDate(toDate);
            bseActive200Entity.setModifiedDate(toDate);
            bseActive200Entity.setCreatedBy("SYSTEM");
            bseActive200Entity.setModifiedBy("SYSTEM");

            bseActive200Entities.add(bseActive200Entity);
        }

        return bseActive200Entities;
    }

    @Override
    public void saveTransformedData(List<BSEActive200Entity> transformedData) {
        this.bseActive200Repository.bulkUpsert(transformedData);
    }
}