package rave.code.nse.web.threads;

import rave.code.java.date.StockMarketDate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class TechnicalAnalysisThread<T> extends Thread {

    private static final Logger LOGGER = Logger.getLogger(TechnicalAnalysisThread.class.getName());

    private List<T> sourceData;

    public TechnicalAnalysisThread() {
        this.sourceData = new ArrayList<>();
    }

    public TechnicalAnalysisThread(List<T> sourceData) {
        this.sourceData = sourceData;
    }

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        System.out.println(String.format("<<<<<<<<<<<<< TechnicalAnalysisThread Created at %s with items count(%s) >>>>>>>>>>>", simpleDateFormat.format(StockMarketDate.getInstance().now()), this.sourceData.size()));
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 1347; i++) {
            stringList.add(String.valueOf(i));
        }
        int remainder = stringList.size() % 10;
        for (int i = remainder; i < 10; i++) {
            stringList.add(null);
        }

        int higherIndex = 10;

        for (int lowerIndex = 0; lowerIndex < stringList.size(); ) {

            List<String> subList = stringList.subList(lowerIndex, higherIndex);
            TechnicalAnalysisThread<String> technicalAnalysisThread2 = new TechnicalAnalysisThread<>(subList);
            technicalAnalysisThread2.start();

            lowerIndex = higherIndex;
            higherIndex += 10;

        }
    }
}
