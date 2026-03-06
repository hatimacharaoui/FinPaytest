package com.esocial.servlet;

import com.esocial.dao.EmployeurDAO;
import com.esocial.model.Employeur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ajouterEmployeur")

public class AjouterEmployeurServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException, IOException {

        String nom=req.getParameter("nom");
        String secteur=req.getParameter("secteur");

        Employeur emp=new Employeur();
        emp.setRaisonSociale(nom);
        emp.setSecteurActivite(secteur);

        EmployeurDAO dao=new EmployeurDAO();

        try{
            dao.addEmployeur(emp);
        }catch(Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("listeEmployeurs");
    }
}
