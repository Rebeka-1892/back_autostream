package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.projet_voiture.projet_voiture.modele.Validation;

public interface ValidationRepository extends MongoRepository<Validation, Integer>{
    
}
