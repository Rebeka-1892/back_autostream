package com.projet_voiture.projet_voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Energie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idenergie;
    String nomenergie;

    public Energie(String nomenergie) {
        this.nomenergie = nomenergie;
    }

    public Energie(int idenergie, String nomenergie) {
        this.idenergie = idenergie;
        this.nomenergie = nomenergie;
    }

    public Energie() {
    }
    
    public int getIdenergie() {
        return idenergie;
    }
    public void setIdenergie(int idenergie) {
        this.idenergie = idenergie;
    }
    public String getNomenergie() {
        return nomenergie;
    }
    public void setNomenergie(String nomenergie) {
        this.nomenergie = nomenergie;
    }
}
