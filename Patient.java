package com.springoot.CabMed.Class;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "patient")
public class Patient extends Utilisateur {
    private String Adresse;
    private long Age;
    private int numserie;
    private String cin;

    public Patient(int _id, String nom, String prenom, String login, String mdp, String adresse, long age, int numserie,String cin) {
        super(_id, nom, prenom, login, mdp);
        Adresse = adresse;
        Age = age;
        this.numserie = numserie;
        this.cin=cin;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public long getAge() {
        return Age;
    }

    public void setAge(long age) {
        Age = age;
    }

    public int getNumserie() {
        return numserie;
    }

    public void setNumserie(int numserie) {
        this.numserie = numserie;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
}
