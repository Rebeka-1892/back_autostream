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

INSERT INTO marque (nommarque, idcontinent) 
VALUES 
('Acura', 2), -- Amérique du Nord
('Aston Martin', 2), -- Amérique du Nord
('Audi', 2), -- Amérique du Nord
('Bentley', 2), -- Amérique du Nord
('BMW', 2), -- Amérique du Nord
('Buick', 2), -- Amérique du Nord
('Cadillac', 2), -- Amérique du Nord
('Chevrolet', 2), -- Amérique du Nord
('Chrysler', 2), -- Amérique du Nord
('Dodge', 2), -- Amérique du Nord
('Ferrari', 2), -- Amérique du Nord
('Fiat', 3), -- Europe
('Ford', 2), -- Amérique du Nord
('GMC', 2), -- Amérique du Nord
('Honda', 2), -- Asie
('Hyundai', 3), -- Asie
('Infiniti', 2), -- Amérique du Nord
('Jaguar', 3), -- Europe
('Jeep', 2), -- Amérique du Nord
('Kia', 3), -- Asie
('Lamborghini', 3), -- Europe
('Land Rover', 3), -- Europe
('Lexus', 2), -- Amérique du Nord
('Lincoln', 2), -- Amérique du Nord
('Lotus', 3), -- Europe
('Maserati', 3), -- Europe
('Mazda', 3), -- Asie
('Mercedes Benz', 3), -- Europe
('Mini', 3), -- Europe
('Mitsubishi', 3), -- Asie
('Nissan', 3), -- Asie
('Porsche', 3), -- Europe
('Ram Trucks', 2), -- Amérique du Nord
('Rolls Royce', 3), -- Europe
('Smart', 3), -- Europe
('Subaru', 3), -- Asie
('Tesla', 2), -- Amérique du Nord
('Toyota', 3), -- Asie
('Volkswagen', 3), -- Europe
('Volvo', 3); -- Europe

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
