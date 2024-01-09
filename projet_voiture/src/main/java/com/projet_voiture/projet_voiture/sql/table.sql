drop database vente_voiture;
CREATE database vente_voiture;
\c vente_voiture

CREATE TABLE categorie(
 idcategorie SERIAL PRIMARY KEY,
 nomcategorie VARCHAR(50)
);

CREATE TABLE continent(
 idcontinent SERIAL PRIMARY KEY,
 nomcontinent VARCHAR(50)
);

CREATE TABLE marque(
 idmarque SERIAL PRIMARY KEY,
 nommarque VARCHAR(50),
 idcontinent INT NOT NULL,
 FOREIGN KEY(idcontinent) REFERENCES continent(idcontinent)
);

CREATE TABLE energie(
 idenergie SERIAL PRIMARY KEY,
 nomenergie VARCHAR(50)
);

CREATE TABLE carrosserie(
 idcarrosserie SERIAL PRIMARY KEY,
 nomcarrosserie VARCHAR(50)
);

CREATE TABLE transmission(
 idtransmission SERIAL PRIMARY KEY,
 nomtransmission VARCHAR(50)
);

CREATE TABLE drivetype(
 iddrivetype SERIAL PRIMARY KEY,
 nomdrivetype VARCHAR(50)
);

CREATE TABLE conduite(
 idconduite SERIAL PRIMARY KEY,
 nomconduite VARCHAR(50)
);

CREATE TABLE type(
 idtype SERIAL PRIMARY KEY,
 nomtype VARCHAR(50)
);

CREATE TABLE options(
 idoptions SERIAL PRIMARY KEY,
 nomoptions VARCHAR(50),
 idtype INT NOT NULL,
 FOREIGN KEY(idtype) REFERENCES type(idtype)
);

CREATE TABLE modele(
 idmodele SERIAL PRIMARY KEY,
 nommodele VARCHAR(50),
 poids real,
 longueur real,
 largeur real,
 hauteur real,
 reservoire real,
 idcarrosserie INT NOT NULL,
 idcategorie INT NOT NULL,
 idmarque INT NOT NULL,
 FOREIGN KEY(idcarrosserie) REFERENCES carrosserie(idcarrosserie),
 FOREIGN KEY(idcategorie) REFERENCES categorie(idcategorie),
 FOREIGN KEY(idmarque) REFERENCES marque(idmarque)
);

CREATE TABLE info(
 idinfo SERIAL PRIMARY KEY,
 datesortie DATE,
 idconduite INT NOT NULL,
 idmodele INT NOT NULL,
 iddrivetype INT NOT NULL,
 idtransmission INT NOT NULL,
 idenergie INT NOT NULL,
 FOREIGN KEY(idconduite) REFERENCES conduite(idconduite),
 FOREIGN KEY(idmodele) REFERENCES modele(idmodele),
 FOREIGN KEY(iddrivetype) REFERENCES drivetype(iddrivetype),
 FOREIGN KEY(idtransmission) REFERENCES transmission(idtransmission),
 FOREIGN KEY(idenergie) REFERENCES energie(idenergie)
);

CREATE TABLE voitureoptions(
 idvoitureoptions SERIAL PRIMARY KEY,
 idinfo INT,
 idoptions INT,
 UNIQUE(idvoitureoptions),
 FOREIGN KEY(idoptions) REFERENCES options(idoptions),
 FOREIGN KEY(idinfo) REFERENCES info(idinfo)
);

CREATE TABLE voiture(
 idvoiture SERIAL PRIMARY KEY,
 nbplace INT,
 nbporte INT,
 kilometrage real,
 cylindre real,
 puissance real,
 fumeur INT,
 idinfo INT NOT NULL,
 FOREIGN KEY(idinfo) REFERENCES info(idinfo)
);

CREATE SEQUENCE seq_user;

CREATE TABLE utilisateur(
    idutilisateur VARCHAR(50) PRIMARY KEY,
    nomutilisateur VARCHAR(50),
    email VARCHAR(50),
    mdp VARCHAR(50),
    isadmin INT
);

CREATE TABLE annonce(
    idannonce SERIAL PRIMARY KEY,
    datepub TIMESTAMP,
    idvoiture INT NOT NULL,
    idutilisateur VARCHAR(50) NOT NULL,
    FOREIGN KEY(idvoiture) REFERENCES voiture(idvoiture),
    FOREIGN KEY(idutilisateur) REFERENCES utilisateur(idutilisateur)
);

CREATE TABLE validation(
 idvalidation SERIAL PRIMARY KEY,
 etat INT,
 datemodif TIMESTAMP,
 idannonce INT NOT NULL,
 FOREIGN KEY(idannonce) REFERENCES annonce(idannonce)
);
