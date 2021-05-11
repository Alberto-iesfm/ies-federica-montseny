USE jardineria;

-- Realiza los siguientes ejercicios mediante subconsultas

-- 1. Listado de clientes de las oficinas de Madrid (MAD-ES).

SELECT NombreCliente AS Cliente
FROM clientes
WHERE CodigoEmpleadoRepVentas IN (
	SELECT CodigoEmpleado
    FROM empleados
    WHERE CodigoOficina = 'MAD-ES');

-- 2. Listado de clientes de las oficinas de Madrid (MAD-ES) mediante una tabla temporal.

SELECT cli_emp.NombreCliente
FROM (
	SELECT *
    FROM clientes cli
    INNER JOIN empleados emp ON cli.CodigoEmpleadoRepVentas = emp.CodigoEmpleado
		WHERE CodigoOficina = 'MAD-ES'
        ) cli_emp;
        
SELECT cli_emp.NombreCliente
FROM (
	SELECT *
    FROM clientes cli
		WHERE CodigoEmpleadoRepVentas IN (
			SELECT CodigoEmpleado
			FROM empleados
			WHERE CodigoOficina = 'MAD-ES')) cli_emp;

-- 3. Listar el nombre del cliente y el nombre y apellido de sus representantes de
-- aquellos clientes que no hayan realizado pagos.

SELECT cli_emp.NombreCliente AS "Cliente", CONCAT(cli_emp.Nombre, ' ', cli_emp.Apellido1, ' ', cli_emp.Apellido2) AS "Empleado"
FROM (
	SELECT *
    FROM clientes cli
    INNER JOIN empleados emp ON cli.CodigoEmpleadoRepVentas = emp.CodigoEmpleado
		WHERE cli.CodigoCliente NOT IN (
			SELECT CodigoCliente
            FROM pagos)
	) cli_emp;

-- 4. Sacar el nombre, apellidos, oficina y cargo de aquellos que no sean representantes de ventas.

SELECT CONCAT(emp_ofi.Nombre, ' ', emp_ofi.Apellido1, ' ', emp_ofi.Apellido2) AS "Nombre y apellidos",
emp_ofi.Puesto, emp_ofi.Ciudad AS Oficina, emp_ofi.CodigoOficina
FROM (
	SELECT emp.Nombre, emp.Apellido1, emp.Apellido2, emp.Puesto, ofi.Ciudad, ofi.CodigoOficina
	FROM empleados emp
    INNER JOIN oficinas ofi ON emp.CodigoOficina = ofi.CodigoOficina
	WHERE emp.Puesto NOT IN ('Representante Ventas')) emp_ofi;

-- 5. Sacar el nombre, apellido, oficina (ciudad) y cargo del empleado que no represente a ningún cliente.

SELECT CONCAT(emp_ofi.Nombre, ' ', emp_ofi.Apellido1, ' ', emp_ofi.Apellido2) AS "Nombre y apellidos", emp_ofi.Puesto, emp_ofi.Ciudad AS Oficina
FROM (
	SELECT emp.Nombre, emp.Apellido1, emp.Apellido2, emp.Puesto, ofi.Ciudad, ofi.CodigoOficina
	FROM empleados emp
    INNER JOIN oficinas ofi ON emp.CodigoOficina = ofi.CodigoOficina
	WHERE emp.CodigoEmpleado NOT IN (
		SELECT CodigoEmpleadoRepVentas
        FROM clientes)
	) emp_ofi;

-- 6. Sacar los clientes que residan en ciudades donde no hay oficinas ordenado por la ciudad donde residen.

SELECT NombreCliente, Ciudad
FROM clientes
WHERE Ciudad NOT IN (
	SELECT Ciudad
    FROM oficinas)
ORDER BY Ciudad;

-- 7. Muestra el listado de ventas por gama de productos mediante una tabla temporal.

SELECT pro_det.Gama, pro_det.Ventas
FROM (
	SELECT pro.Gama, SUM(det.Cantidad) AS "Ventas"
    FROM productos pro
    INNER JOIN detallepedidos det ON pro.CodigoProducto = det.CodigoProducto
    GROUP BY pro.Gama
    ) pro_det;
    