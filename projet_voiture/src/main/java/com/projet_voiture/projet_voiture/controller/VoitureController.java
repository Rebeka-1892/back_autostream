package com.projet_voiture.projet_voiture.controller;

import java.util.List;
import java.util.ArrayList;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projet_voiture.projet_voiture.modele.Voiture;
import com.projet_voiture.projet_voiture.service.VoitureService;

@RequestMapping("/voiture")
@RestController
public class VoitureController {

    private final VoitureService VoitureService;

    @Autowired
    public VoitureController(VoitureService VoitureService) {
        this.VoitureService = VoitureService;
    }

    @GetMapping
    public List<Document> findAll() {
        return VoitureService.findAll().into(new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<Voiture> insert( @RequestBody Voiture Voiture ) {
        try {
            Voiture inserted = VoitureService.insert(Voiture);
            return new ResponseEntity<>(inserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Document findById(@PathVariable int id) {
        return VoitureService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateVoiture(@PathVariable int id, @RequestBody Document updatedVoiture) {
        VoitureService.updateVoiture(id, updatedVoiture);
    }

    @DeleteMapping("/{id}")
    public void deleteVoiture(@PathVariable int id) {
        VoitureService.deleteVoiture(id);
    }
}
