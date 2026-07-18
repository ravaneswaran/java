package rave.code.utilitiy.java.system;

import rave.code.utilities.file.UserCredentialsFileReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockMarketSystemProperties {

    private static final Logger LOGGER = Logger.getLogger(StockMarketSystemProperties.class.getName());

    public static void loadProperties() {
        UserCredentialsFileReader userCredentialsFileReader = new UserCredentialsFileReader();
        Path filePath = Paths.get("/home/ravaneswaran/.username-and-passwords");
        File file = filePath.toFile();
        Map<String, String> keyValuePairs = new HashMap<>();
        try {
            keyValuePairs = userCredentialsFileReader.read(file);
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        }

        Set<String> keys = keyValuePairs.keySet();
        for (String key : keys) {
            System.setProperty(key, keyValuePairs.get(key));
        }
    }
}
