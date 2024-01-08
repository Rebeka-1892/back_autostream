package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet_voiture.projet_voiture.modele.Continent;

public interface ContinentRepository extends JpaRepository<Continent, Integer>{
    
}
