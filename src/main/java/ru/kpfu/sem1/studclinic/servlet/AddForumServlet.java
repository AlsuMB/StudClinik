package ru.kpfu.sem1.studclinic.servlet;

import ru.kpfu.sem1.studclinic.dao.daoImpl.ForumDaoImpl;
import ru.kpfu.sem1.studclinic.models.forum.Forum;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@WebServlet(name = "AddForumServlet", urlPatterns = "/add_new_forum")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024)
public class AddForumServlet extends HttpServlet {
    private static final String FILE_PATH_PREFIX = "C:\\Users\\Alsu\\Desktop\\path_for_site";
    ForumDaoImpl forumDao = new ForumDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        try {
            req.getRequestDispatcher("webapp/add_forum.ftl").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            String title = req.getParameter("title");
            String text = req.getParameter("text");
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

            Forum newForum = new Forum(text, title, fileName);
            forumDao.save(newForum);
            resp.sendRedirect("/forum");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/add_new_forum");
        }
    }
}
