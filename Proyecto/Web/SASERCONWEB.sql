DROP DATABASE SASERCONWEB;
CREATE DATABASE SASERCONWEB;
USE SASERCONWEB;
CREATE TABLE usuario(
	matricula smallint NOT NULL UNIQUE AUTO_INCREMENT,
	nombre varchar(45),
	apPat varchar(35),
	apMat varchar(35),
	correo varchar(50),
	contraseña varchar(40),
	academia varchar(25),
	PRIMARY KEY (matricula)
);

INSERT INTO usuario VALUES(1,"Perro Guau Guau","Aguirre","Urquiza","woof@woof.woof","grrrr","Informática");
