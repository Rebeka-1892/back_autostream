package com.projet_voiture.projet_voiture.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet_voiture.projet_voiture.modele.Utilisateur;
import com.projet_voiture.projet_voiture.service.UtilisateurService;

@RequestMapping("/utilisateur")
@RestController
public class UtilisateurController {
     @Autowired
    private UtilisateurService service;

    @GetMapping
    public List<Utilisateur> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Optional<Utilisateur> findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
    
    @PostMapping
    public ResponseEntity<Utilisateur> insert( @RequestBody Utilisateur Utilisateur ) {
        try {
            Utilisateur inserted = service.insert(Utilisateur);
            return new ResponseEntity<>(inserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> update( @PathVariable("id") String id, @RequestBody Utilisateur Utilisateur ) {
        Optional<Utilisateur> to_update = service.findById(id);
        if (to_update.isPresent()) {
            Utilisateur updated = to_update.get();
            updated.setEmail(Utilisateur.getEmail()); 
            updated.setMdp(Utilisateur.getMdp());
            updated.setNomutilisateur(Utilisateur.getNomutilisateur());  
            
            return new ResponseEntity<Utilisateur>(
                service.insert(updated),
                HttpStatus.OK
            );
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id) {
        try {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
