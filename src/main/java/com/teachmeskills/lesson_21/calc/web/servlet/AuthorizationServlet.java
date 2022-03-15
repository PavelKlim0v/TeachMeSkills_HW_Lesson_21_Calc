package com.teachmeskills.lesson_21.calc.web.servlet;

import com.teachmeskills.lesson_21.calc.entity.User;
import com.teachmeskills.lesson_21.calc.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userService.findUserByLogin(login);
        if (user.getPassword().equals(password)) {
            req.getSession().setAttribute("user", user);
            resp.getWriter().println("---authorization---");
        } else {
            resp.getWriter().println("Wrong Password!");
        }
    }

}
