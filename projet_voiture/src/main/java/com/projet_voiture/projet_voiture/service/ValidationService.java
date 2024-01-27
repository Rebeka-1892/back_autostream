package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet_voiture.projet_voiture.modele.HistoriqueValidation;
import com.projet_voiture.projet_voiture.modele.Tresorerie;
import com.projet_voiture.projet_voiture.modele.Validation;
import com.projet.voiture_occasion.modele.NombreVoitureVenduParMois;
import com.projet_voiture.projet_voiture.repository.ValidationRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ValidationService {
    @Autowired
    private ValidationRepository repository;   

    // @Autowired
    // private AnnonceService annonceService;

    // @Autowired
    // private CommissionService commissionService;

    // @Autowired
    // private TresorerieService tresorerieService;

    // @Autowired
    // private HistoriqueValidationService historiqueValidationService;

    @Autowired
    private MongoTemplate mongoTemplate;


    public Optional<Validation> findByIdannonce(String idannonce) {
        return repository.findByIdannonce(idannonce);
    }

    public List<String> getAllValidationIds() {
        return repository.findByEtat(0).stream().map(Validation::getIdannonce).collect(Collectors.toList());
    }

    public List<String> getHistoriqueValidation() {
        return repository.findByEtatNotEqualToTwo().stream().map(Validation::getIdannonce).collect(Collectors.toList());
    }

    public List<Validation> findByEtat(int etat){
        return repository.findByEtat(etat);
    }

    public Validation insert(Validation Validation) {
        Validation.setIdvalidation(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(Validation);
    }

    // public List<Validation> findAll() {
    //     return repository.findAll();
    // }
    // public Validation findById(String ValidationId){
    //     return repository.findById(ValidationId).get();
    // }

    // @Transactional
    // public Validation updateValidation(Validation ValidationRequest){
    //     Validation existingValidation = repository.findById(ValidationRequest.getIdvalidation()).get();

    //     HistoriqueValidation historiqueValidation = new HistoriqueValidation();
    //     historiqueValidation.setIdvalidation(existingValidation.getIdvalidation());
    //     historiqueValidation.setIdannonce(existingValidation.getIdannonce());
    //     historiqueValidation.setEtat(existingValidation.getEtat());
    //     historiqueValidation.setDatemodif(existingValidation.getDatemodif());

    //     historiqueValidationService.insertHistoriqueValidation(historiqueValidation);

    //     existingValidation.setEtat(ValidationRequest.getEtat());
    //     existingValidation.setIdannonce(ValidationRequest.getIdannonce());
    //     existingValidation.setDatemodif(LocalDateTime.now());
        

    //     if(existingValidation.getEtat() == 3) {
    //         double pourcentage = commissionService.getLastCommission().getValeur();
    //         double prixVoiture = annonceService.findById(existingValidation.getIdannonce()).getPrix();

    //         double gainSite = prixVoiture *(pourcentage/100);

    //         Tresorerie tresorerie = new Tresorerie();
    //         tresorerie.setIdannonce(existingValidation.getIdannonce());
    //         tresorerie.setEntre(gainSite);
    //         tresorerie.setSortie(0);
    //         LocalDateTime currentDate = LocalDateTime.now();
    //         Instant instant = currentDate.toInstant(ZoneOffset.UTC);
    //         tresorerie.setDatemouvement(Timestamp.from(instant));

    //         tresorerieService.insertTresorerie(tresorerie);
    //     }
    //     return repository.save(existingValidation);
    // }

    // public String deleteValidation(String ValidationId){
    //     repository.deleteById(ValidationId);
    //     return ValidationId+" Validation deleted from dashboard ";
    // }

    public List<NombreVoitureVenduParMois> getNombreVenteParMois() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("etat").is(3).and("datemodif").ne(null)),
                Aggregation.project()
                        .andExpression("year(datemodif)").as("anneeValidation")
                        .andExpression("month(datemodif)").as("moisValidation"),
                Aggregation.group("anneeValidation", "moisValidation").count().as("nombreValidations"),
                Aggregation.project("anneeValidation", "moisValidation", "nombreValidations")
                        .andExclude("_id"),
                Aggregation.sort(Sort.Direction.DESC, "anneeValidation", "moisValidation")
        );

        AggregationResults<NombreVoitureVenduParMois> results = mongoTemplate.aggregate(
                aggregation, "validation", NombreVoitureVenduParMois.class);

        return results.getMappedResults();
    }
}
