package com.ngiersz.scraper.file;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

public class CSVFile {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    private String path;

    private UUID uuid;

    private final String EXTENSION = ".csv";
    private final String FILE_NAME_PREFIX = "data";

    public CSVFile() {
        path = System.getProperty("user.home") + File.separator + "data-scraper";
    }

    public CSVFile(String path) {
        this.path = path;
    }

    public void createFile(List<List<String>> data, List<String> headers) throws IOException {
        ascertainDirectoryExists();
        fillFileWithData(path + File.separator + getUniqueFileName(), data, headers);
    }

    public void createFile(List<List<String>> data, String fileName, List<String> headers) throws IOException {
        ascertainDirectoryExists();
        fillFileWithData(path + File.separator + fileName + EXTENSION, data, headers);
    }

    private void fillFileWithData(String filePath, List<List<String>> data, List<String> headers) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        csvPrinter.printRecord(headers);
        csvPrinter.printRecord(data);
        csvPrinter.flush();
        log.info("File " + filePath + " was created");
    }

    private void ascertainDirectoryExists() throws IOException {
        if (!Files.exists(Paths.get(path))) {
            Files.createDirectory(Paths.get(path));
        }
    }

    private String getUniqueFileName() {
        uuid = UUID.randomUUID();
        return FILE_NAME_PREFIX + "_" + uuid.toString() + EXTENSION;
    }

}
