package com.projet_voiture.projet_voiture.modele;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "voiture")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {
    @Id
    String idvoiture;
    int nbplace;
    int nbporte;
    double kilometrage;
    double cylindre;
    double puissance;
    int fumeur;
    Date datesortie;
    int idconduite;
    int idmodele;
    int iddrivetype;
    int idtransmission;
    int idenergie;
    String[] photos;
}
