package com.epam.note.rest.service;

import com.epam.note.rest.model.Note;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Oleg on 30.12.15.
 */

@Path("/note")
public class NoteRestService {

    @DELETE
    @Path("{id}")
    public Response deleteNote(@PathParam("id") int id) {
        System.out.println("delete note id = " + id);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("{id}")
    public Response updateNote(@PathParam("id") int id) {
        System.out.println("update note id = " + id);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNote(Note note) {
        System.out.println("update note id = " + note);
        return Response.status(Response.Status.OK).build();
    }
}
