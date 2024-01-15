package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.projet_voiture.projet_voiture.modele.Utilisateur;
// import org.springframework.data.mongodb.repository.Query;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, String>{
    
}
