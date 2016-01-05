package com.epam.note.util;

import com.epam.note.model.Note;
//convert format From RestService to
public class EntityConvertor {
    private EntityConvertor(){}

    public static Note convert(com.epam.note.rest.model.Note note) {

        Note res = new Note();
        res.setId(note.getId());
        res.setTitle(note.getTitle());
        res.setDescription(note.getDescription());
        res.setCategory(note.getCategory());
        return res;
    }


}
