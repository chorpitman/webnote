package com.epam.note.util;

import com.epam.note.model.Note;
import com.epam.note.rest.model.NoteRest;

//convert format From RestService to
public class EntityConvertor {
    private EntityConvertor(){}

    public static Note convert(NoteRest noteRest) {

        Note res = new Note();
        res.setId(noteRest.getId());
        res.setDate(noteRest.getDate());
        res.setTitle(noteRest.getTitle());
        res.setDescription(noteRest.getDescription());
        res.setCategory(noteRest.getCategory());
        return res;
    }

    public static NoteRest convertToNote(Note note) {
        NoteRest result = new NoteRest();
        result.setId(note.getId());
        result.setDate(note.getDate());
        result.setCategory(note.getCategory());
        result.setDescription(note.getDescription());
        result.setTitle(note.getTitle());
        return result;
    }


}
