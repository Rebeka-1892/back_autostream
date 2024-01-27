package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.projet_voiture.projet_voiture.modele.Validation;
import com.projet_voiture.projet_voiture.modele.NombreVoitureVenduParMois;
import com.projet_voiture.projet_voiture.repository.ValidationRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ValidationService {
    @Autowired
    private ValidationRepository repository;   

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
