/* creacion de la base de datos */

CREATE DATABASE IF NOT EXISTS nba_management;

/* ejercicio 1. Crea las sentencias SQL que nos permiten crear las tablas anteriores y sus restricciones, teniendo en cuenta las siguientes restricciones */

USE nba_management;

CREATE TABLE IF NOT EXISTS temporadas (
	nombre VARCHAR(5) NOT NULL,
    CONSTRAINT PK_tem
    PRIMARY KEY (nombre)
);

CREATE TABLE IF NOT EXISTS equipos (
	nombre VARCHAR(20) NOT NULL,
    ciudad VARCHAR(20) NOT NULL,
    conferencia VARCHAR(4) NOT NULL,
    division VARCHAR(9) NOT NULL,
    CONSTRAINT PK_eq
    PRIMARY KEY (nombre)
);

CREATE TABLE IF NOT EXISTS jugadores (
	codigo INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    apellido_1 VARCHAR(30) NOT NULL,
    apellido_2 VARCHAR(30) NOT NULL,
    procedencia VARCHAR(20) NOT NULL,
    altura VARCHAR(4) NOT NULL,
    peso INT NOT NULL,
    posicion VARCHAR(5) NOT NULL,
    nombre_equipo VARCHAR(20) NOT NULL,
    CONSTRAINT PK_jug
    PRIMARY KEY (codigo),
    CONSTRAINT FK_nom_eq_nom_eq
    FOREIGN KEY (nombre_equipo) REFERENCES equipos(nombre)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS estadisticas (
	temporada VARCHAR(5) NOT NULL,
    jugador INT NOT NULL,
    puntos_por_partido FLOAT NOT NULL,
    asistencias_por_partido FLOAT NOT NULL,
    tapones_por_partido FLOAT NOT NULL,
    rebotes_por_partido FLOAT NOT NULL,
    CONSTRAINT PK_est
    PRIMARY KEY (temporada, jugador),
    CONSTRAINT FK_tem_tem_nom
    FOREIGN KEY (temporada) REFERENCES temporadas(nombre)
		ON UPDATE CASCADE
        ON DELETE CASCADE,
	CONSTRAINT FK_jug_jug_cod
    FOREIGN KEY (jugador) REFERENCES jugadores(codigo)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS partidos (
	codigo INT AUTO_INCREMENT NOT NULL,
    equipo_local VARCHAR(20) NOT NULL,
    equipo_visitante VARCHAR(20) NOT NULL,
    puntos_local INT NOT NULL,
    puntos_visitante INT NOT NULL,
    temporada VARCHAR(5) NOT NULL,
    CONSTRAINT PK_part
    PRIMARY KEY (codigo),
    CONSTRAINT FK_eq_lo_eq_nom
    FOREIGN KEY (equipo_local) REFERENCES equipos(nombre)
		ON UPDATE CASCADE
        ON DELETE CASCADE,
	CONSTRAINT FK_eq_vis_eq_nom
    FOREIGN KEY (equipo_visitante) REFERENCES equipos(nombre)
		ON UPDATE CASCADE
        ON DELETE CASCADE,
	CONSTRAINT FK_tem_temp_nom
    FOREIGN KEY (temporada) REFERENCES temporadas(nombre)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

/* ejercicio 2. Crea un índice para cada tabla que incluya sus campos clave y ajenos, en caso de que una tabla no tenga claves ajenas, el índice estará compuesto solo por la clave primaria */

CREATE INDEX idx_tem_nom ON temporadas(nombre);

CREATE INDEX idx_eq_nom ON equipos(nombre);

CREATE INDEX idx_jug_cod_nom_eq ON jugadores(codigo, nombre_equipo);

CREATE INDEX idx_est_tem_jug ON estadisticas(temporada, jugador);

CREATE INDEX idx_par_cod_eq_lo_eq_vis_tem ON partidos(codigo, equipo_local, equipo_visitante, temporada);

/* ejercicio 3 a. Crea las siguientes restricciones: UNIQUE para el campo ‘nombre’ de la tabla jugador */

ALTER TABLE jugadores
ADD CONSTRAINT uk_nom_jug UNIQUE (nombre);

/* ejercicio 3 b. Crea las siguientes restricciones: b.	DEFAULT para el campo puntos_por_partido = 0, puntos_visitante = 0 */

ALTER TABLE estadisticas
ALTER puntos_por_partido SET DEFAULT 0;

ALTER TABLE partidos
ALTER puntos_visitante SET DEFAULT 0;

/* ejercicio 4. Elimina las restricciones creadas en el ejercicio anterior */

ALTER TABLE estadisticas
ALTER puntos_por_partido DROP DEFAULT;

ALTER TABLE partidos
ALTER puntos_visitante DROP DEFAULT;

/* ejercicio 5. Crea un campo ‘creation_time’ para las tablas partido y estadística de tipo datetime y que por defecto guarden la fecha y hora actuales */

ALTER TABLE estadisticas
ADD COLUMN creation_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE partidos
ADD COLUMN creation_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP;

/* ejercicio 6. Añade 2 registros para cada tabla, en las tablas jugador y equipo tienes que realizarlo mediante un solo insert, en el resto con dos inserts */

INSERT INTO temporadas (nombre)
VALUES 
	(2020),
    (2019);
    
INSERT INTO equipos (nombre, ciudad, conferencia, division)
VALUES
	("equipo_a", "ciudad_a", "a", "primera");
    
INSERT INTO equipos (nombre, ciudad, conferencia, division)
VALUES
	("equipo_b", "ciudad_b", "b", "primera");

INSERT INTO jugadores (nombre, apellido_1, apellido_2, procedencia, altura, peso, posicion, nombre_equipo)
VALUES
	("nombre_1", "apelido11", "apellido12", "procedencia1", "180", 70, "A", "equipo_a");
    
INSERT INTO jugadores (nombre, apellido_1, apellido_2, procedencia, altura, peso, posicion, nombre_equipo)
VALUES
    ("nombre_2", "apelido21", "apellido22", "procedencia2", "190", 85, "C", "equipo_b");
    
INSERT INTO estadisticas (temporada, jugador, puntos_por_partido, asistencias_por_partido, tapones_por_partido, rebotes_por_partido)
VALUES
	(2020, 1, 50, 6, 12, 6),
    (2019, 2, 80, 9, 11, 9);

INSERT INTO partidos (equipo_local, equipo_visitante, puntos_local, puntos_visitante, temporada)
VALUES
	("equipo_a", "equipo_b", 99, 87, "2020"),
    ("equipo_b", "equipo_a", 103, 95, "2019");

/* ejercicio 7 a. Indica los comandos para realizar los siguientes ejercicios: Muestra el listado de tablas de la bases de datos */

SHOW TABLES;

/* ejercicio 8 b. Muestra la descripción/información de la tabla jugador, de las dos formas vistas en clase */

SHOW CREATE TABLE jugadores;

SELECT * FROM jugadores;
