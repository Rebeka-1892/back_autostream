INSERT INTO categorie (nomcategorie) 
VALUES 
('Sport'), 
('Famille'), 
('Compacte'), 
('4x4'), 
('électrique');

INSERT INTO continent (nomcontinent) 
VALUES 
('Amérique du Nord'), 
('Amérique du Sud'), 
('Europe'), 
('Asie'), 
('Afrique'), 
('Océanie'), 
('Antarctique');

INSERT INTO marque (nommarque, idcontinent, photo) 
VALUES 
('Acura', 2, 'zertyu'), -- Amérique du Nord
('Aston Martin', 2, 'qsdfg'), -- Amérique du Nord
('Audi', 2, 'qsdfg'), -- Amérique du Nord
('Bentley', 2, 'qsdfg'), -- Amérique du Nord
('BMW', 2, 'qsdfg'), -- Amérique du Nord
('Buick', 2, 'qsdfg'), -- Amérique du Nord
('Cadillac', 2, 'qsdfg'), -- Amérique du Nord
('Chevrolet', 2, 'qsdfg'), -- Amérique du Nord
('Chrysler', 2, 'qsdfg'), -- Amérique du Nord
('Dodge', 2, 'qsdfg'), -- Amérique du Nord
('Ferrari', 2, 'qsdfg'), -- Amérique du Nord
('Fiat', 3, 'qsdfg'), -- Europe
('Ford', 2, 'qsdfg'), -- Amérique du Nord
('GMC', 2, 'qsdfg'), -- Amérique du Nord
('Honda', 2, 'qsdfg'), -- Asie
('Hyundai', 3, 'qsdfg'), -- Asie
('Infiniti', 2, 'qsdfg'), -- Amérique du Nord
('Jaguar', 3, 'qsdfg'), -- Europe
('Jeep', 2, 'qsdfg'), -- Amérique du Nord
('Kia', 3, 'qsdfg'), -- Asie
('Lamborghini', 3, 'qsdfg'), -- Europe
('Land Rover', 3, 'qsdfg'), -- Europe
('Lexus', 2, 'qsdfg'), -- Amérique du Nord
('Lincoln', 2, 'qsdfg'), -- Amérique du Nord
('Lotus', 3, 'qsdfg'), -- Europe
('Maserati', 3, 'qsdfg'), -- Europe
('Mazda', 3, 'qsdfg'), -- Asie
('Mercedes Benz', 3, 'qsdfg'), -- Europe
('Mini', 3, 'qsdfg'), -- Europe
('Mitsubishi', 3, 'qsdfg'), -- Asie
('Nissan', 3, 'qsdfg'), -- Asie
('Porsche', 3, 'qsdfg'), -- Europe
('Ram Trucks', 2, 'qsdfg'), -- Amérique du Nord
('Rolls Royce', 3, 'qsdfg'), -- Europe
('Smart', 3, 'qsdfg'), -- Europe
('Subaru', 3, 'qsdfg'), -- Asie
('Tesla', 2, 'qsdfg'), -- Amérique du Nord
('Toyota', 3, 'qsdfg'), -- Asie
('Volkswagen', 3, 'qsdfg'), -- Europe
('Volvo', 3, 'qsdfg'); -- Europe

INSERT INTO energie (nomenergie) 
VALUES 
('Essence'), 
('Diesel'), 
('Bio-diesel'), 
('Ethanol'), 
('Gaz naturel'), 
('électrique');

INSERT INTO carrosserie (nomcarrosserie) 
VALUES 
('Berline'), 
('Break'), 
('SUV'), 
('Coupé'), 
('Cabriolet'), 
('Roadster'), 
('Monospace');

INSERT INTO transmission (nomtransmission) 
VALUES 
('Manuelle'), 
('Automatique'), 
('Semi-automatique'), 
('Continu variable');

INSERT INTO drivetype (nomdrivetype) 
VALUES 
('Avant'), 
('Arrière'), 
('Intégrale');

INSERT INTO conduite (nomconduite) 
VALUES 
('Conduite à droite'), 
('Conduite à gauche');

INSERT INTO type (nomtype) 
VALUES 
('Interieur'), 
('Exterieur');
