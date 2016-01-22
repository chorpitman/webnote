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
//        UserDao userDao = new UserDao();
//        System.out.println(userDao.getById(1));
         return noteDao.getAll();
    }

    @Override
    public void add(Note note) {
        noteDao.add(note);
    }

    @Override
    public void delete(int id) {
        noteDao.delete(id);
    }

    @Override
    public void update(Note note){
        noteDao.update(note);
    }

    @Override
    public Note getById(int id) {
        return noteDao.getById(id);
    }
}
