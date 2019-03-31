package SASERCON;

import java.util.*;


public class ALERTA {
    public String variable;
    public int num;
    public  boolean seguir=true;
    Scanner entrada=new Scanner(System.in);

    public String valtext(String a){
        do {
            System.out.print(a);
            variable=entrada.next();
            seguir=true;
            if(variable.matches("[^0-9]*")&&vacio(variable)==false) seguir=false;
            else System.out.println("\nEl dato ingresado no es correcto.");
            if(seguir==false) seguir=vacio(variable);
        } while (seguir==true);
        return variable;
    }
    
    public int valint(String a) {
        do {
            System.out.print(a);
            variable=entrada.next();
            seguir=true;
            if(variable.matches("[^a-zA-Z]*")&&vacio(variable)==false) seguir=false;
            else System.out.println("\nEl dato ingresado no es correcto.");
            if(seguir==false) seguir=vacio(variable);
        } while (seguir==true);
        num=Integer.parseInt(variable);
        return num;
    }

    public char valchar(String a)   {
        char mander;
        do {
            System.out.print(a);
            variable=entrada.next();
            if(variable.matches("[^0-9]*")&&vacio(variable)==false) seguir=false;
            else System.out.println("\nEl dato ingresado no es correcto.");
            if(seguir==false) seguir=vacio(variable);
        } while (seguir==true);
        mander=variable.charAt(0);
        return mander;
    }
    
    public float valfloat(String a) {
        float fl;
        do {
            System.out.print(a);
            variable=entrada.next();
            seguir=true;
            if(variable.matches("[^a-zA-Z]*[0-9]*[.]?[0-9]{1,2}")&&vacio(variable)==false) seguir=false;
            else System.out.println("\nEl dato ingresado no es correcto ingresa la cifra con decimales.");
        } while (seguir==true);
        fl=Float.parseFloat(variable);
        return fl;
    }
    
    public String valmail(String a) {
        do{
            System.out.print(a);
            variable=entrada.next();
            seguir=true;
            if(variable.matches("[-\\w\\.]+\\@{1}\\w+\\.\\w+")&&vacio(variable)==false) seguir=false;
            else System.out.println("\nEl dato ingresado no es correcto.");
        } while (seguir==true);
        return variable;
    }
    
    public String valhr(String a) {
        do{
            System.out.print(a);
            variable=entrada.next();
            seguir=true;
            if(variable.matches("[-\\w\\.]+\\:{1}\\w\\w+")&&vacio(variable)==false) seguir=false;
            else System.out.println("\nEl dato ingresado no es correcto.");
        } while (seguir==true);
        return variable;
    }
    
    public boolean vacio(String a) {
        if (a==null)    {
            System.out.println("No se puede dejar el espacio vacio.");
            return true;
        }
        else return false;
    }

    public String matricula()  {
        //Letras validas para matricula
        char[] array = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
        String matricula = "";

        for (int i=0; i<7; i++){
            Random rnd = new Random();
            int ale = (int)(rnd.nextDouble() * array.length); //Aleatorio para la letra
            int ale2 = (int)(rnd.nextDouble() * 10); //Aleatorio entre 0-9
            if (i>3) {
                matricula += array[ale];
            } else {
                matricula +=  ale2;
            }
        }
        return matricula;
    }


    public String folio()  {
        //Letras validas para matricula
        char[] array = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
        String folio = "";

        for (int i=0; i<7; i++){
            Random rnd = new Random();
            int ale = (int)(rnd.nextDouble() * array.length); //Aleatorio para la letra
            int ale2 = (int)(rnd.nextDouble() * 10); //Aleatorio entre 0-9
            if (i>3) {
                folio+= array[ale];
            } else {
                folio +=  ale2;
            }
        }

        return folio;

    }
 
   public long numerotelefono (String a){
        do {
            System.out.print(a);
            variable = entrada.next(); //Invocamos un metodo sobre un objeto Scanner
            if (variable.length() != 10&&vacio(variable)==true) System.out.println ("No tiene longitud 10, entrada no valida");
            else seguir=false;
        } while (seguir==true);
        long tel = Long.parseLong(variable);
        return tel;
    }
    
    public long valnss (String a){
        do {
            System.out.print(a);
            variable = entrada.next(); //Invocamos un metodo sobre un objeto Scanner
            if (variable.length() != 11&&vacio(variable)==true) System.out.println ("No tiene longitud 11, entrada no valida");
            else seguir=false;
        } while (seguir==true);
        long tel = Long.parseLong(variable);
        return tel;
    }
}