package com.ngiersz.scraper.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    private Long id;

    private String title;

    private List<String> genres;

    private int year;

    public Film(String title) {
        this.title = title;
    }

    public Film(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public Film(String title, int year, List<String> genres) {
        this.title = title;
        this.year = year;
        this.genres = genres;
    }

    public String toString() {
        return title + " (" + year + ") " + genres;
    }

}
