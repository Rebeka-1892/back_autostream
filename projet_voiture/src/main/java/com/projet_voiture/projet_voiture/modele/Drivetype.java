package com.projet_voiture.projet_voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Drivetype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int iddrivetype;
    String nomdrivetype;

    public Drivetype(int iddrivetype, String nomdrivetype) {
        this.iddrivetype = iddrivetype;
        this.nomdrivetype = nomdrivetype;
    }

    public Drivetype() {
    }
    
    public int getIddrivetype() {
        return iddrivetype;
    }
    public void setIddrivetype(int iddrivetype) {
        this.iddrivetype = iddrivetype;
    }
    public String getNomdrivetype() {
        return nomdrivetype;
    }
    public void setNomdrivetype(String nomdrivetype) {
        this.nomdrivetype = nomdrivetype;
    }
    
}
