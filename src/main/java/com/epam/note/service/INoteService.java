package com.epam.note.service;

import com.epam.note.model.Note;

import java.util.List;

public interface INoteService {

    List<Note> getNotes();

    int add(Note note);

    void delete(int id);

    void update(Note note);

    Note getById(int id);

    List<Note> getUserNotes(String login);

}
