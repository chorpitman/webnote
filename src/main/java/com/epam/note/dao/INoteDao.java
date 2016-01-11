package com.epam.note.dao;

import com.epam.note.model.Note;

import java.util.List;

public interface INoteDao {

    public void add(Note note);
    public void delete(int noteId);
    public void update(Note note);
    public Note getById(int notesId);
    public List<Note> getAll();
}
