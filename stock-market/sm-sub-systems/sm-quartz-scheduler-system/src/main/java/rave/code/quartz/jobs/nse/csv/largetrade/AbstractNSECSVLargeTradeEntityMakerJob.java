package rave.code.quartz.jobs.nse.csv.largetrade;

import rave.code.quartz.jobs.nse.csv.AbstractNSECSVEntityMakerJob;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class AbstractNSECSVLargeTradeEntityMakerJob<T> extends AbstractNSECSVEntityMakerJob<T> {

    public AbstractNSECSVLargeTradeEntityMakerJob(String csvDownloadUrl) {
        super(csvDownloadUrl);
    }

    protected void reconstructCsvDownloadUrl() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate toLocalDate = LocalDate.parse(simpleDateFormat.format(new Date()), formatter);
        Date toDate = Date.from(toLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String toDateStr = simpleDateFormat.format(toDate);
        this.setCsvDownloadUrl(String.format(this.csvDownloadUrl, toDateStr, toDateStr));
    }

    protected void reconstructCsvDownloadUrl(Date fromDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate fromLocalDate = LocalDate.parse(simpleDateFormat.format(fromDate), formatter);
        LocalDate toLocalDate = LocalDate.parse(simpleDateFormat.format(new Date()), formatter);

        Date fromDateStart = Date.from(fromLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date toDateStart = Date.from(toLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        String fromDateStr = simpleDateFormat.format(fromDateStart);
        String toDateStr = simpleDateFormat.format(toDateStart);

        this.setCsvDownloadUrl(String.format(this.csvDownloadUrl, fromDateStr, toDateStr));
    }

}
