package com.ngiersz.scraper;

import com.ngiersz.scraper.domain.FilmwebToFilmMapper;
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

        FilmwebToFilmMapper mapper = new FilmwebToFilmMapper();

        List<String> classNames = mapper.getAllUniqueClassNames(doc);

        System.out.println("What data do you want to see? Choose one class from the list:");
        for (String e: classNames
             ) {
            System.out.println(e);
        }

        String chosenClass = "filmPreview__info filmPreview__info--cast";
        System.out.println("\nData from " + chosenClass);
        List<String> data = mapper.getTextFromSelectedClass(doc, chosenClass);
        for (String e: data) {
            System.out.println(e);
        }
    }
}
