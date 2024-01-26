package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.projet_voiture.projet_voiture.modele.Annonce;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;

public interface AnnonceRepository extends MongoRepository<Annonce, String>{

    List<Annonce> findAllByIdannonceNotIn(List<String> allValidationIds);

    // @Query("{'idutilisateur': ?0, 'idannonce': {$in: ['$idannonce'], '$nin': [2]}}")
    // List<Annonce> findByIduutilisateurAndIdannonceInValidationAndEtatNotEqualToTwo(String idutilisateur);

    @Query("{ 'idutilisateur': ?0, 'idannonce': { $in: ?1 } }")
    List<Annonce> findByIduutilisateurAndIdannonceIn(String idutilisateur, List<String> allValidationIds);

}
