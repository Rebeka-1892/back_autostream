package com.projet_voiture.projet_voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Conduite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idconduite;
    String nomconduite;

    public Conduite(int idconduite, String nomconduite) {
        this.idconduite = idconduite;
        this.nomconduite = nomconduite;
    }

    public Conduite() {
    }
    
    public int getIdconduite() {
        return idconduite;
    }
    public void setIdconduite(int idconduite) {
        this.idconduite = idconduite;
    }
    public String getNomconduite() {
        return nomconduite;
    }
    public void setNomconduite(String nomconduite) {
        this.nomconduite = nomconduite;
    }
}
