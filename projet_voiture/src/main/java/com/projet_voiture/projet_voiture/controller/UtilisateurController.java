package com.projet_voiture.projet_voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import com.projet_voiture.projet_voiture.modele.Utilisateur;
import com.projet_voiture.projet_voiture.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurService service;

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Utilisateur insert(@RequestBody Utilisateur Utilisateur) {
        return service.insert(Utilisateur);
    }

    @GetMapping
    public List<Utilisateur> findAll() {
        return service.findAll();
    }

    @GetMapping("/{UtilisateurId}")
    public Utilisateur findById(@PathVariable String UtilisateurId) {
        return service.findById(UtilisateurId);
    }

    @PutMapping
    public Utilisateur updateUtilisateur(@RequestBody Utilisateur Utilisateur) {
        return service.updateUtilisateur(Utilisateur);
    }

    @DeleteMapping("/{UtilisateurId}")
    public String deleteUtilisateur(@PathVariable String UtilisateurId) {
        return service.deleteUtilisateur(UtilisateurId);
    }
}
