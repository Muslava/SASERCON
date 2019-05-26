/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DMI;

/**
 *
 * @author darki
 */
import java.sql.*;
import javax.swing.JOptionPane;
//import com.mysql.jdbc.Connection;
public class ConexionMySQL {
    public String db="SASERCON";
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
    
    public  ResultSet consultar(String st)	{
	Connection con = Conectar();
	ResultSet rs = null;
	try	{
		PreparedStatement ps = con.prepareStatement(st);
		rs = ps.executeQuery();
	} catch(Exception ex)	{
            JOptionPane.showMessageDialog(null, ex);
	}
	return rs;
    }

}
