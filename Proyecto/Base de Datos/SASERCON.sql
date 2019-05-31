DROP DATABASE SASERCON;
CREATE DATABASE IF NOT EXISTS SASERCON;
USE SASERCON;

create table familias(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	familia varchar(20),
	primary key (CLAVE)
);

CREATE TABLE fabricante(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	fabricante varchar (50),
	PRIMARY KEY (clave)
);

CREATE TABLE marca(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	marca varchar (30),
	PRIMARY KEY (clave)
);

CREATE TABLE categoriaProductos(
	clave smallint not NULL UNIQUE AUTO_INCREMENT,
	categoria varchar (20),
	PRIMARY KEY (clave)
);

CREATE TABLE unidadTiempo(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	unidadTiempo varchar(10),
	PRIMARY KEY (clave)
);

CREATE TABLE clasificacionProducto(
	clave  smallint NOT NULL UNIQUE AUTO_INCREMENT,
	clasificacion varchar(20),
	PRIMARY KEY (clave)
);

CREATE TABLE embalaje(
	numero smallint NOT NULL UNIQUE AUTO_INCREMENT,
	unidadPeso varchar(3),
	pesoMaximo float(6,2),
	pesoMinimo float(6,2),
	tiempoEntrega time,
	unidadTiempoEntrega smallint,
	formatoTransporte varchar(50),
	advertenciaRiesgo varchar(200),
	instruccionesManejo varchar(200),
	cantidad float(4,2),
	PRIMARY KEY (numero),
	FOREIGN KEY (unidadTiempoEntrega) REFERENCES unidadTiempo(clave)
);

CREATE TABLE pais(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	pais varchar(50),
	PRIMARY KEY (clave)
);

CREATE TABLE estado(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	estado varchar(20),
	clavePais smallint,
	PRIMARY KEY (clave),
	FOREIGN KEY (clavePais) REFERENCES pais(clave)
);

CREATE TABLE ciudad(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	nombre varchar(60),
	claveEstado smallint,
	PRIMARY KEY (clave),
	FOREIGN KEY (claveEstado) REFERENCES estado(clave)
);

CREATE TABLE productos(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	nombre varchar(50) NOT NULL,
	descripcionProducto varchar(100),
	modelo varchar(20),
	familia smallint,
	marca smallint,
	codigoFabricante smallint,
	numeroProductosEntrantes smallint,
	peso smallint,
	unidadMedida varchar(5),
	stock smallint,
	impuesto smallint,
	precio float,
	productoActivo boolean,
	contraEntrega boolean,
	categoria smallint,
	fechaAltaProducto date,
	fechaProducto date,
	umbralInventario smallint,
	clasificacionProducto smallint,
	codigoBarras varchar(13),
	numeroEmbalaje smallint,
	claveCiudadOrigen smallint,
	PRIMARY KEY (clave),
	FOREIGN KEY (familia) REFERENCES familias(clave),
	FOREIGN KEY (codigoFabricante) REFERENCES fabricante(clave),
	FOREIGN KEY (marca) REFERENCES marca(clave),
	FOREIGN KEY (categoria) REFERENCES categoriaProductos(clave),
	FOREIGN KEY (claveCiudadOrigen) REFERENCES ciudad(clave),
	FOREIGN KEY (clasificacionProducto) REFERENCES clasificacionProducto(clave),
	FOREIGN KEY (numeroEmbalaje) REFERENCES embalaje(numero),
	FOREIGN KEY (claveCiudadOrigen) REFERENCES ciudad(clave)
);


CREATE TABLE imagenProducto (
	clave smallint not NULL UNIQUE AUTO_INCREMENT,
	numero smallint,
	descripcion varchar (50),
	imagenVisual BLOB,
	FOREIGN KEY (clave) REFERENCES productos(clave)
);


CREATE TABLE tiposServicios(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	tipo varchar(12),
	PRIMARY KEY (clave)
);

CREATE TABLE prioridadServicio(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	importancia varchar (13),
	PRIMARY KEY (clave)
);
 
CREATE TABLE estatusServicio(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	estatus varchar (12),
	PRIMARY KEY (clave)
);

CREATE TABLE categorias(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	categoria varchar(40),
	PRIMARY KEY (clave)
);

CREATE TABLE servicios(
	folio smallint NOT NULL UNIQUE AUTO_INCREMENT,
	estatusPago boolean,
	tipoServicio smallint(30),
	fechaAgendada date,
	fechaEntrega date,
	fechaSalida date,
	horaAgendada time,
	horaEntrada time,
	horaSalida time,
	nombreServicio varchar(50),
	prioridad smallint,
	descripcion varchar(500),
	costo float(10,2),
	observaciones varchar(500),
	duracionHorasMinutos time,
	duracionEstimada time,
	estatusServicio smallint,
	PRIMARY KEY (folio),
	FOREIGN KEY (tipoServicio) REFERENCES tiposServicios(clave),
	FOREIGN KEY (prioridad) REFERENCES prioridadServicio(clave),
	FOREIGN KEY (estatusServicio) REFERENCES estatusServicio(clave)
);


CREATE TABLE categoriaServicios(
    claveCategoria smallint NOT NULL,
    folioServicio smallint NOT NULL,
    FOREIGN KEY(claveCategoria) REFERENCES categorias(clave),
    FOREIGN KEY(folioServicio) REFERENCES servicios(folio)
);

CREATE TABLE serviciosProducto(
	folioServicios smallint NOT NULL,
	claveProducto smallint NOT NULL,
	cantidadProducto smallint,
	FOREIGN KEY (folioServicios) REFERENCES servicios(folio),
	FOREIGN KEY (claveProducto) REFERENCES productos(clave)
);


CREATE TABLE herramientas(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	nombre varchar (50),
	descripcion varchar (350),
	PRIMARY KEY (clave)
);

CREATE TABLE serviciosHerramientas(
	folioServicios smallint NOT NULL,
	claveHerramienta smallint NOT NULL,
	cantidad smallint,
	FOREIGN KEY (folioServicios) REFERENCES servicios(folio),
	FOREIGN KEY (claveHerramienta) REFERENCES herramientas(clave)
);

CREATE TABLE formasPago(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	formaPago varchar(25),
	PRIMARY KEY (clave)
);

CREATE TABLE reciboPago(
	formaPago smallint NOT NULL,
	claveProducto smallint,
	folioServicio smallint,
	fechaEdicion date,
	cantidadPagado float(9.2),
	FOREIGN KEY (formaPago) REFERENCES formasPago(clave),
	FOREIGN KEY (folioServicio) REFERENCES servicios(folio),
	FOREIGN KEY (claveProducto) REFERENCES productos(clave)
);


CREATE TABLE estatusCotizacion(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	estatus varchar(10),
	PRIMARY KEY (clave)
);

CREATE TABLE cotizacion(
	numero smallint NOT NULL UNIQUE AUTO_INCREMENT,
	estatus smallint(10),
	importe float(9,2),
	fecha DATE,
	PRIMARY KEY (numero),
	FOREIGN KEY (estatus) REFERENCES estatusCotizacion(clave)
);

CREATE TABLE productosCotizacion (
	numeroCotizacion smallint NOT NULL,
	claveProducto smallint NOT NULL,
	cantidad smallint,
	FOREIGN KEY (numeroCotizacion) REFERENCES cotizacion(numero),
	FOREIGN KEY (claveProducto) REFERENCES productos(clave)
);

CREATE TABLE serviciosCotizacion(
	numeroCotizacion smallint NOT NULL,
	folioServicios smallint NOT NULL,
	cantidad smallint,
	FOREIGN KEY (numeroCotizacion) REFERENCES cotizacion(numero),
	FOREIGN KEY (folioServicios) REFERENCES servicios(folio)
);

CREATE TABLE preguntaSecreta(
	clave smallint NOT NULL AUTO_INCREMENT,
	preguntaSecreta varchar(45),
	PRIMARY KEY (clave)
);


CREATE TABLE empresa(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	nombre varchar (10),
	PRIMARY KEY (clave)
);

CREATE TABLE cliente(
	folio smallint not NULL UNIQUE AUTO_INCREMENT,
	vigencia boolean,
	nombreEmpresa varchar(30),
	contrasena varchar(30),
	fechaBaja DATE,
	fechaAlta DATE,
	correoEmpresarial varchar(35),
	extension  varchar(3),
	telefonoOficina  varchar(15),
	nombreRepresentante varchar(30),
	apellidoPaternoRepresentante varchar(30),
	apellidoMaternoRepresentante varchar(30),
	correoRepresentante varchar(35),
	empresa  smallint,
	RFC  varchar(13),
	preguntaSecretaUno smallint,
	preguntaSecretaDos smallint,
	PRIMARY KEY (folio),
	FOREIGN KEY (empresa) REFERENCES empresa(clave),
	FOREIGN KEY (preguntaSecretaUno) REFERENCES preguntaSecreta(clave),
	FOREIGN KEY (preguntaSecretaDos) REFERENCES preguntaSecreta(clave)
);

CREATE TABLE clienteCotizacion(
	numeroCotizacion smallint NOT NULL,
	folioCliente smallint NOT NULL,
	FOREIGN KEY (numeroCotizacion) REFERENCES cotizacion(numero),
	FOREIGN KEY (folioCliente) REFERENCES cliente(folio)
);


CREATE TABLE alcaldia(
    clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
    alcaldia varchar(50),
    claveCiudad smallint NOT NULL,
    PRIMARY KEY (clave),
    FOREIGN KEY (claveCiudad) REFERENCES estado(clave)
);

CREATE TABLE tipoDireccion(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	tipo varchar(10),
	PRIMARY KEY (clave)
);

CREATE TABLE direccion(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	numeroExterior varchar(10),
	numeroInterior varchar(10),
	calle varchar(30),
	colonia varchar(50),
	codigoPostal smallint,
	tipo smallint,
	alcaldia smallint,
	PRIMARY KEY (clave),
	FOREIGN KEY (tipo) REFERENCES tipoDireccion(clave),
	FOREIGN KEY (alcaldia) REFERENCES alcaldia(clave)
);

CREATE TABLE direccionCliente(
	claveDireccion smallint NOT NULL,
	folioCliente smallint NOT NULL,
	FOREIGN KEY (claveDireccion) REFERENCES direccion(clave),
	FOREIGN KEY (folioCliente) REFERENCES cliente(folio)
);

create table direccionServicio(
	claveDireccion smallint NOT NULL,
	claveServicio smallint NOT NULL,
	foreign key (claveDireccion) REFERENCES direccion(clave),
	foreign key (claveServicio) REFERENCES servicios(folio)
);


CREATE TABLE puesto(
	clave smallint NOT NULL UNIQUE AUTO_INCREMENT,
	nombre varchar (12),
	PRIMARY KEY (clave)
);

CREATE TABLE empleado(
	matricula smallint NOT NULL UNIQUE AUTO_INCREMENT,
	nombreEmpleado varchar (30),
	apellidoPaternoEmpleado varchar(20),
	apellidoMaternoEmpleado varchar(20),
	correoEmpleado varchar(35),
	empresa smallint,
	puesto smallint,
	contrasena varchar(30),
	curp varchar(18),
	numeroSeguroSocial varchar(12),
	celular varchar(12),
	telefonoEmergencia varchar(12),
	nombreContacto varchar(30),
	apellidoPaternoContacto varchar(20),
	apellidoMaternoContacto varchar(20),
	correoContacto varchar(35),
	estadoActivo boolean,
	telefono varchar(12),
	fotoEmpleado BLOB,
	RFC varchar(13),
	PRIMARY KEY (matricula),
	FOREIGN KEY (empresa) REFERENCES empresa(clave),
	FOREIGN KEY (puesto) REFERENCES puesto(clave)
);

CREATE TABLE direccionEmpleado(
	claveEmpleado smallint NOT NULL,
	claveDireccion smallint NOT NULL,
	FOREIGN KEY(claveEmpleado) REFERENCES empleado(matricula),
	FOREIGN KEY(claveDireccion) REFERENCES direccion(clave)
);

create table empleadoServicios(
	folioServicio smallint NOT NULL,
	matriculaEmpleado smallint NOT NULL,
	foreign key (matriculaEmpleado) REFERENCES empleado(matricula),
	foreign key (folioServicio) REFERENCES servicios(folio)
);

INSERT INTO familias (clave, familia)
values (1,"cables"),(2,"tornillos"),(3,"imanes"),(4,"pistones"),(5,"frenos"),(6,"botoneras"),(7,"puertas"),(8,"tarjetas digitales"),(9,"sensores");

INSERT INTO fabricante (clave,fabricante) VALUES(
	1,"Otis"),(2,"Schindler"
);

INSERT INTO marca (clave,marca)
VALUES
(1,"Tetraflon"),(2,"Jogar"),(3,"Iesa"),(4,"Transbelt"),(5,"Schindler");

INSERT INTO categoriaProductos(clave,categoria)
VALUES (1,"Elevador"),(2,"Escaleras"),(3,"Derivado");

INSERT INTO unidadTiempo(clave,unidadTiempo)
VALUES (1,"Meses"),(2,"Semanas"),(3,"Días");

INSERT INTO clasificacionProducto values (1,"Activo Circulante");
INSERT INTO clasificacionProducto values (2,"Activo No Circulante");

INSERT INTO embalaje(numero,unidadPeso,pesoMaximo,pesoMinimo,tiempoEntrega,unidadTiempoEntrega,formatoTransporte,advertenciaRiesgo,instruccionesManejo,cantidad)
VALUES (
	1,"kg",25,10,"4:00:00",3,"Camión","Fragil","Manjear con precaucion y velcidad moderada",1),
	(2,"gr",5000,500,"3:00:00",3,"Camión","Fragil","Manjear con precaucion y velcidad moderada",1),
	(3,"kg",70,90,"1:00:00",3,"Camión","Fragil","Manjear con precaucion y velcidad moderada",1),
	(4,"gr",900,100,"11:00:00",3,"Camión","Fragil","Manjear con precaucion y velcidad moderada",1),
	(5,"kg",10,14,"11:00:00",3,"Camión","Fragil","Manjear con precaucion y velcidad moderada",1
);


INSERT INTO pais(clave,pais) VALUES(1,"México"),(2,"Estados Unidos"),(3,"Guatemala"),(4,"Belice");

INSERT INTO estado(clave,estado,clavePais) VALUES(1,"Aguascalientes",1),(2,"BajaCalifornia",1),(3,"BajaCaliforniaSur",1),(4,"Campeche",1),(5,"Chihuahua",1),(6,"Chiapas",1),(7,"Coahuila",1),(8,"Colima",1),(9,"Durango",1),(10,"Guanajuato",1),(11,"Guerrero",1),(12,"Hidalgo",1),(13,"Jalisco",1),(14,"México",1),(15,"Michoacán",1),(16,"Morelos",1),(17,"Nayarit",1),(18,"NuevoLeón",1),(19,"Oaxaca",1),(20,"Puebla",1),(21,"Querétaro",1),(22,"QuintanaRoo",1),(23,"SanLuisPotosí",1),(24,"Sinaloa",1),(25,"Sonora",1),(26,"Tabasco",1),(27,"Tamaulipas",1),(28,"Tlaxcala",1),(29,"Veracruz",1),(30,"Yucatán",1),(31,"Zacatecas",1),(32,"CiudaddeMéxico",1),(33,"Alabama",2),(34,"Alaska",2),(35,"Arizona",2),(36,"Arkansas",2),(37,"California",2),(38,"CarolinadelNorte",2),(39,"CarolinadelSur",2),(40,"Colorado",2),(41,"Connecticut",2),(42,"DakotadelNorte",2),(43,"DakotadelSur",2),(44,"Delaware",2),(45,"Florida",2),(46,"Georgia",2),(47,"Hawái",2),(48,"Idaho",2),(49,"Illinois",2),(50,"Indiana",2),(51,"Iowa",2),(52,"Kansas",2),(53,"Kentucky",2),(54,"Luisiana",2),(55,"Maine",2),(56,"Maryland",2),(57,"Massachusetts",2),(58,"Míchigan",2),(59,"Minnesota",2),(60,"Misisipi",2),(61,"Misuri",2),(62,"Montana",2),(63,"Nebraska",2),(64,"Nevada",2),(65,"NuevaJersey",2),(66,"NuevaYork",2),(67,"NuevoHampshire",2),(68,"NuevoMéxico",2),(69,"Ohio",2),(70,"Oklahoma",2),(71,"Oregón",2),(72,"Pensilvania",2),(73,"RhodeIsland",2),(74,"Tennessee",2),(75,"Texas",2),(76,"Utah",2),(77,"Vermont",2),(78,"Virginia",2),(79,"VirginiaOccidental",2),(80,"Washington",2),(81,"Wisconsin",2),(82,"Wyoming",2);

