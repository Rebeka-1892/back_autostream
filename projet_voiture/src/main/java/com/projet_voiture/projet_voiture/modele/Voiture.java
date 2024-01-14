package com.projet_voiture.projet_voiture.modele;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Voiture {
    @Id
    int idvoiture;
    int nbplace;
    int nbporte;
    double kilometrage;
    double cylindre;
    double puissance;
    int fumeur;
    Date datesortie;
    int idconduite;
    int idmodele;
    int iddrivetype;
    int idtransmission;
    int idenergie;

    public Voiture() {
    }

    public Voiture(int idvoiture, int nbplace, int nbporte, double kilometrage, double cylindre, double puissance,
            int fumeur, Date datesortie, int idconduite, int idmodele, int iddrivetype, int idtransmission,
            int idenergie) {
        this.idvoiture = idvoiture;
        this.nbplace = nbplace;
        this.nbporte = nbporte;
        this.kilometrage = kilometrage;
        this.cylindre = cylindre;
        this.puissance = puissance;
        this.fumeur = fumeur;
        this.datesortie = datesortie;
        this.idconduite = idconduite;
        this.idmodele = idmodele;
        this.iddrivetype = iddrivetype;
        this.idtransmission = idtransmission;
        this.idenergie = idenergie;
    }
    
    public int getIdvoiture() {
        return idvoiture;
    }
    public void setIdvoiture(int idvoiture) {
        this.idvoiture = idvoiture;
    }
    public int getNbplace() {
        return nbplace;
    }
    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }
    public int getNbporte() {
        return nbporte;
    }
    public void setNbporte(int nbporte) {
        this.nbporte = nbporte;
    }
    public double getKilometrage() {
        return kilometrage;
    }
    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }
    public double getCylindre() {
        return cylindre;
    }
    public void setCylindre(double cylindre) {
        this.cylindre = cylindre;
    }
    public double getPuissance() {
        return puissance;
    }
    public void setPuissance(double puissance) {
        this.puissance = puissance;
    }
    public int getFumeur() {
        return fumeur;
    }
    public void setFumeur(int fumeur) {
        this.fumeur = fumeur;
    }
    public Date getDatesortie() {
        return datesortie;
    }
    public void setDatesortie(Date datesortie) {
        this.datesortie = datesortie;
    }
    public int getIdconduite() {
        return idconduite;
    }
    public void setIdconduite(int idconduite) {
        this.idconduite = idconduite;
    }
    public int getIdmodele() {
        return idmodele;
    }
    public void setIdmodele(int idmodele) {
        this.idmodele = idmodele;
    }
    public int getIddrivetype() {
        return iddrivetype;
    }
    public void setIddrivetype(int iddrivetype) {
        this.iddrivetype = iddrivetype;
    }
    public int getIdtransmission() {
        return idtransmission;
    }
    public void setIdtransmission(int idtransmission) {
        this.idtransmission = idtransmission;
    }
    public int getIdenergie() {
        return idenergie;
    }
    public void setIdenergie(int idenergie) {
        this.idenergie = idenergie;
    }
    
}
