package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.projet_voiture.projet_voiture.modele.Annonce;
import java.util.List;

public interface AnnonceRepository extends MongoRepository<Annonce, String>{

    List<Annonce> findAllByIdannonceNotIn(List<String> allValidationIds);

}
