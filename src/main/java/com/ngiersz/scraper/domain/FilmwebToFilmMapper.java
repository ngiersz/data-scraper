package com.ngiersz.scraper.domain;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class FilmwebToFilmMapper {

//    List<Film> films;

//    public List<String> getTitles(Document doc) {
//        Elements elements = doc.getElementsByClass(FilmwebProperties.TITLE.tag);
//
//        Vector<String> titles = new Vector<>();
//        elements.forEach(element -> {
//            titles.add(element.text());
//        });
//        return titles;
//    }

//    public List<Film> getFilms(Document doc) {
//        films = new ArrayList<>();
//        appendTitles(doc);
//        appendYears(doc);
//        appendGenres(doc);
//        return films;
//    }
//
//    public void printAllElements(Document doc) {
//        Elements elements = doc.getAllElements();
//        for (Element e: elements) {
//            System.out.println(e.className());
//        }
//    }

    public List<String> getAllUniqueClassNames(Document doc) {
        List<String> classNames = new ArrayList<>();
        Elements elements = doc.getAllElements();
        for (Element e: elements) {
            if(!classNames.contains(e.className())) {
                classNames.add(e.className());
            }
        }
        return classNames;
    }

    public List<String> getTextFromSelectedClass(Document doc, String className) {
        List<String> text = new ArrayList<>();
        Elements elements = doc.getElementsByClass(className);

        elements.forEach(element -> {
            text.add(element.text());
        });
        return text;
    }

    public List<List<String>> getDataFromSelectedClasses(Document doc, List<String> classNames) {
        List<List<String>> data = new ArrayList<>();
        for (String className : classNames) {
            List<String> column = getTextFromSelectedClass(doc, className);
            data.add(column);
        }
        return data;
    }

//    private void appendTitles(Document doc) {
//        Elements elements = doc.getElementsByClass(FilmwebProperties.TITLE.tag);
//
//        elements.forEach(element -> {
//            films.add(new Film(element.text()));
//        });
//    }
//
//    private void appendYears(Document doc) {
//        Elements elements = doc.getElementsByClass(FilmwebProperties.YEAR.tag);
//        List<Film> newFilms = new ArrayList<>();
//        int i = 0;
//        for(Element element : elements) {
//                Integer year = Integer.parseInt(element.text());
//                newFilms.add(new Film(films.get(i).getTitle(), year));
//                i++;
//        }
//        this.films = newFilms;
//    }
//
//    private void appendGenres(Document doc) {
//        Elements elements = doc.getElementsByClass(FilmwebProperties.GENRES.tag);
//        List<Film> newFilms = new ArrayList<>();
//        int i = 0;
//        for(Element element : elements) {
//            List<String> genres = new ArrayList<>();
//            genres.add(element.text());
//            newFilms.add(new Film(films.get(i).getTitle(), films.get(i).getYear(), genres));
//            i++;
//        }
//        this.films = newFilms;
//    }
}
