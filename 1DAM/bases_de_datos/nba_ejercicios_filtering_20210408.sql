USE nba;

SHOW TABLES;

DESCRIBE EQUIPOS;

DESCRIBE estadisticas;

DESCRIBE jugadores;

DESCRIBE partidos;

-- Consultas con los operadores AND, OR, NOT, NULL, IN, BETWEEN, LIKE

-- TABLA equipos

SELECT * FROM equipos;

-- 1. Muestra los nombres de los equipos y sus ciudades que empiecen por 'H' ordenados por la ciudad de forma ascendente.

SELECT Nombre, Ciudad
FROM equipos
WHERE Nombre LIKE 'H%'
ORDER BY Ciudad;

-- 2. Muestra las ciudades que contengan una 'o' ordenados por la ciudad de forma descendente.

SELECT Ciudad
FROM equipos
WHERE Ciudad LIKE '%o%'
ORDER BY Ciudad DESC;

-- 3. Muestra los nombres de los equipos, ciudades y divisiones de la conferencia 'East' entre los Clippers y los Hornets ordenados por el campo division de forma descendente.

SELECT Nombre, Ciudad, Division
FROM equipos
WHERE Conferencia = 'East' AND Nombre BETWEEN 'Clippers' AND 'Hornets'
ORDER BY Division DESC;

-- TABLA estadisticas

SELECT * FROM estadisticas;

-- 1. Muestra los jugadores de la temporada 02/03 que hayan anotado entre 10 y 20 puntos de forma ordenada descendente por los campo puntos_por_partido.

SELECT jugador
FROM estadisticas
WHERE temporada = '02/03' AND Puntos_por_partido BETWEEN 10 AND 20
ORDER BY Puntos_por_partido DESC;

-- 2. Muestra los jugadores de las temporadas 00/01 hasta la 05/06 que hayan anotado menos de 10 o más de 20 puntos de forma ordenada descendente por el campo jugador.

SELECT jugador
FROM estadisticas
WHERE temporada BETWEEN '00/01' AND '05/06' AND Puntos_por_partido NOT BETWEEN 10 AND 20
ORDER BY jugador DESC;

-- 3. Muestra los 5 jugadores que mas asistencias han realizado de las temporada 03/04 hasta 05/06 sin tener en cuenta a los jugadores número 33, 43 y 50.

SELECT jugador
FROM estadisticas
WHERE temporada BETWEEN '03/04' AND '05/06' AND jugador NOT IN (33, 43, 50)
ORDER BY Asistencias_por_partido DESC
LIMIT 5;

-- 4. Muestra los puntos de los jugadores del rango 5 al 40 de las temporadas 01/02, 02/03 y 04/05, de forma ordenada ascendente por el campo puntos_por_partido.

SELECT Puntos_por_partido
FROM estadisticas
WHERE temporada IN ('01/02', '02/03', '04/05')
ORDER BY Puntos_por_partido
LIMIT 4, 36;

-- 5. Muestra los jugadores y suma de las asistencias, tapones y rebotes por partido de los jugadores que han anotado entre 0 y 10 puntos por partido. 

SELECT jugador, Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido AS 'Suma estadisticas'
FROM estadisticas
WHERE Puntos_por_partido BETWEEN 0 AND 10;

-- 6. Muestra los jugadores, puntos y suma de las asistencias, tapones y rebotes por partido de los jugadores cuya suma de los 3 campos sea mayor de 12.

SELECT jugador, Puntos_por_partido, Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido AS 'Suma estadisticas'
FROM estadisticas
WHERE Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido > 12;

-- TABLA jugadores

SELECT * FROM jugadores;

-- 1. Muestra los nombres y procedencia de los jugadores cuyo nombre incluya 'Aaron'.

SELECT Nombre, Procedencia
FROM jugadores
WHERE Nombre LIKE '%Aaron%';

-- 2. Muestra el codigo y nombre de los jugadores que pesen entre 100 y 150 de todas las posiciones excepto de la G y de la G-F.

SELECT codigo, Nombre
FROM jugadores
WHERE Peso BETWEEN 100 AND 150 AND Posicion NOT IN ('G', 'G-F');

-- 3. Muestra el nombre, posicion y equipo de los jugadores cuya procedencia NO sea nula y cuyo equipo no contenga una 'v' en la tercera posición.

SELECT Nombre, Posicion, Nombre_equipo
FROM jugadores
WHERE Procedencia IS NOT NULL AND Nombre_equipo NOT LIKE '__v%';

-- 4. Muestra el nombre, posicion y equipo de los jugadores cuya procedencia no sea nula y empiece y acabe por 'a'.

SELECT Nombre, Posicion, Nombre_equipo
FROM jugadores
WHERE Procedencia IS NOT NULL AND Procedencia LIKE 'a%a';

-- 5. Muestra el nombre, posicion y equipo de los jugadores cuyo nombre de equipo no contenga una 'i' en la segunda posición

SELECT Nombre, Posicion, Nombre_equipo
FROM jugadores
WHERE Nombre_equipo NOT LIKE '_i%';
