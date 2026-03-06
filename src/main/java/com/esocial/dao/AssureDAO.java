package com.esocial.dao;

import com.esocial.model.Assure;
import com.esocial.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssureDAO {

    // Ajouter un assuré
    public void addAssure(Assure a) throws Exception {

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO assure(nom, salaire, employeur_id) VALUES (?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, a.getNom());
        ps.setDouble(2, a.getSalaire());
        ps.setInt(3, a.getEmployeurId());

        ps.executeUpdate();
    }


    // Récupérer tous les assurés
    public List<Assure> getAssures() throws Exception {

        List<Assure> list = new ArrayList<>();

        Connection con = DBConnection.getConnection();

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM assure");

        while (rs.next()) {

            Assure a = new Assure();

            a.setId(rs.getInt("id"));
            a.setNom(rs.getString("nom"));
            a.setSalaire(rs.getDouble("salaire"));
            a.setEmployeurId(rs.getInt("employeur_id"));

            list.add(a);
        }

        return list;
    }

}
