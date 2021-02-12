/* creacion de la base de datos */

CREATE DATABASE game_management;

/* creacion de las tablas */

USE game_management;

CREATE TABLE genres (
	id INT AUTO_INCREMENT NOT NULL,
    genre_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE games (
	id INT AUTO_INCREMENT NOT NULL,
    genre_id INT NOT NULL,
    game_name VARCHAR(40) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_id_gen_ga
    FOREIGN KEY (genre_id)
    REFERENCES genres(id)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE publishers (
	id INT AUTO_INCREMENT NOT NULL,
    publisher_name VARCHAR(40) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE games_publishers (
	id INT AUTO_INCREMENT NOT NULL,
    game_id INT NOT NULL,
    publisher_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_id_ga_ga_pub
    FOREIGN KEY (game_id)
    REFERENCES games(id)
		ON UPDATE CASCADE
        ON DELETE CASCADE,
	CONSTRAINT FK_id_pub_ga_pub
    FOREIGN KEY (publisher_id)
    REFERENCES publishers(id)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE platforms (
	id INT AUTO_INCREMENT NOT NULL,
    platform_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE games_platforms (
	id INT AUTO_INCREMENT NOT NULL,
    game_publisher_id INT NOT NULL,
    platform_id INT NOT NULL,
    release_year INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_id_ga_pub_ga_plat
    FOREIGN KEY (game_publisher_id)
    REFERENCES games_publishers(id)
		ON UPDATE CASCADE
        ON DELETE CASCADE,
	CONSTRAINT FK_id_plat_ga_plat
    FOREIGN KEY (platform_id)
    REFERENCES platforms(id)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE regions (
	id INT NOT NULL,
    region_name VARCHAR(40) NOT NULL
);

CREATE TABLE regions_sales (
	region_id INT NOT NULL,
    game_platform_id INT NOT NULL,
    num_sales INT NOT NULL
);

/* añadir PK y FK a las tablas regions_sales y regions */

ALTER TABLE regions
MODIFY id INT AUTO_INCREMENT NOT NULL,
ADD CONSTRAINT PK_id_reg
PRIMARY KEY (id);

ALTER TABLE regions_sales
ADD CONSTRAINT PK_reg_id_ga_plat_id_reg_sal
PRIMARY KEY (region_id, game_platform_id),
ADD CONSTRAINT FK_id_reg_reg_sal
FOREIGN KEY (region_id) REFERENCES regions(id)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
ADD CONSTRAINT FK_id_ga_plat_reg_sal
FOREIGN KEY (game_platform_id) REFERENCES games_platforms(id)
ON UPDATE CASCADE
ON DELETE CASCADE;
