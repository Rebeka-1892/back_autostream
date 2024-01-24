package com.projet_voiture.projet_voiture.modele;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "annonce")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Annonce {
    @Id
    String idannonce;
    String descri;
    double prix;
    LocalDateTime datepub;
    String idvoiture;
    String idutilisateur;    
}
