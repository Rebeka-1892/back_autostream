package com.projet_voiture.projet_voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
 

import com.projet_voiture.projet_voiture.modele.Favori;
import com.projet_voiture.projet_voiture.service.FavoriService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/favori")
public class FavoriController {
    @Autowired
    private FavoriService service;

    @GetMapping("/favori")
    public List<Favori> getListeFavoris(String idutilisateur) {
        return service.getFavorisByIdutilisateur(idutilisateur);
    }
     
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Favori insert(@RequestBody Favori Favori) {
        return service.insert(Favori);
    }

    @GetMapping
    public List<Favori> findAll() {
        return service.findAll();
    }

    @GetMapping("/{FavoriId}")
    public Favori findById(@PathVariable String FavoriId) {
        return service.findById(FavoriId);
    }

    @DeleteMapping("/{FavoriId}")
    public String deleteFavori(@PathVariable String FavoriId) {
        return service.deleteFavori(FavoriId);
    }

    @DeleteMapping("/favori/{idannonce}/{idutilisateur}")
    public void deleteFavoriByIds(@PathVariable String idannonce, @PathVariable String idutilisateur) {
        service.deleteFavoriByIdannonceAndIdutilisateur(idannonce, idutilisateur);
    }
}