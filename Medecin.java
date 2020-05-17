package com.springoot.CabMed.Class;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Medecindb")
public class Medecin extends Utilisateur{

    private String spécialité ;

    public Medecin(int _id, String nom, String prenom, String login, String mdp, String spécialité) {
        super(_id, nom, prenom, login, mdp);
        this.spécialité = spécialité;
    }

    public String getSpécialité() {
        return spécialité;
    }

    public void setSpécialité(String spécialité) {
        this.spécialité = spécialité;
    }
}
