package rave.code.utility.csv;

import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestApacheCommonsCSVFileReader {

    private final ApacheCommonsCSVFileReader apacheCommonsCSVFileReader = new ApacheCommonsCSVFileReader();

    @Test
    public void testApacheCommonsCSVFileRead() throws IOException {
        List<CSVRecord> csvRecords = null;
        try (InputStream inputStream = this.getClass().getResourceAsStream("/csv/errorneous-csv-record-file.csv");) {
            csvRecords = this.apacheCommonsCSVFileReader.read(inputStream);
        }
        assertNotNull(csvRecords);
        assertFalse(csvRecords.isEmpty());
    }
}
