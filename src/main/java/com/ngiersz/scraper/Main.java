package com.ngiersz.scraper;

import com.ngiersz.scraper.domain.FilmwebToFilmMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "https://www.filmweb.pl/user/ngiersz/films";
        Connection connection = new Connection(path);
        String content = connection.getResponse();

        Document doc = Jsoup.parse(content);


        FilmwebToFilmMapper filmwebToFilmMapper = new FilmwebToFilmMapper();
//        System.out.println(filmwebToFilmMapper.getTitles(doc));
        filmwebToFilmMapper.getFilms(doc)
                .forEach(film ->
                        System.out.println(film.toString()));

    }
}
