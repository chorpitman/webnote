package com.epam.note.rest.service;

import com.epam.note.dto.NoteDto;
import com.epam.note.service.INoteService;
import com.epam.note.service.impl.NoteService;
import com.epam.note.util.EntityConvertor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public Response updateNote(NoteDto noteDto) {
        INoteService noteService = new NoteService();
        noteService.update(EntityConvertor.convert(noteDto));
        System.out.println("update noteDto id = " + noteDto);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNote(NoteDto noteDto) {
        INoteService noteService = new NoteService();
        int id = noteService.add(EntityConvertor.convert(noteDto));
        return Response.ok(String.valueOf(id)).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNoteResponse(@PathParam("id") int id) {
        INoteService noteService = new NoteService();
        NoteDto noteDto = EntityConvertor.convertToNote(noteService.getById(id));
        System.out.println("get noteDto = " + id);
        return Response.ok(noteDto).build();
    }
}
