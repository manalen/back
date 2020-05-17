package com.springoot.CabMed.Class;

import com.sun.javafx.webkit.UtilitiesImpl;

public class Administrateur extends Utilisateur {
    private String fonction;

    public Administrateur(int _id, String nom, String prenom, String login, String mdp, String fonction) {
        super(_id, nom, prenom, login, mdp);
        this.fonction = fonction;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
}
