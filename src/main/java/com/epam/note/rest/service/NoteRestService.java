package com.epam.note.rest.service;

import com.epam.note.dto.NoteDto;
import com.epam.note.service.INoteService;
import com.epam.note.service.impl.NoteService;
import com.epam.note.util.EntityConvertor;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
        Integer id = noteService.add(EntityConvertor.convert(noteDto));
        return Response.ok(id.toString()).build();
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
