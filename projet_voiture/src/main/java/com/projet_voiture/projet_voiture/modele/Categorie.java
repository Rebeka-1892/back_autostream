package com.projet_voiture.projet_voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idcategorie;
    String nomcategorie;

    public Categorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }

    public Categorie() {
    }

    public int getIdcategorie() {
        return idcategorie;
    }
    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }
    public String getNomcategorie() {
        return nomcategorie;
    }
    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }    
}