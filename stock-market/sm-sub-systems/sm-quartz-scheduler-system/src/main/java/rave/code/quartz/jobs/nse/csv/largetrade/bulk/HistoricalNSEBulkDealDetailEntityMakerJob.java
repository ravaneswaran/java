package rave.code.quartz.jobs.nse.csv.largetrade.bulk;

import rave.code.utility.log.JavaUtilLogDecor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class HistoricalNSEBulkDealDetailEntityMakerJob extends NSEDayBulkDealDetailEntityMakerJob {

    public HistoricalNSEBulkDealDetailEntityMakerJob(Date fromDate){
        this.setCsvDownloadUrl("https://www.nseindia.com/api/historicalOR/bulk-block-short-deals?csv=true&optionType=bulk_deals&from=%s&to=%s");
        this.setDownloadPageUrl("https://www.nseindia.com/report-detail/display-bulk-and-block-deals");
        this.reconstructCsvDownloadUrl(fromDate);
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fromLocalDate = LocalDate.parse(simpleDateFormat.format(new Date()), formatter).minusDays(10);

        Date fromDateStart = Date.from(fromLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        HistoricalNSEBulkDealDetailEntityMakerJob historicalNSEBulkDealDetailEntityMakerJob = new HistoricalNSEBulkDealDetailEntityMakerJob(fromDateStart);
        historicalNSEBulkDealDetailEntityMakerJob.saveTransformedData(historicalNSEBulkDealDetailEntityMakerJob.transformSourceData(historicalNSEBulkDealDetailEntityMakerJob.getDataFromSource()));
    }

}
