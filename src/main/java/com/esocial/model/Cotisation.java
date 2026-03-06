package com.esocial.model;

public class Cotisation {

    private double cotisationSalariale;
    private double cotisationPatronale;

    public Cotisation(double s,double p){
        this.cotisationSalariale=s;
        this.cotisationPatronale=p;
    }

    public double getCotisationSalariale(){
        return cotisationSalariale;
    }

    public double getCotisationPatronale(){
        return cotisationPatronale;
    }

}
