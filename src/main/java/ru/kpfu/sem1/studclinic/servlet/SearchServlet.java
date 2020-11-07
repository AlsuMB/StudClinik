package ru.kpfu.sem1.studclinic.servlet;

import ru.kpfu.sem1.studclinic.dao.daoImpl.ArticleDaoImpl;
import ru.kpfu.sem1.studclinic.models.atricals.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    ArticleDaoImpl articleDao = new ArticleDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String search = req.getParameter("search");
        List<Article> articles = articleDao.getAllUsersLikeString(search);
        System.out.println(articles);
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("webapp/search.ftl").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
