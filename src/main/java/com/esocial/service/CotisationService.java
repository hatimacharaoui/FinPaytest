package com.esocial.service;

public class CotisationService {

    double tauxSalarial=0.04;
    double tauxPatronal=0.08;

    public double cotisationSalariale(double salaire){
        return salaire*tauxSalarial;
    }

    public double cotisationPatronale(double salaire){
        return salaire*tauxPatronal;
    }

    public double total(double salaire){
        return cotisationSalariale(salaire)+cotisationPatronale(salaire);
    }

}
