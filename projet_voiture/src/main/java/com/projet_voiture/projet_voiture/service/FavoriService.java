package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.voiture_occasion.modele.Annonce;
import com.projet.voiture_occasion.repository.AnnonceRepository;
import com.projet_voiture.projet_voiture.modele.Favori;
import com.projet_voiture.projet_voiture.repository.FavoriRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FavoriService {
    @Autowired
    private FavoriRepository repository;

    @Autowired
    private AnnonceRepository annonceRepository;

    public List<Favori> getFavorisByIdutilisateur(String idutilisateur) {
        return repository.findByIdutilisateur(idutilisateur);
    }

    public String deleteFavoriByIdannonceAndIdutilisateur(String idannonce, String idutilisateur) {
        repository.deleteByIdannonceAndIdutilisateur(idannonce, idutilisateur);        
        return " Deleted from Favori ";
    }

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

    public List<Annonce> getAnnonceFavoriByIdUtilisateur(String idUtilisateur)
    {
        List<Favori> favoris = repository.findByIdutilisateur(idUtilisateur);
        List<String> idAnnonces = favoris.stream().map(Favori::getIdannonce).collect(Collectors.toList());

        return annonceRepository.findByIdannonceIn(idAnnonces);
    }
}
