/* Creacion de la base de datos */

CREATE DATABASE IF NOT EXISTS empleados;

USE empleados;

/* Creacion de las tablas */

CREATE TABLE IF NOT EXISTS oficios (
    nombre VARCHAR(50) NOT NULL PRIMARY KEY
    );
    
CREATE TABLE IF NOT EXISTS departamentos (
    nombre VARCHAR(50) NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS empleados (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	oficio VARCHAR(50) NULL,
	direccion VARCHAR(100) NOT NULL,
	fecha_alta DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	salario	FLOAT NOT NULL CHECK (18000 <= salario <= 50000),
	comision FLOAT NOT NULL DEFAULT 5,
	departamento VARCHAR(50) NOT NULL,
    CONSTRAINT FK_of_emp
    FOREIGN KEY (oficio)
    REFERENCES oficios(nombre)
		ON UPDATE CASCADE
        ON DELETE CASCADE,
	CONSTRAINT FK_dep_emp
    FOREIGN KEY (departamento)
    REFERENCES departamentos (nombre)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

/* Insercion de los datos en las tablas */

INSERT INTO oficios (nombre)
VALUES 	("Programador"),
		("Comercial"),
        ("Director"),
        ("Practicas");

INSERT INTO departamentos (nombre)
VALUES 	("Ventas"),
		("Marketing"),
        ("Informatica");
        
INSERT INTO empleados (nombre, apellido, oficio, direccion, fecha_alta, salario, departamento)
VALUES	("Juan", "Perez", "Comercial", "Av. de las naciones, 23", "2020-07-25", 25000, "Ventas"),
		("Sandra", "Ruiz", "Practicas", "Plaza de la reconquista, 1", "2021-01-01", 18000, "Marketing"),
        ("Ruben", "Alamo", "Programador", "Calle rio Duero, 23", "2005-09-03", 36000, "Informatica"),
        ("Julian", "Garcia", "Practicas", "Av. Europa, 35", "2021-03-01", 18000, "Informatica"),
        ("Alberto", "Hernan", "Director", "Calle de la mina, 51", "2003-05-15", 45000,"Informatica");
        
INSERT INTO empleados (nombre, apellido, oficio, direccion, fecha_alta, salario, comision, departamento)
VALUES	("Julian", "Romeral", "Comercial", "Calle laguna, 13", "2015-04-02", 30000, 15, "Marketing"),
		("Luis", "Alonso", "Director", "Plaza de la villa, 3", "2001-03-21", 30000, 15, "Ventas");

/* Actualizacion de apellidos */

SELECT * FROM empleados
WHERE nombre = "Julian" AND apellido = "Romeral";

UPDATE empleados
SET apellido = "Alonso"
WHERE nombre = "Julian" AND apellido = "Romeral";

SELECT * FROM empleados
WHERE nombre = "Luis" AND apellido = "Alonso";

UPDATE empleados
SET apellido = "Romeral"
WHERE nombre = "Luis" AND apellido = "Alonso";

/* Actulizacion de oficios */

SELECT * FROM empleados
WHERE nombre = "Luis" AND apellido = "Romeral";

UPDATE empleados
SET oficio = "Programador", departamento = "Informatica"
WHERE nombre = "Luis" AND apellido = "Romeral";

SELECT * FROM empleados
WHERE nombre = "Julian" AND apellido = "Alonso";

UPDATE empleados
SET oficio = "Practicas", departamento = "Ventas"
WHERE nombre = "Julian" AND apellido = "Alonso";

SELECT * FROM empleados
WHERE nombre = "Julian" AND apellido = "Garcia";

UPDATE empleados
SET oficio = "Comercial", departamento = "Marketing"
WHERE nombre = "Julian" AND apellido = "Garcia";

SELECT * FROM empleados
WHERE nombre = "Sandra" AND apellido = "Ruiz";

UPDATE empleados
SET oficio = "Director", departamento = "Ventas"
WHERE nombre = "Sandra" AND apellido = "Ruiz";

/* "ejercicio 10" */