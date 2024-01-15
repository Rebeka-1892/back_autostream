package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.projet_voiture.projet_voiture.modele.Annonce;
// import org.springframework.data.mongodb.repository.Query;

public interface AnnonceRepository extends MongoRepository<Annonce, String>{
    
}
