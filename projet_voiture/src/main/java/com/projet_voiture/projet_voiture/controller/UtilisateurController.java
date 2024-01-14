package com.projet_voiture.projet_voiture.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projet_voiture.projet_voiture.modele.Utilisateur;
import com.projet_voiture.projet_voiture.service.UtilisateurService;

@RequestMapping("/utilisateur")
@RestController
public class UtilisateurController {
    private final UtilisateurService UtilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService UtilisateurService) {
        this.UtilisateurService = UtilisateurService;
    }

    @GetMapping
    public List<Document> findAll() {
        return UtilisateurService.findAll().into(new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<Utilisateur> insert( @RequestBody Utilisateur Utilisateur ) {
        try {
            Utilisateur inserted = UtilisateurService.insert(Utilisateur);
            return new ResponseEntity<>(inserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Document findById(@PathVariable String id) {
        return UtilisateurService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateUtilisateur(@PathVariable String id, @RequestBody Document updatedUtilisateur) {
        UtilisateurService.updateUtilisateur(id, updatedUtilisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable String id) {
        UtilisateurService.deleteUtilisateur(id);
    }
}
