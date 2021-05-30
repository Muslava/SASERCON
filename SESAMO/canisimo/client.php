<?php
/*<?php
try {
	$soapclient = new SoapClient('http://localhost/canisimo/canisimo.wsdl');

} catch (Exception $e) {
	echo $e->getMessage();
}
https://www.youtube.com/watch?v=OS5Ucm9b8sY
C:\xampp\htdocs\canisimo\canisimo.wsdl
?>*/

// create instance and set a book name
/*$book      =new Book();
$book->name='test 2';*/
$mail = "valentin@gmail.com";
$password = "98fedaea6b3826d34afe6bf621d42b0157e4b6f1597bdf8cd2cc22672824afebdf51c066af564c639d01a84eb36f5ab5a4fec0a7fac441e373172f53511cbed0";

// initialize SOAP client and call web service function
$client=new SoapClient('http://localhost/canisimo/server.php?wsdl',['trace'=>1,'cache_wsdl'=>WSDL_CACHE_NONE]);
$resp  =$client->login($mail,$password);

// dump response
var_dump($resp);