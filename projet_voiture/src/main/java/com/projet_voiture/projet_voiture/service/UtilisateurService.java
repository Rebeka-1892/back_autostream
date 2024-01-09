package com.projet_voiture.projet_voiture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Utilisateur;
import com.projet_voiture.projet_voiture.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository repository;

    public List<Utilisateur> list() {
        return repository.findAll();
    }

    public Utilisateur insert(Utilisateur Utilisateur) {
        return repository.save(Utilisateur);
    }

    public Optional<Utilisateur> findById(String idUtilisateur) {
        return repository.findById(idUtilisateur);
    }

    public void deleteById(String idUtilisateur) {
        repository.deleteById(idUtilisateur);
    }
}
