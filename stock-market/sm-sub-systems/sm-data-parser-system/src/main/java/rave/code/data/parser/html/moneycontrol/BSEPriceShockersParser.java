package rave.code.data.parser.html.moneycontrol;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.data.parser.html.HTMLSourceParser;
import rave.code.data.model.web.external.moneycontrol.PriceShockerModel;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class BSEPriceShockersParser extends HTMLSourceParser<PriceShockerModel> {

    private static final Logger LOGGER = Logger.getLogger(BSEPriceShockersParser.class.getName());

    public BSEPriceShockersParser() {
        //https://www.moneycontrol.com/stocks/marketstats/bse_pshockers/index.php
        super("https://www.moneycontrol.com/stocks/marketstats/bse_pshockers/index.php");
    }

    public static void main(String[] args) {
        BSEPriceShockersParser moneyControlPriceShockersParser = new BSEPriceShockersParser();
        moneyControlPriceShockersParser.parse();
    }

    @Override
    public List<PriceShockerModel> parse() {
        try {
            Document document = null;
            try {
                document = Jsoup.connect(this.getSourceUrl()).get();
            } catch (HttpStatusException httpStatusException) {
                LOGGER.log(Level.SEVERE, httpStatusException.getMessage(), httpStatusException);
                LOGGER.log(Level.INFO, "trying again to connect to the site(https://www.moneycontrol.com) for the data.....");
                this.parse();
            }

            List<PriceShockerModel> priceShockerModels = new ArrayList<>();

            if (document != null) {
                Element table = document.select("table").get(1);
                Element tableBody = table.select("tbody").get(0);
                Elements tableRows = tableBody.select("tr");

                for (Element tr : tableRows) {
                    Elements tableData = tr.select("td");

                    // the reason why we check this condition is to make sure that we have more or equal to 24 <td>s for the data to be parsed for our need.
                    if (tableData.size() >= 22) {
                        Elements stockNameAnchorElements = tableData.get(0).select("a");

                        String stockName = "COMPANY-NAME : SOURCE DATA ERROR";
                        if (stockNameAnchorElements.size() > 0) {
                            stockName = stockNameAnchorElements.get(0).text();
                        }

                        String group = tableData.get(1).text();
                        String sector = tableData.get(2).text();
                        String currentPrice = tableData.get(3).text();
                        String previousPrice = tableData.get(4).text();
                        String percentageChange = tableData.get(5).text();

                        Elements averageVolumeTables = tableData.get(6).select("table");
                        String averageVolume5Days = "0.00";
                        String averageVolume10Days = "0.00";
                        String averageVolume30Days = "0.00";

                        if (averageVolumeTables.size() > 0) {
                            Element averageVolumeTable = tableData.get(6).select("table").get(0);
                            Element averageVolumeTableBody = averageVolumeTable.select("tbody").get(0);

                            Element averageVolume5DaysTableRow = averageVolumeTableBody.select("tr").get(0);
                            Element averageVolume10DaysTableRow = averageVolumeTableBody.select("tr").get(1);
                            Element averageVolume30DaysTableRow = averageVolumeTableBody.select("tr").get(2);

                            averageVolume5Days = averageVolume5DaysTableRow.select("td").get(1).select("strong").get(0).text();
                            averageVolume10Days = averageVolume10DaysTableRow.select("td").get(1).select("strong").get(0).text();
                            averageVolume30Days = averageVolume30DaysTableRow.select("td").get(1).select("strong").get(0).text();
                        }

                        String displacedMovingAverage30Days = tableData.get(13).text();
                        String displacedMovingAverage50Days = tableData.get(14).text();
                        String displacedMovingAverage150Days = tableData.get(15).text();
                        String displacedMovingAverage200Days = tableData.get(16).text();

                        String priceToEarningRatio = tableData.get(17).text();
                        String priceToBookRatio = tableData.get(18).text();
                        String upperCircuit = tableData.get(21).text();
                        String lowerCircuit = tableData.get(22).text();
                        String volumeWeightedAveragePrice = "NO_DATA";

                        PriceShockerModel priceShockerModel = new PriceShockerModel();
                        priceShockerModel.setStockName(stockName);
                        priceShockerModel.setGroup(group);
                        priceShockerModel.setSector(sector);
                        priceShockerModel.setCurrentPrice(currentPrice);
                        priceShockerModel.setPreviousPrice(previousPrice);
                        priceShockerModel.setPercentageChange(percentageChange);
                        priceShockerModel.setAverageVolume5Days(averageVolume5Days);
                        priceShockerModel.setAverageVolume10Days(averageVolume10Days);
                        priceShockerModel.setAverageVolume30Days(averageVolume30Days);
                        priceShockerModel.setPriceToEarningRatio(priceToEarningRatio);
                        priceShockerModel.setPriceToBookRatio(priceToBookRatio);
                        priceShockerModel.setUpperCircuit(upperCircuit);
                        priceShockerModel.setLowerCircuit(lowerCircuit);
                        priceShockerModel.setVolumeWeightedAveragePrice(volumeWeightedAveragePrice);
                        priceShockerModel.setDisplacedMovingAverage30D(displacedMovingAverage30Days);
                        priceShockerModel.setDisplacedMovingAverage50D(displacedMovingAverage50Days);
                        priceShockerModel.setDisplacedMovingAverage150D(displacedMovingAverage150Days);
                        priceShockerModel.setDisplacedMovingAverage200D(displacedMovingAverage200Days);

                        priceShockerModels.add(priceShockerModel);
                    }
                }
            }

            return priceShockerModels.stream().distinct().collect(Collectors.toList());

        } catch (SocketTimeoutException socketTimeoutException) {
            LOGGER.log(Level.SEVERE, socketTimeoutException.getMessage());
            LOGGER.log(Level.INFO, "trying again to connect to the site(https://www.moneycontrol.com) for the data.....");
            return this.parse();
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
            return new ArrayList<>();
        }
    }
}
