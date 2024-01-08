package com.projet_voiture.projet_voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idcontinent;
    String nomcontinent;
    
    public Continent(int idcontinent, String nomcontinent) {
        this.idcontinent = idcontinent;
        this.nomcontinent = nomcontinent;
    }

    public Continent() {
    }

    public int getIdcontinent() {
        return idcontinent;
    }
    public void setIdcontinent(int idcontinent) {
        this.idcontinent = idcontinent;
    }
    public String getNomcontinent() {
        return nomcontinent;
    }
    public void setNomcontinent(String nomcontinent) {
        this.nomcontinent = nomcontinent;
    }
}
