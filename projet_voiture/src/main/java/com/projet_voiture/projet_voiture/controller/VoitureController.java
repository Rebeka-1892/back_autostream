package com.projet_voiture.projet_voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
 

import com.projet_voiture.projet_voiture.modele.Voiture;
import com.projet_voiture.projet_voiture.service.VoitureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voiture")
public class VoitureController {
    @Autowired
    private VoitureService service;

     
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Voiture insert(@RequestBody Voiture Voiture) {
        return service.insert(Voiture);
    }

    @GetMapping
    public List<Voiture> findAll() {
        return service.findAll();
    }

    @GetMapping("/{VoitureId}")
    public Voiture findById(@PathVariable String VoitureId) {
        return service.findById(VoitureId);
    }

    @PutMapping
    public Voiture updateVoiture(@RequestBody Voiture Voiture) {
        return service.updateVoiture(Voiture);
    }

    @DeleteMapping("/{VoitureId}")
    public String deleteVoiture(@PathVariable String VoitureId) {
        return service.deleteVoiture(VoitureId);
    }
}
