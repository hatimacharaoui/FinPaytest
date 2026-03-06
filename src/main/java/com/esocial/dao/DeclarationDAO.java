package com.esocial.dao;

import com.esocial.model.Declaration;
import com.esocial.util.DBConnection;

import java.sql.*;
import java.time.LocalDate;

public class DeclarationDAO {

    public void addDeclaration(Declaration d) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO declaration(employeur_id, mois, annee, date_declaration) VALUES (?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, d.getEmployeurId());
        ps.setInt(2, d.getMois());
        ps.setInt(3, d.getAnnee());
        ps.setDate(4, Date.valueOf(d.getDateDeclaration()));

        ps.executeUpdate();
    }

}
