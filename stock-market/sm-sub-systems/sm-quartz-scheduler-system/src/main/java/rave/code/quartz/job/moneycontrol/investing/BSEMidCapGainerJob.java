package rave.code.quartz.job.moneycontrol.investing;

import rave.code.data.parser.html.moneycontrol.BSEMidCapGainersParser;
import rave.code.stockmarket.repository.BSEMidCapGainerRepository;
import rave.code.stockmarket.entity.BSEMidCapGainerEntity;
import rave.code.website.data.model.moneycontrol.CapitalGainerModel;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSEMidCapGainerJob extends AbstractInvestingEntityMakerJob<CapitalGainerModel, BSEMidCapGainerEntity> {

    private static final Logger LOGGER = Logger.getLogger(BSEMidCapGainerJob.class.getName());

    @Override
    public List<CapitalGainerModel> getDataFromSource() {
        BSEMidCapGainersParser moneyControlBSEMidCapGainersParser = new BSEMidCapGainersParser();
        return moneyControlBSEMidCapGainersParser.parse();
    }

    @Override
    public List<BSEMidCapGainerEntity> transformSourceData(List<CapitalGainerModel> sourceData) {
        List<BSEMidCapGainerEntity> entities = new ArrayList<>();

        NumberFormat format = NumberFormat.getInstance();
        for (CapitalGainerModel moneyControlCapGainerModel : sourceData) {
            BSEMidCapGainerEntity moneyControlBSEMidCapGainerEntity = new BSEMidCapGainerEntity();

            String companyName = moneyControlCapGainerModel.getStockName();
            if (null != companyName && !"".equals(companyName)) {
                moneyControlBSEMidCapGainerEntity.setStockName(companyName);

                Number value = null;
                try {
                    value = format.parse(moneyControlCapGainerModel.getHigh());
                    moneyControlBSEMidCapGainerEntity.setHigh(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setHigh(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getLow());
                    moneyControlBSEMidCapGainerEntity.setLow(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setLow(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getLastPrice());
                    moneyControlBSEMidCapGainerEntity.setLastPrice(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setLastPrice(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPreviousClose());
                    moneyControlBSEMidCapGainerEntity.setPreviousClose(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setPreviousClose(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getChange());
                    moneyControlBSEMidCapGainerEntity.setVariation(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setVariation(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPercentageGain());
                    moneyControlBSEMidCapGainerEntity.setPercentageGain(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setPercentageGain(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getAverageVolume5Days());
                    moneyControlBSEMidCapGainerEntity.setAverageVolume5Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setAverageVolume5Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getAverageVolume10Days());
                    moneyControlBSEMidCapGainerEntity.setAverageVolume10Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setAverageVolume10Days(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getAverageVolume30Days());
                    moneyControlBSEMidCapGainerEntity.setAverageVolume30Days(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setAverageVolume30Days(String.valueOf(0.00));
                }


                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage30D());
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage30D(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage30D(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage50D());
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage50D(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage50D(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage150D());
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage150D(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage150D(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getDisplacedMovingAverage200D());
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage200D(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setDisplacedMovingAverage200D(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPriceToEarningRatio());
                    moneyControlBSEMidCapGainerEntity.setPriceToEarningRatio(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setPriceToEarningRatio(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getPriceToBookRatio());
                    moneyControlBSEMidCapGainerEntity.setPriceToBookRatio(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setPriceToBookRatio(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getUpperCircuit());
                    moneyControlBSEMidCapGainerEntity.setUpperCircuit(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setUpperCircuit(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getLowerCircuit());
                    moneyControlBSEMidCapGainerEntity.setLowerCircuit(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setLowerCircuit(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlCapGainerModel.getVolumeWeightedAveragePrice());
                    moneyControlBSEMidCapGainerEntity.setVolumeWeightedAveragePrice(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSEMidCapGainerEntity.setVolumeWeightedAveragePrice(String.valueOf(0.00));
                }

                Date toDate = new Date();
                moneyControlBSEMidCapGainerEntity.setCreatedDate(toDate);
                moneyControlBSEMidCapGainerEntity.setModifiedDate(toDate);
                moneyControlBSEMidCapGainerEntity.setCreatedBy("SYSTEM");
                moneyControlBSEMidCapGainerEntity.setModifiedBy("SYSTEM");

                entities.add(moneyControlBSEMidCapGainerEntity);
            }
        }
        return entities;
    }

    @Override
    public void saveTransformedData(List<BSEMidCapGainerEntity> transformedData) {
        BSEMidCapGainerRepository bseMidCapGainerRepository = new BSEMidCapGainerRepository(BSEMidCapGainerEntity.class);
        bseMidCapGainerRepository.bulkUpsert(transformedData);
    }
}
