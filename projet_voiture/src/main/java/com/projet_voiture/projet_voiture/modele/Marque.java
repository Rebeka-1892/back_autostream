package com.projet_voiture.projet_voiture.modele;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idmarque;
    String nommmarque;
    @ManyToOne
    @JoinColumn(name = "idcontinent")
    Continent continent;

    public Marque(int idmarque, String nommmarque, Continent continent) {
        this.idmarque = idmarque;
        this.nommmarque = nommmarque;
        this.continent = continent;
    }

    public Marque(String nommmarque, Continent continent) {
        this.nommmarque = nommmarque;
        this.continent = continent;
    }

    public Marque() {
    }
    
    public int getIdmarque() {
        return idmarque;
    }
    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }
    public String getNommmarque() {
        return nommmarque;
    }
    public void setNommmarque(String nommmarque) {
        this.nommmarque = nommmarque;
    }
    public Continent getContinent() {
        return continent;
    }
    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
