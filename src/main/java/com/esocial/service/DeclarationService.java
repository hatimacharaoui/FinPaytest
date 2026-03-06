package com.esocial.service;

import com.esocial.dao.DeclarationDAO;
import com.esocial.model.Declaration;

public class DeclarationService {

    DeclarationDAO dao = new DeclarationDAO();

    // créer une déclaration
    public void creerDeclaration(Declaration d) {

        try {

            dao.addDeclaration(d);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
