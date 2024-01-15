package com.projet_voiture.projet_voiture.modele;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "options")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Options {
    @Id
    String idoptions;
    String nomoptions;
    int idtype;
}
