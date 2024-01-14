package com.projet_voiture.projet_voiture.modele;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Validation {
    @Id
    int idvalidation;
    int etat;
    LocalDateTime datemodif;
    int idannonce;

    public Validation(int idvalidation, int etat, LocalDateTime datemodif, int idannonce) {
        this.idvalidation = idvalidation;
        this.etat = etat;
        this.datemodif = datemodif;
        this.idannonce = idannonce;
    }

    public Validation() {
    }
    
    public int getIdvalidation() {
        return idvalidation;
    }
    public void setIdvalidation(int idvalidation) {
        this.idvalidation = idvalidation;
    }
    public int getEtat() {
        return etat;
    }
    public void setEtat(int etat) {
        this.etat = etat;
    }
    public LocalDateTime getDatemodif() {
        return datemodif;
    }
    public void setDatemodif(LocalDateTime datemodif) {
        this.datemodif = datemodif;
    }
    public int getIdannonce() {
        return idannonce;
    }
    public void setIdannonce(int idannonce) {
        this.idannonce = idannonce;
    }
}
