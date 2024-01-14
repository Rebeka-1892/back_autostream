package com.projet_voiture.projet_voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idtransmission;
    String nomtransmission;

    public Transmission(int idtransmission, String nomtransmission) {
        this.idtransmission = idtransmission;
        this.nomtransmission = nomtransmission;
    }

    public Transmission() {
    }
    
    public int getIdtransmission() {
        return idtransmission;
    }
    public void setIdtransmission(int idtransmission) {
        this.idtransmission = idtransmission;
    }
    public String getNomtransmission() {
        return nomtransmission;
    }
    public void setNomtransmission(String nomtransmission) {
        this.nomtransmission = nomtransmission;
    }
}
