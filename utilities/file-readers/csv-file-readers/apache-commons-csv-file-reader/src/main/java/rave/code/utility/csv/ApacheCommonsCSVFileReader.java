package rave.code.utility.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import rave.code.utility.download.FileDownloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApacheCommonsCSVFileReader implements FileReader {

    private static final Logger LOGGER = Logger.getLogger(ApacheCommonsCSVFileReader.class.getName());

    public List<CSVRecord> read(InputStream inputStream) {
        List<CSVRecord> csvRecordList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                try (CSVParser parser = CSVParser.parse(line, CSVFormat.DEFAULT);) {
                    for (CSVRecord csvRecord : parser) {
                        csvRecordList.add(csvRecord);
                    }
                } catch (Exception exception) {
                    LOGGER.log(Level.SEVERE, String.format("Found a erroneous record {%s} while parsing... correcting the same...", line));
                    String correctedLineRecord = this.scanErroneousLine(line);
                    try (CSVParser parser = CSVParser.parse(correctedLineRecord, CSVFormat.DEFAULT);) {
                        for (CSVRecord csvRecord : parser) {
                            csvRecordList.add(csvRecord);
                        }
                    }
                }
            }
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        }
        return csvRecordList;
    }

    private String scanErroneousLine(String line) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] lineComponents = line.split(",");
        for (String lineComponent : lineComponents) {
            int countOccurrencesOfDoubleQuote = countOccurrences(lineComponent, '"');
            if (countOccurrencesOfDoubleQuote > 0) {
                if (countOccurrencesOfDoubleQuote == 2) {
                    stringBuilder.append(lineComponent).append(",");
                } else {
                    int[] indexes = this.findStartAndEndIndexes(lineComponent, '"');
                    String correctedLineComponent = lineComponent.substring(indexes[0], indexes[1] + 1);
                    stringBuilder.append(correctedLineComponent).append(",");
                }
            } else {
                stringBuilder.append(lineComponent).append(",");
            }
        }
        String correctedLineRecord = stringBuilder.toString();
        return correctedLineRecord.substring(0, correctedLineRecord.length() - 1);
    }

    public int countOccurrences(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    public int[] findStartAndEndIndexes(String str, char ch) {
        int[] indexes = new int[2];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                indexes[index] = i;
                index += 1;
            }
            if (index == 2) {
                break;
            }
        }
        return indexes;
    }

    public static void main(String[] args) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String url = String.format("https://www.bseindia.com/download/BhavCopy/Equity/BhavCopy_BSE_CM_0_0_0_%s_F_0000.CSV", simpleDateFormat.format(new Date()));
        System.out.println("---------------->>>>> " + url);

        FileDownloader fileDownloader = new FileDownloader();
        InputStream inputStream = fileDownloader.downloadFile("https://www.bseindia.com/download/BhavCopy/Equity/BhavCopy_BSE_CM_0_0_0_20250813_F_0000.CSV");
        ApacheCommonsCSVFileReader apacheCommonsCSVReader = new ApacheCommonsCSVFileReader();
        List<CSVRecord> csvRecords = apacheCommonsCSVReader.read(inputStream);
        for (CSVRecord csvRecord : csvRecords) {
            System.out.println(csvRecord.toString());
        }
    }
}
