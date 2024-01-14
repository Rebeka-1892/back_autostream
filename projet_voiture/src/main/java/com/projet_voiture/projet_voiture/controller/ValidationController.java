package com.projet_voiture.projet_voiture.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projet_voiture.projet_voiture.modele.Validation;
import com.projet_voiture.projet_voiture.service.ValidationService;

@RequestMapping("/validation")
@RestController
public class ValidationController {
    private final ValidationService ValidationService;

    @Autowired
    public ValidationController(ValidationService ValidationService) {
        this.ValidationService = ValidationService;
    }

    @GetMapping
    public List<Document> findAll() {
        return ValidationService.findAll().into(new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<Validation> insert( @RequestBody Validation Validation ) {
        try {
            Validation inserted = ValidationService.insert(Validation);
            return new ResponseEntity<>(inserted, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Document findById(@PathVariable int id) {
        return ValidationService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateValidation(@PathVariable int id, @RequestBody Document updatedValidation) {
        ValidationService.updateValidation(id, updatedValidation);
    }

    @DeleteMapping("/{id}")
    public void deleteValidation(@PathVariable int id) {
        ValidationService.deleteValidation(id);
    }
}
