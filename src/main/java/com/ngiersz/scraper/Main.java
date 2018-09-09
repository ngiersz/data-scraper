package com.ngiersz.scraper;

import com.google.common.collect.Lists;
import com.ngiersz.scraper.file.CSVFile;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "https://www.filmweb.pl/user/ngiersz/films";
        Connection connection = new Connection(path);
        String content = connection.getResponse();

        Document doc = Jsoup.parse(content);

        Scraper mapper = new Scraper();

        List<String> classNames = mapper.getAllUniqueClassNames(doc);

        System.out.println("What data do you want to see? Choose one class from the list:");
//        print(classNames);

        List<String> chosenClasses = Lists.newArrayList("filmPreview__title", "filmPreview__year", "filmPreview__info filmPreview__info--cast");
        System.out.println("\nData from: " + chosenClasses);
        List<List<String>> data = mapper.getDataFromSelectedClasses(doc, chosenClasses);


        CSVFile file = new CSVFile("C:\\Users\\ngier\\data-scraper\\dane");
        file.createFile(data, chosenClasses);
//        file.createFile(data, "plik");
    }

    private static void print(List<String> data) {
        for (String e: data) {
            System.out.println(e);
        }
    }
}
