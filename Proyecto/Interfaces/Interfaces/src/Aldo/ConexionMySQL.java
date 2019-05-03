/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aldo;

/**
 *
 * @author darki
 */
import java.sql.*;
import javax.swing.JOptionPane;
//import com.mysql.jdbc.Connection;
public class ConexionMySQL {
    public String db="TercerParcial";
    public String url="jdbc:mysql://localhost:3306/"+db;
    public String usuario="root";
    public String pass="";
   
    public ConexionMySQL(){
    }
    
    public Connection Conectar(){
        Connection enlace=null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            enlace=(Connection)DriverManager.getConnection(this.url,this.usuario,this.pass);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
          return enlace;  
            
        }
    
}
