package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.projet_voiture.projet_voiture.modele.Favori;
import java.util.List;

public interface FavoriRepository extends MongoRepository<Favori, String>{

    List<Favori> findByIdutilisateur(String idutilisateur);

}
