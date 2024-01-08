package com.projet_voiture.projet_voiture.modele;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idmodele;
    String nommodele;
    double poids;
    double longueur;
    double largeur;
    double hauteur;
    double reservoire;
    @ManyToOne
    @JoinColumn(name = "idcarrosserie")
    Carrosserie carrosserie;
    @ManyToOne
    @JoinColumn(name = "idcategorie")
    Categorie categorie;
    @ManyToOne
    @JoinColumn(name = "idmarque")
    Marque marque;    

    public Modele(int idmodele, String nommodele, double poids, double longueur, double largeur, double hauteur,
            double reservoire, Carrosserie carrosserie, Categorie categorie, Marque marque) {
        this.idmodele = idmodele;
        this.nommodele = nommodele;
        this.poids = poids;
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.reservoire = reservoire;
        this.carrosserie = carrosserie;
        this.categorie = categorie;
        this.marque = marque;
    }

    public Modele(String nommodele, double poids, double longueur, double largeur, double hauteur, double reservoire,
            Carrosserie carrosserie, Categorie categorie, Marque marque) {
        this.nommodele = nommodele;
        this.poids = poids;
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.reservoire = reservoire;
        this.carrosserie = carrosserie;
        this.categorie = categorie;
        this.marque = marque;
    }

    public Modele() {
    }

    public int getIdmodele() {
        return idmodele;
    }
    public void setIdmodele(int idmodele) {
        this.idmodele = idmodele;
    }
    public String getNommodele() {
        return nommodele;
    }
    public void setNommodele(String nommodele) {
        this.nommodele = nommodele;
    }
    public double getPoids() {
        return poids;
    }
    public void setPoids(double poids) {
        this.poids = poids;
    }
    public double getLongueur() {
        return longueur;
    }
    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }
    public double getLargeur() {
        return largeur;
    }
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public double getHauteur() {
        return hauteur;
    }
    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }
    public double getReservoire() {
        return reservoire;
    }
    public void setReservoire(double reservoire) {
        this.reservoire = reservoire;
    }
    public Carrosserie getCarrosserie() {
        return carrosserie;
    }
    public void setCarrosserie(Carrosserie carrosserie) {
        this.carrosserie = carrosserie;
    }
    public Categorie getCategorie() {
        return categorie;
    }
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    public Marque getMarque() {
        return marque;
    }
    public void setMarque(Marque marque) {
        this.marque = marque;
    }
    
}
