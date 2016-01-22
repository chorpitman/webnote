package com.epam.note.model;

import java.util.Date;

public class Note {
    private Integer id;
    private Date date;
    private String title;
    private String category;
    private String description;

    public Note() {

    }

    public Note(Integer id, Date date, String title, String category, String description) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.category = category;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
                ", date=" + date +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
