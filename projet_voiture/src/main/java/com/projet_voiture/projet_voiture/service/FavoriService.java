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

    public List<Favori> getFavorisByIdutilisateur(String idutilisateur) {
        return repository.findByIdutilisateur(idutilisateur);
    }

    public Favori insert(Favori Favori) {
        Favori.setIdfavori(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(Favori);
    }

    public String deleteFavori(String FavoriId){
        repository.deleteById(FavoriId);
        return FavoriId+" Favori deleted from dashboard ";
    }

}
