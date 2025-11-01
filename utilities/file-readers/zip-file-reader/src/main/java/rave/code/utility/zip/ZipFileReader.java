package rave.code.utility.zip;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileReader {

    public static final Logger LOGGER = Logger.getLogger(ZipFileReader.class.getName());

    public InputStream read(InputStream inputStream, String zipEntryName) throws IOException {
        ZipInputStream zis = new ZipInputStream(inputStream);
        StringBuffer lineBuffer = new StringBuffer();
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            if (zipEntryName.toLowerCase().equalsIgnoreCase(entry.getName())) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(zis, "UTF-8"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        lineBuffer.append(line).append("\n");
                    }
                }
                break; // stop after reading the target file
            }
            zis.closeEntry();
        }

        if(lineBuffer.toString().length() > 0){
            return new ByteArrayInputStream(lineBuffer.toString().getBytes(StandardCharsets.UTF_8));
        } else {
            return null;
        }
    }
}
