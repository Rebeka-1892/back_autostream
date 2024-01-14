package com.projet_voiture.projet_voiture.modele;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Annonce {
    @Id
    int idannonce;
    String descri;
    double prix;
    LocalDateTime datepub;
    int idvoiture;
    int idutilisateur;

    public Annonce(int idannonce, String descri, double prix, LocalDateTime datepub, int idvoiture,
            int idutilisateur) {
        this.idannonce = idannonce;
        this.descri = descri;
        this.prix = prix;
        this.datepub = datepub;
        this.idvoiture = idvoiture;
        this.idutilisateur = idutilisateur;
    }

    public Annonce() {
    }    

    public int getIdannonce() {
        return idannonce;
    }
    public void setIdannonce(int idannonce) {
        this.idannonce = idannonce;
    }
    public LocalDateTime getDatepub() {
        return datepub;
    }
    public void setDatepub(LocalDateTime datepub) {
        this.datepub = datepub;
    }
    public int getIdvoiture() {
        return idvoiture;
    }
    public void setIdvoiture(int idvoiture) {
        this.idvoiture = idvoiture;
    }
    public int getIdutilisateur() {
        return idutilisateur;
    }
    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }    
    
}
