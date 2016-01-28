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
//        HttpServletRequest validRequest = validateRequest(request);
        User user = new User();
        user.setLogin(request.getParameter("inputEmail"));
        user.setPassword(request.getParameter("inputPassword"));
        request.setAttribute("user", user);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
    }

    private  boolean validateRequest(HttpServletRequest request) {
        if (request.getParameter("inputEmail") == null || request.getParameter("inputEmail").isEmpty()) {
            System.out.println("Email can't be null or empty");
        }
        if (request.getParameter("inputPassword") == null || request.getParameter("inputPassword").isEmpty()) {
            System.out.println("Password can't be null or empty");
        }
        return false;
    }
}
