package com.ngiersz.scraper.domain;

public enum FilmwebProperties {
    TITLE("filmPreview__title"),
    YEAR("filmPreview__year"),
    GENRES("filmPreview__info filmPreview__info--genres");

    public String tag; // tag?

    FilmwebProperties(String tag){
        this.tag = tag;
    }

}
