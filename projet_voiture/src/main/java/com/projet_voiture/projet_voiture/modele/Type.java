package com.projet_voiture.projet_voiture.modele;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idtype;
    String nomtype;

    public Type(String nomtype) {
        this.nomtype = nomtype;
    }

    public Type(int idtype, String nomtype) {
        this.idtype = idtype;
        this.nomtype = nomtype;
    }

    public Type() {
    }

    public int getIdtype() {
        return idtype;
    }
    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }
    public String getNomtype() {
        return nomtype;
    }
    public void setNomtype(String nomtype) {
        this.nomtype = nomtype;
    }    
}
