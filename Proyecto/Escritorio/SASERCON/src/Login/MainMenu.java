/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.util.*;
/**
 *
 * @author Christian
 */
public class MainMenu {
    public void Menu()  {
        Scanner sc = new Scanner(System.in);
        ALERTA al = new ALERTA();
        Ccliente cc = new Ccliente();
        Productos pp = new Productos();
        Eempleados ee = new Eempleados();
        Servicios ss = new Servicios();
        //Agenda aa = new Agenda();
        //Embalaje em = new Embalaje();
        
        boolean rep=true;
        
        do {
            System.out.println("\n\t\tBienvenido a SASERCON");
            System.out.println("\t\t  MENU PRINCIPAL");
            System.out.println("1) Cliente");
            System.out.println("2) Producto");
            System.out.println("3) Empleado");
            System.out.println("4) Servicio");
            //System.out.println("5) Cotizar refaccion");
            //System.out.println("6) Generar documento de embalaje");
            System.out.println("\n0) Salir\n");
            
            int opc = al.valint("Su opcion: ");
            switch(opc) {
                case 1:
                    cc.Cmenu();
                    break;
                case 2:
                    pp.Pmenu();
                    break;
                case 3:
                    ee.Emenu();
                    break;
                case 4:
                    ss.Smenu();
                    break;
                
                case 5:
                    //pp.cotizar(sc); NO
                    break;
                case 6:
                    //em.generar(sc); NO
                    break;
                case 0:
                    System.out.println("Gracias por usar SASERCON");
                    rep=false;
                    break;
                default:
                    break;

            }
        } while (rep==true);
        sc.close();
    }
}
