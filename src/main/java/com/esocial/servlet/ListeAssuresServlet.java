package com.esocial.servlet;

import com.esocial.dao.AssureDAO;
import com.esocial.model.Assure;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listeAssures")

public class ListeAssuresServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        AssureDAO dao = new AssureDAO();

        try {

            List<Assure> list = dao.getAssures();

            req.setAttribute("assures", list);

            RequestDispatcher rd = req.getRequestDispatcher("assures/listeAssures.jsp");

            rd.forward(req, resp);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
