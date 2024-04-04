package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login", name = "LoginServlet")
public class HttpServletDemo extends HttpServlet implements Servlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Login Servlet - doGet() method");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<h1> This is overriden doGet method of HttpServlet class </h1>");
		String name = "Testing";
		writer.println(name);
		
	}

	
	 @Override protected void doPost(HttpServletRequest req, HttpServletResponse
	 resp) throws ServletException, IOException { 

		 
		 
	 }
	 
	

}
