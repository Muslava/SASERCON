<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>SASERCON</title>
    <link rel="stylesheet" href="css/catalo.css">

  </head>
  <body>

    <div class="top-redes">
      <ul>
        <li><a href ="https://www.instagram.com/?hl=es-la">INSTAGRAM</a></li>
        <li><a href ="https://es-la.facebook.com/">FACEBOOK</a></li>
      </ul>


    </div>

<div class="contenedor1">
  <img src="img/sercon.png" alt="">
  <div class="MENU-PRINCIPAL">
    <div class="contenedor">
      <ul>
        <li><a href="index.html">INICIO</a></li>
        <li><a href="nosotros.html">NOSOTROS</a></li>
        <li><a href="catalo.php">CATÁLOGO</a></li>
        <li><a href="login.php">INICIAR SESION</a></li>

</ul>
</div>

</div>

      <TABLE class="subtitulo"=1>
      <TR><TD>
      <MARQUEE>SERVICIOS CONFIABLES </MARQUEE>
      </TD></TR>
    </TABLE>



    <?php
        $top = '0';
        $cont = 0;
        include("abrir_conexion.php");
        $res = mysqli_query($conn,"SELECT * FROM catalogo");
        while($consulta = mysqli_fetch_array($res)) {
            if($cont==2)    {
                $cont=0;
                echo "<br>";
            }
            else    {
                echo "x
                <div id=\"top\">
                    <ul>
                      <li>
                      	<img src=\" ".$consulta['foto']." \"
                      	width=\"326\" height=\"192\"
                      	alt=\" ".$consulta['nombre']."\"class=\"center\"/>
                      	</li>

                        </div>
                        <div id=\"top0\">

                           ".$consulta['descripcion']."
                        </ul>
                </div>
                ";
                $cont++;
            }
        }
    ?>

    <div id="top0">
      <ul>
            <li>
                <p id=d3></p>
            </li>

            <li>

               <p id=d3> </p>

            </li>
        </ul>

    </div>



<!-- Cierra parte Superior -->

<!-- Inicia Sección -->

<section>

    <aside id="izq"></aside>

    <article>
      <h2>

            <h2>CATALOGO PRODUCTOS/REFACCIONES</h2>
                    <div class="TITULO">
                        <div class="content-carrousel">
                              <figure><img src="img/img1.jpg"></figure>
                              <figure><img src="img/img2.jpg"></figure>
                              <figure><img src="img/img3.jpg"></figure>
                              <figure><img src="img/img4.jpg"></figure>
                              <figure><img src="img/img5.jpg"></figure>
                              <figure><img src="img/img6.jpg"></figure>
                              <figure><img src="img/img7.jpg"></figure>
                              <figure><img src="img/img8.jpg"></figure>
                              <figure><img src="img/img9.jpg"></figure>
                              <figure><img src="img/img10.jpg"></figure>
                         </div>



      </h2>

     </article>

    <aside id="der"></aside>

</section>

<!-- Cierra Sección -->

<!-- Inicia Pie de Página -->

<footer></footer>

<!-- Cierra Pie de Página -->






<div class="Final">
    <a href="index.html">Regresar a pagina principal</a>
</div>



  </body>
</html>
