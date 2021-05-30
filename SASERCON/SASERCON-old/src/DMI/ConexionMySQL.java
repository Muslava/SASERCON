/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DMI;

import java.sql.*;
import java.util.logging.Level;
//import javax.swing.JOptionPane;
//import com.mysql.jdbc.Connection;
public class ConexionMySQL {
    public String db="SASERCON";
    public String url="jdbc:mysql://sasercon-1.cluster-cte59hesh8ir.us-east-1.rds.amazonaws.com/"+db;
    public String usuario="admin_sercon";
    public String pass="caninosTeam2020?";
   
    public ConexionMySQL(){
    }
    
    public Connection Conectar(){
        Connection enlace=null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            
            System.out.println("Connecting to a selected database...");
            enlace=(Connection)DriverManager.getConnection(this.url,this.usuario,this.pass);
            System.out.println("Connected database successfully...");
            
        }catch(Exception e){
            System.out.println("Error de enlace ConexionMySQL" +e);
            java.util.logging.Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, e);
        }
          return enlace;  
            
    }
    
    public  ResultSet consultar(String st)	{
	Connection con = Conectar();
	ResultSet rs = null;
	try	{
		PreparedStatement ps = con.prepareStatement(st);
		rs = ps.executeQuery();
	} catch(Exception e)	{
            System.out.println("Error de consulta ConexionMySQL" +e);
            java.util.logging.Logger.getLogger(ConexionMySQL.class.getName()).log(Level.SEVERE, null, e);
	}
	return rs;
    }

}
