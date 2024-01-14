package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet_voiture.projet_voiture.modele.Marque;
import com.projet_voiture.projet_voiture.modele.Modele;
import java.util.List;


@Repository
public interface ModeleRepository extends JpaRepository<Modele, Integer>{
    List<Modele> findByMarque(Marque marque);
}
