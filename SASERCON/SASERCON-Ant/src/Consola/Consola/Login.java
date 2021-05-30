/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SASERCON;
import java.util.Scanner;
/**
 *
 * @author Brenda Mejia
 */
public class Login {
    
    /*
    solicitar_usuario metod, receive a Strign and in case it is incorrect, allows to retry two times the text
    Doesn't use parameters
    Use local variables: String usuario, usu; global variables: NON
    Doesn't return anything
    */
    public void solicitar_usuario(){
        Scanner sc = new Scanner(System.in);
        String usuario, usu;
        usuario = "elevadoressercon";
        boolean encontrado = false; 
        for(int i=0; i<3 && !encontrado;i++){
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
        
    } /* The method ends*/
   
    /*
    solicitar_contrasenha requests a data, and it allows to retry two more times the same requested data in case it is wrong
    also verify if the verifica que los datos ingresados sean a los que ya estan estbalecido
    Doesn't use parameters
    Use local variables: String contrasenha, con; global variables  
   */
    public void solicitar_contrasenha(){
        Scanner sc = new Scanner(System.in);
        String contrasenha;
	String con;
	contrasenha = "sasercon";
        boolean encontrado2 = false;
        for(int i=0; i<3 && !encontrado2;i++) {
			if (i==0){
				System.out.println("Introduzca la contrasenha: ");
			}else if(i==1){
				System.out.println("Restan dos intentos: ");
			}else if(i==2){
				System.out.println("Último intento: ");
			}
			
			con = sc.nextLine();
            if (con.equals(contrasenha)){
            	encontrado2=true;
            }
    }
    if (encontrado2){
    	System.out.println("La contrasenha introducida es correcta.");
        System.out.println("Usuario con Acceso ");
        System.exit(0);
    }else{
    	System.out.println("Has olvidado tu contrasenha ?, Recuperando contrasenha!.");
        
    } /* The method ends*/
    
    /*guardar method, request string data without limit. It will be saved in an array.
    Doesn't use parameters
    Use local variables: String nuevacontrasenha; global variables
    Doesn't return anything
    */
    }
    public void guardar(){
    Scanner sc = new Scanner(System.in);
    String[] nuevacontrasenha = new String[1];
           nuevacontrasenha[0]="";
        System.out.println("Favor de ingresar su nueva contrasenha.");
        nuevacontrasenha[0] = sc.nextLine();
        System.out.println("Nueva contrasenha guardada:"+ nuevacontrasenha[0]);

    } /* The metod ends*/
    
    /*The metod is constructed 
   the motod send the warnig message*/
    public void bloquear(){
        System.out.println("Su usuario se ha bloqueado.");
    } /*The metdos ends*/
    
    
    /*mostrar allows to show questions that saves the new password with a String value
    Doesn't use parameters
    Doesn't return anything
    */
    public void mostrar(){
    Scanner sc = new Scanner(System.in);
    String[] nuevacontrasenha = new String[5];
           nuevacontrasenha[0]="";
           nuevacontrasenha[1]="";
           nuevacontrasenha[2]="";
           nuevacontrasenha[3]="";
           nuevacontrasenha[4]="";
        System.out.println("Desea cambiar sus preguntas secretas?");
        String input = sc.nextLine().toUpperCase();
            if (input.equals("SI")) {
        System.out.println("Favor de ingresar nueva pregunta 1.");
        nuevacontrasenha[1] = sc.nextLine();
        System.out.println("Nueva pregunta 1 guardada:"+ nuevacontrasenha[1]);
        System.out.println("Favor de ingresar respuesta a nueva pregunta 1.");
        nuevacontrasenha[2] = sc.nextLine();
        System.out.println("Nueva respuesta a nueva pregunta 1 guardada:"+ nuevacontrasenha[2]);
        System.out.println("Favor de ingresar nueva pregunta 2.");
        nuevacontrasenha[3] = sc.nextLine();
        System.out.println("Nueva pregunta 2 guardada:"+ nuevacontrasenha[3]);
        System.out.println("Favor de ingresar respuesta a nueva pregunta 2.");
        nuevacontrasenha[4] = sc.nextLine();
        System.out.println("Nueva respuesta a nueva pregunta 2 guardada:"+ nuevacontrasenha[4]);
        System.out.println("Nueva contrasenha y preguntas secretas guardadas exitosamente");
    } else {
        System.out.println("Nueva contrasenha guardada exitosamente");
        
    }
        
    }/*The method ends*/
    
    
    /**/
    public void recuperar(){
    Scanner sc = new Scanner(System.in);
                String respuesta1;
		String respuesta2;
                String pregunta1;
		String pregunta2;
                String res1;
		String res2;
                respuesta1 = "Benji";
		respuesta2 = "Programador";
                pregunta1 = "¿ Cual era el nombre de tu primer animal de compañia ?";
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
    	System.out.println("Respuesta a la pregunta 1 incorrecta, responda la pregunta 2 para poder cambiar su contrasenha.");
        
    }
        //Respuesta 2
    
         		for(int i=0; i<3 && !encontrado2;i++) {
			if (i==0){
				System.out.println("Introducir la respuesta a la pregunta 2: "+pregunta2);
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
    
} /*Fin de codigo*/
