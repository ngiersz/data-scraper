package com.ngiersz.scraper;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Scraper {

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

}
