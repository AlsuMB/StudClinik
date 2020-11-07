package ru.kpfu.sem1.studclinic.servlet;

import org.apache.logging.log4j.core.util.JsonUtils;
import org.w3c.dom.ls.LSOutput;
import ru.kpfu.sem1.studclinic.dao.daoImpl.ArticleDaoImpl;
import ru.kpfu.sem1.studclinic.models.atricals.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;


@WebServlet(name = "AddArticleServlet", urlPatterns = "/add_new_article")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024)
public class AddArticleServlet extends HttpServlet {
    ArticleDaoImpl articleDao = new ArticleDaoImpl();
    private static final String FILE_PATH_PREFIX = "C:\\Users\\Alsu\\Desktop\\path_for_site";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        try {
            req.getRequestDispatcher("webapp/add_article.ftl").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            Article newArticle = new Article(text, title, fileName);
            articleDao.save(newArticle);
            resp.sendRedirect("/articles");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/add_new_article");
        }
    }
}
