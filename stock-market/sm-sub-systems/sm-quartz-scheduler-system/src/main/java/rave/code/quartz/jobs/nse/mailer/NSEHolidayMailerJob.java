package rave.code.quartz.jobs.nse.mailer;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import rave.code.entity.groww.HolidayEntity;
import rave.code.utilitiy.java.system.StockMarketSystemProperties;
import rave.code.quartz.config.mail.ThymeleafMailConfiguration;
import rave.code.quartz.jobs.AbstractQuartzJob;
import rave.code.repository.groww.HolidayRepository;
import rave.code.utility.email.JavaMailer;
import rave.code.utility.log.JavaUtilLogDecor;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEHolidayMailerJob extends AbstractQuartzJob {

    private static final Logger LOGGER = Logger.getLogger(NSEHolidayMailerJob.class.getName());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        Date toDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd, YYYY");
        String formattedToDate = simpleDateFormat.format(toDate);
        String mailSubject = System.getProperty("nse.holiday.remainder.mail.subject");

        HolidayRepository stockMarketHolidayDataAccess = new HolidayRepository();
        List<HolidayEntity> entities = stockMarketHolidayDataAccess.findAll();

        for (HolidayEntity entity : entities) {
            if (formattedToDate.trim().equals(entity.getHolidate().trim())) {

                Context context = new Context();
                context.setVariable("holiday", entity.getHoliday());
                context.setVariable("description", entity.getDescription());

                ThymeleafMailConfiguration thymeleafMailConfiguration = new ThymeleafMailConfiguration();
                TemplateEngine templateEngine = thymeleafMailConfiguration.mailTemplateEngine();
                String mailContent = templateEngine.process("daily_trade_details_template", context);

                try {
                    LOGGER.log(Level.INFO, String.format("SENDING (%s) MAIL....", mailSubject));
                    JavaMailer javaMailer = new JavaMailer();
                    javaMailer.connect(System.getProperty("smtp.mail.host"), System.getProperty("smtp.mail.port"), System.getProperty("smtp.mail.username"), System.getProperty("smtp.mail.password"));
                    javaMailer.sendMail(System.getProperty("smtp.mail.from"), System.getProperty("smtp.mail.username"), mailSubject, mailContent);
                } catch (MessagingException messagingException) {
                    LOGGER.log(Level.SEVERE, messagingException.getMessage(), messagingException);
                }
            }
        }
    }

    public static void main(String[] args) throws JobExecutionException {
        StockMarketSystemProperties.loadProperties();
        JavaUtilLogDecor.setupLogDecor();
        NSEHolidayMailerJob holidayMailerJob = new NSEHolidayMailerJob();
        holidayMailerJob.execute(null);
    }
}
