mongosh
use vente_voiture
-- curl -X POST http://localhost:8080/options -H "Content-Type: application/json" -d @data.json
-- curl -X POST http://localhost:8080/options -H "Content-Type: application/json" -d '{ "nomoptions": "Airbags", "idtype" : 1}'

db.options.insertMany([
    { "nomoptions": "Airbags", "idtype" : 1}, 
    { "nomoptions": "Systeme de navigation", "idtype" : 1}, 
    { "nomoptions": "Caméra de recul", "idtype" : 1}, 
    { "nomoptions": "Freins ABS", "idtype" : 1}, 
    { "nomoptions": "Toit ouvrant", "idtype" : 2}, 
    { "nomoptions": "Système audio haut de gamme", "idtype" : 2}, 
    { "nomoptions": "Système de climatisation automatique", "idtype" : 2}, 
    { "nomoptions": "Sieges en cuir", "idtype" : 2}, 
    { "nomoptions": "Système de freinage d''urgence", "idtype" : 3}, 
    { "nomoptions": "Système de surveillance de la pression des pneus", "idtype" : 3}, 
    { "nomoptions": "Système de contrôle de la stabilité", "idtype" : 3}, 
    { "nomoptions": "Système de sécurité actif", "idtype" : 3}
])

db.voiture.insertOne(
    {
        "idvoiture" : 1, "nbplace" : 8, "nbporte" : 5, "kilometrage" : 1561, "cylindre" : 50, "puissance" : 78, "fumeur" : 1, 
        "datesortie" : "2023-12-31", "idconduite" : 1, "idmodele" : 1, "iddrivetype" : 1, "idtransmission" : 1, "idenergie" : 1
    }
)

db.voitureoptions.insertOne(
    { "idvoitureoptions" : 1, "idvoiture" : 1, "idoptions" : 2 }
)

db.utilisateur.insertMany([
    { "idutilisateur" : "USR001", "nomutilisateur" : "Rakoto", "email" : "rakoto@gmail.com", "mdp" : "1234", "role" : "admin"},
    { "idutilisateur" : "USR002", "nomutilisateur" : "Rasoa", "email" : "rasoa@gmail.com", "mdp" : "1234", "role" : "user"}
])

db.annonce.insertOne(
    { "idannonce" : 1, "descri" : "", "prix" : 15000, "datepub" : "2023-12-31", "idvoiture" : 1, "idutilisateur" : 2}
)

db.validation.insertOne(
    { "idvalidation" : 1, "etat" : 1, "datemodif" : "2023-12-31", "idannonce" : 1 }
)

db.message.insertOne(
    { "idmessage" : auto, "description" : VARCHAR, "idsend" : idutilisateur, "idreceive" : idutilisateur, "dateheure" : timestamp}
)

db.favori.insertOne(
    { "idfavori" : auto, "idannonce" : idannonce, "idutilisateur" : idutilisateur}
)