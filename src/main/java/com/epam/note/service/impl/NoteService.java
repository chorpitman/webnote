package com.epam.note.service.impl;

import com.epam.note.dao.INoteDao;
import com.epam.note.dao.impl.NoteDao;
import com.epam.note.model.Note;
import com.epam.note.service.INoteService;

import java.util.List;

public class NoteService implements INoteService {

    private INoteDao noteDao = new NoteDao();

    @Override
    public List<Note> getNotes() {
         return noteDao.getAll();
    }

    @Override
    public void add(Note note) {
        noteDao.add(note);
    }
}
