
<?php
if(isset($_POST['boton'])){
  $usr=$_POST["usuario"];
  $pwd=$_POST["contra"];



  header('Location: catalo.html');
/*
ABRIR LA CONEXION BD
SQL usr y pwd

si existe usr y el pwd correcto redirect consultas
mostrar msg error y quedarse en la pagina

*/
//  echo $usr;
///  echo $pwd;
  //if ($var == "Iniciar Sesion"){
    //echo "OK";
  //}
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
    <form name="Login" method="post" action="login.php">
      <!-- USERNAME INPUT location.href='catalo.html'-->
      <label for="username">Usuario</label>
      <input name="usuario" type="email" placeholder="Ingresa Usuario" required>
      <!-- PASSWORD INPUT -->
      <label for="password">Contraseña</label>
      <input name="contra" type="password" placeholder="Ingresa Contraseña" required/>
      <input type="submit" value="Iniciar Sesion" name="boton"/>
      <a href="#">Olvidaste tu Contraseña?</a><br>
      <a href="formulario.html">Crear cuenta</a>
    </form>
  </div>

  <div class="Final">
      <a href="index.html">Regresar a pagina principal</a>
  </div>

  </body>
</html>
