package rave.code.utilities.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVFileReader {

    public List<String> read(InputStream inputStream) throws IOException, CsvValidationException {
        return normalFileReadStyle(inputStream);
    }

    private List<String> normalFileReadStyle(InputStream inputStream) throws IOException, CsvValidationException {
        List<String> lineList = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        if(null != inputStream) {
            try (Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
                int ch;
                while ((ch = reader.read()) != -1) {
                    result.append((char) ch);
                }
            }
        }
        String[] lines = result.toString().split("\n");
        for (String line : lines) {
            lineList.add(line);
        }
        return lineList;
    }

    private List<String> openCSVReadStyle(InputStream inputStream) throws IOException, CsvValidationException {
        List<String> lines = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        CSVReader reader = new CSVReader(bufferedReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }
}
