package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7162734103137003255L;
	
	@SuppressWarnings("null")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
		out.println("<h2>Welcome to Register</h2>");
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		String email = request.getParameter("uesr_email");
		String gender = request.getParameter("user_gander");
		String course = request.getParameter("user_course");
		String condition = request.getParameter("condition");
		if (condition!=null) {
		if (condition.equals("checked")) {
			System.out.println(name);
			System.out.println(password);
			System.out.println(gender);
			out.println("<h2> Name : " + name + "<h2>");
			out.println("<h2> Password : " + password + "<h2>");
			out.println("<h2> EMail : " + email + "<h2>");
			out.println("<h2> Gender : " + gender + "<h2>");
			out.println("<h2> Course : " + course + "<h2>");
			
			//JDBC connection code can come here
		
		}else 
		{
			out.println("<h2>You have not accepted terms and condition</h2>");
			}
		}else {out.println("<h2>You have not accepted terms and condition</h2>");}
}
}
