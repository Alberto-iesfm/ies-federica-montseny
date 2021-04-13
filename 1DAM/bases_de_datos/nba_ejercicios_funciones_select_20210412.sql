USE nba;

SHOW TABLES;

DESCRIBE EQUIPOS;

DESCRIBE estadisticas;

DESCRIBE jugadores;

DESCRIBE partidos;

-- TABLA equipos

SELECT * FROM equipos;

-- 1. Muestra las distintas ciudades.

SELECT DISTINCT Ciudad
FROM equipos;

-- 2. Muestra las divisiones sin repetir que acaben por 'West'.

SELECT DISTINCT Division
FROM equipos
WHERE Division LIKE '%West';

-- 3. Muestra las divisiones y conferencias sin repetidos, de las conferencias que contegan una e.

SELECT DISTINCT Division, Conferencia
FROM equipos
WHERE Conferencia LIKE '%e%';

-- 4. Muestra el número de las distintas ciudades de la conferencia 'East' que contienen una 'l'.

SELECT COUNT(DISTINCT Ciudad) AS 'Numero de ciudades'
FROM equipos
WHERE Conferencia = 'East' AND Ciudad LIKE '%l%';


-- TABLA estadisticas

SELECT * FROM estadisticas ORDER BY jugador, temporada;

-- 1. Muestra los puntos del jugador que más puntos ha anotado.

SELECT MAX(Puntos_por_partido) AS 'maximo puntos por partido'
FROM estadisticas;

-- 2. Muestra los puntos del jugador que menos puntos ha anotado.

SELECT MIN(Puntos_por_partido) AS 'minimo puntos por partido'
FROM estadisticas;

-- 3. Muestra el número de jugadores que han anotado más de 20 puntos por partido ordenado descendentemente.

SELECT COUNT(DISTINCT jugador) AS 'jugadores con mas de 20 puntos'
FROM estadisticas
WHERE Puntos_por_partido > 20
ORDER BY Puntos_por_partido DESC;

-- 4. Muestra el número de jugadores de los que la suma de las asistencias y rebotes sea más de 20 y menos de 60. 

SELECT COUNT(DISTINCT jugador) AS 'jugadores con suma de estadisticas entre 20 y 60'
FROM estadisticas
WHERE Asistencias_por_partido + Rebotes_por_partido BETWEEN 20.01 AND 59.99;

-- 5. Muestra la media de puntos del jugador 2 de las temporadas 03/04 hasta la 06/07.

SELECT AVG(Puntos_por_partido) AS 'media puntos jugador 2'
FROM estadisticas
WHERE jugador = 2 AND temporada BETWEEN '03/04' AND '06/07';

-- 6. Muestra la media de la suma de asistencias y tapones de los jugadores número 30 al 100 
-- de las temporadas 02/03 hasta la 05/06.

SELECT AVG(Asistencias_por_partido + Tapones_por_partido) AS 'media de asistencias y tapones'
FROM estadisticas
WHERE jugador BETWEEN 30 AND 100 AND temporada BETWEEN '02/03' AND '05/06';

-- TABLA jugadores

SELECT * FROM jugadores;

-- 1. Muestra las distintas procedencias de los jugadores de los equipos Timberwolves, Clippers, Grizzlies, Knicks,
-- Bobcats y Cavaliers de todas las posiciones excepto de la F y de la G.

SELECT DISTINCT Procedencia
FROM jugadores
WHERE Nombre_equipo IN ('Timberwolves',
						'Clippers',
                        'Grizzlies',
                        'Knicks',
                        'Bobcats',
                        'Cavaliers')
					AND Posicion NOT IN ('F', 'G'); 

-- 2. Muestra el peso máximo de los jugadores de todos los equipos excepto de los Bobcats y Cavaliers
-- y de las posiciones F, G, C-F Y F-C.

SELECT MAX(Peso), Nombre_equipo
FROM jugadores
WHERE Nombre_equipo NOT IN ('Bobcats', 'Cavaliers')
					AND Posicion IN ('F', 'G', 'C-F', 'F-C')
GROUP BY Nombre_equipo;

-- TABLA partidos

SELECT * FROM partidos;

-- 1. Muestra la suma de los puntos que han obtenido los Lakers como visitante en las temporadas 98/99, 05/06 y 07/08.

SELECT SUM(puntos_visitante) AS 'puntos lakers como visitante'
FROM partidos
WHERE equipo_visitante = 'Lakers' AND temporada IN ('98/99', '05/06', '07/08');

-- 2. Muestra la media de los puntos que han obtenido los Bulls como local en los partidos que han anotado más puntos 
-- que el equipo visitante.

SELECT AVG(puntos_local) AS 'puntos lakers local ganador'
FROM partidos
WHERE equipo_local = 'Bulls' AND puntos_local > puntos_visitante;

-- 3. Muestra la media de la suma de los puntos obtenidos por los equipos visitantes 
-- en todos los partidos de las temporadas 98/99 hasta 05/06.

SELECT AVG(puntos_visitante) AS 'media puntos visitante'
FROM partidos
WHERE temporada BETWEEN '98/99' AND '05/06';
