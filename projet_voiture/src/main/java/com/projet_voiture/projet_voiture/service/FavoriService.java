package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Favori;
import com.projet_voiture.projet_voiture.repository.FavoriRepository;

import java.util.List;
import java.util.UUID;

@Service
public class FavoriService {
    @Autowired
    private FavoriRepository repository;

    public Favori insert(Favori Favori) {
        Favori.setIdfavori(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(Favori);
    }

    public List<Favori> findAll() {
        return repository.findAll();
    }

    public Favori findById(String FavoriId){
        return repository.findById(FavoriId).get();
    }

    public String deleteFavori(String FavoriId){
        repository.deleteById(FavoriId);
        return FavoriId+" Favori deleted from dashboard ";
    }
}
