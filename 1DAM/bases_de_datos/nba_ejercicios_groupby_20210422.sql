USE nba;

-- 1. Mostrar el número de jugadores de cada equipo.

SELECT Nombre_equipo, COUNT(*) AS 'numero jugadores'
FROM jugadores
GROUP BY Nombre_equipo;

-- 2. Mostrar el nombre, codigo, numero de puntos totales y la media de cada jugador en toda su carrera.

SELECT est.jugador, jug.Nombre, SUM(est.Puntos_por_partido) AS 'puntos totales', AVG(est.Puntos_por_partido) AS 'media carrera'
FROM estadisticas est
	INNER JOIN jugadores jug ON est.jugador = jug.codigo
GROUP BY jug.codigo;

-- 3. Mostrar el nombre, codigo, la suma de las asistencias, tapones y rebotes de cada jugador en toda su carrera, 
-- de los jugadores cuya suma sea mayor de 5, ordenado por el nombre de forma descendente.

SELECT est.jugador, jug.Nombre, SUM(est.Asistencias_por_partido + est.Tapones_por_partido + est.Rebotes_por_partido) AS 'suma_estadisticas'
FROM estadisticas est
	INNER JOIN jugadores jug ON est.jugador = jug.codigo
GROUP BY jug.codigo
HAVING suma_estadisticas > 5
ORDER BY jug.Nombre DESC;

-- 4. Mostrar la suma y la media de los puntos por partido de todos los jugadores por equipo, de las temporadas
-- 01/02 hasta 06/07

SELECT jug.Nombre_equipo, SUM(est.Puntos_por_partido) AS 'suma puntos', AVG(est.Puntos_por_partido) AS 'media puntos'
FROM estadisticas est
	INNER JOIN jugadores jug ON est.jugador = jug.codigo
WHERE est.temporada BETWEEN '01/02' AND '06/07'
GROUP BY jug.Nombre_equipo;

-- 5. Mostrar el número de equipos de la conferencia East

SELECT Conferencia, COUNT(*) AS 'numero equipos'
FROM equipos
WHERE Conferencia = "East";

-- 6. Mostrar el número de equipos por division

SELECT Division, COUNT(*) AS 'numero equipos'
FROM equipos
GROUP BY Division;

-- 7. Media de rebotes de los jugadores de la conferencia West

SELECT jug.Nombre, AVG(est.Rebotes_por_partido) AS 'media rebotes'
FROM estadisticas est
	INNER JOIN jugadores jug ON est.jugador = jug.codigo
    INNER JOIN equipos eq ON jug.Nombre_equipo = eq.Nombre
WHERE eq.Conferencia = "West"
GROUP BY jug.codigo;

-- 8. Número de jugadores de las posiciones ‘C’, G y F que tiene cada equipo de la conferencia East

SELECT eq.Nombre, COUNT(jug.codigo) AS 'numero jugadores'
FROM equipos eq
	INNER JOIN jugadores jug ON jug.Nombre_equipo = eq.Nombre
WHERE jug.Posicion IN ('C', 'G', 'F') AND eq.Conferencia = 'East'
GROUP BY eq.Nombre;

-- 9. Número de jugadores que pesan más de 200 de cada division

SELECT eq.Division, COUNT(jug.codigo) AS 'numero jugadores'
FROM equipos eq
	INNER JOIN jugadores jug ON jug.Nombre_equipo = eq.Nombre
WHERE jug.Peso > 200
GROUP BY eq.Division;

-- 10. Peso medio de los jugadores de la division NorthWest y SouthEast

SELECT eq.Division, AVG(jug.peso) AS 'peso medio'
FROM equipos eq
	INNER JOIN jugadores jug ON jug.Nombre_equipo = eq.Nombre
WHERE eq.Division IN ('NorthWest', 'SouthEast')
GROUP BY eq.Division;
