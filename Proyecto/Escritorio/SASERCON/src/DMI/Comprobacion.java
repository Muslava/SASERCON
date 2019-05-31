/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DMI;

/**
 *
 * @author coner
 */
public class Comprobacion {
    
    public boolean vacio(String a) {
        return a==null;
    }

    public boolean valtext(String a)    {
        return a.matches("[^0-9]*")&&vacio(a)==false;
    }
    
    public boolean valint(String a) {
        return a.matches("[^a-zA-Z]*")&&vacio(a)==false;
    }

    public boolean valchar(String a)    {
        return a.matches("[^0-9]*[a-zA-Z]{1}")&&vacio(a)==false;
    }
    
    public boolean valfloat(String a)   {
        return a.matches("[^a-zA-Z]*[0-9]*[.]?[0-9]{1,2}")&&vacio(a)==false;
    }
    
    public boolean valmail(String a)    {
        return a.matches("[-\\w\\.]+\\@{1}\\w+\\.\\w+")&&vacio(a)==false;
    }
    
    public boolean valhr(String a)  {
        return a.matches("[-\\w\\.]+\\:{1}\\w\\w+")&&vacio(a)==false;
    }
    
    public boolean valtel (String a)    {
        return a.length()==10&&valint(a)==true&&vacio(a)==false;
    }
    
    public boolean valmatricula(String a)   {
        return a.matches("[^a-zA-Z]{3}")&&vacio(a)==false;
    }
    
    public boolean valnss (String a)    {
        return a.length()==12&&valint(a)==true&&vacio(a)==false;
    }

    public boolean valcurp (String a)   {
        return a.matches("[^0-9]{4}[^a-zA-Z]{6}[^0-9]{6}[^a-zA-Z]{2}")&&vacio(a)==false;
    }
    
    public boolean valrfc (String a)  {
        return a.matches("[^0-9]{4}[^a-zA-Z]{6}[a-zA-Z0-9]{3}")&&vacio(a)==false;
    }
    
    public boolean valne (String a) {
        return (a.matches("[0-9]*\\-{1}[a-zA-Z]{2}")||a.matches("[0-9]*")||a.matches("[0-9]*\\-{1}[a-zA-Z]*"))&&vacio(a)==false;
    }
    
    public boolean valni (String a) {
        return (a.matches("[0-9]*\\-{1}[a-zA-Z]{2}")||a.matches("[0-9]*")||a.matches("[0-9]*\\-{1}[a-zA-Z]*"))&&vacio(a)==false;
    }
    
    public boolean valcp (String a)    {
        return a.length()==5&&valint(a)==true&&vacio(a)==false;
    }
    
    public boolean valcel (String a)    {
        return a.length()==12&&valint(a)==true&&vacio(a)==false;
    }
}
