package com.epam.note.servlet;

import com.epam.note.model.User;
import com.epam.note.service.IUserService;
import com.epam.note.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private IUserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("inputEmail");
        String pwd = request.getParameter("inputPassword");
        User user = userService.getUser(login, pwd);
        if (user != null) {
//            request.getRequestDispatcher("/home").forward(request, response);
            response.sendRedirect("/home");
        } else {
            request.getRequestDispatcher("/").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
    }

    private boolean validateRequest(HttpServletRequest request) {
        if (request.getParameter("inputEmail") == null || request.getParameter("inputEmail").isEmpty()) {
            System.out.println("Email can't be null or empty");
        }
        if (request.getParameter("inputPassword") == null || request.getParameter("inputPassword").isEmpty()) {
            System.out.println("Password can't be null or empty");
        }
        return false;
    }
}
