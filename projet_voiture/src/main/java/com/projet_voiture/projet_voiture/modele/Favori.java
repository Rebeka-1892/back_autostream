package com.projet_voiture.projet_voiture.modele;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "favori")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favori {
    @Id
    String idfavori;
    String idannonce;
    String idutilisateur;
}
