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

import com.projet_voiture.projet_voiture.modele.Marque;
import com.projet_voiture.projet_voiture.service.MarqueService;

public class MarqueController {
    @Autowired
    private MarqueService service;

    @GetMapping
    public List<Marque> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Optional<Marque> findById(@PathVariable("id") int id) {
        return service.findById(id);
    }
    
    @PostMapping
    public ResponseEntity<Marque> insert( @RequestBody Marque Marque ) {
        try {
            Marque inserted = service.insert(Marque);
            return new ResponseEntity<>(inserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marque> update( @PathVariable("id") int id, @RequestBody Marque Marque ) {
        Optional<Marque> to_update = service.findById(id);
        if (to_update.isPresent()) {
            Marque updated = to_update.get();
            updated.setNommmarque(Marque.getNommmarque());    
            updated.setContinent(Marque.getContinent());      
            return new ResponseEntity<Marque>(
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
