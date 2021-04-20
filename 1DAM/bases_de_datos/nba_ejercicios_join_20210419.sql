USE nba;

SHOW TABLES;

-- TABLA equipos

DESCRIBE EQUIPOS;

SELECT * FROM equipos;

-- TABLA estadisticas

DESCRIBE estadisticas;

SELECT * FROM estadisticas;

-- TABLA jugadores

DESCRIBE jugadores;

SELECT * FROM jugadores;

-- TABLA partidos

DESCRIBE partidos;

SELECT * FROM partidos;

-- Consultas

-- 1. Muestra el código, nombre y la ciudad del equipo en el que juegan los jugadores que juegan en todas las posiciones excepto la posición G

SELECT jug.codigo, jug.Nombre, eq.Nombre, eq.Ciudad
FROM jugadores jug
	INNER JOIN equipos eq ON jug.Nombre_equipo = eq.Nombre
WHERE jug.Posicion NOT IN ('G');

-- 2. Muestra el nombre de los jugadores y conferencia que juegan en la division Central

SELECT jug.Nombre, eq.Conferencia
FROM jugadores jug
	INNER JOIN equipos eq ON jug.Nombre_equipo = eq.Nombre
WHERE eq.Division = 'Central';

-- 3. Muestra el código de los jugadores que juegan en la conferencia West

SELECT jug.codigo, jug.Nombre
FROM jugadores jug
	INNER JOIN equipos eq ON jug.Nombre_equipo = eq.Nombre
WHERE Conferencia = 'West';

-- 4. Muestra el nombre y procedencia de los jugadores cuya suma de asistencias, tapones y rebotes sume mas de 5 y menos de 20

SELECT jug.Nombre, jug.Procedencia
FROM jugadores jug
	INNER JOIN estadisticas est ON jug.codigo = est.jugador
WHERE (Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido) BETWEEN 5.01 AND 19.99;

-- 5. Muestra el código y nombre de los jugadores, así como la temporada y puntos por partido y conferencia, de los Bulls, Lakers y Grizzlies

SELECT jug.codigo, jug.Nombre, est.temporada, est.Puntos_por_partido, eq.Conferencia
FROM jugadores jug
	INNER JOIN estadisticas est ON jug.codigo = est.jugador
	INNER JOIN equipos eq ON jug.Nombre_equipo = eq.Nombre
WHERE eq.Nombre IN ('Bulls', 'Lakers', 'Grizzlies');
