
package SASERCON;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class Agenda {
    public   ArrayList<Date> hora = new ArrayList<Date>()  {{
        add(new Date());
        add(new Date());
        add(new Date());
    }};
    public ArrayList<Date> fecha = new ArrayList<Date>()  {{
        add(new Date());
        add(new Date());
        add(new Date());
    }};
    static long milisegundos_dia = 24 * 60 *60 * 100;
    
    static Scanner sc=new Scanner(System.in);
    static boolean rep=true;
    ALERTA al = new ALERTA();

    public void duracion()  {
                        
        int hre,hrs;
    
        do  {
            try {
                //hre=entrada.nextInt();
                Date fechaInicio=new SimpleDateFormat("HH:mm").parse(al.valhr("\n\tingrese la hora de entrada al realizar el servicio:"));
                            
                // hrs=sc.nextInt();
                Date fechaFinal=new SimpleDateFormat("HH:mm").parse(al.valhr("\n\tingrese hora de salida referido al servicio finalizado:"));
                double fechaTotal=fechaFinal.getTime()-fechaInicio.getTime();
                double TotalHrs=fechaTotal/1000/60/60;
                if(TotalHrs<0)  {
                    System.out.println("La resta da negativo, favor de repetir la resta.");
                    rep=true;
                }
                else    {
                    System.out.println("\n\tEl servicio se a realizado en un total de "+TotalHrs+ "hrs.\n");
                    rep=false;
                }
            } catch(Exception e)    {

            }
        }   while(rep==true);
        
    }


static long milisegundos_di = 24 * 60 *60 * 100;
    
    public void FechaAyB() throws ParseException {
                        
        String fechaalta,fechabaja;
    
        System.out.println("\n\tIngrese la fecha de alta del servicio en formato (\"dd//MM/aaaa\")");
                fechaalta=sc.next();
                
         System.out.println("\n\tIngrese la fecha de baja del servicio en formato (\"dd//MM/aaaa\")");       
                 fechabaja=sc.next();
                 System.out.println("\n\tLas fechas son:\n" + "fecha de alta:" +  fechaalta + "\nfecha de baja:"+  fechabaja);
    
    }}
           