package com.projet_voiture.projet_voiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projet_voiture.projet_voiture.modele.Tresorerie;
import com.projet_voiture.projet_voiture.modele.VGainParMois;
// import org.springframework.data.mongodb.repository.Query;

@Repository
public interface TresorerieRepository extends JpaRepository<Tresorerie, Integer>{
    
}