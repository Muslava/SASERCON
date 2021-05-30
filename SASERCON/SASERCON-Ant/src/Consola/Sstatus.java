package Consola;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;



public class Sstatus {
        public ArrayList<String> status  = new ArrayList<String>()  {{
        add("");
        add("");
        add("");
    }};
    Scanner entrada=new Scanner(System.in);
    
    
    /*
    status method
    Doesn't use parameters
    Use local variables: Char Status, Boolean seguir; doesn't use global variables
    Doesn't return anything
    */
    public String status()  {
        String s="";
        char Status;
        boolean seguir;
        System.out.println("\n\t\tSelecciona el Status del servicio:");
        System.out.println("\t\ta.-Servicio programado");
        System.out.println("\t\tb.-Servicio concluido");
        System.out.println("\t\tc.-Servicio cancelado");
       
        do {
             Status=entrada.next().charAt(0);
            switch (Status) {

                case 'a':
                    System.out.println("\nEl Servicio se encuentra programado.");
                    s="Programado";
                    seguir = false;
                    break;
                case 'b':   
                    System.out.println("\nEl Servicio esta concluido.");
                    s="Concluido";
                    seguir = false;
                    break;
                case 'c':     
                    System.out.println("\nEl Servicio se encuentra cancelado.");
                    s="Cancelado";
                    seguir = false;
                    break;
                default:
                    System.out.println("\nOpcion incorrecta:");
                    seguir = true;
                    break;
            }
        } while (seguir==true);
        return s;
    }
}
