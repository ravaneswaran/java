package rave.code.quartz.job.moneycontrol.trading;

import org.quartz.DisallowConcurrentExecution;
import rave.code.data.parser.html.moneycontrol.BSEActive100Parser;
import rave.code.stockmarket.repository.BSEActive100Repository;
import rave.code.stockmarket.entity.BSEActive100Entity;
import rave.code.website.data.model.moneycontrol.BSEGenericActiveModel;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@DisallowConcurrentExecution
public class BSEActive100Job extends AbstractTradingEntityMakerJob<BSEGenericActiveModel, BSEActive100Entity> {

    private static final Logger LOGGER = Logger.getLogger(BSEActive100Job.class.getName());

    private BSEActive100Repository bseActive100Repository = new BSEActive100Repository(BSEActive100Entity.class);

    @Override
    public List<BSEGenericActiveModel> getDataFromSource() {
        BSEActive100Parser bseActive100Parser = new BSEActive100Parser();
        List<BSEGenericActiveModel> bseActive100Models = bseActive100Parser.parse();
        return bseActive100Models;
    }

    @Override
    public List<BSEActive100Entity> transformSourceData(List<BSEGenericActiveModel> sourceData) {

        List<BSEActive100Entity> bseActive100Entities = new ArrayList<>();
        NumberFormat format = NumberFormat.getInstance();

        for (BSEGenericActiveModel bseActive100Model : sourceData) {

            BSEActive100Entity bseActive100Entity = this.bseActive100Repository.findBy(bseActive100Model.getStockName().trim());
            if (null == bseActive100Entity) {
                bseActive100Entity = new BSEActive100Entity();
                bseActive100Entity.setStockName(bseActive100Model.getStockName().trim());
            }

            bseActive100Entity.setCategory(bseActive100Model.getGroup());

            Number value = null;
            try {
                value = format.parse(bseActive100Model.getHigh());
                bseActive100Entity.setHigh(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setHigh(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getLow());
                bseActive100Entity.setLow(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setLow(String.valueOf(0.00));
            }

            try {
                String lastPrice = bseActive100Model.getLastPrice();
                if(null != lastPrice && !"".equals(lastPrice)){
                    value = format.parse(lastPrice);
                    lastPrice = String.valueOf(value.doubleValue());
                    bseActive100Entity.setLastPrice(lastPrice);
                    if (bseActive100Entity.isNewEntity()) {
                        bseActive100Entity.setLastPriceMovement(lastPrice);
                    } else {
                        String lastPriceMovement = bseActive100Entity.getLastPriceMovement();
                        if(!lastPriceMovement.contains(lastPrice)) {
                            bseActive100Entity.setLastPriceMovement(String.format("%s -> %s", lastPriceMovement, lastPrice));
                        }
                    }
                } else {
                    LOGGER.log(Level.SEVERE, "LAST PRICE : is found to be null or empty... setting last price to 0.0");
                    bseActive100Entity.setLastPrice(String.valueOf(0.00));
                }
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setLastPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getPercentageChange());
                bseActive100Entity.setPercentageChange(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setPercentageChange(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getValueInCrores());
                bseActive100Entity.setValueInCrores(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setValueInCrores(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getAverageVolume5Days());
                bseActive100Entity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setAverageVolume5Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getAverageVolume10Days());
                bseActive100Entity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setAverageVolume10Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getAverageVolume30Days());
                bseActive100Entity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setAverageVolume30Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getPriceToEarningRatio());
                bseActive100Entity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setPriceToEarningRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getPriceToBookRatio());
                bseActive100Entity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setPriceToBookRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getUpperCircuit());
                bseActive100Entity.setUpperCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setUpperCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getLowerCircuit());
                bseActive100Entity.setLowerCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setLowerCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getVolumeWeightedAveragePrice());
                bseActive100Entity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getDisplacedMovingAverage30D());
                bseActive100Entity.setDisplacedMovingAverage30D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setDisplacedMovingAverage30D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getDisplacedMovingAverage50D());
                bseActive100Entity.setDisplacedMovingAverage50D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setDisplacedMovingAverage50D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getDisplacedMovingAverage150D());
                bseActive100Entity.setDisplacedMovingAverage150D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setDisplacedMovingAverage150D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive100Model.getDisplacedMovingAverage200D());
                bseActive100Entity.setDisplacedMovingAverage200D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive100Entity.setDisplacedMovingAverage200D(String.valueOf(0.00));
            }

            Date toDate = new Date();
            bseActive100Entity.setCreatedDate(toDate);
            bseActive100Entity.setModifiedDate(toDate);
            bseActive100Entity.setCreatedBy("SYSTEM");
            bseActive100Entity.setModifiedBy("SYSTEM");

            bseActive100Entities.add(bseActive100Entity);
        }

        return bseActive100Entities;
    }

    @Override
    public void saveTransformedData(List<BSEActive100Entity> transformedData) {
        this.bseActive100Repository.bulkUpsert(transformedData);
    }
}