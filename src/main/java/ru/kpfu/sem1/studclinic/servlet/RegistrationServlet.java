package ru.kpfu.sem1.studclinic.servlet;

import ru.kpfu.sem1.studclinic.dao.daoImpl.UserDaoImpl;
import ru.kpfu.sem1.studclinic.models.aboutUser.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@WebServlet(name = "registrationServlet", urlPatterns = "/registration")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024)
public class RegistrationServlet extends HttpServlet {
    private final UserDaoImpl userDao = new UserDaoImpl();
    private static final String FILE_PATH_PREFIX = "C:\\Users\\Alsu\\Desktop\\path_for_site";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("webapp/registration_page.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String status = "patient";
        String rememberMe = req.getParameter("remember_me");
        Part filePart = req.getPart("img");
        String fileName;
        if(filePart == null) {
            fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            InputStream fileContent = filePart.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(FILE_PATH_PREFIX + fileName);
            byte[] buffer = new byte[fileContent.available()];
            fileContent.read(buffer);
            outputStream.write(buffer);
        } else {
            fileName = "not_found_img.png";
        }
        try {
            User newUser = new User(name + " " + lastname, login, password, status, fileName);
            userDao.save(newUser);
            if (rememberMe.equals("on")) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("username", login);
                httpSession.setMaxInactiveInterval(60 * 60);
                Cookie userCookie = new Cookie("username", login);
                userCookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(userCookie);
            }
            resp.sendRedirect("/account");
        } catch (Exception e) {
            resp.sendRedirect("/registration");
        }
    }
}
