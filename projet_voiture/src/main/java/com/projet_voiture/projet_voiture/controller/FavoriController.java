package com.projet_voiture.projet_voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;

import com.projet_voiture.projet_voiture.modele.Favori;
import com.projet_voiture.projet_voiture.modele.Utilisateur;
import com.projet_voiture.projet_voiture.repository.UtilisateurRepository;
import com.projet_voiture.projet_voiture.service.FavoriService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.projet_voiture.projet_voiture.tools.JwtUtil;


@RestController
@RequestMapping("/Favori")
public class FavoriController {
    @Autowired
    private FavoriService service;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    private UtilisateurRepository repository;

    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    @GetMapping("/{idutilisateur}")
    public List<Favori> getListeFavoris(@PathVariable String idutilisateur) {
        return service.getFavorisByIdutilisateur(idutilisateur);
    }
     
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Favori insert(@RequestBody Favori Favori) {
        String login = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());

        // String authorization = request.getHeader("Authorization");
        // String token = authorization.substring(7);
        // System.out.println("Token: " + token);
        // String login = jwtUtil.extractLogin(token);

        Optional<Utilisateur> utilisateurOptional = repository.findByEmail(login);
        Utilisateur utilisateur = new Utilisateur();
        if (utilisateurOptional.isPresent()) {

            utilisateur = utilisateurOptional.get();
            Favori.setIdutilisateur(utilisateur.getIdutilisateur());
            return service.insert(Favori);
        }
        return null;
    }

    @DeleteMapping("/{FavoriId}")
    public String deleteFavori(@PathVariable String FavoriId) {
        return service.deleteFavori(FavoriId);
    }

}