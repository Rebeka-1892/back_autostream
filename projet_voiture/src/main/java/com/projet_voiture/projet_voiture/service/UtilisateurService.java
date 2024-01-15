package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Utilisateur;
import com.projet_voiture.projet_voiture.repository.UtilisateurRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository repository;

    public Utilisateur insert(Utilisateur Utilisateur) {
        Utilisateur.setIdutilisateur(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(Utilisateur);
    }

    public List<Utilisateur> findAll() {
        return repository.findAll();
    }

    public Utilisateur findById(String UtilisateurId){
        return repository.findById(UtilisateurId).get();
    }

    public Utilisateur updateUtilisateur(Utilisateur UtilisateurRequest){
        Utilisateur existingUtilisateur = repository.findById(UtilisateurRequest.getIdutilisateur()).get();
        existingUtilisateur.setEmail(UtilisateurRequest.getEmail());
        existingUtilisateur.setIsadmin(UtilisateurRequest.getIsadmin());
        existingUtilisateur.setNomutilisateur(UtilisateurRequest.getNomutilisateur());
        existingUtilisateur.setMdp(UtilisateurRequest.getMdp());
        return repository.save(existingUtilisateur);
    }

    public String deleteUtilisateur(String UtilisateurId){
        repository.deleteById(UtilisateurId);
        return UtilisateurId+" Utilisateur deleted from dashboard ";
    }
}
