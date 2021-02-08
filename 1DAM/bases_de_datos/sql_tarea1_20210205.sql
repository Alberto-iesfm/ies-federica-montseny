/* creacion de la base de datos */

CREATE DATABASE gestio_pub;

/* ejercicio 1 */

USE gestion_pub;

CREATE TABLE IF NOT EXISTS pub (
	cod_pub INT AUTO_INCREMENT NOT NULL,
	name_pub VARCHAR(40) NOT NULL,
    tax_license VARCHAR (30) NOT NULL,
	adress VARCHAR (50),
    cod_city INT NOT NULL,
    PRIMARY KEY (cod_pub)
);

CREATE TABLE IF NOT EXISTS owner_pub (
	dni_owner VARCHAR(9) NOT NULL,
    name_owner VARCHAR(40) NOT NULL,
    adress VARCHAR(50),
    cod_pub INT NOT NULL,
    PRIMARY KEY (dni_owner)
);

CREATE TABLE IF NOT EXISTS employee (
	dni_employee VARCHAR(9) NOT NULL AUTO_INCREMENT,
    name_employee VARCHAR(40) NOT NULL,
    adress VARCHAR(50),
    PRIMARY KEY (dni_employee)
);

CREATE TABLE IF NOT EXISTS stock (
	cod_article INT NOT NULL AUTO_INCREMENT,
    name_article VARCHAR(40) NOT NULL,
    amount INT NOT NULL,
    cod_pub INT NOT NULL
);

CREATE TABLE IF NOT EXISTS city (
	cod_city INT NOT NULL AUTO_INCREMENT,
    name_city VARCHAR(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS pub_employee (
	cod_pub INT NOT NULL AUTO_INCREMENT,
    dni_employee VARCHAR(9) NOT NULL,
    function_employee VARCHAR (30) NOT NULL
);

/* ejercicio 2 */

ALTER TABLE pub
RENAME TO pubs;

ALTER TABLE employee
RENAME TO employees;

ALTER TABLE stock
RENAME TO stocks;

ALTER TABLE city
RENAME TO cities;

ALTER TABLE owner_pub
RENAME TO owners;

ALTER TABLE pub_employee
RENAME TO pub_employees;

/* ejercicio 3 */

ALTER TABLE pubs ADD (
	opening_date DATE NOT NULL,
    timetable VARCHAR(70) NOT NULL
);

ALTER TABLE stocks ADD (
	price INT NOT NULL
);

ALTER TABLE cities ADD (
	province VARCHAR(40) NOT NULL
);

ALTER TABLE employees ADD (
	ages VARCHAR(3) NOT NULL
);

/* ejercicio 4 */

ALTER TABLE stocks
ADD CONSTRAINT sto_codart_pk
PRIMARY KEY (cod_article);

ALTER TABLE cities
ADD CONSTRAINT cit_codcit_pk
PRIMARY KEY (cod_city);

ALTER TABLE pub_employees
ADD CONSTRAINT pubem_cod_dni_func_pk
PRIMARY KEY (cod_pub, dni_employee, function_employee);