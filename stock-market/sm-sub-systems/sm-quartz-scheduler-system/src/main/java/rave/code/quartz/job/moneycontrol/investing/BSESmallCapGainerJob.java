package rave.code.quartz.job.moneycontrol.investing;

import rave.code.data.parser.html.moneycontrol.BSESmallCapGainersParser;
import rave.code.stockmarket.repository.BSESmallCapGainerRepository;
import rave.code.stockmarket.entity.BSESmallCapGainerEntity;
import rave.code.website.data.model.moneycontrol.CapitalGainerModel;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSESmallCapGainerJob extends AbstractInvestingEntityMakerJob<CapitalGainerModel, BSESmallCapGainerEntity> {

    private static final Logger LOGGER = Logger.getLogger(BSESmallCapGainerJob.class.getName());

    @Override
    public List<CapitalGainerModel> getDataFromSource() {
        BSESmallCapGainersParser moneyControlBSESmallCapGainersParser = new BSESmallCapGainersParser();
        return moneyControlBSESmallCapGainersParser.parse();
    }

    @Override
    public List<BSESmallCapGainerEntity> transformSourceData(List<CapitalGainerModel> sourceData) {
        List<BSESmallCapGainerEntity> entities = new ArrayList<>();

        NumberFormat format = NumberFormat.getInstance();
        for (CapitalGainerModel moneyControlCapGainerModel : sourceData) {
            BSESmallCapGainerEntity moneyControlBSESmallCapGainerEntity = new BSESmallCapGainerEntity();

            String companyName = moneyControlCapGainerModel.getStockName();
            if (null != companyName && !"".equals(companyName)) {
                moneyControlBSESmallCapGainerEntity.setStockName(moneyControlCapGainerModel.getStockName());
                Number value = null;

                try {
                    value = format.parse(moneyControlCapGainerModel.getHigh());
                    moneyControlBSESmallCapGainerEntity.setHigh(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setHigh(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getLow());
                    moneyControlBSESmallCapGainerEntity.setLow(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setLow(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getLastPrice());
                    moneyControlBSESmallCapGainerEntity.setLastPrice(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setLastPrice(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPreviousClose());
                    moneyControlBSESmallCapGainerEntity.setPreviousClose(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setPreviousClose(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getChange());
                    moneyControlBSESmallCapGainerEntity.setVariation(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setVariation(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPercentageGain());
                    moneyControlBSESmallCapGainerEntity.setPercentageGain(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setPercentageGain(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getAverageVolume5Days());
                    moneyControlBSESmallCapGainerEntity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setAverageVolume5Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getAverageVolume10Days());
                    moneyControlBSESmallCapGainerEntity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setAverageVolume10Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getAverageVolume30Days());
                    moneyControlBSESmallCapGainerEntity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setAverageVolume30Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage30D());
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage30D(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage30D(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage50D());
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage50D(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage50D(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage150D());
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage150D(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage150D(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage200D());
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage200D(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setDisplacedMovingAverage200D(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPriceToEarningRatio());
                    moneyControlBSESmallCapGainerEntity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setPriceToEarningRatio(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPriceToBookRatio());
                    moneyControlBSESmallCapGainerEntity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setPriceToBookRatio(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getUpperCircuit());
                    moneyControlBSESmallCapGainerEntity.setUpperCircuit(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setUpperCircuit(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getLowerCircuit());
                    moneyControlBSESmallCapGainerEntity.setLowerCircuit(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setLowerCircuit(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getVolumeWeightedAveragePrice());
                    moneyControlBSESmallCapGainerEntity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSESmallCapGainerEntity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
                }

                Date toDate = new Date();
                moneyControlBSESmallCapGainerEntity.setCreatedDate(toDate);
                moneyControlBSESmallCapGainerEntity.setModifiedDate(toDate);
                moneyControlBSESmallCapGainerEntity.setCreatedBy("SYSTEM");
                moneyControlBSESmallCapGainerEntity.setModifiedBy("SYSTEM");

                entities.add(moneyControlBSESmallCapGainerEntity);
            }
        }
        return entities;
    }

    @Override
    public void saveTransformedData(List<BSESmallCapGainerEntity> transformedData) {
        BSESmallCapGainerRepository bseSmallCapGainerRepository = new BSESmallCapGainerRepository(BSESmallCapGainerEntity.class);
        bseSmallCapGainerRepository.bulkUpsert(transformedData);
    }
}
