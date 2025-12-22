package rave.code.quartz.jobs.nse.mailer;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;
import rave.code.java.system.StockMarketSystemProperties;
import rave.code.quartz.config.mail.ThymeleafMailConfiguration;
import rave.code.quartz.jobs.AbstractQuartzJob;
import rave.code.quartz.jobs.nse.mailer.model.NSEDailyTradeDetailMailerModel;
import rave.code.repository.nse.NSEPriceSpurtDetailRepository;
import rave.code.utility.email.JavaMailer;
import rave.code.utility.log.JavaUtilLogDecor;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEDailyTradeDetailsMailerJob extends AbstractQuartzJob {

    private static final Logger LOGGER = Logger.getLogger(NSEDailyTradeDetailsMailerJob.class.getName());

    private NSEPriceSpurtDetailRepository nsePriceSpurtDetailRepository = new NSEPriceSpurtDetailRepository();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        List<NSEPriceSpurtDetailEntity> nsePriceSpurtDetailEntities = this.nsePriceSpurtDetailRepository.findAll();

        Context context = new Context();
        context.setVariable("nseDailyTradeDetailMailerModels", this.transformSourceData(nsePriceSpurtDetailEntities));

        ThymeleafMailConfiguration thymeleafMailConfiguration = new ThymeleafMailConfiguration();
        TemplateEngine templateEngine = thymeleafMailConfiguration.mailTemplateEngine();
        String mailContent = templateEngine.process("daily_trade_details_template", context);

        try {
            LOGGER.log(Level.INFO, "SENDING MAIL....");
            JavaMailer javaMailer = new JavaMailer();
            javaMailer.connect(System.getProperty("smtp.mail.host"), System.getProperty("smtp.mail.port"), System.getProperty("smtp.mail.username"), System.getProperty("smtp.mail.password"));
            javaMailer.sendMail(System.getProperty("smtp.mail.from"), System.getProperty("smtp.mail.username"), System.getProperty("holiday.mail.remainder.subject"), mailContent);
        } catch (MessagingException messagingException) {
            LOGGER.log(Level.SEVERE, messagingException.getMessage(), messagingException);
        }
    }

    private List<NSEDailyTradeDetailMailerModel> transformSourceData(List<NSEPriceSpurtDetailEntity> nsePriceSpurtDetailEntities) {
        List<NSEDailyTradeDetailMailerModel> nseDailyTradeDetailMailerModels = new ArrayList<>();
        for (NSEPriceSpurtDetailEntity nsePriceSpurtDetailEntity : nsePriceSpurtDetailEntities) {
            NSEDailyTradeDetailMailerModel nseDailyTradeDetailMailerModel = new NSEDailyTradeDetailMailerModel();

            nseDailyTradeDetailMailerModel.setId(nsePriceSpurtDetailEntity.getId());
            nseDailyTradeDetailMailerModel.setStockBaseId(nsePriceSpurtDetailEntity.getNseStockBaseEntity().getId());
            nseDailyTradeDetailMailerModel.setSymbol(nsePriceSpurtDetailEntity.getSymbol());
            nseDailyTradeDetailMailerModel.setOpenPrice(nsePriceSpurtDetailEntity.getOpenPrice());
            nseDailyTradeDetailMailerModel.setHighPrice(nsePriceSpurtDetailEntity.getHighPrice());
            nseDailyTradeDetailMailerModel.setLowPrice(nsePriceSpurtDetailEntity.getLowPrice());
            nseDailyTradeDetailMailerModel.setLastTradedPrice(nsePriceSpurtDetailEntity.getLastTradedPrice());
            nseDailyTradeDetailMailerModel.setPercentageChange(nsePriceSpurtDetailEntity.getPercentageChange());
            nseDailyTradeDetailMailerModel.setPreviousClosePrice(nsePriceSpurtDetailEntity.getPreviousClosePrice());

            nseDailyTradeDetailMailerModels.add(nseDailyTradeDetailMailerModel);
        }
        return nseDailyTradeDetailMailerModels;
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();
        StockMarketSystemProperties.loadProperties();
        NSEDailyTradeDetailsMailerJob nseDailyTradeDetailsMailerJob = new NSEDailyTradeDetailsMailerJob();
        nseDailyTradeDetailsMailerJob.execute(null);
    }
}
