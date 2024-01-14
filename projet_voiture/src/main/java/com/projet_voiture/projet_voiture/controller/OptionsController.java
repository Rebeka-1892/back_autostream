package com.projet_voiture.projet_voiture.controller;

import com.projet_voiture.projet_voiture.modele.Options;
import com.projet_voiture.projet_voiture.service.OptionsService;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/options")
@RestController
public class OptionsController {
     private final OptionsService OptionsService;

    @Autowired
    public OptionsController(OptionsService OptionsService) {
        this.OptionsService = OptionsService;
    }

    @GetMapping
    public List<Document> findAll() {
        return OptionsService.findAll().into(new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<Options> insert( @RequestBody Options Options ) {
        try {
            Options inserted = OptionsService.insert(Options);
            return new ResponseEntity<>(inserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Document findById(@PathVariable int id) {
        return OptionsService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateOptions(@PathVariable int id, @RequestBody Document updatedOptions) {
        OptionsService.updateOptions(id, updatedOptions);
    }

    @DeleteMapping("/{id}")
    public void deleteOptions(@PathVariable int id) {
        OptionsService.deleteOptions(id);
    }
}
