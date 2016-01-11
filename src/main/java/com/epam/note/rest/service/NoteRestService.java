package com.epam.note.rest.service;

import com.epam.note.rest.model.Note;
import com.epam.note.service.INoteService;
import com.epam.note.service.impl.NoteService;
import com.epam.note.util.EntityConvertor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/note")
public class NoteRestService {

    //TODO read REST name convention and apply

    @DELETE
    @Path("{id}")
    public Response deleteNote(@PathParam("id") int id) {
        INoteService noteService = new NoteService();
        noteService.delete(id);
        System.out.println("delete note id = " + id);
        return Response.status(Response.Status.OK).build();
    }

    //update
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateNote(Note note) {
        INoteService noteService = new NoteService();
        noteService.update(EntityConvertor.convert(note));
        System.out.println("update note id = " + note);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNote(Note note) {
        INoteService noteService = new NoteService();
        noteService.add(EntityConvertor.convert(note));
        System.out.println("added note = " + note);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/get")
    public Response createNote() {
        System.out.println("get note = ");
        return Response.status(Response.Status.OK).build();
    }


}
