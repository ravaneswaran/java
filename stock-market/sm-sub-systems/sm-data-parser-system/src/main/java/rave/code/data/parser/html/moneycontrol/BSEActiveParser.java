package rave.code.data.parser.html.moneycontrol;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rave.code.data.model.web.external.moneycontrol.BSEGenericActiveModel;
import rave.code.data.parser.html.HTMLSourceParser;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class BSEActiveParser extends HTMLSourceParser<BSEGenericActiveModel> {

    private static final Logger LOGGER = Logger.getLogger(BSEActiveParser.class.getName());

    public BSEActiveParser(String sourceUrl) {
        super(sourceUrl);
    }

    @Override
    public List<BSEGenericActiveModel> parse() {
        try {
            Document document = null;
            try {
                document = Jsoup.connect(this.getSourceUrl()).get();
            } catch (HttpStatusException httpStatusException) {
                LOGGER.log(Level.SEVERE, httpStatusException.getMessage(), httpStatusException);
                LOGGER.log(Level.INFO, "trying again to connect to the site(https://www.moneycontrol.com) for the data.....");
                this.parse();
            }

            List<BSEGenericActiveModel> bseGenericActiveModels = new ArrayList<>();

            if (document != null) {
                Element table = document.select("table").get(1);
                Element tableBody = table.select("tbody").get(0);
                Elements tableRows = tableBody.select("tr");

                for (Element tr : tableRows) {

                    Elements tableData = tr.select("td");

                    /*for (int i = 0; i < tableData.size() - 1; i++) {
                        String element = tableData.get(i).toString();
                        System.out.println(i + " ================>>>>>>> " + element);
                        Elements companyNameAnchorElements = tableData.get(0).select("a");
                        String companyName = "COMPANY-NAME : SOURCE DATA ERROR";
                        if (companyNameAnchorElements.size() > 0) {
                            companyName = companyNameAnchorElements.get(0).text();
                            //System.out.println(companyName);
                        }
                    }*/

                    // the reason why we check this condition is to make sure that we have more or equal to 24 <td>s for the data to be parsed for our need.
                    if (tableData.size() >= 24) {
                        Elements stockNameAnchorElements = tableData.get(0).select("a");

                        String stockName = "COMPANY-NAME : SOURCE DATA ERROR";
                        if (stockNameAnchorElements.size() > 0) {
                            stockName = stockNameAnchorElements.get(0).text();
                        }

                        String group = tableData.get(1).text();
                        String high = tableData.get(2).text();
                        String low = tableData.get(3).text();
                        String lastPrice = tableData.get(4).text();
                        String percentageChange = tableData.get(5).text();
                        String valueInCrores = tableData.get(6).text();

                        Elements averageVolumeTables = tableData.get(7).select("table");
                        String averageVolume5Days = "0.00";
                        String averageVolume10Days = "0.00";
                        String averageVolume30Days = "0.00";

                        if (averageVolumeTables.size() > 0) {
                            Element averageVolumeTable = tableData.get(7).select("table").get(0);
                            Element averageVolumeTableBody = averageVolumeTable.select("tbody").get(0);

                            Element averageVolume5DaysTableRow = averageVolumeTableBody.select("tr").get(0);
                            Element averageVolume10DaysTableRow = averageVolumeTableBody.select("tr").get(1);
                            Element averageVolume30DaysTableRow = averageVolumeTableBody.select("tr").get(2);

                            averageVolume5Days = averageVolume5DaysTableRow.select("td").get(1).select("strong").get(0).text();
                            averageVolume10Days = averageVolume10DaysTableRow.select("td").get(1).select("strong").get(0).text();
                            averageVolume30Days = averageVolume30DaysTableRow.select("td").get(1).select("strong").get(0).text();
                        }

                        String displacedMovingAverage30Days = tableData.get(14).text();
                        String displacedMovingAverage50Days = tableData.get(15).text();
                        String displacedMovingAverage150Days = tableData.get(16).text();
                        String displacedMovingAverage200Days = tableData.get(17).text();

                        String priceToEarningRatio = tableData.get(18).text();
                        String priceToBookRatio = tableData.get(19).text();
                        String upperCircuit = tableData.get(22).text();
                        String lowerCircuit = tableData.get(23).text();
                        String volumeWeightedAveragePrice = tableData.get(24).text();

                        BSEGenericActiveModel bseGenericActiveModel = new BSEGenericActiveModel();
                        bseGenericActiveModel.setStockName(stockName);
                        bseGenericActiveModel.setGroup(group);
                        bseGenericActiveModel.setHigh(high);
                        bseGenericActiveModel.setLow(low);
                        bseGenericActiveModel.setLastPrice(lastPrice);
                        bseGenericActiveModel.setPercentageChange(percentageChange);
                        bseGenericActiveModel.setValueInCrores(valueInCrores);
                        bseGenericActiveModel.setAverageVolume5Days(averageVolume5Days);
                        bseGenericActiveModel.setAverageVolume10Days(averageVolume10Days);
                        bseGenericActiveModel.setAverageVolume30Days(averageVolume30Days);
                        bseGenericActiveModel.setPriceToEarningRatio(priceToEarningRatio);
                        bseGenericActiveModel.setPriceToBookRatio(priceToBookRatio);
                        bseGenericActiveModel.setUpperCircuit(upperCircuit);
                        bseGenericActiveModel.setLowerCircuit(lowerCircuit);
                        bseGenericActiveModel.setVolumeWeightedAveragePrice(volumeWeightedAveragePrice);
                        bseGenericActiveModel.setDisplacedMovingAverage30D(displacedMovingAverage30Days);
                        bseGenericActiveModel.setDisplacedMovingAverage50D(displacedMovingAverage50Days);
                        bseGenericActiveModel.setDisplacedMovingAverage150D(displacedMovingAverage150Days);
                        bseGenericActiveModel.setDisplacedMovingAverage200D(displacedMovingAverage200Days);

                        bseGenericActiveModels.add(bseGenericActiveModel);
                    }
                }
            }

            return bseGenericActiveModels.stream().distinct().collect(Collectors.toList());

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
