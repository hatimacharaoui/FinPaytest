package com.esocial.servlet;

import com.esocial.dao.AssureDAO;
import com.esocial.model.Assure;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ajouterAssure")

public class AjouterAssureServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nom = req.getParameter("nom");

        double salaire = Double.parseDouble(req.getParameter("salaire"));

        int employeurId = Integer.parseInt(req.getParameter("employeurId"));

        Assure a = new Assure();

        a.setNom(nom);
        a.setSalaire(salaire);
        a.setEmployeurId(employeurId);

        AssureDAO dao = new AssureDAO();

        try {

            dao.addAssure(a);

        } catch (Exception e) {

            e.printStackTrace();

        }

        resp.sendRedirect("listeAssures");

    }
}
