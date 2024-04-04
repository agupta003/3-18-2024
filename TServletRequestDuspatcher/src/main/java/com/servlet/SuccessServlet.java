package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SuccessServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8531778181741959312L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.println("This is success servlet");
		pw.println("<h2> Succesfully Registered</h2>");
		
	}

	
}
