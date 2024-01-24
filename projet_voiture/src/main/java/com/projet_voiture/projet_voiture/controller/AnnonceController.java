package com.projet_voiture.projet_voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 

import com.projet_voiture.projet_voiture.modele.Annonce;
import com.projet_voiture.projet_voiture.modele.HistoriqueAnnonce;
import com.projet_voiture.projet_voiture.service.AnnonceService;
import com.projet_voiture.projet_voiture.service.HistoriqueAnnonceService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonce")
public class AnnonceController {
    @Autowired
    private AnnonceService service;

    @Autowired
    private HistoriqueAnnonceService historiqueAnnonceService;

    @GetMapping("/unvalid/")
    public List<Annonce> getUnvalidatedAnnonces() {
        return service.getUnvalidatedAnnonces();
    }
     
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Annonce insert(@RequestBody Annonce Annonce) {
        return service.insert(Annonce);
    }

    @GetMapping
    public List<Annonce> findAll() {
        return service.findAll();
    }

    @GetMapping("/{AnnonceId}")
    public Annonce findById(@PathVariable String AnnonceId) {
        return service.findById(AnnonceId);
    }

    @PutMapping
    public Annonce updateAnnonce(@RequestBody Annonce Annonce) {
        return service.updateAnnonce(Annonce);
    }

    @DeleteMapping("/{AnnonceId}")
    public String deleteAnnonce(@PathVariable String AnnonceId) {
        return service.deleteAnnonce(AnnonceId);
    }

    @PostMapping("/modifAnnonce")
    public ResponseEntity<Annonce> updateAnnonceHistorique(@RequestBody Annonce annonce)
    {
        Annonce a = service.modifAnnonce(annonce);
        return ResponseEntity.ok().body(a);
    }

    @GetMapping("/histo/{idAnnonce}")
    public List<HistoriqueAnnonce> getHistoriqueAnnonceByIdAnnonce(@PathVariable String idAnnonce)
    {
        return historiqueAnnonceService.getAllHistoAnnonceByIdAnnonce(idAnnonce);
    }
}
