package com.projet_voiture.projet_voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carrosserie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idcarrosserie;
    String nomcarrosserie;

    public Carrosserie(String nomcarrosserie) {
        this.nomcarrosserie = nomcarrosserie;
    }

    public Carrosserie(int idcarrosserie, String nomcarrosserie) {
        this.idcarrosserie = idcarrosserie;
        this.nomcarrosserie = nomcarrosserie;
    }

    public Carrosserie() {
    }
    
    public int getIdcarrosserie() {
        return idcarrosserie;
    }
    public void setIdcarrosserie(int idcarrosserie) {
        this.idcarrosserie = idcarrosserie;
    }
    public String getNomcarrosserie() {
        return nomcarrosserie;
    }
    public void setNomcarrosserie(String nomcarrosserie) {
        this.nomcarrosserie = nomcarrosserie;
    }
}
