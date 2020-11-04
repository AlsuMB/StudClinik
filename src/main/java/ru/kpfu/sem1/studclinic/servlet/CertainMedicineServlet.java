package ru.kpfu.sem1.studclinic.servlet;

import ru.kpfu.sem1.studclinic.dao.daoImpl.DragDaoImpl;
import ru.kpfu.sem1.studclinic.models.aboutUser.Drag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CertainMedicineServlet", urlPatterns = "/medicine")
public class CertainMedicineServlet extends HttpServlet {
    private final DragDaoImpl dragDao = new DragDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String medicineId = req.getParameter("id");
        Drag drag = dragDao.get(Integer.parseInt(medicineId));
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("drag", drag);
        req.getRequestDispatcher("webapp/medicine_example_page.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
