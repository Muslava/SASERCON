package com.sercon.sasercon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import static java.awt.Color.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class prueba {

    //public static void main(String []args) {
        /*System.out.println(java.time.LocalDate.now().toString());
        try {

            URL url = new URL("https://9qob1rxodb.execute-api.us-west-1.amazonaws.com/api/employee");//https://api.covid19api.com/summary"); //https://9qob1rxodb.execute-api.us-west-1.amazonaws.com/api/employee

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "{\"Employees\": ";
                //String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                inline += "}";
                //Close the scanner
                scanner.close();

                //Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);

                JSONArray arr = (JSONArray) data_obj.get("Employees");

                for (int i = 0; i < arr.size(); i++) {

                    JSONObject new_obj = (JSONObject) arr.get(i);

                    if (new_obj.get("matricula").equals("2")) {
                        System.out.println("Total Recovered: " + new_obj.get("nombreEmpleado"));
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    //}
}



                    /*ConexionMySQL cmysql = new ConexionMySQL();
                    con = (Connection) cmysql.Conectar();
                    Statement st = con.createStatement();
                    ResultSet rs0 = st.executeQuery("SELECT correoEmpleado FROM tbl_empleado;");
                    while(rs0.next()) {
                        count++;
                        if(Lcorreo.equals(ALERTA.getDecrypted(rs0.getString("correoEmpleado"))))    {
                            find = 1;
                            matrif = count;
                        }
                    }*/
//ps = con.prepareStatement("SELECT contrasena FROM tbl_empleado WHERE matricula = " + matrif + " AND estadoActivo = 1;");
//ResultSet rs = ps.executeQuery();
//encontrar contraseña a partir de matrícula
//if (rs.next() == true) {
// Comprueba si tiene contraseña (primer ingreso)
