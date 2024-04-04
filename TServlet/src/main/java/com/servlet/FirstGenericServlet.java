package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FirstGenericServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// for dynamic response to the coming request first we will set the type for response object
				System.out.println("Inside Generic Servlet --> service method");
				res.setContentType("text/html");
				PrintWriter pw = res.getWriter();
				pw.print("<h1>Todays Data & Time :" +new Date().toString()+"</h1>");
				pw.print("<h1> Generic servlet exted method implemented here <h1>");
				getServletInfo();
				getServletConfig();
		
	}

}
