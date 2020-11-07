package ru.kpfu.sem1.studclinic.servlet;

import ru.kpfu.sem1.studclinic.dao.daoImpl.ArticleDaoImpl;
import ru.kpfu.sem1.studclinic.dao.daoImpl.CommentToArticleDaoImpl;
import ru.kpfu.sem1.studclinic.dao.daoImpl.ForumDaoImpl;
import ru.kpfu.sem1.studclinic.dao.daoImpl.UserDaoImpl;
import ru.kpfu.sem1.studclinic.models.aboutUser.Drag;
import ru.kpfu.sem1.studclinic.models.aboutUser.User;
import ru.kpfu.sem1.studclinic.models.atricals.Article;
import ru.kpfu.sem1.studclinic.models.atricals.CommentToArticle;
import ru.kpfu.sem1.studclinic.models.forum.AnswerInForum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CertainArticleServlet", urlPatterns = "/article")
public class CertainArticleServlet extends HttpServlet {
    ArticleDaoImpl articleDao = new ArticleDaoImpl();
    CommentToArticleDaoImpl commentToArticleDao = new CommentToArticleDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int articleID = Integer.parseInt(req.getParameter("id"));
        Article article = articleDao.get(articleID);
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("article", article);
        ArrayList<CommentToArticle> comments = (ArrayList<CommentToArticle>) commentToArticleDao.getAllCommentsInArticle(articleID);
        System.out.println(comments);
        req.setAttribute("comments", comments);
        req.getRequestDispatcher("webapp/article_page.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String text = req.getParameter("text");

        HttpSession session = req.getSession();
        if (session != null) {
            String login = (String) session.getAttribute("username");
            User user = new UserDaoImpl().getByLogin(login);
            CommentToArticle answer = new CommentToArticle(articleDao.get(Integer.parseInt(req.getParameter("id"))), user, text);
            System.out.println(answer);
            commentToArticleDao.save(answer);
            resp.sendRedirect("/article?id=" + req.getParameter("id"));
        } else {
            resp.sendRedirect("/article?id=" + req.getParameter("id"));
        }
    }
}
