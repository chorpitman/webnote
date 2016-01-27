package com.epam.note.servlet;

import com.epam.note.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
//create private method with work with reqest parameters
        if (request.getParameter("inputEmailinputEmail") == null || request.getParameter("inputEmailinputEmail").isEmpty()) {

        }

        if (request.getParameter("inputPassword") == null || request.getParameter("inputPassword").isEmpty()) {
        } else {
            user.setLogin(request.getParameter("inputEmailinputEmail"));
            user.setPassword(request.getParameter("inputPassword"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
    }
}
