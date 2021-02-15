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

/* creacion de indices */

CREATE INDEX idx_gen ON genres(id);

CREATE INDEX idx_pub ON publishers(id);

CREATE INDEX idx_ga ON games(id, genre_id);

CREATE INDEX idx_ga_pub ON games_publishers(id, game_id, publisher_id);

CREATE INDEX idx_plat ON platforms(id);

CREATE INDEX idx_ga_plat ON games_platforms(id, game_publisher_id, platform_id);

CREATE INDEX idx_reg ON regions(id);

CREATE INDEX idx_reg_sal ON regions_sales(region_id, game_platform_id);

/* creacion de restricciones */

ALTER TABLE regions
ADD CONSTRAINT uk_reg_na
UNIQUE(region_name);

ALTER TABLE publishers
ADD CONSTRAINT uk_pub_na
UNIQUE(publisher_name);

ALTER TABLE regions_sales
ALTER num_sales SET DEFAULT 0;

ALTER TABLE games_platforms
ALTER release_year SET DEFAULT 1989;

ALTER TABLE regions_sales
ADD CONSTRAINT chk_num_reg_sal CHECK (num_sales>=0);

ALTER TABLE games_platforms
ADD CONSTRAINT chk_year_ga_plat CHECK (release_year>=1989);

/* eliminar constraints */

DROP INDEX uk_reg_na ON regions;

DROP INDEX uk_pub_na ON publishers;

ALTER TABLE regions_sales
ALTER num_sales DROP DEFAULT;

ALTER TABLE games_platforms
ALTER release_year DROP DEFAULT;

ALTER TABLE regions_sales
DROP CHECK chk_num_reg_sal;

ALTER TABLE games_platforms
DROP CHECK chk_year_ga_plat;
