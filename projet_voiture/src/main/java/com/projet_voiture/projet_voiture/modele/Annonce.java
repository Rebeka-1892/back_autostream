package com.projet_voiture.projet_voiture.modele;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idannonce;
    LocalDateTime datepub;
    
    public Annonce() {
    }

    public int getIdannonce() {
        return idannonce;
    }
    public void setIdannonce(int idannonce) {
        this.idannonce = idannonce;
    }
    public LocalDateTime getDatepub() {
        return datepub;
    }
    public void setDatepub(LocalDateTime datepub) {
        this.datepub = datepub;
    }
}
