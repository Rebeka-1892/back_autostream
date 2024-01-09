package com.projet_voiture.projet_voiture.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Utilisateur {
    @Id
    String idutilisateur;
    String nomutilisateur;
    String email;
    String mdp;
    int isadmin;
    
    public Utilisateur(String nomutilisateur, String email, String mdp) {
        this.nomutilisateur = nomutilisateur;
        this.email = email;
        this.mdp = mdp;
    }

    public Utilisateur(String idutilisateur, String nomutilisateur, String email, String mdp, int isadmin) {
        this.idutilisateur = idutilisateur;
        this.nomutilisateur = nomutilisateur;
        this.email = email;
        this.mdp = mdp;
        this.isadmin = isadmin;
    }

    public Utilisateur() {
    }
    
    public String getIdutilisateur() {
        return idutilisateur;
    }
    public void setIdutilisateur(String idutilisateur) {
        this.idutilisateur = idutilisateur;
    }
    public String getNomutilisateur() {
        return nomutilisateur;
    }
    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public int getIsadmin() {
        return isadmin;
    }
    public void setIsadmin(int isadmin) {
        this.isadmin = isadmin;
    }
}
