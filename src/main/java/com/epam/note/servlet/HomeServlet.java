package com.epam.note.servlet;

import com.epam.note.model.Note;
import com.epam.note.model.User;
import com.epam.note.service.INoteService;
import com.epam.note.service.impl.NoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {

    private INoteService noteService = new NoteService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            int userId = user.getId();

            System.out.println("user id " + userId);

            List<Note> notes = noteService.getUserNotes(userId);
            System.out.println(notes.toString());
            request.setAttribute("notes", notes);
            request.setAttribute("userid", userId);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("/");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
