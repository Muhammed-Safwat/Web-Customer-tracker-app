package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

 
@WebServlet("/testDbServlet")
public class testDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public testDbServlet() {
        super();
         
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // setup  connection variables 
		
		String dbURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false"; // MySQL
		String userName = "root";
		String password = "1032001mr";
		
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out  = response.getWriter();
			out.println("Connecting to database : "+dbURL);

			Class.forName(driver);
			
			Connection myCon = (Connection)DriverManager.getConnection(dbURL, userName , password);
			
			
			out.println("Connected !!!");
			
		}catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
	}

 
}
