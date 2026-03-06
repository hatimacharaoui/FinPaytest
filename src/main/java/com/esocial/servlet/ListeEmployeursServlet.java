package com.esocial.servlet;

import com.esocial.dao.EmployeurDAO;
import com.esocial.model.Employeur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listeEmployeurs")

public class ListeEmployeursServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        EmployeurDAO dao = new EmployeurDAO();

        try {

            List<Employeur> list = dao.getEmployeurs();

            req.setAttribute("employeurs", list);

            RequestDispatcher rd = req.getRequestDispatcher("employeurs/listeEmployeurs.jsp");

            rd.forward(req, resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
