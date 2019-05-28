<?php

session_start();
ob_start();

if(isset($_POST['boton']))  {
    
    $_SESSION['sesion_exito']=2;

    $usr=$_POST['usuario'];
    $pwd=$_POST['contra'];

    include("abrir_conexion.php");        // realiza una conexión por mysqli
   
    $sql = "SELECT contraseña FROM usuario WHERE correo = '$usr'";

    $_SESSION['sesion_exito']=3;
    
    $result = mysqli_query($conn,"SELECT * FROM usuario;");
    $row = mysqli_fetch_array($result,MYSQLI_NUM)
	/*if(false){
        if($row['contraseña'] == $pwd){
            $_SESSION['sesion_exito'] = 1;
            echo 'Has sido logueado correctamente ';
            header('Location: catalo.html');
        }else{
        echo 'Password incorrecto';
        }
    }else{
    echo 'Usuario no existente en la base de datos';
    }*/
	//mysqli_free_result($result);

    
    mysqli_close($conn);
    
    
    if($_SESSION['sesion_exito']<>1)    {
        header('Location: login.php');
    }
}

?>

<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>SASERCON</title>
    <link rel="stylesheet" href="css/login.css">
  </head>
  <body>


    <div class="login-box">
    <img src="img/sercon.png" class="avatar" alt="Avatar Image">
    <h1>Iniciar Sesion</h1>
    <form name="Login" method="post" action="#">
      <!-- USERNAME INPUT location.href='catalo.html'-->
      <label for="username">Usuario</label>
      <input name="usuario" type="email" placeholder="Ingresa Usuario" required>
      <!-- PASSWORD INPUT -->
      <label for="password">Contraseña</label>
      <input name="contra" type="password" placeholder="Ingresa Contraseña" required/>
      <input type="submit" value="Iniciar Sesion" name="boton"/>
        <p align="center">
        <b>
        <?php
            ob_start();
            if(isset($_SESSION['sesion_exito']))    {
                if($_SESSION['sesion_exito']==0)
                    {echo "";}
                if($_SESSION['sesion_exito']==2)
                    {echo "Los campos son obligatorios";}
                if($_SESSION['sesion_exito']==3)
                    {echo "Datos incorrectos";}
            }
            else    {
                $_SESSION['sesion_exito']=0;
            }
        ?>
        </b>
        </p>
      <a href="#">Olvidaste tu Contraseña?</a><br>
      <a href="formulario.html">Crear cuenta</a>
    </form>
  </div>

  <div class="Final">
      <a href="index.html">Regresar a pagina principal</a>
  </div>

  </body>
</html>
