/* creacion de la base de datos */

CREATE DATABASE gestio_pub;

/* ejercicio 1 */

USE gestion_pub;

CREATE TABLE pub (
	cod_pub INT AUTO_INCREMENT,
	name_pub VARCHAR(40),
    tax_license VARCHAR (30),
	adress VARCHAR (50),
    cod_city INT,
    PRIMARY KEY (cod_pub)
);

CREATE TABLE owner_pub (
	dni 