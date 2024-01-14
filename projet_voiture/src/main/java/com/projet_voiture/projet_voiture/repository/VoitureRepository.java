package com.projet_voiture.projet_voiture.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.projet_voiture.projet_voiture.modele.Voiture;

public interface VoitureRepository extends MongoRepository<Voiture, Integer>{
    
}
