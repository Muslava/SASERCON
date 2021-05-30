/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DMI;

//STEP 1. Import required packages

import java.sql.*;

public class ConexionMariaDB {
    // JDBC driver name and database URL

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public static Connection getConexion(String db) {
        Connection conn = null;
        //Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            String DB_URL = "jdbc:mariadb://localhost:3306/"+db;
            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }//end try*/
        return conn;
    }//end main
}//end JDBCExample