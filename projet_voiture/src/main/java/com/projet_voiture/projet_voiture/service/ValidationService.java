package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Validation;
import com.projet_voiture.projet_voiture.repository.ValidationRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ValidationService {
    @Autowired
    private ValidationRepository repository;   

    public List<String> getAllValidationIds() {
        return repository.findAll().stream().map(Validation::getIdannonce).collect(Collectors.toList());
    }

    public List<String> getHistoriqueValidation() {
        return repository.findByEtatNotEqualToTwo().stream().map(Validation::getIdannonce).collect(Collectors.toList());
    }

    public List<Validation> findByEtat(int etat){
        return repository.findByEtat(etat);
    }

    public Validation insert(Validation Validation) {
        Validation.setIdvalidation(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(Validation);
    }

    public List<Validation> findAll() {
        return repository.findAll();
    }

    public Validation findById(String ValidationId){
        return repository.findById(ValidationId).get();
    }

    public Validation updateValidation(Validation ValidationRequest){
        Validation existingValidation = repository.findById(ValidationRequest.getIdvalidation()).get();
        // existingValidation.setDatemodif(ValidationRequest.getDatemodif());
        existingValidation.setEtat(ValidationRequest.getEtat());
        existingValidation.setIdannonce(ValidationRequest.getIdannonce());
        return repository.save(existingValidation);
    }

    public String deleteValidation(String ValidationId){
        repository.deleteById(ValidationId);
        return ValidationId+" Validation deleted from dashboard ";
    }
}
