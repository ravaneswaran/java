package rave.code.utilities.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserCredentialsFileReader {

    public Map<String, String> read(File file) throws IOException {
        StringBuilder result = new StringBuilder();
        InputStream inputStream = new FileInputStream(file);
        try (Reader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                result.append((char) ch);
            }
        }

        String[] lines = result.toString().split("\n");
        Map<String, String> keyValuePairs = new HashMap<>();
        for (String line : lines) {
            if(null != line && !"".equals(line.trim())) {
                String[] lineDetails = line.split("=");
                keyValuePairs.put(lineDetails[0], lineDetails[1]);
            }
        }
        return keyValuePairs;
    }

    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("/home/ravaneswaran/.username-and-passwords");
        File file = filePath.toFile();
        System.out.println(filePath.toAbsolutePath());
        UserCredentialsFileReader userCredentialsFileReader = new UserCredentialsFileReader();
        Map<String, String> keyValuePairs = userCredentialsFileReader.read(file);
        Set<String> keySet = keyValuePairs.keySet();
        for (String key : keySet) {
            System.out.println(String.format("%s -> %s", key, keyValuePairs.get(key)));
        }
    }

}
