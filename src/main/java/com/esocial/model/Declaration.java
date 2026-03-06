package com.esocial.model;

import java.time.LocalDate;

public class Declaration {

    private int id;
    private int employeurId;
    private int mois;
    private int annee;
    private LocalDate dateDeclaration;

    public Declaration(){}

    public Declaration(int id,int employeurId,int mois,int annee,LocalDate dateDeclaration){
        this.id=id;
        this.employeurId=employeurId;
        this.mois=mois;
        this.annee=annee;
        this.dateDeclaration=dateDeclaration;
    }

    public int getId(){ return id; }

    public void setId(int id){ this.id=id; }

    public int getEmployeurId(){ return employeurId; }

    public void setEmployeurId(int id){ this.employeurId=id; }


    // ✅ getter mois
    public int getMois(){
        return mois;
    }

    // setter mois
    public void setMois(int mois){
        this.mois=mois;
    }

    // ✅ getter annee
    public int getAnnee(){
        return annee;
    }

    // setter annee
    public void setAnnee(int annee){
        this.annee=annee;
    }

    // ✅ getter dateDeclaration
    public LocalDate getDateDeclaration(){
        return dateDeclaration;
    }

    // setter dateDeclaration
    public void setDateDeclaration(LocalDate dateDeclaration){
        this.dateDeclaration=dateDeclaration;
    }
}