INSERT INTO ciudad(clave,nombre,claveEstado) VALUES(
	1,"Acapulco",3),(2,"Aguascalientes",3),(3,"Apodaca",3),(4,"Buenavista",3),(5,"Campeche",3),(6,"Cancún",3),(7,"Celaya",3),(8,"Chalco",3),(9,"Chetumal",3),(10,"Chicoloapan",3),(11,"Chihuahua",3),(12,"Chilpancingo",3),(13,"Chimalhuacán",3),(14,"Ciudad Acuña",3),(15,"Ciudad de México DF (CDMX)",3),(16,"Ciudad del Carmen",3),(17,"Ciudad López Mateos",3),(18,"Ciudad Madero",3),(19,"Ciudad Obregón",3),(20,"Ciudad Valles",3),(21,"Ciudad Victoria",3),(22,"Coatzacoalcos",3),(23,"Colima",3),(24,"Córdoba",3),(25,"Cuauhtémoc",3),(26,"Cuautitlán",3),(27,"Cuautitlán Izcalli",3),(28,"Cuautla",3),(29,"Cuernavaca",3),(30,"Culiacán",3),(31,"Delicias",3),(32,"Durango",3),(33,"Ecatepec",3),(34,"Ensenada",3),(35,"Fresnillo",3),(36,"General Escobedo",3),(37,"Gómez Palacio",3),(38,"Guadalajara",3),(39,"Guadalupe",3),(40,"Guadalupe",3),(41,"Guaymas",3),(42,"Hermosillo",3),(43,"Hidalgo del Parral",3),(44,"Iguala",3),(45,"Irapuato",3),(46,"Ixtapaluca",3),(47,"Jiutepec",3),(48,"Juárez",3),(49,"Juárez",3),(50,"La Paz",3),(51,"León",3),(52,"Los Mochis",3),(53,"Manzanillo",3),(54,"Matamoros",3),(55,"Mazatlán",3),(56,"Mérida",3),(57,"Mexicali",3),(58,"Minatitlán",3),(59,"Miramar",3),(60,"Monclova",3),(61,"Monterrey",3),(62,"Morelia",3),(63,"Naucalpan",3),(64,"Naucalpan de Juárez",3),(65,"Navojoa",3),(66,"Nezahualcóyotl",3),(67,"Nogales",3),(68,"Nuevo Laredo",3),(69,"Oaxaca de Juárez",3),(70,"Ojo de Agua",3),(71,"Orizaba",3),(72,"Pachuca",3),(73,"Piedras Negras",3),(74,"Playa del Carmen",3),(75,"Poza Rica de Hidalgo",3),(76,"Puebla",3),(77,"Puerto Vallarta",3),(78,"Querétaro",3),(79,"Reynosa",3),(80,"Salamanca",3),(81,"Saltillo",3),(82,"San Cristóbal de las Casas",3),(83,"San Francisco Coacalco",3),(84,"San Juan Bautista Tuxtepec",3),(85,"San Juan del Río",3),(86,"San Luis Potosí",3),(87,"San Luis Río Colorado",3),(88,"San Nicolás de los Garza",3),(89,"San Pablo de las Salinas",3),(90,"San Pedro Garza García",3),(91,"Santa Catarina",3),(92,"Soledad de Graciano Sánchez",3),(93,"Tampico",3),(94,"Tapachula",3),(95,"Tehuacán",3),(96,"Tepexpan",3),(97,"Tepic",3),(98,"Texcoco de Mora",3),(99,"Tijuana",3),(100,"Tlalnepantla",3),(101,"Tlaquepaque",3),(102,"Toluca",3),(103,"Tonalá",3),(104,"Torreón",3),(105,"Tulancingo de Bravo",3),(106,"Tuxtla",3),(107,"Uruapan",3),(108,"Veracruz",3),(109,"Veracruz",3),(110,"Villa de Álvarez",3),(111,"Villa Nicolás Romero",3),(112,"Villahermosa",3),(113,"Xalapa",3),(114,"Xico",3),(115,"Zacatecas",3),(116,"Zamora",3),(117,"Zapopan",3
);

INSERT INTO productos (clave,nombre,descripcionProducto,modelo,familia,marca,codigoFabricante,numeroProductosEntrantes,peso,unidadMedida,stock,impuesto,precio,productoActivo,contraEntrega,categoria,fechaAltaProducto,fechaProducto,umbralInventario,clasificacionProducto,codigoBarras,numeroEmbalaje,claveCiudadOrigen) VALUES(
  1,"Freno paracaidas progresivo","Velocidad 2.5 M/S, carga máxima: 4000 KG, ancho de riel: 16 MM, 10 MM, incluye todos los accesorios.","AM50",5,5,2,10,250,"kg",1,5,2900.50,1,1,1,"2017-08-24","2018-08-20",2,NULL,9381223100987,NULL,100),
  (2,"Botonera","Botoneras de Cabina de columna, placa plana y montaje superficial.","BT10",6,5,2,100,20,"gr",50,10,4300,1,1,1,"2016-07-20","2016-08-20",2,NULL,9381223100087,NULL,100),
	(3,"Puerta Elevador","Puertas de rellano Epoxi. Telescópica 2 hojas.","PE00",7,5,2,100,20,"kg",05,16,7800,1,1,1,"2018-09-29","2018-10-20",2,NULL,8381223100087,NULL,100),
  (4,"Tarjeta de Control","Para elevadores Vvvvf, Hidraulicos,Una y dos velocidades","TC34",8,5,2,10,20,"gr",20,13,10500,1,1,1,"2018-08-29","2018-19-20",2,NULL,9981223100087,NULL,100),
  (5,"Pistones Hidraulico","Incluye valvulas paracaidas","PH24",4,5,1,10,20,"gr",20,13,10500,1,1,1,"2018-08-29","2018-19-20",2,NULL,9981223100087,NULL,100
);

INSERT INTO imagenProducto(clave,numero,descripcion,imagenVisual)
VALUES (1,NULL,"Descripción",NULL);

INSERT INTO tiposServicios (clave, tipo) VALUES (1,"Correctivo"), (2,"Operativo"), (3,"Operativo"), (4,"Operativo"), (5,"Correctivo"), (6,"Operativo"), (7,"Correctivo"), (8,"Correctivo"), (9,"Operativo"), (10,"Correctivo");

INSERT INTO prioridadServicio (clave,importancia)
VALUES (1,"Alta");
INSERT INTO prioridadServicio (clave,importancia)
VALUES (2,"Media");
INSERT INTO prioridadServicio (clave,importancia)
VALUES (3,"Sin prioridad");

INSERT INTO estatusServicio (clave,estatus)
VALUES (1,"Programado");
INSERT INTO estatusServicio (clave,estatus)
VALUES (2,"Concluido");
INSERT INTO estatusServicio (clave,estatus)
VALUES (3,"Cancelado");

INSERT INTO categorias (clave,categoria)
VALUES
(1,"Ubicación de la maquina"),(2,"Nivel de aceite"),(3,"Freno de la maquina o motor"),(4,"Rieles"),(5,"Funcionamiento del control"),(6,"Regulador final de parada"),(7,"Señalización"),(8,"Operador de puertas"),(9,"Seguridades"),(10,"Funcionamiento de puertas de cabina");

