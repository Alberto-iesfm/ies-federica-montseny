USE jardineria;

-- 1. Muestra el número de clientes por pais

SELECT Pais, COUNT(*) AS 'Numero clientes'
FROM clientes
GROUP BY Pais;

-- 2. Muestra el número de clientes por representante, el pais,
-- y el código, nombre y apellidos del representante en un solo campo
-- de los representantes que tengan más de 2 clientes

SELECT emp.CodigoEmpleado, CONCAT(emp.Nombre, ' ', emp.Apellido1, ' ', emp.Apellido2) AS 'nombre y apellidos', ofi.Pais, COUNT(cli.CodigoCliente) AS 'numero_clientes'
FROM clientes cli
	INNER JOIN empleados emp ON cli.CodigoEmpleadoRepVentas = emp.CodigoEmpleado
    INNER JOIN oficinas ofi ON emp.CodigoOficina = ofi.CodigoOficina
GROUP BY emp.CodigoEmpleado
HAVING numero_clientes > 2;

-- 3. Muestra el número de oficinas por pais, de los paises que tengan más de 1 oficina

SELECT Pais, COUNT(*) AS 'numero_oficinas'
FROM oficinas
GROUP BY Pais
HAVING numero_oficinas > 1;

-- 4. Muestra el número de productos por gama y proveedor que tengan más de 10 productos

SELECT Proveedor, gama, COUNT(*) AS 'numero_productos'
FROM productos
GROUP BY Proveedor, gama
HAVING numero_productos > 10;

-- 5. Muestra el número de productos por gama y la gama, de las gamas que tengan más de 100 productos
-- y la descripción del texto de la gama

SELECT pro.gama, CONVERT(gam_pro.DescripcionTexto USING utf8) AS 'Descripcion', COUNT(pro.CodigoProducto) AS 'numero_productos'
FROM gamasproductos gam_pro
	INNER JOIN productos pro ON pro.Gama = gam_pro.Gama
GROUP BY pro.gama
HAVING numero_productos > 100;
