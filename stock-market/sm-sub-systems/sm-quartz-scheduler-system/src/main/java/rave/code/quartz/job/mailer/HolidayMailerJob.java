package rave.code.quartz.job.mailer;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.mail.java.ElectronicMail;
import rave.code.quartz.job.AbstractQuartzJob;
import rave.code.stockmarket.repository.HolidayRepository;
import rave.code.stockmarket.entity.HolidayEntity;
import rave.code.utility.log.JavaUtilLogDecor;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

        HolidayRepository stockMarketHolidayDataAccess = new HolidayRepository();
        List<HolidayEntity> entities = stockMarketHolidayDataAccess.findAll();

        for (HolidayEntity entity : entities) {
            if (formattedToDate.trim().equals(entity.getHolidate().trim())) {

                String mailContent = "";
                byte[] bytes = new byte[500];
                InputStream inputStream = this.getClass().getResourceAsStream("/holiday_mail.html");
                try {
                    int noOfBytesRead = inputStream.read(bytes);
                    if(-1 < noOfBytesRead){
                        mailContent = new String(bytes).trim();
                    }
                } catch (IOException ioException) {
                    LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
                }

                mailContent = String.format(mailContent, entity.getHoliday(), entity.getDescription());

                try {
                    LOGGER.log(Level.INFO, "SENDING MAIL....");
                    ElectronicMail electronicMail = new ElectronicMail();
                    electronicMail.connect("smtp.gmail.com", "587", "ravaneswaran@gmail.com", "xxpn zrnn ijjz ohcy");
                    electronicMail.sendMail("noreply@stockmarket.com", "ravaneswaran@gmail.com", "Stock Market Holiday Remainder", mailContent);
                } catch (MessagingException messagingException) {
                    LOGGER.log(Level.SEVERE, messagingException.getMessage(), messagingException);
                }
            }
        }
    }
}
