package com.ngiersz.scraper.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Vector;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    private String title;
    private Vector<String> genres;
    private int year;

    public Film(String title) {
        this.title = title;
    }

    public Film(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public Film(String title, int year, Vector<String> genres) {
        this.title = title;
        this.year = year;
        this.genres = genres;
    }

    public String toString() {
        return title + " (" + year + ") " + genres;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }
}
