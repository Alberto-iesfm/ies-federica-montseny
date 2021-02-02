CREATE DATABASE IF NOT EXISTS test;

USE test;

CREATE TABLE IF NOT EXISTS pets (
	name VARCHAR(20),
    owner VARCHAR(20),
    species VARCHAR(20),
    sex CHAR(1),
    birth DATE,
    death DATE
    );
    
DESCRIBE pets;
    
CREATE TABLE IF NOT EXISTS empleoyees (
	id INT,
    name VARCHAR(30),
    ages INT
);

SHOW TABLES;

DESCRIBE empleoyees;

ALTER TABLE empleoyees
RENAME TO employees;

/*TRUNCATE TABLE employees;*/

ALTER TABLE employees ADD (
	office INT
);

DESCRIBE employees;

ALTER TABLE employees ADD (
	boss VARCHAR(20),
    department BIT
);

/*ALTER TABLE employees DROP COLUMN boss;*/

ALTER TABLE employees ADD (
	boss VARCHAR(2)
);

ALTER TABLE employees MODIFY boss VARCHAR(20);
