package rave.code.quartz.jobs.moneycontrol.misc;

import rave.code.data.model.web.external.moneycontrol.BSEGenericActiveModel;
import rave.code.data.parser.html.moneycontrol.BSESensexParser;
import rave.code.entity.bse.BSESensexEntity;
import rave.code.java.date.StockMarketDate;
import rave.code.quartz.jobs.moneycontrol.AbstractMoneyControlEntityMakerJob;
import rave.code.repository.bse.BSESensexRepository;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSESensexJob extends AbstractMoneyControlEntityMakerJob<BSEGenericActiveModel, BSESensexEntity> {

    private static final Logger LOGGER = Logger.getLogger(BSESensexJob.class.getName());

    private BSESensexRepository bseSensexRepository = new BSESensexRepository();

    @Override
    public List<BSEGenericActiveModel> getDataFromSource() {
        BSESensexParser bseSensexParser = new BSESensexParser();
        List<BSEGenericActiveModel> bseSensexModels = bseSensexParser.parse();
        return bseSensexModels;
    }

    @Override
    public List<BSESensexEntity> transformSourceData(List<BSEGenericActiveModel> sourceData) {

        List<BSESensexEntity> bseSensexEntities = new ArrayList<>();
        NumberFormat format = NumberFormat.getInstance();

        for (BSEGenericActiveModel bseSensexModel : sourceData) {

            BSESensexEntity bseSensexEntity = this.bseSensexRepository.findBy(bseSensexModel.getStockName().trim());
            if (null == bseSensexEntity) {
                bseSensexEntity = new BSESensexEntity();
                bseSensexEntity.setStockName(bseSensexModel.getStockName().trim());
            }

            bseSensexEntity.setCategory(bseSensexModel.getGroup());

            Number value = null;
            try {
                value = format.parse(bseSensexModel.getHigh());
                bseSensexEntity.setHigh(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setHigh(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getLow());
                bseSensexEntity.setLow(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setLow(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getLastPrice());
                String lastPrice = String.valueOf(value.doubleValue());
                bseSensexEntity.setLastPrice(lastPrice);
                if (bseSensexEntity.isNewEntity()) {
                    bseSensexEntity.setLastPriceMovement(lastPrice);
                } else {
                    bseSensexEntity.setLastPriceMovement(String.format("%s -> %s", bseSensexEntity.getLastPriceMovement(), lastPrice));
                }
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setLastPrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getPercentageChange());
                bseSensexEntity.setPercentageChange(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setPercentageChange(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getValueInCrores());
                bseSensexEntity.setValueInCrores(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setValueInCrores(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getAverageVolume5Days());
                bseSensexEntity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setAverageVolume5Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getAverageVolume10Days());
                bseSensexEntity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setAverageVolume10Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getAverageVolume30Days());
                bseSensexEntity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setAverageVolume30Days(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getPriceToEarningRatio());
                bseSensexEntity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setPriceToEarningRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getPriceToBookRatio());
                bseSensexEntity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setPriceToBookRatio(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getUpperCircuit());
                bseSensexEntity.setUpperCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setUpperCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getLowerCircuit());
                bseSensexEntity.setLowerCircuit(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setLowerCircuit(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getVolumeWeightedAveragePrice());
                bseSensexEntity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getDisplacedMovingAverage30D());
                bseSensexEntity.setDisplacedMovingAverage30D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setDisplacedMovingAverage30D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getDisplacedMovingAverage50D());
                bseSensexEntity.setDisplacedMovingAverage50D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setDisplacedMovingAverage50D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getDisplacedMovingAverage150D());
                bseSensexEntity.setDisplacedMovingAverage150D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setDisplacedMovingAverage150D(String.valueOf(0.00));
            }

            try {
                value = format.parse(bseSensexModel.getDisplacedMovingAverage200D());
                bseSensexEntity.setDisplacedMovingAverage200D(String.valueOf(value.doubleValue()));
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                bseSensexEntity.setDisplacedMovingAverage200D(String.valueOf(0.00));
            }

            Date toDate = StockMarketDate.getInstance().now();
            bseSensexEntity.setCreatedDate(toDate);
            bseSensexEntity.setModifiedDate(toDate);
            bseSensexEntity.setCreatedBy("SYSTEM");
            bseSensexEntity.setModifiedBy("SYSTEM");

            bseSensexEntities.add(bseSensexEntity);
        }

        return bseSensexEntities;
    }

    @Override
    public void saveTransformedData(List<BSESensexEntity> transformedData) {
        this.bseSensexRepository.bulkUpsert(transformedData);
    }
}