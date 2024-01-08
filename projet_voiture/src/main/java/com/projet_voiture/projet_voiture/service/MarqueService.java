package com.projet_voiture.projet_voiture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projet_voiture.projet_voiture.modele.Marque;
import com.projet_voiture.projet_voiture.repository.MarqueRepository;

public class MarqueService {
    @Autowired
    private MarqueRepository repository;

    public List<Marque> list() {
        return repository.findAll();
    }

    public Marque insert(Marque Marque) {
        return repository.save(Marque);
    }

    public Optional<Marque> findById(int idMarque) {
        return repository.findById(idMarque);
    }

    public void deleteById(int idMarque) {
        repository.deleteById(idMarque);
    }
}
