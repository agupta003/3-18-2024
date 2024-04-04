package com.servlet;

import java.io.IOException;

import jakarta.servlet.*;

public class FirstServlet {
	
//Life Cycle Methosa
	
	ServletConfig conf;
	
	public void init(ServletConfig conf) {
		this.conf = conf;
		System.out.println("Creating object");
	}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
		System.out.println("Servicing...........");
		
	}
	public void destroy() {
		System.out.println("Destroying ");
	}
	
	public ServletConfig getsServletConfig() {
		return this.conf;
	}
	public String getServletInfo() {
		return "This Servlet is created by Abhishek";}
}
