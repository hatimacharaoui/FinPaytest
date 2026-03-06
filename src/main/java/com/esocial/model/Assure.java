package com.esocial.model;

public class Assure {

    private int id;
    private String nom;
    private double salaire;
    private int employeurId;

    public Assure(){}

    public Assure(int id,String nom,double salaire,int employeurId){
        this.id=id;
        this.nom=nom;
        this.salaire=salaire;
        this.employeurId=employeurId;
    }

    public int getId(){ return id; }

    public void setId(int id){ this.id=id; }

    public String getNom(){ return nom; }

    public void setNom(String nom){ this.nom=nom; }

    public double getSalaire(){ return salaire; }

    public void setSalaire(double salaire){ this.salaire=salaire; }

    public int getEmployeurId(){ return employeurId; }

    public void setEmployeurId(int id){ this.employeurId=id; }

}
