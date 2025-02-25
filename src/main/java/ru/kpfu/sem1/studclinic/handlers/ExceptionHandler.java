package ru.kpfu.sem1.studclinic.handlers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/handle")
public class ExceptionHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        handleException(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleException(req, resp);
    }

    private void handleException(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String uri = (String) req.getAttribute("javax.servlet.error.request_uri");
        uri = uri == null ? "Unknown" : uri;


        req.setAttribute("statusCode", statusCode);
        req.setAttribute("uri", uri);
        if (statusCode != 500) {
            req.setAttribute("message", throwable.getMessage());
        }
        req.getRequestDispatcher("exception.ftl").forward(req, resp);
    }
}
