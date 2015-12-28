package com.epam.note.servlet;

import com.epam.note.model.Note;
import com.epam.note.service.NoteService;
import com.epam.note.util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(DBConnection.getConnection());
        NoteService noteService = new NoteService();
        List<Note> notes = noteService.getNotes();
        request.setAttribute("notes", notes);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
