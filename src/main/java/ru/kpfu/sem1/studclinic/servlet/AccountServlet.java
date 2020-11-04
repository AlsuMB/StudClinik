package ru.kpfu.sem1.studclinic.servlet;

import ru.kpfu.sem1.studclinic.dao.daoImpl.UserDaoImpl;
import ru.kpfu.sem1.studclinic.models.aboutUser.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "accountServlet", urlPatterns = "/account")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie[] cookies = req.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("JSESSIONID")) {
//                    System.out.println(String.format("JSESSIONID=%s", cookie.getValue()));
//                }
//                cookie.setMaxAge(0);
//                resp.addCookie(cookie);
//            }
//        }
//        resp.sendRedirect("webapp/account_page.html");

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("username");
        System.out.println(login);
        if (login != null) {
            UserDaoImpl udi = new UserDaoImpl();
            User user = udi.getByLogin(login);
            System.out.println(user);
            req.setAttribute("user", user);
            req.getRequestDispatcher("webapp/account_page.ftl").forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
