package com.esocial.dao;

import com.esocial.model.Employeur;
import com.esocial.util.DBConnection;

import java.sql.*;
import java.util.*;

public class EmployeurDAO {

    public void addEmployeur(Employeur e) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql="INSERT INTO employeur(raison_sociale,secteur_activite) VALUES (?,?)";

        PreparedStatement ps=con.prepareStatement(sql);

        ps.setString(1,e.getRaisonSociale());
        ps.setString(2,e.getSecteurActivite());

        ps.executeUpdate();
    }

    public List<Employeur> getEmployeurs() throws Exception {

        List<Employeur> list=new ArrayList<>();

        Connection con=DBConnection.getConnection();

        Statement st=con.createStatement();

        ResultSet rs=st.executeQuery("SELECT * FROM employeur");

        while(rs.next()){

            Employeur e=new Employeur();

            e.setId(rs.getInt("id"));
            e.setRaisonSociale(rs.getString("raison_sociale"));
            e.setSecteurActivite(rs.getString("secteur_activite"));

            list.add(e);
        }

        return list;
    }
}
