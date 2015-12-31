package com.epam.note.service;

import com.epam.note.model.Note;

import java.util.List;

/**
 * Created by Oleg on 29.12.15.
 */
public interface INoteService {

    List<Note> getNotes();

    void add(Note note);

}
