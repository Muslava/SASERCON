/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consola;

import java.util.Scanner;

/**
 *
 * @author darki
 */
public class Login {

    public void solicitar_usuario(){
        Scanner sc = new Scanner(System.in);
        String usuario;
        String usu;
        usuario = "elevadoressercon";
        boolean encontrado = false;
        for(int i=0; i<3 && !encontrado;i++) {
			if (i==0){
				System.out.println("Introduzca su usuario: ");
			}else if(i==1){
				System.out.println("Restan dos intentos: ");
			}else if(i==2){
				System.out.println("Último intento: ");
			}
			
			usu = sc.nextLine();
            if (usu.equals(usuario)){
            	encontrado=true;
            }
    }
        if (encontrado){
    	System.out.println("El usuario introducido es correcto.");
    }else{
    	System.out.println("Has olvidado tu usuario ?, Deseas verificar si estas registrado con tu correro electronico ?.");
        System.exit(0);
    }
        
    }
    
    public void solicitar_contraseña(){
        Scanner sc = new Scanner(System.in);
        String contraseña;
	String con;
	contraseña = "sasercon";
        boolean encontrado2 = false;
        for(int i=0; i<3 && !encontrado2;i++) {
			if (i==0){
				System.out.println("Introduzca la contraseña: ");
			}else if(i==1){
				System.out.println("Restan dos intentos: ");
			}else if(i==2){
				System.out.println("Último intento: ");
			}
			
			con = sc.nextLine();
            if (con.equals(contraseña)){
            	encontrado2=true;
            }
    }
    if (encontrado2){
    	System.out.println("La contraseña introducida es correcta.");
        System.out.println("Usuario con Acceso ");
        System.exit(0);
    }else{
    	System.out.println("Has olvidado tu contraseña ?, Recuperando contraseña!.");
        
    }
    
        
    }
    public void guardar(){
    Scanner sc = new Scanner(System.in);
    String[] nuevacontraseña = new String[1];
           nuevacontraseña[0]="";
        System.out.println("Favor de ingresar su nueva contraseña.");
        nuevacontraseña[0] = sc.nextLine();
        System.out.println("Nueva contraseña guardada:"+ nuevacontraseña[0]);

        
    }
    public void bloquear(){
        
    }
    public void mostrar(){
    Scanner sc = new Scanner(System.in);
    String[] nuevacontraseña = new String[5];
           nuevacontraseña[0]="";
           nuevacontraseña[1]="";
           nuevacontraseña[2]="";
           nuevacontraseña[3]="";
           nuevacontraseña[4]="";
        System.out.println("Desea cambiar sus preguntas secretas?");
        String input = sc.nextLine().toUpperCase();
            if (input.equals("SI")) {
        System.out.println("Favor de ingresar nueva pregunta 1.");
        nuevacontraseña[1] = sc.nextLine();
        System.out.println("Nueva pregunta 1 guardada:"+ nuevacontraseña[1]);
        System.out.println("Favor de ingresar respuesta a nueva pregunta 1.");
        nuevacontraseña[2] = sc.nextLine();
        System.out.println("Nueva respuesta a nueva pregunta 1 guardada:"+ nuevacontraseña[2]);
        System.out.println("Favor de ingresar nueva pregunta 2.");
        nuevacontraseña[3] = sc.nextLine();
        System.out.println("Nueva pregunta 2 guardada:"+ nuevacontraseña[3]);
        System.out.println("Favor de ingresar respuesta a nueva pregunta 2.");
        nuevacontraseña[4] = sc.nextLine();
        System.out.println("Nueva respuesta a nueva pregunta 2 guardada:"+ nuevacontraseña[4]);
        System.out.println("Nueva contraseña y preguntas secretas guardadas exitosamente");
    } else {
        System.out.println("Nueva contraseña guardada exitosamente");
        
    }
        
    }
    public void recuperar(){
    Scanner sc = new Scanner(System.in);
                String respuesta1;
		String respuesta2;
                String pregunta1;
		String pregunta2;
                String res1;
		String res2;
                respuesta1 = "Benji";
		respuesta2 = "programador";
                pregunta1 = "¿ Cual era el nombre de tu primer mascota de compañia ?";
                pregunta2 = "¿ Cual seria tu trabajo ideal ?";
                
                boolean encontrado = false;
                boolean encontrado2 = false;
                
		for(int i=0; i<3 && !encontrado;i++) {
			if (i==0){
				System.out.println("Introduzca la respuesta a la pregunta 1: "+pregunta1);
			}else if(i==1){
				System.out.println("Restan dos intentos: ");
			}else if(i==2){
				System.out.println("Último intento: ");
			}
			
			res1 = sc.nextLine();
            if (res1.equals(respuesta1)){
            	encontrado=true;
            }
    }
                       
    
    if (encontrado){
    	System.out.println("Respuesta a la pregunta 1 correcta.");
    }else{
    	System.out.println("Respuesta a la pregunta 1 incorrecta, responda la pregunta 2 para poder cambiar su contraseña.");
        
    }
        //FDGDFgdfgfdgdfgdfg
    
         		for(int i=0; i<3 && !encontrado2;i++) {
			if (i==0){
				System.out.println("Introducir la repsuesta a la pregunta 2: "+pregunta2);
			}else if(i==1){
				System.out.println("Restan dos intentos: ");
			}else if(i==2){
				System.out.println("Último intento: ");
			}
			
			res2 = sc.nextLine();
            if (res2.equals(respuesta2)){
            	encontrado2=true;
            }
    }
                        if (encontrado2){
    	System.out.println("Respuestas a la pregunta 2 correcta.");
}else{
    	System.out.println("Respuestas a la pregunta 2 incorrecta.");
        System.out.println("Su usuario se ha bloqueado.");
        System.exit(0);
        
    }
    }
    
}
