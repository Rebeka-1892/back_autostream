package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.projet_voiture.projet_voiture.modele.Voiture;
// import org.springframework.data.mongodb.repository.Query;

public interface VoitureRepository extends MongoRepository<Voiture, String>{
    
}
