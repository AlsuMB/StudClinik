package ru.kpfu.sem1.studclinic.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authenticationFilter", urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

    public void init(FilterConfig filterConfig) {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();
        HttpSession httpSession = req.getSession();

        if (httpSession == null && !uri.contains("username")) {
            req.getRequestDispatcher("/webapp/login.ftl").include(req,resp);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
