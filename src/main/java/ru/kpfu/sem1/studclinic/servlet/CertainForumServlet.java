package ru.kpfu.sem1.studclinic.servlet;

import ru.kpfu.sem1.studclinic.dao.daoImpl.CommentInForumDaoImpl;
import ru.kpfu.sem1.studclinic.dao.daoImpl.ForumDaoImpl;
import ru.kpfu.sem1.studclinic.dao.daoImpl.UserDaoImpl;
import ru.kpfu.sem1.studclinic.models.aboutUser.User;
import ru.kpfu.sem1.studclinic.models.forum.AnswerInForum;
import ru.kpfu.sem1.studclinic.models.forum.Forum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "ForumPageServlet", urlPatterns = "/forum_page")
public class CertainForumServlet extends HttpServlet {
    private final ForumDaoImpl forumDao = new ForumDaoImpl();
    private final CommentInForumDaoImpl commentInForumDao = new CommentInForumDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int forum_id = Integer.parseInt(req.getParameter("id"));
        Forum forum = forumDao.get(forum_id);
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        ArrayList<AnswerInForum> answers = (ArrayList<AnswerInForum>) commentInForumDao.getAllCommentsInForum(forum_id);
        req.setAttribute("answers",answers);
        req.setAttribute("forum", forum);
        req.getRequestDispatcher("webapp/forum_page.ftl").forward(req, resp);

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
            AnswerInForum answer = new AnswerInForum(new ForumDaoImpl().get(Integer.parseInt(req.getParameter("id"))), user, text);
            commentInForumDao.save(answer);
            resp.sendRedirect("/forum_page?id=" + req.getParameter("id"));
        } else {
            resp.sendRedirect("/forum_page?id=" + req.getParameter("id"));
        }
    }
}

