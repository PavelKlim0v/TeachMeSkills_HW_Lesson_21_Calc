package com.teachmeskills.lesson_21.calc.web.servlet;

import com.teachmeskills.lesson_21.calc.entity.User;
import com.teachmeskills.lesson_21.calc.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(name, password, login);
        boolean isAdded = userService.add(user);
        if (isAdded) {
            resp.getWriter().println("---Ok---");
        } else {
            resp.getWriter().println("---Error---");
        }
    }

}
