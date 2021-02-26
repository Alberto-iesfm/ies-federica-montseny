/* creacion de la base de datos */

CREATE DATABASE department_management;

/* creacion de las tablas */

USE department_management;

CREATE TABLE departments (
	id INT AUTO_INCREMENT NOT NULL,
    department_name VARCHAR(40) NOT NULL,
    company_code VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)
	);
    
CREATE TABLE languages (
	id INT AUTO_INCREMENT NOT NULL,
    language_name VARCHAR(30) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE employees (
	id INT AUTO_INCREMENT NOT NULL,
    employee_name VARCHAR (40) NOT NULL,
    surname1 VARCHAR (40) NOT NULL,
    surname2 VARCHAR (40) NOT NULL,
    language_id INT NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_id_lan_emp
    FOREIGN KEY (language_id)
    REFERENCES languages(id)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE employees_departments (
	id INT NOT NULL,
    employee_id INT NOT NULL,
    department_id INT NOT NULL
);

/* creacion de PK y FK en employees_departments */

ALTER TABLE employees_departments
MODIFY id INT AUTO_INCREMENT NOT NULL,
ADD CONSTRAINT PK_id_emp_dep
PRIMARY KEY (id),
ADD CONSTRAINT FK_id_emp_emp_dep
FOREIGN KEY (employee_id)
REFERENCES employees(id)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
ADD CONSTRAINT FK_id_dep_emp_dep
FOREIGN KEY (department_id)
REFERENCES departments (id)
	ON UPDATE CASCADE
    ON DELETE CASCADE;
    
/* creacion de indices */

CREATE INDEX idx_dep ON departments(id);

CREATE INDEX idx_lan ON languages(id);

CREATE INDEX idx_emp ON employees(id, language_id);

CREATE INDEX idx_emp_dep ON employees_departments(id, employee_id, department_id);

/* creacion de restricciones */

ALTER TABLE departments
ADD CONSTRAINT uk_dep_na
UNIQUE(department_name),
ALTER company_code SET DEFAULT "COD10000";

ALTER TABLE languages
ADD CONSTRAINT uk_lan_na
UNIQUE(language_name);

ALTER TABLE employees
ADD CONSTRAINT uk_emp_na
UNIQUE(employee_name);

/* eliminacion de las restricciones */

ALTER TABLE departments
ALTER company_code DROP DEFAULT;

DROP INDEX uk_dep_na ON departments;

DROP INDEX uk_lan_na ON languages;

DROP INDEX uk_emp_na ON employees;

/* creacion de campo created_at */

ALTER TABLE departments ADD (
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE employees ADD (
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

/* creacion de registros para las tablas */

INSERT INTO departments (department_name, company_code)
VALUES
	("Administracion", "COD25741"),
    ("Mantenimiento", "COD45932");
    
INSERT INTO languages (language_name)
VALUES
	("Español"),
    ("Ingles");
    
INSERT INTO employees (employee_name, surname1, surname2, language_id)
VALUES
	("Juan", "Gil", "Mata", 1),
    ("John", "Smith", "Russel", 2);
    
INSERT INTO employees_departments (employee_id, department_id)
VALUES
	(1, 2),
    (2, 1);
    
SELECT * FROM employees;
