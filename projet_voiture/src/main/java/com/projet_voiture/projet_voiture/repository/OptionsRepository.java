package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.projet_voiture.projet_voiture.modele.Options;

public interface OptionsRepository extends MongoRepository<Options, Integer>{

    
}
