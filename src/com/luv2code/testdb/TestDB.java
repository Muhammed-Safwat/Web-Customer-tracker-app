package com.luv2code.testdb;

import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;

import com.mysql.jdbc.Connection;

public class TestDB {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false"; // MySQL
		String userName = "root";
		String password = "1032001mr";
		
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			//PrintWriter out  = response.getWriter();
	//		out.println("Connecting to database : "+dbURL);

			Class.forName(driver);
			
			Connection myCon = (Connection)DriverManager.getConnection(dbURL, userName , password);
			System.out.println("Connected ?? ");
			
			//out.println("Connected !!!");
			
		}catch(Exception exc) {
			exc.printStackTrace();
			//throw new ServletException(exc);
		}

	}

}