INSERT INTO servicios (folio,estatusPago,tipoServicio,fechaAgendada,fechaEntrega,fechaSalida,horaAgendada,horaEntrada,horaSalida,nombreServicio,prioridad,descripcion,costo,observaciones,duracionhorasMinutos,duracionEstimada,estatusServicio)
VALUES (1,1,1,"2017-08-24","2017-08-24","2017-08-24","08:30:00","08:30:00","15:00:00","Condominio Arkansas 14",2,"Un (1) elevador marca SCHINDLER EXEL con una capacidad de 560 kg, equivalentes a 8 pasajeros, Con 12 salidas todas al frente",1500.00,"Después de hacer una inspección técnica a un (1) elevador de pasajeros marca SCHINDLER EXEL nos permitimos presentar a su consideración nuestro presupuesto por el servicio de MANTENIMIENTO PREVENTIVO","06:30:00","09:30:00",1);
INSERT INTO servicios (folio,estatusPago,tipoServicio,fechaAgendada,fechaEntrega,fechaSalida,horaAgendada,horaEntrada,horaSalida,nombreServicio,prioridad,descripcion,costo,observaciones,duracionhorasMinutos,duracionEstimada,estatusServicio)
VALUES (2,1,1,"2017-04-24","2017-04-24","2017-04-24","08:30:00","08:30:00","13:00:00","Condominio Campeche 272",2,"Un (1) elevador marca SCHINDLER con una capacidad de 630 kg, equivalentes a 8 pasajeros, Con 9 salidas todas al frente, el cual tienen una velocidad de .1 m/s, sin cuarto de máquinas, 220 vts.",1500.00,"Después de hacer una inspección técnica a un (1) elevador de pasajeros marca SCHINDLER EXEL nos permitimos presentar a su consideración nuestro presupuesto por el servicio de MANTENIMIENTO PREVENTIVO","04:30:00","09:30:00",1);
INSERT INTO servicios (folio,estatusPago,tipoServicio,fechaAgendada,fechaEntrega,fechaSalida,horaAgendada,horaEntrada,horaSalida,nombreServicio,prioridad,descripcion,costo,observaciones,duracionhorasMinutos,duracionEstimada,estatusServicio)
VALUES (3,1,1,"2017-04-24","2017-04-24","2017-04-24","08:30:00","08:30:00","12:00:00","Condominio Gabriel Mancera 1027",2,"Un (1) elevador marca THYSSENKRUPP con una capacidad de 630 kg, equivalentes a 8 pasajeros, Con 7 salidas todas al frente, el cual tienen una velocidad de .1 m/s, sin cuarto de máquinas, 220 vts",1400.00,"Después de hacer una inspección técnica a un (1) elevador de pasajeros marca THYSSENKRUPP nos permitimos presentar a su consideración nuestro presupuesto por el servicio de MANTENIMIENTO PREVENTIVO","03:30:00","09:30:00",1);
INSERT INTO servicios (folio,estatusPago,tipoServicio,fechaAgendada,fechaEntrega,fechaSalida,horaAgendada,horaEntrada,horaSalida,nombreServicio,prioridad,descripcion,costo,observaciones,duracionhorasMinutos,duracionEstimada,estatusServicio)
VALUES (4,1,1,"2018-12-01","2018-12-01","2018-12-01","08:30:00","08:30:00","17:00:00","Condominio Camino del Recreo 11",2,"Dos (2) elevadores marca KONE con una capacidad de 450 kg, equivalente a 6 pasajeros, Con 9 niveles, el cual tiene una velocidad de .70 m/s y una corriente alterna de 220 V.",5500.00,"Después de hacer una inspección técnica a dos (2) elevadores de pasajeros marca KONE nos permitimos presentar a su consideración nuestro presupuesto por el servicio de MANTENIMIENTO PREVENTIVO","08:30:00","09:30:00",1);
INSERT INTO servicios (folio,estatusPago,tipoServicio,fechaAgendada,fechaEntrega,fechaSalida,horaAgendada,horaEntrada,horaSalida,nombreServicio,prioridad,descripcion,costo,observaciones,duracionhorasMinutos,duracionEstimada,estatusServicio)
VALUES (5,1,1,"2017-11-10","2017-11-10","2017-11-10","08:30:00","08:30:00","17:00:00","Condominio tOLTECAS 166",2,"Tres elevadores marca Otis (Sigma) con una capacidad de 910 kg c/u, equivalentes a 13 pasajeros, Con 18 niveles, el cual tiene una velocidad de 1.70 m/s y una corriente alterna de 380 V",5400.00,"
Después de hacer una inspección técnica de tres (3) elevador de pasajeros marca OTIS (SIGMA) nos permitimos presentar a su consideración nuestro presupuesto por el servicio de MANTENIMIENTO PREVENTIVO","08:30:00","09:30:00",1);
INSERT INTO servicios (folio,estatusPago,tipoServicio,fechaAgendada,fechaEntrega,fechaSalida,horaAgendada,horaEntrada,horaSalida,nombreServicio,prioridad,descripcion,costo,observaciones,duracionhorasMinutos,duracionEstimada,estatusServicio)
VALUES (6,1,1,"2017-09-24","2017-09-24","2017-09-24","08:30:00","08:30:00","15:00:00","Condominio Arkansas 14",2,"Un (1) elevador marca SCHINDLER EXEL con una capacidad de 560 kg, equivalentes a 8 pasajeros, Con 12 salidas todas al frente",1500.00,"Después de hacer una inspección técnica a un (1) elevador de pasajeros marca SCHINDLER EXEL nos permitimos presentar a su consideración nuestro presupuesto por el servicio de MANTENIMIENTO PREVENTIVO","06:30:00","09:30:00",1);
INSERT INTO servicios (folio,estatusPago,tipoServicio,fechaAgendada,fechaEntrega,fechaSalida,horaAgendada,horaEntrada,horaSalida,nombreServicio,prioridad,descripcion,costo,observaciones,duracionhorasMinutos,duracionEstimada,estatusServicio)
VALUES (7,1,1,"2017-05-24","2017-05-24","2017-05-24","08:30:00","08:30:00","13:00:00","Condominio Campeche 272",2,"Un (1) elevador marca SCHINDLER con una capacidad de 630 kg, equivalentes a 8 pasajeros, Con 9 salidas todas al frente, el cual tienen una velocidad de .1 m/s, sin cuarto de máquinas, 220 vts.",1500.00,"Después de hacer una inspección técnica a un (1) elevador de pasajeros marca SCHINDLER EXEL nos permitimos presentar a su consideración nuestro presupuesto por el servicio de MANTENIMIENTO PREVENTIVO","04:30:00","09:30:00",1);
INSERT INTO servicios (folio,estatusPago,tipoServicio,fechaAgendada,fechaEntrega,fechaSalida,horaAgendada,horaEntrada,horaSalida,nombreServicio,prioridad,descripcion,costo,observaciones,duracionhorasMinutos,duracionEstimada,estatusServicio)
VALUES (8,1,1,"2017-05-24","2017-05-24","2017-05-24","08:30:00","08:30:00","12:00:00","Condominio Gabriel Mancera 1027",2,"Un (1) elevador marca THYSSENKRUPP con una capacidad de 630 kg, equivalentes a 8 pasajeros, Con 7 salidas todas al frente, el cual tienen una velocidad de .1 m/s, sin cuarto de máquinas, 220 vts",1400.00,"Después de hacer una inspección técnica a un (1) elevador de pasajeros marca THYSSENKRUPP nos permitimos presentar a su consideración nuestro presupuesto por el servicio de MANTENIMIENTO PREVENTIVO","03:30:00","09:30:00",1);
INSERT INTO servicios (folio,estatusPago,tipoServicio,fechaAgendada,fechaEntrega,fechaSalida,horaAgendada,horaEntrada,horaSalida,nombreServicio,prioridad,descripcion,costo,observaciones,duracionhorasMinutos,duracionEstimada,estatusServicio)
VALUES (9,1,1,"2019-01-01","2019-01-01","2019-01-01","08:30:00","08:30:00","17:00:00","Condominio Camino del Recreo 11",2,"Dos (2) elevadores marca KONE con una capacidad de 450 kg, equivalente a 6 pasajeros, Con 9 niveles, el cual tiene una velocidad de .70 m/s y una corriente alterna de 220 V.",5500.00,"Después de hacer una inspección técnica a dos (2) elevadores de pasajeros marca KONE nos permitimos presentar a su consideración nuestro presupuesto por el servicio de MANTENIMIENTO PREVENTIVO","08:30:00","09:30:00",1);
INSERT INTO servicios (folio,estatusPago,tipoServicio,fechaAgendada,fechaEntrega,fechaSalida,horaAgendada,horaEntrada,horaSalida,nombreServicio,prioridad,descripcion,costo,observaciones,duracionhorasMinutos,duracionEstimada,estatusServicio)
VALUES (10,1,1,"2017-12-10","2017-12-10","2017-12-10","08:30:00","08:30:00","17:00:00","Condominio tOLTECAS 166",2,"Tres elevadores marca Otis (Sigma) con una capacidad de 910 kg c/u, equivalentes a 13 pasajeros, Con 18 niveles, el cual tiene una velocidad de 1.70 m/s y una corriente alterna de 380 V",5400.00,"
Después de hacer una inspección técnica de tres (3) elevador de pasajeros marca OTIS (SIGMA) nos permitimos presentar a su consideración nuestro presupuesto por el servicio de MANTENIMIENTO PREVENTIVO","08:30:00","09:30:00",1);


INSERT INTO categoriaServicios (claveCategoria,folioServicio)
VALUES
(1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10);

INSERT INTO serviciosProducto (folioServicios, claveProducto, cantidadProducto) VALUES (1,1,2), (2,2,3), (3,3,4), (4,4,5), (5,5,4);

INSERT INTO herramientas (clave, nombre, descripcion)
VALUES (1,"Taladro inalámbrico","Velocidad Doble media pulgada 20V. 16 posiciones de Torque. Potencia 300W"),
(2,"Juego de desarmadores 50 piezas.","Set de desarmadores de 15 piezas. Incluye 4 desarmadores planos 5 desarmadores Phillips 4 desarmadores Torx  2 desarmadores Pozi 4 desarmadores de precisión 1 desarmador de trinquete. 1 extensión de 2. 1 socket de 9 piezas"),
(3,"Máquina para soldar.","Uso industrial básico. 110/220 V 230 Amps. Ciclos de trabajo de 20 Para soldadura 7018. 6013. Acero inoxidable. Aluminio"),
(4,"Juego de pinzas","Juego de 3 pinzas fabricadas con aleación de acero forjado para una mayor durabilidad. Mangos moldeados de doble inyección que proporcionan un agarre acolchonado y antideslizante."),
(5,"Multímetro digital.","El multímetro CL800 digital de gancho de rango automático con media cuadrática real TRMS que mide voltaje, resistencia, continuidad, frecuencia y capacitancia, y prueba diodos con los cables de prueba; y mide temperatura con una sonda de termopar.");

INSERT INTO serviciosHerramientas (folioServicios, claveHerramienta, cantidad) VALUES (1,1,5), (2,2,8), (3,3,3), (4,4,8), (5,5,6);

INSERT INTO formasPago(clave,formaPago)
VALUES(1,"Tarjeta crédito/Débito"),(2,"Pago en Efectivo"),(3,"Pago en Bancos"),(4,"Transferecia bancaria");

INSERT INTO reciboPago(formaPago,folioServicio,fechaEdicion,cantidadPagado)
VALUES(1,1,"2017-11-10",5400),(2,2,"2018-12-01", 5500),(2,3,"2017-04-24", 1400),( 2,4,"2017-04-24", 1500), (2,5,"2017-08-24", 1500),( 2,6,"2018-06-15", 9000),(3,7,"2018-07-16", 5000),( 3,8,"2018-08-17", 5000),( 3,9,"2018-09-18", 5000),( 4,10,"2018-10-19", 5000);

INSERT INTO estatusCotizacion values (1,"Activo");
INSERT INTO estatusCotizacion values (2,"Inactivo");

INSERT INTO cotizacion values (1,1,5500.00,"2018-12-08");
INSERT INTO cotizacion values (2,2,1500.00,"2017-04-24");
INSERT INTO cotizacion values (3,2,1400.00,"2017-04-24 ");

INSERT INTO productosCotizacion(numeroCotizacion,claveProducto,cantidad)
VALUES (1,2,5),(2,1,2),(3,1,1);

INSERT INTO serviciosCotizacion(numeroCotizacion,folioServicios,cantidad) VALUES(
	2,10,1),(2,3,3),(1,7,2
);

INSERT INTO preguntaSecreta(preguntaSecreta) VALUES(
	"¿Cuál fue el nombre de tu primera mascota?"),("¿Cómo se llama la ciudad donde naciste?"),("¿Cómo se llama tu amigo de la primaria?"),("¿Cuál es el trabajo de tus sueños?"
);

INSERT INTO Empresa (clave,nombre)
VALUES (1,"SERCON");
INSERT INTO Empresa (clave,nombre)
VALUES (2,"ICC");
INSERT INTO Empresa (clave,nombre)
VALUES (3,"SAMSARA");
INSERT INTO Empresa (clave,nombre)
VALUES (4,"MABA");

INSERT INTO cliente values (1,1,"Forum Buenavista","BuenaForo",NULL,"2019-06-13","contactoforumB@outlook.com",215,"01 55 5541 7898","Ricardo","Polanco","Reyes","reyespolanco@yahoo.com.mx",1,"AAVU800825569",1,2);
INSERT INTO cliente values (2,1,"Plaza Antara","Pantara",NULL,"2019-06-11","contEscantara@gmail.com",431,"01 55 5511 8766","Alfonso","Morales","Pacheco","AMP_@gmail.com",2,"FLsCA965321009",1,3);
INSERT INTO cliente values (3,1,"Plaza Perisur","PPerisur",NULL,"2019-05-09","pericontactosur@hotmail.com",894,"01 55 5591 8766","Gustavo","Tamez","Galvan","tavotava@outlook.com",3,"SMMG788542016",3,2);
INSERT INTO cliente values (4,1,"Plaza Mundo E","MundoE_plaza",NULL,"2019-04-23","contactamundoE@gmail.com",997,"01 55 5153 3553","Fernanda","Pacheco","Maya","ferpacheco90@gmail.com",4,"MLJF889223605",4,2);
INSERT INTO cliente values (5,1,"Plaza Toreo","Toreoplaza",NULL,"2019-02-22","toreoinfo@gmail.com",556,"01 55 5111 8766","Javier","Hidalgo","Grande","javigrandeh@hotmail.com",1,"COHJ114455237",4,1);

INSERT INTO clienteCotizacion VALUES(
	1,5),(3,3),(2,3
);

INSERT INTO alcaldia(clave,alcaldia,claveCiudad) VALUES(
  1,"Aguascalientes",1),(2,"Asientos",1),(3,"Calvillo",1),(4,"Cosío",1),(5,"El Llano",1),(6,"Jesús María",1),(7,"Pabellón de Arteaga",1),(8,"Rincón de Romos",1),(9,"San Francisco de los Romo",1),(10,"San José de Gracia",1),(11,"Tepezalá",1),
  (12,"Ensenada",2),(13,"Mexicali",2),(14,"Playas de Rosarito",2),(15,"Tecate",2),(16,"Tijuana",2),
  (17,"Comondú",3),(18,"Mulegé",3),(19,"La Paz",3),(20,"Los Cabos",3),(21,"Loreto",3),
  (22,"Calakmul",4),(23,"Calkiní",4),(24,"Campeche",4),(25,"Candelaria",4),(26,"Carmen",4),(27,"Champotón",4),(28,"Escárcega",4),(29,"Hecelchakán",4),(30,"Hopelchén",4),(31,"Palizada",4),(32,"Tenabo",4),
  (33,"Ahumada",5),(34,"Aldama",5),(35,"Allende",5),(36,"Aquiles Serdán",5),(37,"Ascensión",5),(38,"Bachíniva",5),(39,"Balleza",5),(40,"Batopilas",5),(41,"Bocoyna",5),(42,"Buenaventura",5),(43,"Camargo",5),(44,"Carichí",5),(45,"CasasGrandes",5),(46,"Chihuahua",5),(47,"Chínipas",5),(48,"Coronado",5),(49,"Coyame del Sotol",5),(50,"Cuauhtémoc",5),(51,"Cusihuiriachi",5),(52,"Delicias",5),(53,"Belisario Domínguez",5),(54,"El Tule",5),(55,"Galeana",5),(56,"Gómez Farías",5),(57,"Gran Morelos",5),(58,"Guachochi",5),(59,"Guadalupe",5),(60,"Guadalupe y Calvo",5),(61,"Guazapares",5),(62,"Guerrero",5),(63,"Hidalgo del Parral",5),(64,"Huejotitán",5),(65,"Ignacio Zaragoza",5),(66,"Janos",5),(67,"Jiménez",5),(68,"Juárez",5),(69,"Julimes",5),(70,"LaCruz",5),(71,"López",5),(72,"Madera",5),(73,"Maguarichi",5),(74,"Manuel Benavides",5),(75,"Matachí",5),(76,"Matamoros",5),(77,"Meoqui",5),(78,"Morelos",5),(79,"Moris",5),(80,"Namiquipa",5),(81,"Nonoava",5),(82,"Nuevo Casas Grandes",5),(83,"Ocampo",5),(84,"Ojinaga",5),(85,"Praxedis G. Guerrero",5),(86,"Riva Palacio",5),(87,"Rosales",5),(88,"Rosario",5),(89,"San Francisco de Borja",5),(90,"San Francisco de Conchos",5),(91,"San Francisco del Oro",5),(92,"Santa Bárbara",5),(93,"Santa Isabel",5),(94,"Satevó",5),(95,"Saucillo",5),(96,"Temósachic",5),(97,"Urique",5),(98,"Uruachi",5),(99,"Valle de Zaragoza",5),
  (100,"Acacoyagua",6),(101,"Acala",6),(102,"Acapetahua",6),(103,"Altamirano",6),(104,"Amatán",6),(105,"Amatenango de la Frontera",6),(106,"Amatenango del Valle",6),(107,"Ángel Albino Corzo",6),(108,"Arriaga",6),(109,"Bejucal de Ocampo",6),(110,"Bella Vista",6),(111,"Berriozábal",6),(112,"Bochil",6),(113,"El Bosque",6),(114,"Cacahoatán",6),(115,"Catazajá",6),(116,"Cintalapa",6),(117,"Coapilla",6),(118,"Comitán de Domínguez",6),(119,"La Concordia",6),(120,"Copainalá",6),(121,"Chalchihuitán",6),(122,"Chamula",6),(123,"Chanal",6),(124,"Chapultenango",6),(125,"Chenalhó",6),(126,"Chiapa de Corzo",6),(127,"Chiapilla",6),(128,"Chicoasén",6),(129,"Chicomuselo",6),(130,"Chilón",6),(131,"Escuintla",6),(132,"Francisco León",6),(133,"Frontera Comalapa",6),(134,"Frontera Hidalgo",6),(135,"La Grandeza",6),(136,"Huehuetán",6),(137,"Huixtán",6),(138,"Huitiupán",6),(139,"Huixtla",6),(140,"La Independencia",6),(141,"Ixhuatán",6),(142,"Ixtacomitán",6),(143,"Ixtapa",6),(144,"Ixtapangajoya",6),(145,"Jiquipilas",6),(146,"Jitotol",6),(147,"Juárez",6),(148,"Larráinzar",6),(149,"La Libertad",6),(150,"Mapastepec",6),(151,"Las Margaritas",6),(152,"Mazapa de Madero",6),(153,"Mazatán",6),(154,"Metapa",6),(155,"Mitontic",6),(156,"Motozintla",6),(157,"Nicolás Ruíz",6),(158,"Ocosingo",6),(159,"Ocotepec",6),(160,"Ocozocoautla de Espinosa",6),(161,"Ostuacán",6),(162,"Oxchuc",6),(163,"Palenque",6),(164,"Pantelhó",6),(165,"Pantepec",6),(166,"Pichucalco",6),(167,"Pijijiapan",6),(168,"El Porvenir",6),(169,"Villa Comaltitlán",6),(170,"Pueblo Nuevo Solistahuacán",6),(171,"Rayón",6),(172,"Reforma",6),(173,"Las Rosas",6),(174,"Sabanilla",6),(175,"Salto de Agua",6),(176,"San Cristóbal de las Casas",6),(177,"San Fernando",6),(178,"Siltepec",6),(179,"Simojovel",6),(180,"Sitalá",6),(181,"Socoltenango",6),(182,"Solosuchiapa",6),(183,"Soyaló",6),(184,"Suchiapa",6),(185,"Suchiate",6),(186,"Sunuapa",6),(187,"Tapachula",6),(188,"Tapalapa",6),(189,"Tapilula",6),(190,"Tecpatán",6),(191,"Tenejapa",6),(192,"Teopisca",6),(193,"Tila",6),(194,"Tonalá",6),(195,"Totolapa",6),(196,"La Trinitaria",6),(197,"Tumbalá",6),(198,"Tuxtla Gutiérrez",6),(199,"Tuxtla Chico",6),(200,"Tuzantán",6),(201,"Tzimol",6),(202,"Unión Juárez",6),(203,"Venustiano Carranza",6),(204,"Villa Corzo",6),(205,"Villaflores",6),(206,"Yajalón",6),(207,"San Lucas",6),(208,"Zinacantán",6),(209,"San Juan Cancuc",6),(210,"Aldama",6),(211,"Benemérito de las Américas",6),(212,"Maravilla Tenejapa",6),(213,"Marqués de Comillas",6),(214,"Montecristo de Guerrero",6),(215,"San Andrés Duraznal",6),(216,"Santiago el Pinar",6),(217,"El Parral",6),(218,"Emiliano Zapata",6),(219,"Mezcalapa",6),(220,"Belisario Dominguez",6),(221,"Capitán Luis Ángel Vidal",6),(222,"Rincón Chamula San Pedro",6),
  (223,"Abasolo",7),(224,"Acuña",7),(225,"Allende",7),(226,"Arteaga",7),(227,"Candela",7),(228,"Castaños",7),(229,"Cuatro Ciénegas",7),(230,"Escobedo",7),(231,"Francisco I. Madero",7),(232,"Frontera",7),(233,"General Cepeda",7),(234,"Guerrero",7),(235,"Hidalgo",7),(236,"Jiménez",7),(237,"Juárez",7),(238,"Lamadrid",7),(239,"Matamoros",7),(240,"Monclova",7),(241,"Morelos",7),(242,"Múzquiz",7),(243,"Nadadores",7),(244,"Nava",7),(245,"Ocampo",7),(246,"Parras",7),(247,"Piedras Negras",7),(248,"Progreso",7),(249,"Ramos Arizpe",7),(250,"Sabinas",7),(251,"Sacramento",7),(252,"Saltillo",7),(253,"San Buenaventura",7),(254,"San Juan de Sabinas",7),(255,"San Pedro",7),(256,"Sierra Mojada",7),(257,"Torreón",7),(258,"Viesca",7),(259,"Villa Unión",7),(260,"Zaragoza",7),
  (261,"Armería",8),(262,"Colima",8),(263,"Comala",8),(264,"Coquimatlán",8),(265,"Cuauhtémoc",8),(266,"Ixtlahuacán",8),(267,"Manzanillo",8),(268,"Minatitlán",8),(269,"Tecomán",8),(270,"Villa de Álvarez",8),
  (271,"Canatlán",9),(272,"Canelas",9),(273,"Coneto de Comonfort",9),(274,"Cuencamé",9),(275,"Durango",9),(276,"General Simón Bolívar",9),(277,"Gómez Palacio",9),(278,"Guadalupe Victoria",9),(279,"Guanaceví",9),(280,"Hidalgo",9),(281,"Indé",9),(282,"Lerdo",9),(283,"Mapimí",9),(284,"Mezquital",9),(285,"Nazas",9),(286,"Nombre de Dios",9),(287,"Ocampo",9),(288,"El Oro",9),(289,"Otáez",9),(290,"Pánuco de Coronado",9),(291,"Peñón Blanco",9),(292,"Poanas",9),(293,"Pueblo Nuevo",9),(294,"Rodeo",9),(295,"San Bernardo",9),(296,"San Dimas",9),(297,"San Juan de Guadalupe",9),(298,"San Juan del Río",9),(299,"San Luis del Cordero",9),(300,"San Pedro del Gallo",9),(301,"Santa Clara",9),(302,"Santiago Papasquiaro",9),(303,"Súchil",9),(304,"Tamazula",9),(305,"Tepehuanes",9),(306,"Tlahualilo",9),(307,"Topia",9),(308,"Vicente Guerrero",9),(309,"Nuevo Ideal",9),
  (310,"Abasolo",10),(311,"Acámbaro",10),(312,"San Miguel de Allende",10),(313,"Apaseo el Alto",10),(314,"Apaseo el Grande",10),(315,"Atarjea",10),(316,"Celaya",10),(317,"Manuel Doblado",10),(318,"Comonfort",10),(319,"Coroneo",10),(320,"Cortazar",10),(321,"Cuerámaro",10),(322,"Doctor Mora",10),(323,"Dolores Hidalgo Cuna de la Independencia Nacional",10),(324,"Guanajuato",10),(325,"Huanímaro",10),(326,"Irapuato",10),(327,"Jaral del Progreso",10),(328,"Jerécuaro",10),(329,"León",10),(330,"Moroleón",10),(331,"Ocampo",10),(332,"Pénjamo",10),(333,"Pueblo Nuevo",10),(334,"Purísima del Rincón",10),(335,"Romita",10),(336,"Salamanca",10),(337,"Salvatierra",10),(338,"San Diego de la Unión",10),(339,"San Felipe",10),(340,"San Francisco del Rincón",10),(341,"San José Iturbide",10),(342,"San Luis de la Paz",10),(343,"Santa Catarina",10),(344,"Santa Cruz de Juventino Rosas",10),(345,"Santiago Maravatío",10),(346,"Silao de la Victoria",10),(347,"Tarandacuao",10),(348,"Tarimoro",10),(349,"Tierra Blanca",10),(350,"Uriangato",10),(351,"Valle de Santiago",10),(352,"Victoria",10),(353,"Villagrán",10),(354,"Xichú",10),(355,"Yuriria",10),
  (356,"Acapulco de Juárez",11),(357,"Ahuacuotzingo",11),(358,"Ajuchitlán del Progreso",11),(359,"Alcozauca de Guerrero",11),(360,"Alpoyeca",11),(361,"Apaxtla",11),(362,"Arcelia",11),(363,"Atenango del Río",11),(364,"Atlamajalcingo del Monte",11),(365,"Atlixtac",11),(366,"Atoyac de Álvarez",11),(367,"Ayutla de los Libres",11),(368,"Azoyú",11),(369,"Benito Juárez",11),(370,"Buenavista de Cuéllar",11),(371,"Coahuayutla de José María Izazaga",11),(372,"Cocula",11),(373,"Copala",11),(374,"Copalillo",11),(375,"Copanatoyac",11),(376,"Coyuca de Benítez",11),(377,"Coyuca de Catalán",11),(378,"Cuajinicuilapa",11),(379,"Cualác",11),(380,"Cuautepec",11),(381,"Cuetzala del Progreso",11),(382,"Cutzamala de Pinzón",11),(383,"Chilapa de Álvarez",11),(384,"Chilpancingo de los Bravo",11),(385,"Florencio Villarreal",11),(386,"General Canuto A. Neri",11),(387,"General Heliodoro Castillo",11),(388,"Huamuxtitlán",11),(389,"Huitzuco de los Figueroa",11),(390,"Iguala de la Independencia",11),(391,"Igualapa",11),(392,"Ixcateopan de Cuauhtémoc",11),(393,"Zihuatanejo de Azueta",11),(394,"Juan R. Escudero",11),(395,"Leonardo Bravo",11),(396,"Malinaltepec",11),(397,"Mártir de Cuilapan",11),(398,"Metlatónoc",11),(399,"Mochitlán",11),(400,"Olinalá",11),(401,"Ometepec",11),(402,"Pedro Ascencio Alquisiras",11),(403,"Petatlán",11),(404,"Pilcaya",11),(405,"Pungarabato",11),(406,"Quechultenango",11),(407,"San Luis Acatlán",11),(408,"San Marcos",11),(409,"San Miguel Totolapan",11),(410,"Taxco de Alarcón",11),(411,"Tecoanapa",11),(412,"Técpan de Galeana",11),(413,"Teloloapan",11),(414,"Tepecoacuilco de Trujano",11),(415,"Tetipac",11),(416,"Tixtla de Guerrero",11),(417,"Tlacoachistlahuaca",11),(418,"Tlacoapa",11),(419,"Tlalchapa",11),(420,"Tlalixtaquilla de Maldonado",11),(421,"Tlapa de Comonfort",11),(422,"Tlapehuala",11),(423,"La Unión de Isidoro Montes de Oca",11),(424,"Xalpatláhuac",11),(425,"Xochihuehuetlán",11),(426,"Xochistlahuaca",11),(427,"Zapotitlán Tablas",11),(428,"Zirándaro",11),(429,"Zitlala",11),(430,"Eduardo Neri",11),(431,"Acatepec",11),(432,"Marquelia",11),(433,"Cochoapa el Grande",11),(434,"José Joaquín de Herrera",11),(435,"Juchitán",11),(436,"Iliatenco",11),
  (437,"Acatlán",12),(438,"Acaxochitlán",12),(439,"Actopan",12),(440,"Agua Blanca de Iturbide",12),(441,"Ajacuba",12),(442,"Alfajayucan",12),(443,"Almoloya",12),(444,"Apan",12),(445,"El Arenal",12),(446,"Atitalaquia",12),(447,"Atlapexco",12),(448,"Atotonilco el Grande",12),(449,"Atotonilco de Tula",12),(450,"Calnali",12),(451,"Cardonal",12),(452,"Cuautepec de Hinojosa",12),(453,"Chapantongo",12),(454,"Chapulhuacán",12),(455,"Chilcuautla",12),(456,"Eloxochitlán",12),(457,"Emiliano Zapata",12),(458,"Epazoyucan",12),(459,"Franciso I. Madero",12),(460,"Huasca de Ocampo",12),(461,"Huautla",12),(462,"Huazalingo",12),(463,"Huehuetla",12),(464,"Huejutla de Reyes",12),(465,"Huichapan",12),(466,"Ixmiquilpan",12),(467,"Jacala de Ledezma",12),(468,"Jaltocán",12),(469,"Juárez Hidalgo",12),(470,"Lolotla",12),(471,"Metepec",12),(472,"San Agustín Metzquititlán",12),(473,"Metztitlán",12),(474,"Mineral del Chico",12),(475,"Mineral del Monte",12),(476,"La Misión",12),(477,"Mixquiahuala de Juárez",12),(478,"Molango de Escamilla",12),(479,"Nicolás Flores",12),(480,"Nopala de Villagrán",12),(481,"Omitlán de Juárez",12),(482,"San Felipe Orizatlán",12),(483,"Pacula",12),(484,"Pachuca de Soto",12),(485,"Pisaflores",12),(486,"Progreso de Obregón",12),(487,"Mineral de la Reforma",12),(488,"San Agustín Tlaxiaca",12),(489,"San Bartolo Tutotepec",12),(490,"San Salvador",12),(491,"Santiago de Anaya",12),(492,"Santiago Tulantepec de Lugo Guerrero",12),(493,"Singuilucan",12),(494,"Tasquillo",12),(495,"Tecozautla",12),(496,"Tenango de Doria",12),(497,"Tepeapulco",12),(498,"Tepehuacán de Guerrero",12),(499,"Tepeji del Río de Ocampo",12),(500,"Tepetitlán",12),(501,"Tetepango",12),(502,"Villa de Tezontepec",12),(503,"Tezontepec de Aldama",12),(504,"Tianguistengo",12),(505,"Tizayuca",12),(506,"Tlahuelilpan",12),(507,"Tlahuiltepa",12),(508,"Tlanalapa",12),(509,"Tlanchinol",12),(510,"Tlaxcoapan",12),(511,"Tolcayuca",12),(512,"Tula de Allende",12),(513,"Tulancingo de Bravo",12),(514,"Xochiatipan",12),(515,"Xochicoatlán",12),(516,"Yahualica",12),(517,"Zacualtipán de Ángeles",12),(518,"Zapotlán de Juárez",12),(519,"Zempoala",12),(520,"Zimapán",12),
  (521,"Acatic",13),(522,"Acatlán de Juárez",13),(523,"Ahualulco de Mercado",13),(524,"Amacueca",13),(525,"Amatitán",13),(526,"Ameca",13),(527,"San Juanito de Escobedo",13),(528,"Arandas",13),(529,"El Arenal",13),(530,"Atemajac de Brizuela",13),(531,"Atengo",13),(532,"Atenguillo",13),(533,"Atotonilco el Alto",13),(534,"Atoyac",13),(535,"Autlán de Navarro",13),(536,"Ayotlán",13),(537,"Ayutla",13),(538,"La Barca",13),(539,"Bolaños",13),(540,"Cabo Corrientes",13),(541,"Casimiro Castillo",13),(542,"Cihuatlán",13),(543,"Zapotlán el Grande",13),(544,"Cocula",13),(545,"Colotlán",13),(546,"Concepción de Buenos Aires",13),(547,"Cuautitlán de García Barragán",13),(548,"Cuautla",13),(549,"Cuquío",13),(550,"Chapala",13),(551,"Chimaltitán",13),(552,"Chiquilistlán",13),(553,"Degollado",13),(554,"Ejutla",13),(555,"Encarnación de Díaz",13),(556,"Etzatlán",13),(557,"El Grullo",13),(558,"Guachinango",13),(559,"Guadalajara",13),(560,"Hostotipaquillo",13),(561,"Huejúcar",13),(562,"Huejuquilla el Alto",13),(563,"La Huerta",13),(564,"Ixtlahuacán de los Membrillos",13),(565,"Ixtlahuacán del Río",13),(566,"Jalostotitlán",13),(567,"Jamay",13),(568,"Jesús María",13),(569,"Jilotlán de los Dolores",13),(570,"Jocotepec",13),(571,"Juanacatlán",13),(572,"Juchitlán",13),(573,"Lagos de Moreno",13),(574,"El Limón",13),(575,"Magdalena",13),(576,"Santa María del Oro",13),(577,"La Manzanilla de la Paz",13),(578,"Mascota",13),(579,"Mazamitla",13),(580,"Mexticacán",13),(581,"Mezquitic",13),(582,"Mixtlán",13),(583,"Ocotlán",13),(584,"Ojuelos de Jalisco",13),(585,"Pihuamo",13),(586,"Poncitlán",13),(587,"Puerto Vallarta",13),(588,"Villa Purificación",13),(589,"Quitupan",13),(590,"El Salto",13),(591,"San Cristóbal de la Barranca",13),(592,"San Diego de Alejandría",13),(593,"San Juan de los Lagos",13),(594,"San Julián",13),(595,"San Marcos",13),(596,"San Martín de Bolaños",13),(597,"San Martín Hidalgo",13),(598,"San Miguel el Alto",13),(599,"Gómez Farías",13),(600,"San Sebastián del Oeste",13),(601,"Santa María de los Ángeles",13),(602,"Sayula",13),(603,"Tala",13),(604,"Talpa de Allende",13),(605,"Tamazula de Gordiano",13),(606,"Tapalpa",13),(607,"Tecalitlán",13),(608,"Techaluta de Montenegro",13),(609,"Tecolotlán",13),(610,"Tenamaxtlán",13),(611,"Teocaltiche",13),(612,"Teocuitatlán de Corona",13),(613,"Tepatitlán de Morelos",13),(614,"Tequila",13),(615,"Teuchitlán",13),(616,"Tizapán el Alto",13),(617,"Tlajomulco de Zúñiga",13),(618,"Tlaquepaque",13),(619,"Tolimán",13),(620,"Tomatlán",13),(621,"Tonalá",13),(622,"Tonaya",13),(623,"Tonila",13),(624,"Totatiche",13),(625,"Tototlán",13),(626,"Tuxcacuesco",13),(627,"Tuxcueca",13),(628,"Tuxpan",13),(629,"Unión de San Antonio",13),(630,"Unión de Tula",13),(631,"Valle de Guadalupe",13),(632,"Valle de Juárez",13),(633,"San Gabriel",13),(634,"Villa Corona",13),(635,"Villa Guerrero",13),(636,"Villa Hidalgo",13),(637,"Cañadas de Obregón",13),(638,"Yahualica de González Gallo",13),(639,"Zacoalco de Torres",13),(640,"Zapopan",13),(641,"Zapotiltic",13),(642,"Zapotitlán de Vadillo",13),(643,"Zapotlán del Rey",13),(644,"Zapotlanejo",13),(645,"San Ignacio Cerro Gordo",13),
  (646,"Acambay",14),(647,"Acolman",14),(648,"Aculco",14),(649,"Almoloya de Alquisiras",14),(650,"Almoloya de Juárez",14),(651,"Almoloya del Río",14),(652,"Amanalco",14),(653,"Amatepec",14),(654,"Amecameca",14),(655,"Apaxco",14),(656,"Atenco",14),(657,"Atizapán",14),(658,"Atizapán de Zaragoza",14),(659,"Atlacomulco",14),(660,"Atlautla",14),(661,"Axapusco",14),(662,"Ayapango",14),(663,"Calimaya",14),(664,"Capulhuac",14),(665,"Coacalco de Berriozábal",14),(666,"Coatepec Harinas",14),(667,"Cocotitlán",14),(668,"Coyotepec",14),(669,"Cuautitlán",14),(670,"Chalco",14),(671,"Chapa de Mota",14),(672,"Chapultepec",14),(673,"Chiautla",14),(674,"Chicoloapan",14),(675,"Chiconcuac",14),(676,"Chimalhuacán",14),(677,"Donato Guerra",14),(678,"Ecatepec de Morelos",14),(679,"Ecatzingo",14),(680,"Huehuetoca",14),(681,"Hueypoxtla",14),(682,"Huixquilucan",14),(683,"Isidro Fabela",14),(684,"Ixtapaluca",14),(685,"Ixtapan de la Sal",14),(686,"Ixtapan del Oro",14),(687,"Ixtlahuaca",14),(688,"Xalatlaco",14),(689,"Jaltenco",14),(690,"Jilotepec",14),(691,"Jilotzingo",14),(692,"Jiquipilco",14),(693,"Jocotitlán",14),(694,"Joquicingo",14),(695,"Juchitepec",14),(696,"Lerma",14),(697,"Malinalco",14),(698,"Melchor Ocampo",14),(699,"Metepec",14),(700,"Mexicaltzingo",14),(701,"Morelos",14),(702,"Naucalpan de Juárez",14),(703,"Nezahualcóyotl",14),(704,"Nextlalpan",14),(705,"Nicolás Romero",14),(706,"Nopaltepec",14),(707,"Ocoyoacac",14),(708,"Ocuilan",14),(709,"El Oro",14),(710,"Otumba",14),(711,"Otzoloapan",14),(712,"Otzolotepec",14),(713,"Ozumba",14),(714,"Papalotla",14),(715,"La Paz",14),(716,"Polotitlán",14),(717,"Rayón",14),(718,"San Antonio la Isla",14),(719,"San Felipe del Progreso",14),(720,"San Martín de las Pirámides",14),(721,"San Mateo Atenco",14),(722,"San Simón de Guerrero",14),(723,"Santo Tomás",14),(724,"Soyaniquilpan de Juárez",14),(725,"Sultepec",14),(726,"Tecámac",14),(727,"Tejupilco",14),(728,"Temamatla",14),(729,"Temascalapa",14),(730,"Temascalcingo",14),(731,"Temascaltepec",14),(732,"Temoaya",14),(733,"Tenancingo",14),(734,"Tenango del Aire",14),(735,"Tenango del Valle",14),(736,"Teoloyucan",14),(737,"Teotihuacán",14),(738,"Tepetlaoxtoc",14),(739,"Tepetlixpa",14),(740,"Tepotzotlán",14),(741,"Tequixquiac",14),(742,"Texcaltitlán",14),(743,"Texcalyacac",14),(744,"Texcoco",14),(745,"Tezoyuca",14),(746,"Tianguistenco",14),(747,"Timilpan",14),(748,"Tlalmanalco",14),(749,"Tlalnepantla de Baz",14),(750,"Tlatlaya",14),(751,"Toluca",14),(752,"Tonatico",14),(753,"Tultepec",14),(754,"Tultitlán",14),(755,"Valle de Bravo",14),(756,"Villa de Allende",14),(757,"Villa del Carbón",14),(758,"Villa Guerrero",14),(759,"Villa Victoria",14),(760,"Xonacatlán",14),(761,"Zacazonapan",14),(762,"Zacualpan",14),(763,"Zinacantepec",14),(764,"Zumpahuacán",14),(765,"Zumpango",14),(766,"Cuautitlán Izcalli",14),(767,"Valle de Chalco Solidaridad",14),(768,"Luvianos",14),(769,"San José del Rincón",14),(770,"Tonanitla",14),
  (771,"Acuitzio",15),(772,"Aguililla",15),(773,"Álvaro Obregón",15),(774,"Angamacutiro",15),(775,"Angangueo",15),(776,"Apatzingán",15),(777,"Aporo",15),(778,"Aquila",15),(779,"Ario",15),(780,"Arteaga",15),(781,"Briseñas",15),(782,"Buenavista",15),(783,"Carácuaro",15),(784,"Coahuayana",15),(785,"Coalcomán de Vázquez Pallares",15),(786,"Coeneo",15),(787,"Contepec",15),(788,"Copándaro",15),(789,"Cotija",15),(790,"Cuitzeo",15),(791,"Charapan",15),(792,"Charo",15),(793,"Chavinda",15),(794,"Cherán",15),(795,"Chilchota",15),(796,"Chinicuila",15),(797,"Chucándiro",15),(798,"Churintzio",15),(799,"Churumuco",15),(800,"Ecuandureo",15),(801,"Epitacio Huerta",15),(802,"Erongarícuaro",15),(803,"Gabriel Zamora",15),(804,"Hidalgo",15),(805,"La Huacana",15),(806,"Huandacareo",15),(807,"Huaniqueo",15),(808,"Huetamo",15),(809,"Huiramba",15),(810,"Indaparapeo",15),(811,"Irimbo",15),(812,"Ixtlán",15),(813,"Jacona",15),(814,"Jiménez",15),(815,"Jiquilpan",15),(816,"Juárez",15),(817,"Jungapeo",15),(818,"Lagunillas",15),(819,"Madero",15),(820,"Maravatío",15),(821,"Marcos Castellanos",15),(822,"Lázaro Cárdenas",15),(823,"Morelia",15),(824,"Morelos",15),(825,"Múgica",15),(826,"Nahuatzen",15),(827,"Nocupétaro",15),(828,"Nuevo Parangaricutiro",15),(829,"Nuevo Urecho",15),(830,"Numarán",15),(831,"Ocampo",15),(832,"Pajacuarán",15),(833,"Panindícuaro",15),(834,"Parácuaro",15),(835,"Paracho",15),(836,"Pátzcuaro",15),(837,"Penjamillo",15),(838,"Peribán",15),(839,"La Piedad",15),(840,"Purépero",15),(841,"Puruándiro",15),(842,"Queréndaro",15),(843,"Quiroga",15),(844,"Cojumatlán de Régules",15),(845,"Los Reyes",15),(846,"Sahuayo",15),(847,"San Lucas",15),(848,"Santa Ana Maya",15),(849,"Salvador Escalante",15),(850,"Senguio",15),(851,"Susupuato",15),(852,"Tacámbaro",15),(853,"Tancítaro",15),(854,"Tangamandapio",15),(855,"Tangancícuaro",15),(856,"Tanhuato",15),(857,"Taretan",15),(858,"Tarímbaro",15),(859,"Tepalcatepec",15),(860,"Tingambato",15),(861,"Tingüindín",15),(862,"Tiquicheo de Nicolás Romero",15),(863,"Tlalpujahua",15),(864,"Tlazazalca",15),(865,"Tocumbo",15),(866,"Tumbiscatío",15),(867,"Turicato",15),(868,"Tuxpan",15),(869,"Tuzantla",15),(870,"Tzintzuntzan",15),(871,"Tzitzio",15),(872,"Uruapan",15),(873,"Venustiano Carranza",15),(874,"Villamar",15),(875,"Vista Hermosa",15),(876,"Yurécuaro",15),(877,"Zacapu",15),(878,"Zamora",15),(879,"Zináparo",15),(880,"Zinapécuaro",15),(881,"Ziracueretiro",15),(882,"Zitácuaro",15),(883,"José Sixto Verduzco",15),
  (884,"Amacuzac",16),(885,"Atlatlahucan",16),(886,"Axochiapan",16),(887,"Ayala",16),(888,"Coatlán del Río (municipio)",16),(889,"Cuautla (municipio)",16),(890,"Cuernavaca",16),(891,"Emiliano Zapata",16),(892,"Huitzilac",16),(893,"Jantetelco",16),(894,"Jiutepec",16),(895,"Jojutla",16),(896,"Jonacatepec",16),(897,"Mazatepec",16),(898,"Miacatlán",16),(899,"Ocuituco",16),(900,"Puente de Ixtla",16),(901,"Temixco",16),(902,"Tepalcingo",16),(903,"Tepoztlán",16),(904,"Tetecala",16),(905,"Tetela del Volcán",16),(906,"Tlalnepantla",16),(907,"Tlaltizapán",16),(908,"Tlaquiltenango",16),(909,"Tlayacapan",16),(910,"Totolapan",16),(911,"Xochitepec",16),(912,"Yautepec",16),(913,"Yecapixtla",16),(914,"Zacatepec",16),(915,"Zacualpan",16),(916,"Temoac",16),(917,"Coatetelco",16),(918,"Tetelcingo",16),(919,"Hueyapan",16),(920,"Xoxocotla",16),
  (921,"Acaponeta",17),(922,"Ahuacatlán",17),(923,"Amatlán de Cañas",17),(924,"Compostela",17),(925,"Huajicori",17),(926,"Ixtlán del Río",17),(927,"Jala",17),(928,"Xalisco",17),(929,"El Nayar",17),(930,"Rosamorada",17),(931,"Ruiz",17),(932,"San Blas",17),(933,"San Pedro Lagunillas",17),(934,"Santa María del Oro",17),(935,"Santiago Ixcuintla",17),(936,"Tecuala",17),(937,"Tepic",17),(938,"Tuxpan",17),(939,"La Yesca",17),(940,"Bahía de Banderas",17),
  (941,"Abasolo",18),(942,"Agualeguas",18),(943,"Los Aldamas",18),(944,"Allende",18),(945,"Anáhuac",18),(946,"Apodaca",18),(947,"Aramberri",18),(948,"Bustamante",18),(949,"Cadereyta Jiménez",18),(950,"Carmen",18),(951,"Cerralvo",18),(952,"Ciénega de Flores",18),(953,"China",18),(954,"Doctor Arroyo",18),(955,"Doctor Coss",18),(956,"Doctor González",18),(957,"Galeana",18),(958,"García",18),(959,"San Pedro Garza García",18),(960,"General Bravo",18),(961,"General Escobedo",18),(962,"General Terán",18),(963,"General Treviño",18),(964,"General Zaragoza",18),(965,"General Zuazua",18),(966,"Guadalupe",18),(967,"Los Herreras",18),(968,"Higueras",18),(969,"Hualahuises",18),(970,"Iturbide",18),(971,"Juárez",18),(972,"Lampazos de Naranjo",18),(973,"Linares",18),(974,"Marín",18),(975,"Melchor Ocampo",18),(976,"Mier y Noriega",18),(977,"Mina",18),(978,"Montemorelos",18),(979,"Monterrey ",18),(980,"Parás",18),(981,"Pesquería",18),(982,"Los Ramones",18),(983,"Rayones",18),(984,"Sabinas Hidalgo",18),(985,"Salinas Victoria",18),(986,"San Nicolás de los Garza",18),(987,"Hidalgo",18),(988,"Santa Catarina",18),(989,"Santiago",18),(990,"Vallecillo",18),(991,"Villaldama",18),
  (992,"Abejones",19),(993,"Acatlán de Pérez Figueroa",19),(994,"Asunción Cacalotepec",19),(995,"Asunción Cuyotepeji",19),(996,"Asunción Ixtaltepec",19),(997,"Asunción Nochixtlán",19),(998,"Asunción Ocotlán",19),(999,"Asunción Tlacolulita",19),(1000,"Ayotzintepec",19),(1001,"El Barrio de la Soledad",19),(1002,"Calihualá",19),(1003,"Candelaria Loxicha",19),(1004,"Ciénega de Zimatlán",19),(1005,"Ciudad Ixtepec",19),(1006,"Coatecas Altas",19),(1007,"Coicoyán de las Flores",19),(1008,"La Compañía",19),(1009,"Concepción Buenavista",19),(1010,"Concepción Pápalo",19),(1011,"Constancia del Rosario",19),(1012,"Cosolapa",19),(1013,"Cosoltepec",19),(1014,"Cuilápam de Guerrero",19),(1015,"Cuyamecalco Villa de Zaragoza",19),(1016,"Chahuites",19),(1017,"Chalcatongo de Hidalgo",19),(1018,"Chiquihuitlán de Benito Juárez",19),(1019,"Heroica Ciudad de Ejutla de Crespo",19),(1020,"Eloxochitlán de Flores Magón",19),(1021,"El Espinal",19),(1022,"Tamazulápam del Espíritu Santo",19),(1023,"Fresnillo de Trujano",19),(1024,"Guadalupe Etla",19),(1025,"Guadalupe de Ramírez",19),(1026,"Guelatao de Juárez",19),(1027,"Guevea de Humboldt",19),(1028,"Mesones Hidalgo",19),(1029,"Villa Hidalgo",19),(1030,"Heroica Ciudad de Huajuapan de León",19),(1031,"Huautepec",19),(1032,"Huautla de Jiménez",19),(1033,"Ixtlán de Juárez",19),(1034,"Heroica Ciudad de Juchitán de Zaragoza",19),(1035,"Loma Bonita",19),(1036,"Magdalena Apasco",19),(1037,"Magdalena Jaltepec",19),(1038,"Santa Magdalena Jicotlán",19),(1039,"Magdalena Mixtepec",19),(1040,"Magdalena Ocotlán",19),(1041,"Magdalena Peñasco",19),(1042,"Magdalena Teitipac",19),(1043,"Magdalena Tequisistlán",19),(1044,"Magdalena Tlacotepec",19),(1045,"Magdalena Zahuatlán",19),(1046,"Mariscala de Juárez",19),(1047,"Mártires de Tacubaya",19),(1048,"Matías Romero Avendaño",19),(1049,"Mazatlán Villa de Flores",19),(1050,"Miahuatlán de Porfirio Díaz",19),(1051,"Mixistlán de la Reforma",19),(1052,"Monjas",19),(1053,"Natividad",19),(1054,"Nazareno Etla",19),(1055,"Nejapa de Madero",19),(1056,"Ixpantepec Nieves",19),(1057,"Santiago Niltepec",19),(1058,"Oaxaca de Juárez",19),(1059,"Ocotlán de Morelos",19),(1060,"La Pe",19),(1061,"Pinotepa de Don Luis",19),(1062,"Pluma Hidalgo",19),(1063,"San José del Progreso",19),(1064,"Putla Villa de Guerrero",19),(1065,"Santa Catarina Quioquitani",19),(1066,"Reforma de Pineda",19),(1067,"La Reforma",19),(1068,"Reyes Etla",19),(1069,"Rojas de Cuauhtémoc",19),(1070,"Salina Cruz",19),(1071,"San Agustín Amatengo",19),(1072,"San Agustín Atenango",19),(1073,"San Agustín Chayuco",19),(1074,"San Agustín de las Juntas",19),(1075,"San Agustín Etla",19),(1076,"San Agustín Loxicha",19),(1077,"San Agustín Tlacotepec",19),(1078,"San Agustín Yatareni",19),(1079,"San Andrés Cabecera Nueva",19),(1080,"San Andrés Dinicuiti",19),(1081,"San Andrés Huaxpaltepec",19),(1082,"San Andrés Huayapam",19),(1083,"San Andrés Ixtlahuaca",19),(1084,"San Andrés Lagunas",19),(1085,"San Andrés Nuxiño",19),(1086,"San Andrés Paxtlán",19),(1087,"San Andrés Sinaxtla",19),(1088,"San Andrés Solaga",19),(1089,"San Andrés Teotilálpam",19),(1090,"San Andrés Tepetlapa",19),(1091,"San Andrés Yaá",19),(1092,"San Andrés Zabache",19),(1093,"San Andrés Zautla",19),(1094,"San Antonino Castillo Velasco",19),(1095,"San Antonino el Alto",19),(1096,"San Antonino Monte Verde",19),(1097,"San Antonio Acutla",19),(1098,"San Antonio de la Cal",19),(1099,"San Antonio Huitepec",19),(1100,"San Antonio Nanahuatipam",19),(1101,"San Antonio Sinicahua",19),(1102,"San Antonio Tepetlapa",19),(1103,"San Baltazar Chichicapam",19),(1104,"San Baltazar Loxicha",19),(1105,"San Baltazar Yatzachi el Bajo",19),(1106,"San Bartolo Coyotepec",19),(1107,"San Bartolomé Ayautla",19),(1108,"San Bartolomé Loxicha",19),(1109,"San Bartolomé Quialana",19),(1110,"San Bartolomé Yucuañe",19),(1111,"San Bartolomé Zoogocho",19),(1112,"San Bartolo Soyaltepec",19),(1113,"San Bartolo Yautepec",19),(1114,"San Bernardo Mixtepec",19),(1115,"San Blas Atempa",19),(1116,"San Carlos Yautepec",19),(1117,"San Cristóbal Amatlán",19),(1118,"San Cristóbal Amoltepec",19),(1119,"San Cristóbal Lachirioag",19),(1120,"San Cristóbal Suchixtlahuaca",19),(1121,"San Dionisio del Mar",19),(1122,"San Dionisio Ocotepec",19),(1123,"San Dionisio Ocotlán",19),(1124,"San Esteban Atatlahuca",19),(1125,"San Felipe Jalapa de Díaz",19),(1126,"San Felipe Tejalapam",19),(1127,"San Felipe Usila",19),(1128,"San Francisco Cahuacúa",19),(1129,"San Francisco Cajonos",19),(1130,"San Francisco Chapulapa",19),(1131,"San Francisco Chindúa",19),(1132,"San Francisco del Mar",19),(1133,"San Francisco Huehuetlán",19),(1134,"San Francisco Ixhuatán",19),(1135,"San Francisco Jaltepetongo",19),(1136,"San Francisco Lachigoló",19),(1137,"San Francisco Logueche",19),(1138,"San Francisco Nuxaño",19),(1139,"San Francisco Ozolotepec",19),(1140,"San Francisco Sola",19),(1141,"San Francisco Telixtlahuaca",19),(1142,"San Francisco Teopan",19),(1143,"San Francisco Tlapancingo",19),(1144,"San Gabriel Mixtepec",19),(1145,"San Ildefonso Amatlán",19),(1146,"San Ildefonso Sola",19),(1147,"San Ildefonso Villa Alta",19),(1148,"San Jacinto Amilpas",19),(1149,"San Jacinto Tlacotepec",19),(1150,"San Jerónimo Coatlán",19),(1151,"San Jerónimo Silacayoapilla",19),(1152,"San Jerónimo Sosola",19),(1153,"San Jerónimo Taviche",19),(1154,"San Jerónimo Tecoatl",19),(1155,"San Jorge Nuchita",19),(1156,"San José Ayuquila",19),(1157,"San José Chiltepec",19),(1158,"San José del Peñasco",19),(1159,"San José Estancia Grande",19),(1160,"San José Independencia",19),(1161,"San José Lachiguirí",19),(1162,"San José Tenango",19),(1163,"San Juan Achiutla",19),(1164,"San Juan Atepec",19),(1165,"Ánimas Trujano",19),(1166,"San Juan Bautista Atatlahuca",19),(1167,"San Juan Bautista Coixtlahuaca",19),(1168,"San Juan Bautista Cuicatlán",19),(1169,"San Juan Bautista Guelache",19),(1170,"San Juan Bautista Jayacatlán",19),(1171,"San Juan Bautista Lo de Soto",19),(1172,"San Juan Bautista Suchitepec",19),(1173,"San Juan Bautista Tlacoatzintepec",19),(1174,"San Juan Bautista Tlachichilco",19),(1175,"San Juan Bautista Tuxtepec",19),(1176,"San Juan Cacahuatepec",19),(1177,"San Juan Cieneguilla",19),(1178,"San Juan Coatzospam",19),(1179,"San Juan Colorado",19),(1180,"San Juan Comaltepec",19),(1181,"San Juan Cotzocón",19),(1182,"San Juan Chicomezúchil",19),(1183,"San Juan Chilateca",19),(1184,"San Juan del Estado",19),(1185,"San Juan del Río",19),(1186,"San Juan Diuxi",19),(1187,"San Juan Evangelista Analco",19),(1188,"San Juan Guelavía",19),(1189,"San Juan Guichicovi",19),(1190,"San Juan Ihualtepec",19),(1191,"San Juan Juquila Mixes",19),(1192,"San Juan Juquila Vijanos",19),(1193,"San Juan Lachao",19),(1194,"San Juan Lachigalla",19),(1195,"San Juan Lajarcia",19),(1196,"San Juan Lalana",19),(1197,"San Juan de los Cués",19),(1198,"San Juan Mazatlán",19),(1199,"San Juan Mixtepec -Distrito 08-",19),(1200,"San Juan Mixtepec -Distrito 26-",19),(1201,"San Juan Ñumí",19),(1202,"San Juan Ozolotepec",19),(1203,"San Juan Petlapa",19),(1204,"San Juan Quiahije",19),(1205,"San Juan Quiotepec",19),(1206,"San Juan Sayultepec",19),(1207,"San Juan Tabaá",19),(1208,"San Juan Tamazola",19),(1209,"San Juan Teita",19),(1210,"San Juan Teitipac",19),(1211,"San Juan Tepeuxila",19),(1212,"San Juan Teposcolula",19),(1213,"San Juan Yaeé",19),(1214,"San Juan Yatzona",19),(1215,"San Juan Yucuita",19),(1216,"San Lorenzo",19),(1217,"San Lorenzo Albarradas",19),(1218,"San Lorenzo Cacaotepec",19),(1219,"San Lorenzo Cuaunecuiltitla",19),(1220,"San Lorenzo Texmelucan",19),(1221,"San Lorenzo Victoria",19),(1222,"San Lucas Camotlán",19),(1223,"San Lucas Ojitlán",19),(1224,"San Lucas Quiaviní",19),(1225,"San Lucas Zoquiápam",19),(1226,"San Luis Amatlán",19),(1227,"San Marcial Ozolotepec",19),(1228,"San Marcos Arteaga",19),(1229,"San Martín de los Cansecos",19),(1230,"San Martín Huamelúlpam",19),(1231,"San Martín Itunyoso",19),(1232,"San Martín Lachilá",19),(1233,"San Martín Peras",19),(1234,"San Martín Tilcajete",19),(1235,"San Martín Toxpalan",19),(1236,"San Martín Zacatepec",19),(1237,"San Mateo Cajonos",19),(1238,"Capulálpam de Méndez",19),(1239,"San Mateo del Mar",19),(1240,"San Mateo Yoloxochitlán",19),(1241,"San Mateo Etlatongo",19),(1242,"San Mateo Nejapam",19),(1243,"San Mateo Peñasco",19),(1244,"San Mateo Piñas",19),(1245,"San Mateo Río Hondo",19),(1246,"San Mateo Sindihui",19),(1247,"San Mateo Tlapiltepec",19),(1248,"San Melchor Betaza",19),(1249,"San Miguel Achiutla",19),(1250,"San Miguel Ahuehuetitlán",19),(1251,"San Miguel Aloápam",19),(1252,"San Miguel Amatitlán",19),(1253,"San Miguel Amatlán",19),(1254,"San Miguel Coatlán",19),(1255,"San Miguel Chicahua",19),(1256,"San Miguel Chimalapa",19),(1257,"San Miguel del Puerto",19),(1258,"San Miguel del Río",19),(1259,"San Miguel Ejutla",19),(1260,"San Miguel el Grande",19),(1261,"San Miguel Huautla",19),(1262,"San Miguel Mixtepec",19),(1263,"San Miguel Panixtlahuaca",19),(1264,"San Miguel Peras",19),(1265,"San Miguel Piedras",19),(1266,"San Miguel Quetzaltepec",19),(1267,"San Miguel Santa Flor",19),(1268,"Villa Sola de Vega",19),(1269,"San Miguel Soyaltepec",19),(1270,"San Miguel Suchixtepec",19),(1271,"Villa Talea de Castro",19),(1272,"San Miguel Tecomatlán",19),(1273,"San Miguel Tenango",19),(1274,"San Miguel Tequixtepec",19),(1275,"San Miguel Tilquiápam",19),(1276,"San Miguel Tlacamama",19),(1277,"San Miguel Tlacotepec",19),(1278,"San Miguel Tulancingo",19),(1279,"San Miguel Yotao",19),(1280,"San Nicolás",19),(1281,"San Nicolás Hidalgo",19),(1282,"San Pablo Coatlán",19),(1283,"San Pablo Cuatro Venados",19),(1284,"San Pablo Etla",19),(1285,"San Pablo Huitzo",19),(1286,"San Pablo Huixtepec",19),(1287,"San Pablo Macuiltianguis",19),(1288,"San Pablo Tijaltepec",19),(1289,"San Pablo Villa de Mitla",19),(1290,"San Pablo Yaganiza",19),(1291,"San Pedro Amuzgos",19),(1292,"San Pedro Apóstol",19),(1293,"San Pedro Atoyac",19),(1294,"San Pedro Cajonos",19),(1295,"San Pedro Coxcaltepec Cántaros",19),(1296,"San Pedro Comitancillo",19),(1297,"San Pedro El Alto",19),(1298,"San Pedro Huamelula",19),(1299,"San Pedro Huilotepec",19),(1300,"San Pedro Ixcatlán",19),(1301,"San Pedro Ixtlahuaca",19),(1302,"San Pedro Jaltepetongo",19),(1303,"San Pedro Jicayán",19),(1304,"San Pedro Jocotipac",19),(1305,"San Pedro Juchatengo",19),(1306,"San Pedro Mártir",19),(1307,"San Pedro Mártir Quiechapa",19),(1308,"San Pedro Mártir Yucuxaco",19),(1309,"San Pedro Mixtepec -Distrito 22-",19),(1310,"San Pedro Mixtepec -Distrito 26-",19),(1311,"San Pedro Molinos",19),(1312,"San Pedro Nopala",19),(1313,"San Pedro Ocopetatillo",19),(1314,"San Pedro Ocotepec",19),(1315,"San Pedro Pochutla",19),(1316,"San Pedro Quiatoni",19),(1317,"San Pedro Sochiapam",19),(1318,"San Pedro Tapanatepec",19),(1319,"San Pedro Taviche",19),(1320,"San Pedro Teozacoalco",19),(1321,"San Pedro Teutila",19),(1322,"San Pedro Tidaá",19),(1323,"San Pedro Topiltepec",19),(1324,"San Pedro Totolapa",19),(1325,"Villa de Tututepec de Melchor Ocampo",19),(1326,"San Pedro Yaneri",19),(1327,"San Pedro Yólox",19),(1328,"San Pedro y San Pablo Ayutla",19),(1329,"Villa de Etla",19),(1330,"San Pedro y San Pablo Teposcolula",19),(1331,"San Pedro y San Pablo Tequixtepec",19),(1332,"San Pedro Yucunama",19),(1333,"San Raymundo Jalpan",19),(1334,"San Sebastián Abasolo",19),(1335,"San Sebastián Coatlán",19),(1336,"San Sebastián Ixcapa",19),(1337,"San Sebastián Nicananduta",19),(1338,"San Sebastián Río Hondo",19),(1339,"San Sebastián Tecomaxtlahuaca",19),(1340,"San Sebastián Teitipac",19),(1341,"San Sebastián Tutla",19),(1342,"San Simón Almolongas",19),(1343,"San Simón Zahuatlán",19),(1344,"Santa Ana",19),(1345,"Santa Ana Ateixtlahuaca",19),(1346,"Santa Ana Cuauhtémoc",19),(1347,"Santa Ana del Valle",19),(1348,"Santa Ana Tavela",19),(1349,"Santa Ana Tlapacoyan",19),(1350,"Santa Ana Yareni",19),(1351,"Santa Ana Zegache",19),(1352,"Santa Catalina Quieri",19),(1353,"Santa Catarina Cuixtla",19),(1354,"Santa Catarina Ixtepeji",19),(1355,"Santa Catarina Juquila",19),(1356,"Santa Catarina Lachatao",19),(1357,"Santa Catarina Loxicha",19),(1358,"Santa Catarina Mechoacán",19),(1359,"Santa Catarina Minas",19),(1360,"Santa Catarina Quiané",19),(1361,"Santa Catarina Tayata",19),(1362,"Santa Catarina Ticuá",19),(1363,"Santa Catarina Yosonotú",19),(1364,"Santa Catarina Zapoquila",19),(1365,"Santa Cruz Acatepec",19),(1366,"Santa Cruz Amilpas",19),(1367,"Santa Cruz de Bravo",19),(1368,"Santa Cruz Itundujia",19),(1369,"Santa Cruz Mixtepec",19),(1370,"Santa Cruz Nundaco",19),(1371,"Santa Cruz Papalutla",19),(1372,"Santa Cruz Tacache de Mina",19),(1373,"Santa Cruz Tacahua",19),(1374,"Santa Cruz Tayata",19),(1375,"Santa Cruz Xitla",19),(1376,"Santa Cruz Xoxocotlán",19),(1377,"Santa Cruz Zenzontepec",19),(1378,"Santa Gertrudis",19),(1379,"Santa Inés del Monte",19),(1380,"Santa Inés Yatzeche",19),(1381,"Santa Lucía del Camino",19),(1382,"Santa Lucía Miahuatlán",19),(1383,"Santa Lucía Monteverde",19),(1384,"Santa Lucía Ocotlán",19),(1385,"Santa María Alotepec",19),(1386,"Santa María Apazco",19),(1387,"Santa María la Asunción",19),(1388,"Heroica Ciudad de Tlaxiaco",19),(1389,"Ayoquezco de Aldama",19),(1390,"Santa María Atzompa",19),(1391,"Santa María Camotlán",19),(1392,"Santa María Colotepec",19),(1393,"Santa María Cortijo",19),(1394,"Santa María Coyotepec",19),(1395,"Santa María Chachoapam",19),(1396,"Villa de Chilapa de Díaz",19),(1397,"Santa María Chilchotla",19),(1398,"Santa María Chimalapa",19),(1399,"Santa María del Rosario",19),(1400,"Santa María del Tule",19),(1401,"Santa María Ecatepec",19),(1402,"Santa María Guelacé",19),(1403,"Santa María Guienagati",19),(1404,"Santa María Huatulco",19),(1405,"Santa María Huazolotitlán",19),(1406,"Santa María Ipalapa",19),(1407,"Santa María Ixcatlán",19),(1408,"Santa María Jacatepec",19),(1409,"Santa María Jalapa del Marqués",19),(1410,"Santa María Jaltianguis",19),(1411,"Santa María Lachixío",19),(1412,"Santa María Mixtequilla",19),(1413,"Santa María Nativitas",19),(1414,"Santa María Nduayaco",19),(1415,"Santa María Ozolotepec",19),(1416,"Santa María Pápalo",19),(1417,"Santa María Peñoles",19),(1418,"Santa María Petapa",19),(1419,"Santa María Quiegolani",19),(1420,"Santa María Sola",19),(1421,"Santa María Tataltepec",19),(1422,"Santa María Tecomavaca",19),(1423,"Santa María Temaxcalapa",19),(1424,"Santa María Temaxcaltepec",19),(1425,"Santa María Teopoxco",19),(1426,"Santa María Tepantlali",19),(1427,"Santa María Texcatitlán",19),(1428,"Santa María Tlahuitoltepec",19),(1429,"Santa María Tlalixtac",19),(1430,"Santa María Tonameca",19),(1431,"Santa María Totolapilla",19),(1432,"Santa María Xadani",19),(1433,"Santa María Yalina",19),(1434,"Santa María Yavesía",19),(1435,"Santa María Yolotepec",19),(1436,"Santa María Yosoyúa",19),(1437,"Santa María Yucuhiti",19),(1438,"Santa María Zacatepec",19),(1439,"Santa María Zaniza",19),(1440,"Santa María Zoquitlán",19),(1441,"Santiago Amoltepec",19),(1442,"Santiago Apoala",19),(1443,"Santiago Apóstol",19),(1444,"Santiago Astata",19),(1445,"Santiago Atitlán",19),(1446,"Santiago Ayuquililla",19),(1447,"Santiago Cacaloxtepec",19),(1448,"Santiago Camotlán",19),(1449,"Santiago Comaltepec",19),(1450,"Santiago Chazumba",19),(1451,"Santiago Choápam",19),(1452,"Santiago del Río",19),(1453,"Santiago Huajolotitlán",19),(1454,"Santiago Huauclilla",19),(1455,"Santiago Ihuitlán Plumas",19),(1456,"Santiago Ixcuintepec",19),(1457,"Santiago Ixtayutla",19),(1458,"Santiago Jamiltepec",19),(1459,"Santiago Jocotepec",19),(1460,"Santiago Juxtlahuaca",19),(1461,"Santiago Lachiguiri",19),(1462,"Santiago Lalopa",19),(1463,"Santiago Laollaga",19),(1464,"Santiago Laxopa",19),(1465,"Santiago Llano Grande",19),(1466,"Santiago Matatlán",19),(1467,"Santiago Miltepec",19),(1468,"Santiago Minas",19),(1469,"Santiago Nacaltepec",19),(1470,"Santiago Nejapilla",19),(1471,"Santiago Nundiche",19),(1472,"Santiago Nuyoó",19),(1473,"Santiago Pinotepa Nacional",19),(1474,"Santiago Suchilquitongo",19),(1475,"Santiago Tamazola",19),(1476,"Santiago Tapextla",19),(1477,"Villa Tejúpam de la Unión",19),(1478,"Santiago Tenango",19),(1479,"Santiago Tepetlapa",19),(1480,"Santiago Tetepec",19),(1481,"Santiago Texcalcingo",19),(1482,"Santiago Textitlán",19),(1483,"Santiago Tilantongo",19),(1484,"Santiago Tillo",19),(1485,"Santiago Tlazoyaltepec",19),(1486,"Santiago Xanica",19),(1487,"Santiago Xiacuí",19),(1488,"Santiago Yaitepec",19),(1489,"Santiago Yaveo",19),(1490,"Santiago Yolomécatl",19),(1491,"Santiago Yosondúa",19),(1492,"Santiago Yucuyachi",19),(1493,"Santiago Zacatepec",19),(1494,"Santiago Zoochila",19),(1495,"Nuevo Zoquiapam",19),(1496,"Santo Domingo Ingenio",19),(1497,"Santo Domingo Albarradas",19),(1498,"Santo Domingo Armenta",19),(1499,"Santo Domingo Chihuitán",19),(1500,"Santo Domingo de Morelos",19),(1501,"Santo Domingo Ixcatlán",19),(1502,"Santo Domingo Nuxaá",19),(1503,"Santo Domingo Ozolotepec",19),(1504,"Santo Domingo Petapa",19),(1505,"Santo Domingo Roayaga",19),(1506,"Santo Domingo Tehuantepec",19),(1507,"Santo Domingo Teojomulco",19),(1508,"Santo Domingo Tepuxtepec",19),(1509,"Santo Domingo Tlatayapam",19),(1510,"Santo Domingo Tomaltepec",19),(1511,"Santo Domingo Tonalá",19),(1512,"Santo Domingo Tonaltepec",19),(1513,"Santo Domingo Xagacía",19),(1514,"Santo Domingo Yanhuitlán",19),(1515,"Santo Domingo Yodohino",19),(1516,"Santo Domingo Zanatepec",19),(1517,"Santos Reyes Nopala",19),(1518,"Santos Reyes Pápalo",19),(1519,"Santos Reyes Tepejillo",19),(1520,"Santos Reyes Yucuná",19),(1521,"Santo Tomás Jalieza",19),(1522,"Santo Tomás Mazaltepec",19),(1523,"Santo Tomás Ocotepec",19),(1524,"Santo Tomás Tamazulapan",19),(1525,"San Vicente Coatlán",19),(1526,"San Vicente Lachixío",19),(1527,"San Vicente Nuñú",19),(1528,"Silacayoápam",19),(1529,"Sitio de Xitlapehua",19),(1530,"Soledad Etla",19),(1531,"Villa de Tamazulapam del Progreso",19),(1532,"Tanetze de Zaragoza",19),(1533,"Taniche",19),(1534,"Tataltepec de Valdés",19),(1535,"Teococuilco de Marcos Pérez",19),(1536,"Teotitlán de Flores Magón",19),(1537,"Teotitlán del Valle",19),(1538,"Teotongo",19),(1539,"Tepelmeme Villa de Morelos",19),(1540,"Tezoatlán de Segura y Luna",19),(1541,"San Jerónimo Tlacochahuaya",19),(1542,"Tlacolula de Matamoros",19),(1543,"Tlacotepec Plumas",19),(1544,"Tlalixtac de Cabrera",19),(1545,"Totontepec Villa de Morelos",19),(1546,"Trinidad Zaachila",19),(1547,"La Trinidad Vista Hermosa",19),(1548,"Unión Hidalgo",19),(1549,"Valerio Trujano",19),(1550,"San Juan Bautista Valle Nacional",19),(1551,"Villa Díaz Ordaz",19),(1552,"Yaxe",19),(1553,"Magdalena Yodocono de Porfirio Díaz",19),(1554,"Yogana",19),(1555,"Yutanduchi de Guerrero",19),(1556,"Villa de Zaachila",19),(1557,"San Mateo Yacutindoo",19),(1558,"Zapotitlán Lagunas",19),(1559,"Zapotitlán Palmas",19),(1560,"Santa Inés de Zaragoza",19),(1561,"Zimatlán de Álvarez",19),
  (1562,"Acajete",20),(1563,"Acateno",20),(1564,"Acatlán",20),(1565,"Acatzingo",20),(1566,"Acteopan",20),(1567,"Ahuacatlán",20),(1568,"Ahuatlán",20),(1569,"Ahuazotepec",20),(1570,"Ahuehuetitla",20),(1571,"Ajalpan",20),(1572,"Albino Zertuche",20),(1573,"Aljojuca",20),(1574,"Altepexi",20),(1575,"Amixtlán",20),(1576,"Amozoc",20),(1577,"Aquixtla",20),(1578,"Atempan",20),(1579,"Atexcal",20),(1580,"Atlixco",20),(1581,"Atoyatempan",20),(1582,"Atzala",20),(1583,"Atzitzihuacán",20),(1584,"Atzitzintla",20),(1585,"Axutla",20),(1586,"Ayotoxco de Guerrero",20),(1587,"Calpan",20),(1588,"Caltepec",20),(1589,"Camocuautla",20),(1590,"Caxhuacán",20),(1591,"Coatepec",20),(1592,"Coatzingo",20),(1593,"Cohetzala",20),(1594,"Cohuecan",20),(1595,"Coronango",20),(1596,"Coxcatlán",20),(1597,"Coyomeapan",20),(1598,"Coyotepec",20),(1599,"Cuapiaxtla de Madero",20),(1600,"Cuautempan",20),(1601,"Cuautinchán",20),(1602,"Cuautlancingo",20),(1603,"Cuayuca de Andrade",20),(1604,"Cuetzalan del Progreso",20),(1605,"Cuyoaco",20),(1606,"Chalchicomula de Sesma",20),(1607,"Chapulco",20),(1608,"Chiautla",20),(1609,"Chiautzingo",20),(1610,"Chiconcuautla",20),(1611,"Chichiquila",20),(1612,"Chietla",20),(1613,"Chigmecatitlán",20),(1614,"Chignahuapan",20),(1615,"Chignautla",20),(1616,"Chila",20),(1617,"Chila de la Sal",20),(1618,"Honey",20),(1619,"Chilchotla",20),(1620,"Chinantla",20),(1621,"Domingo Arenas",20),(1622,"Eloxochitlán",20),(1623,"Epatlán",20),(1624,"Esperanza",20),(1625,"Francisco Z. Mena",20),(1626,"General Felipe Ángeles",20),(1627,"Guadalupe",20),(1628,"Guadalupe Victoria",20),(1629,"Hermenegildo Galeana",20),(1630,"Huaquechula",20),(1631,"Huatlatlauca",20),(1632,"Huauchinango",20),(1633,"Huehuetla",20),(1634,"Huehuetlán el Chico",20),(1635,"Huejotzingo",20),(1636,"Hueyapan",20),(1637,"Hueytamalco",20),(1638,"Hueytlalpan",20),(1639,"Huitzilan de Serdán",20),(1640,"Huitziltepec",20),(1641,"Atlequizayan",20),(1642,"Ixcamilpa de Guerrero",20),(1643,"Ixcaquixtla",20),(1644,"Ixtacamaxtitlán",20),(1645,"Ixtepec",20),(1646,"Izúcar de Matamoros",20),(1647,"Jalpan",20),(1648,"Jolalpan",20),(1649,"Jonotla",20),(1650,"Jopala",20),(1651,"Juan C. Bonilla",20),(1652,"Juan Galindo",20),(1653,"Juan N. Méndez",20),(1654,"Lafragua",20),(1655,"Libres",20),(1656,"La Magdalena Tlatlauquitepec",20),(1657,"Mazapiltepec de Juárez",20),(1658,"Mixtla",20),(1659,"Molcaxac",20),(1660,"Cañada Morelos",20),(1661,"Naupan",20),(1662,"Nauzontla",20),(1663,"Nealtican",20),(1664,"Nicolás Bravo",20),(1665,"Nopalucan",20),(1666,"Ocotepec",20),(1667,"Ocoyucan",20),(1668,"Olintla",20),(1669,"Oriental",20),(1670,"Pahuatlán",20),(1671,"Palmar de Bravo",20),(1672,"Pantepec",20),(1673,"Petlalcingo",20),(1674,"Piaxtla",20),(1675,"Puebla",20),(1676,"Quecholac",20),(1677,"Quimixtlán",20),(1678,"Rafael Lara Grajales",20),(1679,"Los Reyes de Juárez",20),(1680,"San Andrés Cholula",20),(1681,"San Antonio Cañada",20),(1682,"San Diego La Mesa Tochimiltzingo",20),(1683,"San Felipe Teotlalcingo",20),(1684,"San Felipe Tepatlán",20),(1685,"San Gabriel Chilac",20),(1686,"San Gregorio Atzompa",20),(1687,"San Jerónimo Tecuanipan",20),(1688,"San Jerónimo Xayacatlán",20),(1689,"San José Chiapa",20),(1690,"San José Miahuatlán",20),(1691,"San Juan Atenco",20),(1692,"San Juan Atzompa",20),(1693,"San Martín Texmelucan",20),(1694,"San Martín Totoltepec",20),(1695,"San Matías Tlalancaleca",20),(1696,"San Miguel Ixitlán",20),(1697,"San Miguel Xoxtla",20),(1698,"San Nicolás Buenos Aires",20),(1699,"San Nicolás de los Ranchos",20),(1700,"San Pablo Anicano",20),(1701,"San Pedro Cholula",20),(1702,"San Pedro Yeloixtlahuaca",20),(1703,"San Salvador el Seco",20),(1704,"San Salvador el Verde",20),(1705,"San Salvador Huixcolotla",20),(1706,"San Sebastián Tlacotepec",20),(1707,"Santa Catarina Tlaltempan",20),(1708,"Santa Inés Ahuatempan",20),(1709,"Santa Isabel Cholula",20),(1710,"Santiago Miahuatlán",20),(1711,"Huehuetlán el Grande",20),(1712,"Santo Tomás Hueyotlipan",20),(1713,"Soltepec",20),(1714,"Tecali de Herrera",20),(1715,"Tecamachalco",20),(1716,"Tecomatlán",20),(1717,"Tehuacán",20),(1718,"Tehuitzingo",20),(1719,"Tenampulco",20),(1720,"Teopantlán",20),(1721,"Teotlalco",20),(1722,"Tepanco de López",20),(1723,"Tepango de Rodríguez",20),(1724,"Tepatlaxco de Hidalgo",20),(1725,"Tepeaca",20),(1726,"Tepemaxalco",20),(1727,"Tepeojuma",20),(1728,"Tepetzintla",20),(1729,"Tepexco",20),(1730,"Tepexi de Rodríguez",20),(1731,"Tepeyahualco",20),(1732,"Tepeyahualco de Cuauhtémoc",20),(1733,"Tetela de Ocampo",20),(1734,"Teteles de Ávila Castillo",20),(1735,"Teziutlán",20),(1736,"Tianguismanalco",20),(1737,"Tilapa",20),(1738,"Tlacotepec de Benito Juárez",20),(1739,"Tlacuilotepec",20),(1740,"Tlachichuca",20),(1741,"Tlahuapan",20),(1742,"Tlaltenango",20),(1743,"Tlanepantla",20),(1744,"Tlaola",20),(1745,"Tlapacoya",20),(1746,"Tlapanalá",20),(1747,"Tlatlauquitepec",20),(1748,"Tlaxco",20),(1749,"Tochimilco",20),(1750,"Tochtepec",20),(1751,"Totoltepec de Guerrero",20),(1752,"Tulcingo",20),(1753,"Tuzamapan de Galeana",20),(1754,"Tzicatlacoyan",20),(1755,"Venustiano Carranza",20),(1756,"Vicente Guerrero",20),(1757,"Xayacatlán de Bravo",20),(1758,"Xicotepec",20),(1759,"Xicotlán",20),(1760,"Xiutetelco",20),(1761,"Xochiapulco",20),(1762,"Xochiltepec",20),(1763,"Xochitlán de Vicente Suárez",20),(1764,"Xochitlán Todos Santos",20),(1765,"Yaonáhuac",20),(1766,"Yehualtepec",20),(1767,"Zacapala",20),(1768,"Zacapoaxtla",20),(1769,"Zacatlán",20),(1770,"Zapotitlán",20),(1771,"Zapotitlán de Méndez",20),(1772,"Zaragoza",20),(1773,"Zautla",20),(1774,"Zihuateutla",20),(1775,"Zinacatepec",20),(1776,"Zongozotla",20),(1777,"Zoquiapan",20),(1778,"Zoquitlán",20),
  (1779,"Amealco de Bonfil",21),(1780,"Pinal de Amoles",21),(1781,"Arroyo Seco",21),(1782,"Cadereyta de Montes",21),(1783,"Colón",21),(1784,"Corregidora",21),(1785,"Ezequiel Montes",21),(1786,"Huimilpan",21),(1787,"Jalpan de Serra",21),(1788,"Landa de Matamoros",21),(1789,"El Marqués",21),(1790,"Pedro Escobedo",21),(1791,"Peñamiller",21),(1792,"Querétaro",21),(1793,"San Joaquín",21),(1794,"San Juan del Río",21),(1795,"Tequisquiapan",21),(1796,"Tolimán",21),
  (1797,"Cozumel",22),(1798,"Felipe Carrillo Puerto",22),(1799,"Isla Mujeres",22),(1800,"Othón P. Blanco",22),(1801,"Benito Juárez",22),(1802,"José María Morelos",22),(1803,"Lázaro Cárdenas",22),(1804,"Solidaridad",22),(1805,"Tulum",22),(1806,"Bacalar",22),(1807,"Puerto Morelos",22),
  (1808,"Ahualulco",23),(1809,"Alaquines",23),(1810,"Aquismón",23),(1811,"Armadillo de los Infante",23),(1812,"Axtla de Terrazas",23),(1813,"Cárdenas",23),(1814,"Catorce",23),(1815,"Cedral",23),(1816,"Cerritos",23),(1817,"Cerro de San Pedro",23),(1818,"Charcas",23),(1819,"Ciudad del Maíz",23),(1820,"Ciudad Fernández",23),(1821,"Ciudad Valles",23),(1822,"Coxcatlán",23),(1823,"Ébano",23),(1824,"El Naranjo",23),(1825,"Guadalcázar",23),(1826,"Huehuetlán",23),(1827,"Lagunillas",23),(1828,"Matehuala",23),(1829,"Matlapa",23),(1830,"Mexquitic de Carmona",23),(1831,"Moctezuma",23),(1832,"Rayón",23),(1833,"Rioverde",23),(1834,"Salinas",23),(1835,"San Antonio",23),(1836,"San Ciro de Acosta",23),(1837,"San Luis Potosí",23),(1838,"San Martín Chalchicuautla",23),(1839,"San Nicolás Tolentino",23),(1840,"San Vicente Tancuayalab",23),(1841,"Santa Catarina",23),(1842,"Santa María del Río",23),(1843,"Santo Domingo",23),(1844,"Soledad de Graciano Sánchez",23),(1845,"Tamasopo",23),(1846,"Tamazunchale",23),(1847,"Tampacán",23),(1848,"Tampamolón Corona",23),(1849,"Tamuín",23),(1850,"Tancanhuitz",23),(1851,"Tanlajás",23),(1852,"Tanquián de Escobedo",23),(1853,"Tierra Nueva",23),(1854,"Vanegas",23),(1855,"Venado",23),(1856,"Villa de Arista",23),(1857,"Villa de Arriaga",23),(1858,"Villa de Guadalupe",23),(1859,"Villa de la Paz",23),(1860,"Villa de Ramos",23),(1861,"Villa de Reyes",23),(1862,"Villa Hidalgo",23),(1863,"Villa Juárez",23),(1864,"Xilitla",23),(1865,"Zaragoza",23),
  (1866,"Ahome",24),(1867,"Angostura",24),(1868,"Badiraguato",24),(1869,"Concordia",24),(1870,"Cosalá",24),(1871,"Culiacán",24),(1872,"Choix",24),(1873,"Elota",24),(1874,"Escuinapa",24),(1875,"El Fuerte",24),(1876,"Guasave",24),(1877,"Mazatlán",24),(1878,"Mocorito",24),(1879,"El Rosario",24),(1880,"Salvador Alvarado",24),(1881,"San Ignacio",24),(1882,"Sinaloa",24),(1883,"Navolato",24),
  (1884,"Aconchi",25),(1885,"Agua Prieta",25),(1886,"Álamos",25),(1887,"Altar",25),(1888,"Arivechi",25),(1889,"Arizpe",25),(1890,"Átil",25),(1891,"Bacadéhuachi",25),(1892,"Bacanora",25),(1893,"Bacerac",25),(1894,"Bacoachi",25),(1895,"Bácum",25),(1896,"Banámichi",25),(1897,"Baviácora",25),(1898,"Bavispe",25),(1899,"Benjamín Hill",25),(1900,"Caborca",25),(1901,"Cajeme",25),(1902,"Cananea",25),(1903,"Carbó",25),(1904,"La Colorada",25),(1905,"Cucurpe",25),(1906,"Cumpas",25),(1907,"Divisaderos",25),(1908,"Empalme",25),(1909,"Etchojoa",25),(1910,"Fronteras",25),(1911,"Granados",25),(1912,"Guaymas",25),(1913,"Hermosillo",25),(1914,"Huachinera",25),(1915,"Huásabas",25),(1916,"Huatabampo",25),(1917,"Huépac",25),(1918,"Ímuris",25),(1919,"Magdalena",25),(1920,"Mazatán",25),(1921,"Moctezuma",25),(1922,"Naco",25),(1923,"Nácori Chico",25),(1924,"Nacozari de García",25),(1925,"Navojoa",25),(1926,"Nogales",25),(1927,"Ónavas",25),(1928,"Opodepe",25),(1929,"Oquitoa",25),(1930,"Pitiquito",25),(1931,"Puerto Peñasco",25),(1932,"Quiriego",25),(1933,"Rayón",25),(1934,"Rosario",25),(1935,"Sahuaripa",25),(1936,"San Felipe de Jesús",25),(1937,"San Javier",25),(1938,"San Luis Río Colorado",25),(1939,"San Miguel de Horcasitas",25),(1940,"San Pedro de la Cueva",25),(1941,"Santa Ana",25),(1942,"Santa Cruz",25),(1943,"Sáric",25),(1944,"Soyopa",25),(1945,"Suaqui Grande",25),(1946,"Tepache",25),(1947,"Trincheras",25),(1948,"Tubutama",25),(1949,"Ures",25),(1950,"Villa Hidalgo",25),(1951,"Villa Pesqueira",25),(1952,"Yécora",25),(1953,"General Plutarco Elías Calles",25),(1954,"Benito Juárez",25),(1955,"San Ignacio Río Muerto",25),
  (1956,"Balancán",26),(1957,"Cárdenas",26),(1958,"Centla",26),(1959,"Centro",26),(1960,"Comalcalco",26),(1961,"Cunduacán",26),(1962,"Emiliano Zapata",26),(1963,"Huimanguillo",26),(1964,"Jalapa",26),(1965,"Jalpa de Méndez",26),(1966,"Jonuta",26),(1967,"Macuspana",26),(1968,"Nacajuca",26),(1969,"Paraíso",26),(1970,"Tacotalpa",26),(1971,"Teapa",26),(1972,"Tenosique",26),
  (1973,"Abasolo",27),(1974,"Aldama",27),(1975,"Altamira",27),(1976,"Antiguo Morelos",27),(1977,"Burgos",27),(1978,"Bustamante",27),(1979,"Camargo",27),(1980,"Casas",27),(1981,"Ciudad Madero",27),(1982,"Cruillas",27),(1983,"Gomez Farías",27),(1984,"González",27),(1985,"Güémez",27),(1986,"Guerrero",27),(1987,"Gustavo Díaz Ordaz",27),(1988,"Hidalgo",27),(1989,"Jaumave",27),(1990,"Jiménez",27),(1991,"Llera",27),(1992,"Mainero",27),(1993,"El Mante",27),(1994,"Matamoros",27),(1995,"Méndez",27),(1996,"Mier",27),(1997,"Miguel Alemán",27),(1998,"Miquihuana",27),(1999,"Nuevo Laredo",27),(2000,"Nuevo Morelos",27),(2001,"Ocampo",27),(2002,"Padilla",27),(2003,"Palmillas",27),(2004,"Reynosa",27),(2005,"Río Bravo",27),(2006,"San Carlos",27),(2007,"San Fernando",27),(2008,"San Nicolás",27),(2009,"Soto la Marina",27),(2010,"Tampico",27),(2011,"Tula",27),(2012,"Valle Hermoso",27),(2013,"Victoria",27),(2014,"Villagrán",27),(2015,"Xicoténcatl",27),
  (2016,"Amaxac de Guerrero",28),(2017,"Apetatitlán de Antonio Carvajal",28),(2018,"Atlangatepec",28),(2019,"Altzayanca",28),(2020,"Apizaco",28),(2021,"Calpulalpan",28),(2022,"El Carmen Tequexquitla",28),(2023,"Cuapiaxtla",28),(2024,"Cuaxomulco",28),(2025,"Chiautempan",28),(2026,"Muñoz de Domingo Arenas",28),(2027,"Españita",28),(2028,"Huamantla",28),(2029,"Hueyotlipan",28),(2030,"Ixtacuixtla de Mariano Matamoros",28),(2031,"Ixtenco",28),(2032,"Mazatecochco de José María Morelos",28),(2033,"Contla de Juan Cuamatzi",28),(2034,"Tepetitla de Lardizábal",28),(2035,"Sanctórum de Lázaro Cárdenas",28),(2036,"Nanacamilpa de Mariano Arista",28),(2037,"Acuamanala de Miguel Hidalgo",28),(2038,"Natívitas",28),(2039,"Panotla",28),(2040,"San Pablo del Monte",28),(2041,"Santa Cruz Tlaxcala",28),(2042,"Tenancingo",28),(2043,"Teolocholco",28),(2044,"Tepeyanco",28),(2045,"Terrenate",28),
  (2046,"Acajete",29),(2047,"Acatlán ",29),(2048,"Acayucan",29),(2049,"Actopan",29),(2050,"Acula",29),(2051,"Acultzingo",29),(2052,"Camarón de Tejeda",29),(2053,"Alpatláhuac",29),(2054,"Alto Lucero de Gutiérrez Barrios",29),(2055,"Altotonga",29),(2056,"Alvarado",29),(2057,"Amatitlán",29),(2058,"Naranjos Amatlán",29),(2059,"Amatlán de los Reyes",29),(2060,"Angel R. Cabada",29),(2061,"La Antigua",29),(2062,"Apazapan ",29),(2063,"Aquila ",29),(2064,"Astacinga ",29),(2065,"Atlahuilco",29),(2066,"Atoyac",29),(2067,"Atzacan",29),(2068,"Atzalan",29),(2069,"Tlaltetela",29),(2070,"Ayahualulco",29),(2071,"Banderilla",29),(2072,"Benito Juárez",29),(2073,"Boca del Río",29),(2074,"Calcahualco ",29),(2075,"Camerino Z. Mendoza",29),(2076,"Carrillo Puerto",29),(2077,"Catemaco",29),(2078,"Cazones de Herrera",29),(2079,"Cerro Azul",29),(2080,"Citlaltépetl",29),(2081,"Coacoatzintla",29),(2082,"Coahuitlán",29),(2083,"Coatepec",29),(2084,"Coatzacoalcos",29),(2085,"Coatzintla",29),(2086,"Coetzala ",29),(2087,"Colipa",29),(2088,"Comapa",29),(2089,"Córdoba",29),(2090,"Cosamaloapan de Carpio",29),(2091,"Cosautlán de Carvajal",29),(2092,"Coscomatepec",29),(2093,"Cosoleacaque",29),(2094,"Cotaxtla",29),(2095,"Coxquihui",29),(2096,"Coyutla",29),(2097,"Cuichapa",29),(2098,"Cuitláhuac",29),(2099,"Chacaltianguis",29),(2100,"Chalma",29),(2101,"Chiconamel",29),(2102,"Chiconquiaco",29),(2103,"Chicontepec",29),(2104,"Chinameca",29),(2105,"Chinampa de Gorostiza",29),(2106,"Las Choapas",29),(2107,"Chocamán",29),(2108,"Chontla",29),(2109,"Chumatlán ",29),(2110,"Emiliano Zapata",29),(2111,"Espinal",29),(2112,"Filomeno Mata",29),(2113,"Fortín",29),(2114,"Gutiérrez Zamora",29),(2115,"Hidalgotitlán",29),(2116,"Huatusco",29),(2117,"Huayacocotla",29),(2118,"Hueyapan de Ocampo",29),(2119,"Huiloapan de Cuauhtémoc",29),(2120,"Ignacio de la Llave",29),(2121,"Ilamatlán ",29),(2122,"Isla",29),(2123,"Ixcatepec",29),(2124,"Ixhuacán de los Reyes",29),(2125,"Ixhuatlán del Café",29),(2126,"Ixhuatlancillo",29),(2127,"Ixhuatlán del Sureste",29),(2128,"Ixhuatlán de Madero",29),(2129,"Ixmatlahuacan",29),(2130,"Ixtaczoquitlán",29),(2131,"Jalacingo",29),(2132,"Xalapa",29),(2133,"Jalcomulco",29),(2134,"Jáltipan",29),(2135,"Jamapa",29),(2136,"Jesús Carranza",29),(2137,"Xico",29),(2138,"Jilotepec",29),(2139,"Juan Rodríguez Clara",29),(2140,"Juchique de Ferrer",29),(2141,"Landero y Coss ",29),(2142,"Lerdo de Tejada",29),(2143,"Magdalena ",29),(2144,"Maltrata",29),(2145,"Manlio Fabio Altamirano",29),(2146,"Mariano Escobedo",29),(2147,"Martínez de la Torre",29),(2148,"Mecatlán ",29),(2149,"Mecayapan ",29),(2150,"Medellín de Bravo",29),(2151,"Miahuatlán ",29),(2152,"Las Minas ",29),(2153,"Minatitlán",29),(2154,"Misantla",29),(2155,"Mixtla de Altamirano ",29),(2156,"Moloacán",29),(2157,"Naolinco",29),(2158,"Naranjal ",29),(2159,"Nautla",29),(2160,"Nogales",29),(2161,"Oluta",29),(2162,"Omealca",29),(2163,"Orizaba",29),(2164,"Otatitlán",29),(2165,"Oteapan",29),(2166,"Ozuluama de Mascareñas",29),(2167,"Pajapan",29),(2168,"Pánuco",29),(2169,"Papantla",29),(2170,"Paso del Macho",29),(2171,"Paso de Ovejas",29),(2172,"La Perla",29),(2173,"Perote",29),(2174,"Platón Sánchez",29),(2175,"Playa Vicente",29),(2176,"Poza Rica de Hidalgo",29),(2177,"Las Vigas de Ramírez",29),(2178,"Pueblo Viejo",29),(2179,"Puente Nacional",29),(2180,"Rafael Delgado",29),(2181,"Rafael Lucio",29),(2182,"Los Reyes ",29),(2183,"Río Blanco",29),(2184,"Saltabarranca",29),(2185,"San Andrés Tenejapan ",29),(2186,"San Andrés Tuxtla",29),(2187,"San Juan Evangelista",29),(2188,"Santiago Tuxtla",29),(2189,"Sayula de Alemán",29),(2190,"Soconusco",29),(2191,"Sochiapa ",29),(2192,"Soledad Atzompa ",29),(2193,"Soledad de Doblado",29),(2194,"Soteapan",29),(2195,"Tamalín",29),(2196,"Tamiahua",29),(2197,"Tampico Alto",29),(2198,"Tancoco",29),(2199,"Tantima",29),(2200,"Tantoyuca",29),(2201,"Tatatila ",29),(2202,"Castillo de Teayo",29),(2203,"Tecolutla",29),(2204,"Tehuipango ",29),(2205,"Álamo Temapache",29),(2206,"Tempoal",29),(2207,"Tenampa",29),(2208,"Tenochtitlán ",29),(2209,"Teocelo",29),(2210,"Tepatlaxco",29),(2211,"Tepetlán",29),(2212,"Tepetzintla",29),(2213,"Tequila",29),(2214,"José Azueta",29),(2215,"Texcatepec ",29),(2216,"Texhuacán ",29),(2217,"Texistepec",29),(2218,"Tezonapa",29),(2219,"Tierra Blanca",29),(2220,"Tihuatlán",29),(2221,"Tlacojalpan",29),(2222,"Tlacolulan",29),(2223,"Tlacotalpan",29),(2224,"Tlacotepec de Mejía ",29),(2225,"Tlachichilco",29),(2226,"Tlalixcoyan",29),(2227,"Tlalnelhuayocan",29),(2228,"Tlapacoyan",29),(2229,"Tlaquilpa",29),(2230,"Tlilapan ",29),(2231,"Tomatlán",29),(2232,"Tonayán ",29),(2233,"Totutla",29),(2234,"Tuxpan",29),(2235,"Tuxtilla ",29),(2236,"Ursulo Galván",29),(2237,"Vega de Alatorre",29),(2238,"Veracruz",29),(2239,"Villa Aldama",29),(2240,"Xoxocotla ",29),(2241,"Yanga",29),(2242,"Yecuatla",29),(2243,"Zacualpan",29),(2244,"Zaragoza",29),(2245,"Zentla",29),(2246,"Zongolica",29),(2247,"Zontecomatlán de López y Fuentes",29),(2248,"Zozocolco de Hidalgo",29),(2249,"Agua Dulce",29),(2250,"El Higo",29),(2251,"Nanchital de Lázaro Cárdenas del Río",29),(2252,"Tres Valles",29),(2253,"Carlos A. Carrillo",29),(2254,"Tatahuicapan de Juárez",29),(2255,"Uxpanapa",29),(2256,"San Rafael",29),(2257,"Santiago Sochiapan",29),
  (2258,"Abalá",30),(2259,"Acanceh",30),(2260,"Akil",30),(2261,"Baca",30),(2262,"Bokobá",30),(2263,"Buctzotz",30),(2264,"Cacalchén",30),(2265,"Calotmul",30),(2266,"Cansahcab",30),(2267,"Cantamayec",30),(2268,"Celestún",30),(2269,"Cenotillo",30),(2270,"Conkal",30),(2271,"Cuncunul",30),(2272,"Cuzamá",30),(2273,"Chacsinkín",30),(2274,"Chankom",30),(2275,"Chapab",30),(2276,"Chemax",30),(2277,"Chicxulub Pueblo",30),(2278,"Chichimilá",30),(2279,"Chikindzonot",30),(2280,"Chocholá",30),(2281,"Chumayel",30),(2282,"Dzan",30),(2283,"Dzemul",30),(2284,"Dzidzantún",30),(2285,"Dzilam de Bravo",30),(2286,"Dzilam González",30),(2287,"Dzitás",30),(2288,"Dzoncauich",30),(2289,"Espita",30),(2290,"Halachó",30),(2291,"Hocabá",30),(2292,"Hoctún",30),(2293,"Homún",30),(2294,"Huhí",30),(2295,"Hunucmá",30),(2296,"Ixil",30),(2297,"Izamal",30),(2298,"Kanasín",30),(2299,"Kantunil",30),(2300,"Kaua",30),(2301,"Kinchil",30),(2302,"Kopomá",30),(2303,"Mama",30),(2304,"Maní",30),(2305,"Maxcanú",30),(2306,"Mayapán",30),(2307,"Mérida",30),(2308,"Mocochá",30),(2309,"Motul",30),(2310,"Muna",30),(2311,"Muxupip",30),(2312,"Opichén",30),(2313,"Oxkutzcab",30),(2314,"Panabá",30),(2315,"Peto",30),(2316,"Progreso",30),(2317,"Quintana Roo",30),(2318,"Río Lagartos",30),(2319,"Sacalum",30),(2320,"Samahil",30),(2321,"Sanahcat",30),(2322,"San Felipe",30),(2323,"Santa Elena",30),(2324,"Seyé",30),(2325,"Sinanché",30),(2326,"Sotuta",30),(2327,"Sucilá",30),(2328,"Sudzal",30),(2329,"Suma",30),(2330,"Tahdziú",30),(2331,"Tahmek",30),(2332,"Teabo",30),(2333,"Tecoh",30),(2334,"Tekal de Venegas",30),(2335,"Tekantó",30),(2336,"Tekax",30),(2337,"Tekit",30),(2338,"Tekom",30),(2339,"Telchac Pueblo",30),(2340,"Telchac Puerto",30),(2341,"Temax",30),(2342,"Temozón",30),(2343,"Tepakán",30),(2344,"Tetiz",30),(2345,"Teya",30),(2346,"Ticul",30),(2347,"Timucuy",30),(2348,"Tinum",30),(2349,"Tixcacalcupul",30),(2350,"Tixkokob",30),(2351,"Tixméhuac",30),(2352,"Tixpéhual",30),(2353,"Tizimín",30),(2354,"Tunkás",30),(2355,"Tzucacab",30),(2356,"Uayma",30),(2357,"Ucú",30),(2358,"Umán",30),(2359,"Valladolid",30),(2360,"Xocchel",30),(2361,"Yaxcabá",30),(2362,"Yaxkukul",30),(2363,"Yobaín",30),
  (2364,"Apozol",31),(2365,"Apulco",31),(2366,"Atolinga",31),(2367,"Benito Juárez",31),(2368,"Calera",31),(2369,"Cañitas de Felipe Pescador",31),(2370,"Concepción del Oro",31),(2371,"Cuauhtémoc",31),(2372,"Chalchihuites",31),(2373,"Fresnillo",31),(2374,"Trinidad García de la Cadena",31),(2375,"Genaro Codina",31),(2376,"General Enrique Estrada",31),(2377,"General Francisco R. Murguía",31),(2378,"El Plateado de Joaquín Amaro",31),(2379,"General Pánfilo Natera",31),(2380,"Guadalupe",31),(2381,"Huanusco",31),(2382,"Jalpa",31),(2383,"Jerez",31),(2384,"Jiménez del Teul",31),(2385,"Juan Aldama",31),(2386,"Juchipila",31),(2387,"Loreto",31),(2388,"Luis Moya",31),(2389,"Mazapil",31),(2390,"Melchor Ocampo",31),(2391,"Mezquital del Oro",31),(2392,"Miguel Auza",31),(2393,"Momax",31),(2394,"Monte Escobedo",31),(2395,"Morelos",31),(2396,"Moyahua de Estrada",31),(2397,"Nochistlán de Mejía",31),(2398,"Noria de Ángeles",31),(2399,"Ojocaliente",31),(2400,"Pánuco",31),(2401,"Pinos",31),(2402,"Río Grande",31),(2403,"Saín Alto",31),(2404,"El Salvador",31),(2405,"Sombrerete",31),(2406,"Susticacán",31),(2407,"Tabasco",31),(2408,"Tepechitlán",31),(2409,"Tepetongo",31),(2410,"Teúl de González Ortega",31),(2411,"Tlaltenango de Sánchez Román",31),(2412,"Valparaíso",31),(2413,"Vetagrande",31),(2414,"Villa de Cos",31),(2415,"Villa García",31),(2416,"Villa González Ortega",31),(2417,"Villa Hidalgo",31),(2418,"Villanueva",31),(2419,"Zacatecas",31),(2420,"Trancoso",31),(2421,"Santa María de la Paz",31),
  (2422,"Álvaro Obregón",32),(2423,"Azcapotzalco",32),(2424,"Benito Juárez",32),(2425,"Coyoacán",32),(2426,"Cuajimalpa de Morelos",32),(2427,"Cuauhtémoc",32),(2428,"Gustavo A. Madero",32),(2429,"Iztacalco",32),(2430,"Iztapalapa",32),(2431,"Magdalena Contreras",32),(2432,"Miguel Hidalgo",32),(2433,"Milpa Alta",32),(2434,"Tláhuac",32),(2435,"Tlalpan",32),(2436,"Venustiano Carranza",32),(2437,"Xochimilco",32
);

INSERT INTO tipoDireccion (clave,Tipo)
VALUES (1,"Cliente");
INSERT INTO tipoDireccion (clave,Tipo)
VALUES (2,"Fiscal");
INSERT INTO tipoDireccion (clave,Tipo)
VALUES (3,"Entrega");
INSERT INTO tipoDireccion (clave,Tipo)
VALUES (4,"Empleado");
INSERT INTO tipoDireccion (clave,Tipo)
VALUES (5,"Servicio");

INSERT INTO direccion values (1,"259","0","Eje 1 Nte","Buenavista",06350,2,2437);
INSERT INTO direccion values (2,"843",NULL,"Av ejer. nacional","Granada",11520,2,2430);
INSERT INTO direccion values (3,NULL,NULL,"Anillo Periferico","AdolfoLopez M",04500,2,2429);
INSERT INTO direccion values (4,NULL,NULL,"Periférico. Blvd.","Manuel Ávila Camacho",54050,2,749);
INSERT INTO direccion values (5,"209","5","Blvrd Manuel Ávila Camacho 5","Residencial Lomas de Sotelo",53390,2,702);

INSERT INTO direccionCliente values (1,1);
INSERT INTO direccionCliente values (2,2);
INSERT INTO direccionCliente values (3,3);
INSERT INTO direccionCliente values (4,4);
INSERT INTO direccionCliente values (5,5);

INSERT INTO direccionServicio (claveDireccion, claveServicio)
values (1, 10),(2, 4),(3, 2),(5, 7);

INSERT INTO puesto (clave,nombre)
VALUES (1,"Directivo");
INSERT INTO puesto (clave,nombre)
VALUES (2,"Secretaria");
INSERT INTO puesto (clave,nombre)
VALUES (3,"Técnico");

INSERT INTO empleado VALUES(
  1,"Juan","Sanchez","Lopez","juan@gmail.com",1,3,"12345678A","SALJ890929HHDFPIO0","1234ABCD3210",0445541434593,54366764,"Aldo","Montes","Enriquez","aldo_me@gmail.com",1,53027329,NULL,"SALJ890929H1P"),
  (2,"Christian","Urquiza","Aguirre","christian@gmail.com",2,3,"12345678B","URAC890929HHDFPIO0","1234EFGH3210",0445541434593,55654654,"Aldo","Montes","Enriquez","aldo_me@gmail.com",1,53027329,NULL,"URAC890929JL1"),
  (3,"David","Mendoza","Castillo","david@gmail.com",1,3,"1234567CD","MECD890929HHDFPIO0","1234ABCD3210",0445541434593,58477501,"Aldo","Montes","Enriquez","aldo_me@gmail.com",1,53027329,NULL,"MECD8909291IK"),
  (4,"Brenda","Alcala","Calderon","brenda@gmail.com",3,2,"123456EFG","ALCB930929HHDFPIO0","1234ABCD3210",0445541434593,59782367,"Aldo","Montes","Enriquez","aldo_me@gmail.com",1,53027329,NULL,"ALCB930929PP3"),
  (5,"Julio","Montaño","Salinas","julio@gmail.com",4,1,"1234HIJKL","MOxJ890929HHDFPIO0","1234ABCD3210",0445541434593,22234557,"Aldo","Montes","Enriquez","aldo_me@gmail.com",1,53027329,NULL,"MOxJ890929OP2"),
  (6,"Valentin","Rodriguez","Mellado","valentin@gmail.com",4,1,"12ABCDEFG","ROMV890929HHDFPIO0","1234ABCD3210",0445541434593,27432340,"Aldo","Montes","Enriquez","aldo_me@gmail.com",1,53027329,NULL,"ROMV890929QLK"
);

INSERT INTO direccionEmpleado (claveDireccion,ClaveEmpleado)
VALUES (1,1);
INSERT INTO direccionEmpleado (claveDireccion,ClaveEmpleado)
VALUES (2,3);
INSERT INTO direccionEmpleado (claveDireccion,ClaveEmpleado)
VALUES (3,5);
INSERT INTO direccionEmpleado (claveDireccion,ClaveEmpleado)
VALUES (4,6);
INSERT INTO direccionEmpleado (claveDireccion,ClaveEmpleado)
VALUES (5,2);

INSERT INTO empleadoServicios (matriculaEmpleado, folioServicio)
values (1, 5),(2, 6),(3, 7),(4, 8);
