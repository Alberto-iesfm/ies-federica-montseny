USE nba;

SHOW TABLES;

DESCRIBE EQUIPOS;

DESCRIBE estadisticas;

DESCRIBE jugadores;

DESCRIBE partidos;

-- TABLA equipos

SELECT * FROM equipos;

-- 1. Muestra los nombres de los equipos y sus ciudades ordenados por la ciudad de forma ascendente

SELECT Nombre, Ciudad FROM equipos
ORDER BY Ciudad;

-- 2. Muestra los nombres de los equipos y sus ciudades ordenados por la ciudad de forma descendente

SELECT Nombre, Ciudad FROM equipos
ORDER BY Ciudad DESC;

-- 3. Muestra los primeros 5 nombres de los equipos, ciudades y divisiones de la conferencia 'East' ordenados por el campo division de forma descendente

SELECT Nombre, Ciudad, Division FROM equipos
WHERE Conferencia = 'East'
ORDER BY Division DESC
LIMIT 5;

-- TABLA estadisticas

SELECT * FROM estadisticas;

-- 1. Muestra los primeros 10 jugadores de la temporada 00/01 que hayan anotado más de 10 puntos de forma ordenada ascendente por el campo puntos_por_partido

SELECT jugador FROM estadisticas
WHERE temporada = '00/01' AND Puntos_por_partido > 10
ORDER BY Puntos_por_partido
LIMIT 10;

-- 2. Muestra los primeros 10 jugadores de la temporada 00/01 que hayan anotado más de 10 puntos de forma ordenada descendente por el campo puntos_por_partido

SELECT jugador FROM estadisticas
WHERE temporada = '00/01' AND Puntos_por_partido > 10
ORDER BY Puntos_por_partido DESC
LIMIT 10;

-- 3. Muestra los 5 jugadores que menos puntos han anotado de la temporada 03/04 ordenado de forma descendente por los campos temporada y jugador

SELECT jugador FROM estadisticas
WHERE temporada = '03/04'
ORDER BY Puntos_por_partido, temporada DESC, jugador DESC
LIMIT 5;

-- 4. Muestra las asistencias y rebotes por partido de los jugadores con más de 6 puntos por partido de las temporadas 01/02 y 02/03, de forma ordenada ascendente por el campo temporada

SELECT Asistencias_por_partido, Rebotes_por_partido FROM estadisticas
WHERE Puntos_por_partido > 6 AND (temporada = '01/02' OR temporada = '02/03')
ORDER BY temporada;

-- 5. Muestra la temporada, jugador y suma de las asistencias, tapones y rebotes por partido de los jugadores con más de 15 puntos por partido, de forma ordenada descendente por el campo temporada y ascendente por el campo jugador

SELECT temporada, jugador, Asistencias_por_partido + Tapones_por_partido + Rebotes_por_partido FROM estadisticas
WHERE Puntos_por_partido > 15
ORDER BY temporada DESC, jugador;

-- TABLA jugadores

SELECT * FROM jugadores;

-- 1. Muestra la altura y nombre de los 5 jugadores con más peso de los Timberwolves y de los Clippers.

SELECT Altura, Nombre FROM jugadores
WHERE Nombre_equipo = 'Timberwolves' OR Nombre_equipo = 'Clippers'
ORDER BY Peso DESC
LIMIT 5;

-- 2. Muestra el nombre y procedencia de los jugadores de los Bulls de todas las posiciones excepto de la G.

SELECT Nombre, Procedencia FROM jugadores
WHERE Nombre_equipo = 'Bulls' AND Posicion != 'G';

-- 3. Muestra el nombre, posicion y equipo de los jugadores de procedencia 'Argentina' y 'France' ordenado por los campos procedencia ascendentemente y posicion descendentemente

SELECT Nombre, Posicion, Nombre_equipo FROM jugadores
WHERE Procedencia = 'Argentina' OR Nombre_equipo = 'France'
ORDER BY Procedencia, Posicion DESC;

-- TABLA partidos

SELECT * FROM partidos;

-- 1. Muestra la anotación de los 5 primeros partidos de los Bulls como equipo visitante en la temporada 05/06 de forma descendente

SELECT puntos_visitante FROM partidos
WHERE equipo_visitante = 'Bulls' AND temporada = '05/06'
ORDER BY puntos_visitante DESC
LIMIT 5;

-- 2. Muestra toda la información de los Rockets como locales de las temporada 04/05 y 05/06, donde los Rockets anotaron menos de 100 puntos, ordenada por el 
--    equipo visitante y por los puntos del equipo visitante de forma descendente

SELECT * FROM partidos
WHERE equipo_local = 'Rockets' AND (temporada = '04/05' OR temporada = '05/06') AND puntos_local < 100
ORDER BY equipo_visitante DESC, puntos_visitante DESC;