package com.projet_voiture.projet_voiture.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projet_voiture.projet_voiture.modele.Annonce;
import com.projet_voiture.projet_voiture.service.AnnonceService;

@RequestMapping("/annonce")
@RestController
public class AnnonceController {

    private final AnnonceService AnnonceService;

    @Autowired
    public AnnonceController(AnnonceService AnnonceService) {
        this.AnnonceService = AnnonceService;
    }

    @GetMapping
    public List<Document> findAll() {
        return AnnonceService.findAll().into(new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<Annonce> insert( @RequestBody Annonce Annonce ) {
        try {
            Annonce inserted = AnnonceService.insert(Annonce);
            return new ResponseEntity<>(inserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Document findById(@PathVariable int id) {
        return AnnonceService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateAnnonce(@PathVariable int id, @RequestBody Document updatedAnnonce) {
        AnnonceService.updateAnnonce(id, updatedAnnonce);
    }

    @DeleteMapping("/{id}")
    public void deleteAnnonce(@PathVariable int id) {
        AnnonceService.deleteAnnonce(id);
    }
}
