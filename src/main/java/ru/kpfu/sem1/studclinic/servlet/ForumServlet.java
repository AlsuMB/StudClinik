package ru.kpfu.sem1.studclinic.servlet;

import ru.kpfu.sem1.studclinic.dao.daoImpl.ForumDaoImpl;
import ru.kpfu.sem1.studclinic.models.forum.Forum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

@WebServlet(name = "ForumServlet", urlPatterns = "/forum")
public class ForumServlet extends HttpServlet {
    private static final String FILE_PATH_PREFIX = "C:\\Users\\Alsu\\Desktop\\path_for_site";
    private final ForumDaoImpl forumDao = new ForumDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        List<Forum> forums = forumDao.getAll();
        req.setAttribute("forums", forums);
        req.getRequestDispatcher("webapp/forum.ftl").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Part filePart = req.getPart("img");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(FILE_PATH_PREFIX + fileName);
        byte[] buffer = new byte[fileContent.available()];
        fileContent.read(buffer);
        outputStream.write(buffer);
        Forum forum = new Forum(req.getParameter("text"),
                req.getParameter("title"),
                "forum" + fileName);
        forumDao.save(forum);
    }
}
