package com.epam.note.dao;

import com.epam.note.model.Note;

import java.util.List;

public interface INoteDao {

    public int add(Note note);
    public void delete(int noteId);
    public void update(Note note);
    public Note getById(int noteId);
    public List<Note> getAll();
    public List<Note> getUserNotes(int userId);
}
