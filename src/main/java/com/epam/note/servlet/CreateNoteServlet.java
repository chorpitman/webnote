package com.epam.note.servlet;

import com.epam.note.model.Note;
import com.epam.note.service.INoteService;
import com.epam.note.service.impl.NoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/add")
public class CreateNoteServlet extends HttpServlet {

    private INoteService noteService = new NoteService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String desc = request.getParameter("description");

//        TODO validate!!!!
        if (title != null && !title.isEmpty()) {
            Note note = new Note(null, new Date().getTime(), title, category, desc);
            noteService.add(note);
            response.sendRedirect("/");
        } else {
            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("create_note.jsp").forward(request, response);
    }
}
