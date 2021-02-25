USE game_management;

-- 1. Crea los siguientes registros en la tabla genres
-- a. Mediante un solo comando: Action, Adventure, Fighting, Misc, Platform, Puzzle, 
-- b. Cada opción un comando en un insert: Racing, Role-Playing, Shooter, Simulation, Sports, Strategy

INSERT INTO genres (genre_name)
VALUES 
	("Action"),
	("Adventure"),
    ("Fighting"),
    ("Misc"),
    ("Platform"),
    ("Puzzle");
    
INSERT INTO genres (genre_name)
VALUES ("Racing");

INSERT INTO genres (genre_name)
VALUES ("Role-playing");

INSERT INTO genres (genre_name)
VALUES ("Shooter");

INSERT INTO genres (genre_name)
VALUES ("Simulation");

INSERT INTO genres (genre_name)
VALUES ("Sports");

INSERT INTO genres (genre_name)
VALUES ("Strategy");

-- 2. Crea los siguientes registros en la tabla platforms
-- (1,'Wii U'),(2,'PS5'),(3,'XBOX ONE'),(4,'PS3')
-- (5,'3DS'),(6,'PS4'),(7,'PC')

INSERT INTO platforms (id, platform_name)
VALUES
	(1, "Wii U"),
    (2, "PS5"),
    (3, "XBOX ONE"),
    (4, "PS3"),
    (5, "3DS"),
    (6, "PS4"),
    (7, "PC");

-- 3. Crea los siguientes registros en la tabla publisers mediante un solo comando insert
-- (1,'10TACLE Studios'),(2,'1C Company'),(3,'20th Century Fox Video Games')
-- (4,'Activision'),(5,'Activision Blizzard'),(6,'Activision Value')

INSERT INTO publishers (id, publisher_name)
VALUES
	(1, "10TACLE Studios"),
    (2, "1C Company"),
    (3, "20th Century Fox Video Games"),
    (4, "Activision"),
    (5, "Activision Blizzard"),
    (6, "Activision Value");

-- 4. Crea los siguientes registros en la tabla regions mediante un solo comando insert
-- (1,'North America'),(2,'Europe'),(3,'Japan'),(4,'Other')

INSERT INTO regions (id, region_name)
VALUES
	(1, "North America"),
    (2, "Europe"),
    (3, "Japan"),
    (4, "Other");
    
-- 5. Crea los campos 'created_at' y 'updated_at' para las siguientes tablas:
-- a. game, game_publisher y game_platform
-- b. NOTA: los campos deben guardar por defecto la fecha actual

ALTER TABLE games ADD (
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP);
    
INSERT INTO games (genre_id, game_name)
VALUES
	(7, "F1 2020"),
    (11, "FIFA 2020");
    
ALTER TABLE games_publishers ADD (
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP);
    
INSERT INTO games_publishers (game_id, publisher_id)
VALUES
    (1, 4),
    (2, 1);
    
ALTER TABLE games_platforms ADD (
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP);
    
INSERT INTO games_platforms (game_publisher_id, platform_id, release_year)
VALUES
	(1, 6, 2020),
    (2, 2, 2020);
    
/* selects */

SELECT * FROM genres;

SELECT * FROM platforms;

SELECT * FROM publishers;

SELECT * FROM regions;

SELECT * FROM games;

SELECT * FROM games_publishers;

SELECT * FROM games_platforms;
