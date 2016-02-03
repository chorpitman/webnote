package com.epam.note.servlet;

import com.epam.note.model.User;
import com.epam.note.service.IUserService;
import com.epam.note.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    private IUserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("email");
        String pwd = request.getParameter("password");
        User user = userService.getUser(login, pwd);

        if (user != null) {
            HttpSession session = request.getSession(true);

            long time = session.getCreationTime();
            long lastTime = session.getLastAccessedTime();
            String idSession = session.getId();

            session.setAttribute("user", user);
            response.sendRedirect("/home");

            System.out.println("session time creation " + time);
            System.out.println("session last access time " + lastTime);
            System.out.println("session id " + idSession);

            System.out.println(user.toString());
        } else {
            request.getRequestDispatcher("/").forward(request, response);
            System.out.println("hera lisogo");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
    }

    private boolean validateRequest(HttpServletRequest request) {
        if (request.getParameter("email") == null || request.getParameter("email").isEmpty()) {
            System.out.println("Email can't be null or empty");
        }
        if (request.getParameter("password") == null || request.getParameter("password").isEmpty()) {
            System.out.println("Password can't be null or empty");
        }
        return false;
    }
}
