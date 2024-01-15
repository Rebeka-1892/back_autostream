package com.projet_voiture.projet_voiture.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.data.mongodb.repository.Query;

import com.projet_voiture.projet_voiture.modele.Validation;

import java.util.List;
public interface  ValidationRepository extends MongoRepository<Validation,String>  {
    
}