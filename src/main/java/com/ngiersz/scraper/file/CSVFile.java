package com.ngiersz.scraper.file;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

public class CSVFile {

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

    public void createFile(List<String> data) throws IOException {
        ascertainDirectoryExists();
        fillFileWithData(path + File.separator + getUniqueFileName(), data);
    }

    public void createFile(List<String> data, String fileName) throws IOException {
        ascertainDirectoryExists();
        fillFileWithData(path + File.separator + fileName + EXTENSION, data);
    }

    private void fillFileWithData(String filePath, List<String> data) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        //.withHeader("ID", "Name", "Designation", "Company"));
        csvPrinter.printRecord(data);
        csvPrinter.flush();
        System.out.println("File " + filePath + " was created");
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
