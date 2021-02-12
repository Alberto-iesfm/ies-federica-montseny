/* creacion de la base de datos */

CREATE DATABASE game_management;

/* creacion de las tablas */

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
    publisher_name VARCHAR(40),
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