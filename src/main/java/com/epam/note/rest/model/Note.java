package com.epam.note.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleg on 30.12.15.
 */

//@XmlRootElement
public class Note {
    private String title;
    private String category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
