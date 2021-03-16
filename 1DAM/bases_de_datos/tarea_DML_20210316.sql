CREATE DATABASE empleados;

USE empleados;

CREATE TABLE oficios (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NOT NULL
    );
    
CREATE TABLE departamentos (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE empleados (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	oficio VARCHAR(50) NULL,
	direccion VARCHAR(100) NOT NULL,
	fecha_alta DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	salario	FLOAT NOT NULL CHECK (18000 <= salario >= 50000),
	comsion FLOAT NOT NULL DEFAULT 5,
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

INSERT INTO oficios (nombre)
VALUES 	("Programador"),
		("Comercial"),
        ("Director"),
        ("Practicas");

INSERT INTO departamentos (nombre)
VALUES 	("Ventas"),
		("Marketing"),
        ("Informatica");
        
