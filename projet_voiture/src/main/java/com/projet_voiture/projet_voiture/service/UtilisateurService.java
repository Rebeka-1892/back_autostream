package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Utilisateur;
import com.projet_voiture.projet_voiture.repository.UtilisateurRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository repository;

    public Optional<Utilisateur> findByNameAndPassword(Utilisateur utilisateur) {
        System.out.println("tafididtra");

        Optional<Utilisateur> user = repository.findByEmailAndMdp(
            utilisateur.getEmail(),
            utilisateur.getMdp()
        );
        System.out.println(user);
        if (user.isPresent()) {
            System.out.println(user.get());
        }
        return user;
    }

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
        existingUtilisateur.setRole(UtilisateurRequest.getRole());
        existingUtilisateur.setNomutilisateur(UtilisateurRequest.getNomutilisateur());
        existingUtilisateur.setMdp(UtilisateurRequest.getMdp());
        return repository.save(existingUtilisateur);
    }

    public String deleteUtilisateur(String UtilisateurId){
        repository.deleteById(UtilisateurId);
        return UtilisateurId+" Utilisateur deleted from dashboard ";
    }
}
