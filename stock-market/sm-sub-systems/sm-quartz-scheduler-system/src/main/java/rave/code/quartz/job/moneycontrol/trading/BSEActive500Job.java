package rave.code.quartz.job.moneycontrol.trading;

import org.quartz.DisallowConcurrentExecution;
import rave.code.data.parser.html.moneycontrol.BSEActive500Parser;
import rave.code.stockmarket.repository.BSEActive500Repository;
import rave.code.stockmarket.entity.BSEActive500Entity;
import rave.code.website.data.model.moneycontrol.BSEGenericActiveModel;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@DisallowConcurrentExecution
public class BSEActive500Job extends AbstractTradingEntityMakerJob<BSEGenericActiveModel, BSEActive500Entity> {

    private static final Logger LOGGER = Logger.getLogger(BSEActive500Job.class.getName());

    private BSEActive500Repository bseActive500Repository = new BSEActive500Repository(BSEActive500Entity.class);

    @Override
    public List<BSEGenericActiveModel> getDataFromSource() {
        BSEActive500Parser bseActive500Parser = new BSEActive500Parser();
        List<BSEGenericActiveModel> bseActive500Models = bseActive500Parser.parse();
        return bseActive500Models;
    }

    @Override
    public List<BSEActive500Entity> transformSourceData(List<BSEGenericActiveModel> sourceData) {

        List<BSEActive500Entity> bseActive500Entities = new ArrayList<>();
        NumberFormat format = NumberFormat.getInstance();

        for (BSEGenericActiveModel bseActive500Model : sourceData) {
            BSEActive500Entity bseActive500Entity = this.bseActive500Repository.findBy(bseActive500Model.getStockName().trim());
            if (null == bseActive500Entity) {
                bseActive500Entity = new BSEActive500Entity();
                bseActive500Entity.setStockName(bseActive500Model.getStockName().trim());
            }
            bseActive500Entity.setCategory(bseActive500Model.getGroup());
            Number value = null;

            try {
                value = format.parse(bseActive500Model.getHigh());
                bseActive500Entity.setHigh(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setHigh(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getLow());
                bseActive500Entity.setLow(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setLow(String.valueOf(0.00));
            }

            try {
                String lastPrice = bseActive500Model.getLastPrice();
                if(null != lastPrice && !"".equals(lastPrice)){
                    value = format.parse(lastPrice);
                    lastPrice = String.valueOf(value.doubleValue());
                    bseActive500Entity.setLastPrice(lastPrice);
                    if (bseActive500Entity.isNewEntity()) {
                        bseActive500Entity.setLastPriceMovement(lastPrice);
                    } else {
                        String lastPriceMovement = bseActive500Entity.getLastPriceMovement();
                        if(!lastPriceMovement.contains(lastPrice)) {
                            bseActive500Entity.setLastPriceMovement(String.format("%s -> %s", lastPriceMovement, lastPrice));
                        }
                    }
                } else {
                    LOGGER.log(Level.SEVERE, "LAST PRICE : is found to be null or empty... setting last price to 0.0");
                    bseActive500Entity.setLastPrice(String.valueOf(0.00));
                }
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setLastPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getPercentageChange());
                bseActive500Entity.setPercentageChange(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setPercentageChange(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getValueInCrores());
                bseActive500Entity.setValueInCrores(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setValueInCrores(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getAverageVolume5Days());
                bseActive500Entity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setAverageVolume5Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getAverageVolume10Days());
                bseActive500Entity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setAverageVolume10Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getAverageVolume30Days());
                bseActive500Entity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setAverageVolume30Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getPriceToEarningRatio());
                bseActive500Entity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setPriceToEarningRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getPriceToBookRatio());
                bseActive500Entity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setPriceToBookRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getUpperCircuit());
                bseActive500Entity.setUpperCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setUpperCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getLowerCircuit());
                bseActive500Entity.setLowerCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setLowerCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getVolumeWeightedAveragePrice());
                bseActive500Entity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getDisplacedMovingAverage30D());
                bseActive500Entity.setDisplacedMovingAverage30D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setDisplacedMovingAverage30D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getDisplacedMovingAverage50D());
                bseActive500Entity.setDisplacedMovingAverage50D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setDisplacedMovingAverage50D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getDisplacedMovingAverage150D());
                bseActive500Entity.setDisplacedMovingAverage150D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setDisplacedMovingAverage150D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseActive500Model.getDisplacedMovingAverage200D());
                bseActive500Entity.setDisplacedMovingAverage200D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseActive500Entity.setDisplacedMovingAverage200D(String.valueOf(0.00));
            }

            Date toDate = new Date();
            bseActive500Entity.setCreatedDate(toDate);
            bseActive500Entity.setModifiedDate(toDate);
            bseActive500Entity.setCreatedBy("SYSTEM");
            bseActive500Entity.setModifiedBy("SYSTEM");

            bseActive500Entities.add(bseActive500Entity);
        }
        return bseActive500Entities;
    }

    @Override
    public void saveTransformedData(List<BSEActive500Entity> transformedData) {
        this.bseActive500Repository.bulkUpsert(transformedData);
    }
}
