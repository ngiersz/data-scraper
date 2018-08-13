package com.ngiersz.scraper.domain;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Vector;

public class FilmwebToFilmMapper {

    Vector<Film> films;

    public Vector<String> getTitles(Document doc) {
        Elements elements = doc.getElementsByClass(FilmwebProperties.TITLE.tag);
//        Elements elements = doc.getElementsByClass("filmPreview filmPreview--FILM Film");

        Vector<String> titles = new Vector<>();
        elements.forEach(element -> {
            titles.add(element.text());
        });
        return titles;
    }

    public Vector<Film> getFilms(Document doc) {
        films = new Vector<>();
        appendTitles(doc);
        appendYears(doc);
        appendGenres(doc);
        return films;
    }

    private void appendTitles(Document doc) {
        Elements elements = doc.getElementsByClass(FilmwebProperties.TITLE.tag);
        elements.forEach(element -> {
            films.add(new Film(element.text()));
        });
    }

    private void appendYears(Document doc) {
        Elements elements = doc.getElementsByClass(FilmwebProperties.YEAR.tag);
        Vector<Film> newFilms = new Vector<>();
        int i = 0;
        for(Element element : elements) {
//            elements.forEach(element -> {
                Integer year = Integer.parseInt(element.text());
                newFilms.add(new Film(films.get(i).getTitle(), year));
                i++;
//            });
        }
        this.films = newFilms;
    }

    private void appendGenres(Document doc) {
        Elements elements = doc.getElementsByClass(FilmwebProperties.GENRES.tag);
        Vector<Film> newFilms = new Vector<>();
        int i = 0;
        for(Element element : elements) {
//            elements.forEach(element -> {
            Vector<String> genres = new Vector<>();
            genres.add(element.text());
            newFilms.add(new Film(films.get(i).getTitle(), films.get(i).getYear(), genres));
            i++;
//            });
        }
        this.films = newFilms;
    }
}
