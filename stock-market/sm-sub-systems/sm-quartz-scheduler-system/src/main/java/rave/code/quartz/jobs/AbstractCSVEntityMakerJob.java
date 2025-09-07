package rave.code.quartz.jobs;

import java.io.*;
import java.nio.charset.StandardCharsets;

public abstract class AbstractCSVEntityMakerJob<S, T> extends AbstractEntityMakerJob<S, T> {

    protected String csvDownloadUrl;

    public AbstractCSVEntityMakerJob(String csvDownloadUrl) {
        this.setCsvDownloadUrl(csvDownloadUrl);
    }

    public void setCsvDownloadUrl(String csvDownloadUrl) {
        this.csvDownloadUrl = csvDownloadUrl;
    }

    protected byte[] cleanseCsvHeader(InputStream inputStream) throws IOException {
        int available = inputStream.available();
        byte[] contentArray = new byte[available];
        inputStream.read(contentArray);
        inputStream.close();

        return contentArray;
    }

    protected File cleanseCsvHeader(File downloadedFile) throws IOException {
        byte[] contentArray = this.cleanseCsvHeader(new FileInputStream(downloadedFile));
        String fileContent = new String(contentArray);
        fileContent = fileContent.replaceAll(" \n", "");
        OutputStream outputStream = new FileOutputStream(downloadedFile);
        outputStream.write(fileContent.getBytes(StandardCharsets.UTF_8));
        outputStream.close();

        return downloadedFile;
    }
}
