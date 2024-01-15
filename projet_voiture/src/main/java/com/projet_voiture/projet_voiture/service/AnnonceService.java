package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Annonce;
import com.projet_voiture.projet_voiture.repository.AnnonceRepository;

import java.util.List;
import java.util.UUID;

@Service
public class AnnonceService {
    @Autowired
    private AnnonceRepository repository;

    public Annonce insert(Annonce Annonce) {
        Annonce.setIdannonce(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(Annonce);
    }

    public List<Annonce> findAll() {
        return repository.findAll();
    }

    public Annonce findById(String AnnonceId){
        return repository.findById(AnnonceId).get();
    }

    public Annonce updateAnnonce(Annonce AnnonceRequest){
        Annonce existingAnnonce = repository.findById(AnnonceRequest.getIdannonce()).get();
        existingAnnonce.setDatepub(AnnonceRequest.getDatepub());
        existingAnnonce.setDescri(AnnonceRequest.getDescri());
        existingAnnonce.setIdutilisateur(AnnonceRequest.getIdutilisateur());
        existingAnnonce.setIdvoiture(AnnonceRequest.getIdvoiture());
        existingAnnonce.setPrix(AnnonceRequest.getPrix());
        return repository.save(existingAnnonce);
    }

    public String deleteAnnonce(String AnnonceId){
        repository.deleteById(AnnonceId);
        return AnnonceId+" Annonce deleted from dashboard ";
    }
}
