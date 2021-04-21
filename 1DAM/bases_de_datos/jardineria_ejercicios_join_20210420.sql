USE jardineria;

-- 1. Muestra el listado de descripciones de texto de la tabla gamasproductos 
-- usando la función CONVERT(DescripcionTexto USING utf8).

SELECT CONVERT(DescripcionTexto USING utf8) AS "Descripcion"
FROM gamasproductos;

-- 2. Muestra el número de clientes norteamericanos.

SELECT COUNT(*)
FROM clientes
WHERE Pais = 'USA';

-- 3. seleccionar la concatenación del nombres, apellido 1 y apellido 2 de los empleados, 
-- y la dirección1 de su oficina.

SELECT CONCAT(emp.Nombre, ' ', emp.Apellido1, ' ', emp.Apellido2) AS 'Nombre y apellidos', ofi.LineaDireccion1
FROM empleados emp
INNER JOIN oficinas ofi ON emp.CodigoOficina = ofi.CodigoOficina;

-- 4. Mostrar el apellido de los empleados y la ciudad de su oficina. 
-- Si algún empleado no tuviera una oficina asignada no saldría

SELECT CONCAT(emp.Apellido1, ' ', emp.Apellido2) AS 'Apellidos', ofi.Ciudad
FROM empleados emp
INNER JOIN oficinas ofi ON emp.CodigoOficina = ofi.CodigoOficina;

-- 5. Mostrar el apellido de los empleados y la ciudad de su oficina. 
-- También deben salir los empleados que no tienen una oficina asignada

SELECT CONCAT(emp.Apellido1, ' ', emp.Apellido2) AS 'Apellidos', ofi.Ciudad
FROM empleados emp
LEFT JOIN oficinas ofi ON emp.CodigoOficina = ofi.CodigoOficina;

-- 6. Muestra el nombre de los cliente y el nombre de su empleado asociado (si lo tiene).

SELECT cli.NombreCliente AS 'Nombre Cliente', CONCAT(emp.Nombre, ' ', emp.Apellido1, ' ', emp.Apellido2) AS 'Nombre Empleado'
FROM clientes cli
INNER JOIN empleados emp ON cli.CodigoEmpleadoRepVentas = emp.CodigoEmpleado;

-- 7. Nombre de los clientes que hayan hecho un pago en 2007.

SELECT cli.NombreCliente AS 'Nombre Cliente'
FROM clientes cli
INNER JOIN pagos pag ON cli.CodigoCliente = pag.CodigoCliente
WHERE pag.FechaPago LIKE '2007-%';


-- 8. Muestra el número de pedido, el nombre del cliente, la fecha de entrega y la fecha esperada
-- de los pedidos que no han sido entregados a tiempo.

SELECT ped.CodigoPedido, cli.NombreCliente, ped.FechaEntrega, ped.FechaEsperada
FROM pedidos ped
INNER JOIN clientes cli ON ped.CodigoCliente = cli.CodigoCliente
WHERE ped.FechaEntrega > ped.FechaEsperada;

-- 9. Muestra el nombre y apellidos de los empleados (concatenados) que trabajan en Barcelona.

SELECT CONCAT(emp.Nombre, ' ', emp.Apellido1, ' ', emp.Apellido2) AS 'Nombre y Apellidos'
FROM empleados emp
INNER JOIN oficinas ofi ON emp.CodigoOficina = ofi.CodigoOficina
WHERE ofi.Ciudad = 'Barcelona';

-- 10. Seleccionar de todos los pedidos, el Nombre del empleado que ha realizado el pedido, 
-- el nombre del cliente al que se le ha vendido y el código de pedido

SELECT ped.CodigoPedido, cli.NombreCliente, CONCAT(emp.Nombre, ' ', emp.Apellido1, ' ', emp.Apellido2) AS 'Nombre Empleado'
FROM pedidos ped
LEFT JOIN clientes cli ON ped.CodigoCliente = cli.CodigoCliente
INNER JOIN empleados emp ON cli.CodigoEmpleadoRepVentas = emp.CodigoEmpleado;

-- 11. Devuelve el producto cartesiano de las tablas empleados y oficinas.

SELECT * 
FROM empleados emp
CROSS JOIN oficinas ofi;

-- 12. Mostrar el listado de pedidos que no tengan fecha de entrega, de los clientes con códigos del 1 al 15
-- junto con los nombres de los clientes

SELECT ped.*, cli.NombreCliente
FROM pedidos ped
INNER JOIN clientes cli ON ped.CodigoCliente = cli.CodigoCliente
WHERE cli.CodigoCliente BETWEEN 1 AND 15 AND ped.FechaEntrega IS NULL;

-- 13. Devuelve un listado de los productos que han aparecido en los pedidos, cuyo codigo de producto empiece por OR.

SELECT pro.CodigoProducto, pro.Nombre
FROM productos pro
INNER JOIN detallepedidos deta ON pro.CodigoProducto = deta.CodigoProducto
INNER JOIN pedidos ped ON deta.CodigoPedido = ped.CodigoPedido
WHERE pro.CodigoProducto LIKE 'OR%'
GROUP BY pro.Nombre;

-- 14. Devuelve un listado de los productos que no han aparecido en ningún pedidos

SELECT pro.CodigoProducto, pro.Nombre
FROM productos pro
LEFT JOIN detallepedidos deta ON pro.CodigoProducto = deta.CodigoProducto
WHERE deta.CodigoPedido IS NULL;


-- 15. Devuelve el código, nombre, y la descripción del texto de la gama de los productos que no han aparecido 
-- en ningún pedido

SELECT pro.CodigoProducto, pro.Nombre, CONVERT(gama.DescripcionTexto USING utf8) AS 'Descripción'
FROM productos pro
LEFT JOIN detallepedidos deta ON pro.CodigoProducto = deta.CodigoProducto
INNER JOIN gamasproductos gama ON pro.Gama = gama.Gama
WHERE deta.CodigoPedido IS NULL;
