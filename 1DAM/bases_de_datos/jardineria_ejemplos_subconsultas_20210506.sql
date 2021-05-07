USE jardineria;

SELECT * FROM clientes
ORDER BY LimiteCredito desc;

SELECT * FROM empleados;

-- Listado de empleados de las oficinas de EEUU.

SELECT *
FROM empleados emp
WHERE emp.CodigoOficina IN (
	SELECT ofi.CodigoOficina
    FROM oficinas ofi
	WHERE ofi.Pais = 'EEUU');

-- La subconsulta anterior equivale a la siguiente consulta con JOIN:

SELECT *
FROM empleados emp INNER JOIN oficinas ofi ON emp.CodigoOficina = ofi.CodigoOficina
WHERE ofi.Pais = 'EEUU';

-- Clientes con el máximo limite de credito

SELECT * 
FROM clientes
WHERE LimiteCredito = (SELECT MAX(LimiteCredito)
	FROM clientes);

-- Clientes con un limite de credito superior a 60000

SELECT cli.CodigoCliente, cli.NombreCliente 
FROM clientes cli
WHERE cli.CodigoCliente IN (SELECT cli2.CodigoCliente
	FROM clientes cli2
    WHERE LimiteCredito > 60000);
    
-- Producto que más se ha vendido

-- Separamos las consultas:

-- Número de ventas por producto

SELECT det_ped.CodigoProducto codproducto, SUM(det_ped.Cantidad) cantidad_sum
	FROM detallepedidos det_ped
	GROUP BY det_ped.CodigoProducto;

-- Número máximo de ventas por producto

SELECT MAX(t2.cantidadsum) AS max_cantidad
	FROM (
		SELECT det_ped_2.CodigoProducto, SUM(det_ped_2.Cantidad) cantidadsum
		FROM detallepedidos det_ped_2
		GROUP BY det_ped_2.CodigoProducto
        ) t2;

-- Consulta final

SELECT t1.codproducto, MAX(t1.cantidad_sum)
FROM
(
	SELECT det_ped.CodigoProducto codproducto, SUM(det_ped.Cantidad) cantidad_sum
	FROM detallepedidos det_ped
	GROUP BY det_ped.CodigoProducto
) t1
WHERE t1.cantidad_sum IN (
	SELECT MAX(t2.cantidadsum) AS max_cantidad
	FROM (
		SELECT det_ped_2.CodigoProducto, SUM(det_ped_2.Cantidad) cantidadsum
		FROM detallepedidos det_ped_2
		GROUP BY det_ped_2.CodigoProducto
        ) t2
	);

SELECT * FROM gamasproductos;

SELECT * FROM oficinas;

SELECT * FROM pagos;

SELECT * FROM pedidos;

SELECT * FROM detallepedidos;

SELECT * FROM productos
ORDER BY PrecioVenta DESC;


