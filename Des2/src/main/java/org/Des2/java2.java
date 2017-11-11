package org.Des2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.ucp.UniversalConnectionPoolException;

public class java2 {

	public static void main(String[] args) throws IOException{
		
		try {
			
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	System.out.println("url:");
	    	String url = br.readLine();
	    	System.out.println("user:");
	    	String user = br.readLine();
	    	System.out.println("pass:");
	    	String pass = br.readLine();
			connectOciFisa.URL = url;
			connectOciFisa.USER = user;
			connectOciFisa.PASS = pass;
			
			Connection contest = connectOciFisa.openConnection();
			connectOciFisa.estadisticas();
			
			Statement stmt = contest.createStatement();
	        String sql = "SELECT 1 as id from dual";
	        ResultSet rs = stmt.executeQuery(sql);
	        while(rs.next()){
	           int id  = rs.getInt("id");
	           System.out.println("ID: " + id);
	        }			
			connectOciFisa.estadisticas();
			contest.close();
		} catch (SQLException e) {
			System.out.println("Error Sql");
			e.printStackTrace();			
		} catch (UniversalConnectionPoolException e) {
			System.out.println("Error UCP");
			e.printStackTrace();
		}
		
	}
	
}
