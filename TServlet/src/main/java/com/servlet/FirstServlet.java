package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;



public class FirstServlet implements Servlet{
	
//Life Cycle Methods
	
	ServletConfig conf;
	
	public ServletConfig getsServletConfig() {
		return this.conf;
	}
	
	public void init(ServletConfig conf) {
		this.conf = conf;
		System.out.println("Creating object");
	}
	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
		System.out.println("Servicing...........");
		// for dynamic response to the coming request first we will set the type for response object
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.print("<h1> Servlet Interface overridden method called here <h1>");
		pw.print("<h1>Data & Time :" +new Date().toString()+"</h1>");
		getServletInfo();
		getServletConfig();
	}
	public void destroy() {
		System.out.println("Destroying ");
	}
	
	
	public String getServletInfo() {
		return "This Servlet is created by Abhishek";}
	
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getInitParameterNames() :"+conf.getInitParameterNames());
		System.out.println("getServletName() :"+ conf.getServletName());
		System.out.println("getServletContext() :"+ conf.getServletContext().toString());
		System.out.println("getClass() :"+conf.getClass().toString());
		return null;
	}}
