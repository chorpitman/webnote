package com.epam.note.util;

import com.epam.note.dto.NoteDto;
import com.epam.note.model.Note;

//convert format From RestService to
public class EntityConvertor {
    private EntityConvertor(){}

    public static Note convert(NoteDto noteDto) {

        Note res = new Note();
        res.setId(noteDto.getId());
        res.setDate(noteDto.getDate());
        res.setTitle(noteDto.getTitle());
        res.setDescription(noteDto.getDescription());
        res.setCategory(noteDto.getCategory());
        return res;
    }

    public static NoteDto convertToNote(Note note) {
        NoteDto result = new NoteDto();
        result.setId(note.getId());
        result.setDate(note.getDate());
        result.setCategory(note.getCategory());
        result.setDescription(note.getDescription());
        result.setTitle(note.getTitle());
        return result;
    }


}
