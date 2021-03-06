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

CREATE TABLE tasks (
	id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    start_date DATE,
    end_date DATE
);

DESCRIBE tasks;

SHOW CREATE TABLE tasks;

SHOW TABLES;

SHOW INDEXES FROM tasks;

ALTER TABLE tasks
ADD CONSTRAINT tas_tit_uk
UNIQUE (title);

USE test;

DROP TABLE IF EXISTS employees;

CREATE TABLE IF NOT EXISTS employees (
	id INT AUTO_INCREMENT,
    name_employee VARCHAR(30),
    ages INT,
    PRIMARY KEY (id)
);

SHOW CREATE TABLE employees;

SHOW INDEXES FROM employees;

DROP INDEX id ON employees;

CREATE INDEX IDX_id ON employees (id);

ALTER TABLE employees
MODIFY id INT;

ALTER TABLE employees
MODIFY id INT AUTO_INCREMENT;

ALTER TABLE employees
ALTER ages SET DEFAULT 0;

/* foreign key*/

DROP TABLE IF EXISTS employees;

CREATE TABLE IF NOT EXISTS employees (
	id_employee INT not null auto_increment PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	edad int
);

DROP TABLE tasks;CREATE TABLE tasks (
	id int NOT NULL PRIMARY KEY,
	title varchar(255) NOT NULL,
	start_date date DEFAULT NULL,
	end_date date DEFAULT NULL,
	price int DEFAULT NULL,
	id_employee int DEFAULT NULL,
	/*CONSTRAINT FK_employees_tasks*/
	FOREIGN KEY (id_employee)
	REFERENCES employees(id_employee)
);

SHOW CREATE TABLE employees;

SHOW CREATE TABLE tasks;

ALTER TABLE tasks
ADD CONSTRAINT FK_employees_tasks
FOREIGN KEY (id_employee)
REFERENCES employees(id_employee);

ALTER TABLE tasks
DROP FOREIGN KEY FK_employees_tasks;

ALTER TABLE tasks
ADD foreign key (id_employee) 
REFERENCES employees(id_employee);

ALTER TABLE tasks
DROP FOREIGN KEY tasks_ibfk_1;
