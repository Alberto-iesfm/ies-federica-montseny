USE nba;

SHOW TABLES;

DESCRIBE equipos;

DESCRIBE estadisticas;

DESCRIBE jugadores;

DESCRIBE partidos;

-- TABLA equipos

SELECT * FROM equipos;

-- 1. Muestra las ciudades de la Division 'SouthWest'

SELECT ciudad FROM equipos
WHERE division = "SouthWest";

-- 2. Muestra el nombre y ciudad de los equipos de la conferencia 'East'

SELECT nombre, ciudad FROM equipos
WHERE conferencia = "East";

-- 3. Muestra el nombre y ciudad de los equipos de la conferencia 'West' y de la division 'Pacific'

SELECT nombre, ciudad FROM equipos
WHERE conferencia = "West" AND division = "Pacific";

-- 4. Muestra el nombre, ciudad y conferencia de los equipos de la division 'SouthEast'

SELECT nombre, ciudad, conferencia FROM equipos
WHERE division = "SouthEast";

-- TABLA estadisticas

SELECT * FROM estadisticas;

-- 1. Muestra las estadisticas de la temporada '00/01'

SELECT * FROM estadisticas
WHERE temporada = "00/01";

-- 2. Muestra los puntos por partido del jugador 2 de las temporadas 04/05 y 05/06

SELECT puntos_por_partido FROM estadisticas
WHERE jugador = 2 AND (temporada = "04/05" OR temporada = "05/06");

-- 3. Muestra las asistencias y tapones por partido del jugador 4 de las temporadas que haya anotado más de 5 puntos por partido

SELECT asistencias_por_partido, tapones_por_partido FROM estadisticas
WHERE jugador = 4 AND puntos_por_partido > 5;

-- 4. Muestra los puntos, asistencias y rebotes por partido de los jugadores con más de 1.2 asistencias

SELECT puntos_por_partido, asistencias_por_partido, rebotes_por_partido FROM estadisticas
WHERE asistencias_por_partido > 1.2;

-- TABLA jugadores

SELECT * FROM jugadores;

-- 1. Muestra toda la información de los jugadores de los Lakers.

SELECT * FROM jugadores
WHERE nombre_equipo = "Lakers";

-- 2. Muestra el codigo, nombre y posicion de los jugadores de los Clippers y de los Grizzlies.

SELECT codigo, nombre, posicion FROM jugadores
WHERE nombre_equipo = "Clippers" OR nombre_equipo = "Grizzlies";

-- 3. Muestra el nombre, posicion y equipo de los jugadores de procedencia 'Spain'

SELECT nombre, posicion, nombre_equipo FROM jugadores
WHERE procedencia = "Spain";

-- 4. Muestra el nombre, procedencia y nombre del equipo de los jugadores cuyo peso sea mayor o igual a 250

SELECT nombre, procedencia, nombre_equipo FROM jugadores
WHERE peso >= 250;

-- 5. Muestra el nombre y equipo de los jugadores de la posición 'F-C'

SELECT nombre, nombre_equipo FROM jugadores
WHERE posicion = "F-C";

-- TABLA partidos

SELECT * FROM partidos;

-- 1. Muestra todos los partidos que los Raptors han jugado como equipo visitante en la temporada 07/08

SELECT * FROM partidos
WHERE equipo_visitante = "Raptors" AND temporada = "07/08";

-- 2. Muestra los equipos visitantes contra los que Mavericks jugaron (como locales) la temporada 05/06 y 06/07

SELECT equipo_visitante FROM partidos
WHERE equipo_local = "Mavericks" AND (temporada = "05/06" OR temporada = "06/07");

-- 3. Muestra los equipos locales y sus puntos, de los que hayan anotado más de 100 puntos en la temporada 04/05

SELECT equipo_local, puntos_local FROM partidos
WHERE puntos_local > 100 AND temporada = "04/05";

-- 4. Muestra los puntos que ha obtenido el equipo de los Supersonics como visitante en la temporada 03/04

SELECT puntos_visitante FROM partidos
WHERE equipo_visitante = "Supersonics" AND temporada = "03/04";

-- 5. Muestra los equipos visitantes que hayan anotado menos de 60 puntos de las temporadas 98/99 y 00/01

SELECT equipo_visitante FROM partidos
WHERE puntos_visitante < 60 AND (temporada = "98/99" OR temporada = "00/01");
