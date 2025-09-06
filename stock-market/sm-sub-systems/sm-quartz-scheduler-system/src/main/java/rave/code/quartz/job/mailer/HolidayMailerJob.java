package rave.code.quartz.job.mailer;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.mail.java.ElectronicMail;
import rave.code.quartz.jobs.AbstractQuartzJob;
import rave.code.stockmarket.entity.HolidayEntity;
import rave.code.stockmarket.repository.HolidayRepository;
import rave.code.utilities.file.UserCredentialsFileReader;
import rave.code.utility.log.JavaUtilLogDecor;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HolidayMailerJob extends AbstractQuartzJob {

    private static final Logger LOGGER = Logger.getLogger(HolidayMailerJob.class.getName());

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();
        HolidayMailerJob holidayMailerJob = new HolidayMailerJob();
        holidayMailerJob.execute(null);
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        Date toDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM dd, YYYY");
        String formattedToDate = simpleDateFormat.format(toDate);
        ResourceBundle quartzResourceBundle = ResourceBundle.getBundle("quartz");

        HolidayRepository stockMarketHolidayDataAccess = new HolidayRepository();
        List<HolidayEntity> entities = stockMarketHolidayDataAccess.findAll();

        for (HolidayEntity entity : entities) {
            if (formattedToDate.trim().equals(entity.getHolidate().trim())) {

                String mailContent = "";
                byte[] bytes = new byte[500];
                InputStream inputStream = this.getClass().getResourceAsStream("/holiday_mail.html");
                try {
                    int noOfBytesRead = inputStream.read(bytes);
                    if (-1 < noOfBytesRead) {
                        mailContent = new String(bytes).trim();
                    }
                } catch (IOException ioException) {
                    LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
                }

                mailContent = String.format(mailContent, entity.getHoliday(), entity.getDescription());

                UserCredentialsFileReader userCredentialsFileReader = new UserCredentialsFileReader();
                Path filePath = Paths.get("stock-market/.username-and-passwords");
                File file = filePath.toFile();
                Map<String, String> keyValuePairs = new HashMap<>();
                try {
                    keyValuePairs = userCredentialsFileReader.read(file);
                } catch (IOException ioException) {
                    LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
                }

                try {
                    LOGGER.log(Level.INFO, "SENDING MAIL....");
                    ElectronicMail electronicMail = new ElectronicMail();
                    electronicMail.connect(quartzResourceBundle.getString("smtp.mail.host"), quartzResourceBundle.getString("smtp.mail.port"), keyValuePairs.get("smtp.mail.username"), keyValuePairs.get("smtp.mail.password"));
                    electronicMail.sendMail(quartzResourceBundle.getString("smtp.mail.from"), keyValuePairs.get("smtp.mail.username"), quartzResourceBundle.getString("holiday.mail.remainder.subject"), mailContent);
                } catch (MessagingException messagingException) {
                    LOGGER.log(Level.SEVERE, messagingException.getMessage(), messagingException);
                }
            }
        }
    }
}
