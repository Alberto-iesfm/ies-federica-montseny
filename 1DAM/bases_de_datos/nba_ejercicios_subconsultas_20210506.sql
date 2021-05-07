USE nba;

-- Realiza los siguientes ejercicios mediante subconsultas

-- 1. Puntos por partido de ’Pau Gasol’ en toda su carrera.

SELECT SUM(Puntos_por_partido) AS "Total puntos por partido"
FROM estadisticas
WHERE jugador = (SELECT codigo
	FROM jugadores
    WHERE nombre = 'Pau Gasol')
GROUP BY jugador;

-- 2. Puntos por partido de los jugadores de los ’cavaliers’.

SELECT SUM(Puntos_por_partido) AS "puntos por partido"
FROM estadisticas
WHERE jugador IN (SELECT codigo
	FROM jugadores
    WHERE Nombre_equipo = 'cavaliers');
    
SELECT SUM(Puntos_por_partido) AS "puntos por partido"
FROM estadisticas
WHERE jugador IN (SELECT codigo
	FROM jugadores
    WHERE Nombre_equipo = 'cavaliers')
GROUP BY jugador;
   
-- 3. Media de puntos de ’Lebron James’ en su carrera.

SELECT AVG(Puntos_por_partido) AS "Puntos maximos"
FROM estadisticas
WHERE jugador = (SELECT codigo
	FROM jugadores
    WHERE nombre = 'Lebron James')
GROUP BY jugador;
    
-- 4. Asistencias por partido de ’Jose Calderon’ en la temporada ’07/08’.

SELECT Asistencias_por_partido AS "asistencias por partido"
FROM estadisticas
WHERE temporada = '07/08' AND jugador = (SELECT codigo
	FROM jugadores
    WHERE nombre = 'Jose Calderon');

-- 5. Suma de puntos por partido de ’Lebron James’ en las temporadas del 03/04 a1 05/06.

SELECT SUM(Puntos_por_partido) AS "Puntos por partido"
FROM estadisticas
WHERE temporada BETWEEN '03/04' AND '05/06' AND jugador = (SELECT codigo
	FROM jugadores
    WHERE nombre = 'Lebron James');
