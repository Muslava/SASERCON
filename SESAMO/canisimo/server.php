<?php
// turn off WSDL caching
ini_set("soap.wsdl_cache_enabled","0");

function getName($matricula)	{
	include("abrir_conexion.php");

	$sql = "SELECT nombreEmpleado FROM empleado WHERE matricula = '$matricula'";

	$qry = mysqli_query($conn, $sql);
	$result = $conn->query($sql);

	if ($result->num_rows > 0)	{
        return $row["nombreEmpleado"];
	}
	else	{
	    return "0 results";
	}

	include("cerrar_conexion.php");
}

function login($mail,$pass)	{
	include("abrir_conexion.php");

	$sql = "SELECT matricula FROM tbl_empleado WHERE correoempleado = '$mail' AND contrasena = '$pass'";
	$res = $conn->query($sql);

	if($res->num_rows > 0)	{
		return true;
	}
	else 	{
		return false;
	}

	include("cerrar_conexion.php");
}

function getInventario($clave)	{
	include("abrir_conexion.php");

	$sql = "SELECT clave, nombre FROM productos WHERE clave = '$clave' OR clave = 2";

	$qry = mysqli_query($conn, $sql);
	$result = $conn->query($sql);

	if ($result->num_rows > 0) {
	    while($row = $result->fetch_assoc()) {
	    	$rows[] = $row;
	    }
	} else {
	    return "0 results";
	}

	//return $rows[];

	include("cerrar_conexion.php");
}

// initialize SOAP Server
$server=new SoapServer("canisimo.wsdl",[
	'classmap'=>[
		'producto'=>'producto',
	]
]);

// register available functions
$server->addFunction('login');
$server->addFunction('getName');
$server->addFunction('getInventario');

// start handling requests
$server->handle();

?>