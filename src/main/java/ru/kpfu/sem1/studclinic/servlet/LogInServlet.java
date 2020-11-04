package ru.kpfu.sem1.studclinic.servlet;

import ru.kpfu.sem1.studclinic.dao.daoImpl.UserDaoImpl;
import ru.kpfu.sem1.studclinic.helpers.PasswordHelper;
import ru.kpfu.sem1.studclinic.models.aboutUser.User;
import sun.awt.windows.WPrinterJob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;


// алсу, не забудь поменть хтмл на фтл. И В РЕГИСТРАЦИИ ТОЖЕ
@WebServlet(urlPatterns = "/login")
public class LogInServlet extends HttpServlet {
    private final UserDaoImpl userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("webapp/login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("remember_me");
        System.out.println(rememberMe);
        User userInBD = userDao.getByLogin(login);
        if (login.equals(userInBD.getLogin()) && Objects.equals(PasswordHelper.encrypt(password), userInBD.getPassword())) {
            if (rememberMe.equals("on")) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("username", login);
                httpSession.setMaxInactiveInterval(-1);
                Cookie userCookie = new Cookie("username", login);
                userCookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(userCookie);

            }
            resp.sendRedirect("/account");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
