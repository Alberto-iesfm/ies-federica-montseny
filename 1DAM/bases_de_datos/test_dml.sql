CREATE DATABASE test_dml;

USE test_dml;

CREATE TABLE clientes (
id INT AUTO_INCREMENT PRIMARY KEY,
dni VARCHAR(9) NOT NULL,
nombre VARCHAR(30) NOT NULL,
ape1 VARCHAR(30) NOT NULL,
ape2 VARCHAR(30),
localidad VARCHAR(30) NOT NULL,
direccion VARCHAR(30) NOT NULL,
comision FLOAT NOT NULL
);

INSERT INTO clientes (dni, nombre, ape1, ape2, localidad, direccion, comision)
VALUES ('11111111H', 'Pedro', 'Gutierrrez', NULL, '', '', 0),
('11111122H', 'Juan', 'Gutierrrez', NULL, '', '', 0),
('11111133H', 'Jose', 'Gutierrrez', NULL, '', '', 0);

SELECT * FROM clientes
WHERE id = 1;

DESCRIBE clientes;

SHOW CREATE TABLE clientes;

UPDATE clientes
SET ape1 = "Lopez", comision = 2
WHERE id = 1;

SELECT * FROM clientes
WHERE comision = 0;

UPDATE clientes
SET comision = 5
WHERE comision = 0;

SELECT * FROM clientes
WHERE id = 2;

UPDATE clientes
SET comision = comision * 1.03
WHERE id = 2;

ALTER TABLE clientes
ADD created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP;

UPDATE clientes
SET created_at = "2021-03-15 14:30"
WHERE id = 2;
