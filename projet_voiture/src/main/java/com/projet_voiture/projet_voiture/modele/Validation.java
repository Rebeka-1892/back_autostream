package com.projet_voiture.projet_voiture.modele;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "validation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Validation {
    @Id
    String idvalidation;
    int etat;
    LocalDateTime datemodif;
    String idannonce;
}
