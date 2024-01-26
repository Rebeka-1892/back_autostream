package com.projet_voiture.projet_voiture.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.projet_voiture.projet_voiture.modele.Validation;

import java.util.List;
import java.util.Optional;
public interface  ValidationRepository extends MongoRepository<Validation,String>  {
    List<Validation> findByEtat(int etat);

    Optional<Validation> findByIdannonce(String idannonce);

    @Query("{ 'etat': { $ne: 2 } }")
    List<Validation> findByEtatNotEqualToTwo();

    @Query(value = "{}", fields = "{ 'idannonce' : 1 }")
    List<String> findAllValidationIds();
}