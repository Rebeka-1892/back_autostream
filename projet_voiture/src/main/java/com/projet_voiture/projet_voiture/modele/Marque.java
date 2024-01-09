package com.projet_voiture.projet_voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idmarque;
    String nommarque;
    @ManyToOne
    @JoinColumn(name = "idcontinent")
    Continent continent;

    public Marque(int idmarque, String nommarque, Continent continent) {
        this.idmarque = idmarque;
        this.nommarque = nommarque;
        this.continent = continent;
    }

    public Marque(String nommarque, Continent continent) {
        this.nommarque = nommarque;
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
    public String getNommarque() {
        return nommarque;
    }
    public void setNommarque(String nommarque) {
        this.nommarque = nommarque;
    }
    public Continent getContinent() {
        return continent;
    }
    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
