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

import com.projet_voiture.projet_voiture.modele.Annonce;
import com.projet_voiture.projet_voiture.service.AnnonceService;

public class AnnonceController {
     @Autowired
    private AnnonceService service;

    @GetMapping
    public List<Annonce> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Optional<Annonce> findById(@PathVariable("id") int id) {
        return service.findById(id);
    }
    
    @PostMapping
    public ResponseEntity<Annonce> insert( @RequestBody Annonce Annonce ) {
        try {
            Annonce inserted = service.insert(Annonce);
            return new ResponseEntity<>(inserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Annonce> update( @PathVariable("id") int id, @RequestBody Annonce Annonce ) {
        Optional<Annonce> to_update = service.findById(id);
        if (to_update.isPresent()) {
            Annonce updated = to_update.get();
            updated.setDatepub(Annonce.getDatepub());          
            return new ResponseEntity<Annonce>(
                service.insert(updated),
                HttpStatus.OK
            );
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") int id) {
        try {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
