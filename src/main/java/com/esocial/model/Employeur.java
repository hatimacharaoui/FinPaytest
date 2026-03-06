package com.esocial.model;

public class Employeur {

    private int id;
    private String raisonSociale;
    private String secteurActivite;

    public Employeur(){}

    public Employeur(int id,String raisonSociale,String secteurActivite){
        this.id=id;
        this.raisonSociale=raisonSociale;
        this.secteurActivite=secteurActivite;
    }

    public int getId(){ return id; }

    public void setId(int id){ this.id=id; }

    public String getRaisonSociale(){ return raisonSociale; }

    public void setRaisonSociale(String r){ this.raisonSociale=r; }

    public String getSecteurActivite(){ return secteurActivite; }

    public void setSecteurActivite(String s){ this.secteurActivite=s; }

}
