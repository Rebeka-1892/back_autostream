package com.projet_voiture.projet_voiture.modele;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "utilisateur")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
    @Id
    String idutilisateur;
    String nomutilisateur;
    String email;
    String mdp;
    int isadmin;
}
