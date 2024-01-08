package com.projet_voiture.projet_voiture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projet_voiture.projet_voiture.modele.Annonce;
import com.projet_voiture.projet_voiture.repository.AnnonceRepository;

public class AnnonceService {
    @Autowired
    private AnnonceRepository repository;

    public List<Annonce> list() {
        return repository.findAll();
    }

    public Annonce insert(Annonce Annonce) {
        return repository.save(Annonce);
    }

    public Optional<Annonce> findById(int idAnnonce) {
        return repository.findById(idAnnonce);
    }

    public void deleteById(int idAnnonce) {
        repository.deleteById(idAnnonce);
    }
}
