package com.epam.note.service;

import com.epam.note.model.Note;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class NoteService {

     public List<Note> getNotes() {
        List<Note> noteList = new LinkedList<Note>();
        noteList.add(new Note(1,new Date(), "myFirsNote", "person", "miFirstNotes"));
        noteList.add(new Note(2,new Date(), "mySecond", "general", "miSecondNotes"));
        return noteList;
    }
}
