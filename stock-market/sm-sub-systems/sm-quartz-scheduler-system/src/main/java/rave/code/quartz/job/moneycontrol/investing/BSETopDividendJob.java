package rave.code.quartz.job.moneycontrol.investing;

import rave.code.data.parser.html.moneycontrol.BSETopDividendParser;
import rave.code.stockmarket.repository.BSETopDividendRepository;
import rave.code.stockmarket.entity.BSETopDividendEntity;
import rave.code.website.data.model.moneycontrol.DividendModel;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BSETopDividendJob extends AbstractInvestingEntityMakerJob<DividendModel, BSETopDividendEntity> {

    private static final Logger LOGGER = Logger.getLogger(BSETopDividendJob.class.getName());

    @Override
    public List<DividendModel> getDataFromSource() {
        return new BSETopDividendParser().parse();
    }

    @Override
    public List<BSETopDividendEntity> transformSourceData(List<DividendModel> sourceData) {
        List<BSETopDividendEntity> entities = new ArrayList<>();

        NumberFormat format = NumberFormat.getInstance();
        for (DividendModel moneyControlDividendModel : sourceData) {
            BSETopDividendEntity moneyControlBSETopDividendEntity = new BSETopDividendEntity();

            String companyName = moneyControlDividendModel.getStockName();
            if (null != companyName && !"".equals(companyName)) {
                moneyControlBSETopDividendEntity.setStockName(companyName);

                Number value = null;
                try {
                    value = format.parse(moneyControlDividendModel.getLastPrice());
                    moneyControlBSETopDividendEntity.setLastPrice(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSETopDividendEntity.setLastPrice(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlDividendModel.getLatestDividendPercentage());
                    moneyControlBSETopDividendEntity.setLatestDividendPercentage(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSETopDividendEntity.setLatestDividendPercentage(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlDividendModel.getDividendYieldPercentAt52High());
                    moneyControlBSETopDividendEntity.setDividendYieldPercentage52High(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSETopDividendEntity.setDividendYieldPercentage52High(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlDividendModel.getDividendYieldPercentAt52Low());
                    moneyControlBSETopDividendEntity.setDividendYieldPercentage52Low(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSETopDividendEntity.setDividendYieldPercentage52Low(String.valueOf(0.00));
                }

                try {
                    value = format.parse(moneyControlDividendModel.getDividendYieldPercentAtCurrent());
                    moneyControlBSETopDividendEntity.setDividendYieldPercentageAtCurrent(String.valueOf(value.doubleValue()));
                } catch (ParseException parseException) {
                    LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
                    moneyControlBSETopDividendEntity.setDividendYieldPercentageAtCurrent(String.valueOf(0.00));
                }

                Date toDate = new Date();
                moneyControlBSETopDividendEntity.setCreatedDate(toDate);
                moneyControlBSETopDividendEntity.setModifiedDate(toDate);
                moneyControlBSETopDividendEntity.setCreatedBy("SYSTEM");
                moneyControlBSETopDividendEntity.setModifiedBy("SYSTEM");

                entities.add(moneyControlBSETopDividendEntity);
            }
        }
        return entities;
    }

    @Override
    public void saveTransformedData(List<BSETopDividendEntity> transformedData) {
        BSETopDividendRepository bseTopDividendRepository = new BSETopDividendRepository();
        bseTopDividendRepository.bulkUpsert(transformedData);
    }
}
