package Login;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Sfecha {
    
    public Date dia;
    public Date mes;
    public Date anho;
    public Date hora;
    Scanner entrada=new Scanner(System.in);

    public Date agenda()    {
        Date hor = new Date();
        Date fecha = new Date();
        DateFormat Shora = new SimpleDateFormat("HH:mm:ss");
        DateFormat Sfecha = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Servicio guardado a las: " +Shora.format(hor)+"de la fecha: " +Sfecha.format(fecha));
        return hor;
    }
}
