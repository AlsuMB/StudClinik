package ru.kpfu.sem1.studclinic.servlet;

import ru.kpfu.sem1.studclinic.dao.daoImpl.ForumDaoImpl;
import ru.kpfu.sem1.studclinic.dao.daoImpl.UserDaoImpl;
import ru.kpfu.sem1.studclinic.helpers.PasswordHelper;
import ru.kpfu.sem1.studclinic.models.aboutUser.User;
import ru.kpfu.sem1.studclinic.models.forum.AnswerInForum;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Enumeration;

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/update_account")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024)
public class UpdateUserServlet extends HttpServlet {
    private final UserDaoImpl userDao = new UserDaoImpl();
    private static final String FILE_PATH_PREFIX = "C:\\Users\\Alsu\\Desktop\\path_for_site";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        try {
            req.getRequestDispatcher("webapp/update_account.ftl").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Part filePart = req.getPart("img");
        String fileName;
        if (filePart != null) {
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
            HttpSession session = req.getSession();
            if (session != null) {
                String login_from_session = (String) session.getAttribute("username");
                User user = new UserDaoImpl().getByLogin(login_from_session);
                if (login.equals(login_from_session)) {
                    User newUser = new User(user.getId(), (name + " " + lastname).trim(), login, PasswordHelper.encrypt(password), "patient", fileName);
                    userDao.update(newUser);
                    HttpSession httpSession = req.getSession();
                    httpSession.setAttribute("username", login);
                    httpSession.setMaxInactiveInterval(60 * 60);
                    Cookie userCookie = new Cookie("username", login);
                    userCookie.setMaxAge(24 * 60 * 60);
                    resp.addCookie(userCookie);
                    resp.sendRedirect("/account");
                } else {
                    resp.sendRedirect("/login");
                }
            } else {
                resp.sendRedirect("/login");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/login");
        }
    }
}
