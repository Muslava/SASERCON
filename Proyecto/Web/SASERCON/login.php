<?php

session_start();
ob_start();

if(isset($_POST['boton']))  {

    $_SESSION['sesion_exito']=2;

    $usr=$_POST['usuario'];

    include("abrir_conexion.php");        // realiza una conexión por mysqli

    $_SESSION['sesion_exito']=3;

    include("abrir_conexion.php");
    $res = mysqli_query($conn,"SELECT contrasena FROM usuario WHERE correo = '$usr'");
    while($consulta = mysqli_fetch_array($res)) {
        if($consulta['contrasena'] == $_POST['contra']){
            $_SESSION['sesion_exito'] = 1;
            echo 'Has sido logueado correctamente ';
            header('Location: catalo.php');
        }else{
        echo 'Password incorrecto';
        }
    }
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
      <!-- USERNAME INPUT location.href='catalo.php'-->
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
      <a href="formulario.php">Crear cuenta</a>
    </form>


  <div class="Final">
      <a href="index.html">Regresar a pagina principal</a>
  </div>
</div>
  </body>
</html>
