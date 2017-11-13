package org.otros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java1 {

public static void main(String[] arg) throws IOException{
	
	System.out.println("-------- Oracle JDBC Connection Testing ------");

    try {

        Class.forName("oracle.jdbc.driver.OracleDriver");

    } catch (ClassNotFoundException e) {

        System.out.println("Where is your Oracle JDBC Driver?");
        e.printStackTrace();
        return;

    }

    System.out.println("Oracle JDBC Driver Registered!");

    Connection connection = null;
    Statement stmt = null;

    try {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("url:");
    	String url = br.readLine();
    	System.out.println("user:");
    	String user = br.readLine();
    	System.out.println("pass:");
    	String pass = br.readLine();
    	
        //connection = DriverManager.getConnection("jdbc:oracle:thin:@//50.116.21.223:1521/XE", "eft", "eft");
        connection = DriverManager.getConnection(url, user, pass);
        
        stmt = connection.createStatement();
        String sql = "SELECT 1 as id from dual";
        ResultSet rs = stmt.executeQuery(sql);
        //STEP 5: Extract data from result set
        while(rs.next()){
           //Retrieve by column name
           int id  = rs.getInt("id");

           //Display values
           System.out.println("ID: " + id);
           
        }
        rs.close();        
        
        

    } catch (SQLException e) {

        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
        return;

    }

    if (connection != null) {
        System.out.println("You made it, take control your database now!");
    } else {
        System.out.println("Failed to make connection!");
    }
}
	
}
