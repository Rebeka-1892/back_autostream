package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.projet_voiture.projet_voiture.modele.Favori;
import java.util.List;
// import org.springframework.data.mongodb.repository.Query;

public interface FavoriRepository extends MongoRepository<Favori, String>{
    // get favoris by idutilisateur
    List<Favori> findByIdutilisateur(String idutilisateur);
    
    void deleteByIdannonceAndIdutilisateur(String idannonce, String idutilisateur);
}
