package com.epam.note.rest.model;

import java.util.Date;

//@XmlRootElement
public class NoteRest {
    private Integer id;
    private Long date;
    private String title;
    private String category;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "NoteRest{" +
                "id=" + id +
                " date=" + date +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
