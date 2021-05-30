DROP DATABASE SASERCONWEB;
CREATE DATABASE SASERCONWEB;
USE SASERCONWEB;
CREATE TABLE usuario(
	matricula smallint NOT NULL UNIQUE AUTO_INCREMENT,
	nombre varchar(45),
	apPat varchar(35),
	apMat varchar(35),
	correo varchar(50),
	contrasena varchar(40),
	academia varchar(25),
	PRIMARY KEY (matricula)
);

INSERT INTO usuario VALUES(1,"Perro Guau Guau","Aguirre","Urquiza","woof@woof.woof","grrrr","Informática");

CREATE TABLE catalogo(
	id smallint NOT NULL UNIQUE AUTO_INCREMENT,
	foto varchar(50),
	nombre varchar(25),
	descripcion varchar(500),
	PRIMARY KEY (id)
);

INSERT INTO catalogo VALUES(
	1,"img/123.jpg","Elevador","Sube y baja como la marea"),
	(2,"img/123.jpg","Portaplatos","Has visto los de la farmacia Paris? Ándale, así mero son"),
	(3,"img/123.jpg","Freno","No es como el de los carros. Ve la foto"),
	(4,"img/123.jpg","Botonera","Kilikitaka"
);
