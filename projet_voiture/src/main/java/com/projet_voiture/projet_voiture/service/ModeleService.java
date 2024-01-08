package com.projet_voiture.projet_voiture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projet_voiture.projet_voiture.modele.Modele;
import com.projet_voiture.projet_voiture.repository.ModeleRepository;

public class ModeleService {
    @Autowired
    private ModeleRepository repository;

    public List<Modele> list() {
        return repository.findAll();
    }

    public Modele insert(Modele Modele) {
        return repository.save(Modele);
    }

    public Optional<Modele> findById(int idModele) {
        return repository.findById(idModele);
    }

    public void deleteById(int idModele) {
        repository.deleteById(idModele);
    }
}
