<?php

if(isset($_POST["Agregar"]))   {
    $_SESSION['sesion_exito']=2;

    $c1=$_POST['c1'];
    $c2=$_POST['c2'];
    $c3=$_POST['c3'];
    $c4=$_POST['c4'];
    $c5=$_POST['c5'];
    $c6=$_POST['c6'];
    $c7=$_POST['c7'];

    include("abrir_conexion.php");        // realiza una conexión por mysqli
   
    $sql = "INSERT INTO usuario VALUES ('$c1','$c2','$c3','$c4','$c5','$c6','$c7')";

    if(mysqli_query($conn,$sql))    {
        header('Location: https://www.facebook.com/');
    } else  {
        echo "Error: ".$sql."<br>".mysqli_error($conn);
    }

    include("cerrar_conexion.php");        // cierra la conexión por mysqli
}

?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html lang="en" dir="ltr">
<head>
<title>SASERCON</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

</head>
<body>
<div class="wrapper col0">
  <div id="topbar">
    <div id="slidepanel">
      <div class="topbox">
        <h2>Registro Para Nuevo Usuario</h2>

      </div>




        <form action="#" method="post">
Matricula: <input type="text" name="c1"> <br><br>
Nombre: <input type="text" name="c2"> <br><br>
Apellido Paterno: <input type="text" name="c3"> <br><br>
Apellido Materno: <input type="text" name="c4"> <br><br>
Correo: <input type="text" name="c5"> <br><br>
Contraseña: <input type="text" name="c6"> <br><br>

Academia: <select name="c7">
<option value="AC01">Informatica</option>
<option value="AC02">Turismo</option>
<option value="AC03">Contaduria</option>
<option value="AC04">Administracion</option>
</select><br>

<input type="submit" value="Agregar" name="Agregar">
<input Type="reset" values="Eliminar">

</form>
<div class="Final">
    <a href="index.html">Regresar a pagina principal</a>
</div>
</body>
</html>
