package com.ln.web.cats;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ln.web.baselet.Baselet;

/**
 * Servlet implementation class NotCats
 */
//@WebServlet("/NotCats")
public class NotCats extends Baselet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotCats() {
    	super();
    	System.out.println("In NotCats constructor.");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("In main method.");
		
		super.doGet(request, response);
		
		response.getWriter().append("<html>");
		
		String inputname = request.getParameter("first_name") + " " +
				request.getParameter("last_name"); 
		String welcome_msg;
		
		if(inputname.equals("Steve Harvey")) {
			welcome_msg = "<h1>HERE'S YA BOI STEVE HARVEYYYYYYYYYY</h1>";
		}
		else {
			welcome_msg = "<h1>Hello, " + request.getParameter("first_name") + " " + "!</h1>";
		}
		
		
		response.getWriter().append(welcome_msg);
		if(inputname.equals("Steve Harvey")) 
			response.getWriter().append("<img src=\"images/steve_harvey.jpg\"/>");
		response.getWriter().append("<h2>Accessing from: ").append(request.getRemoteAddr()).append("</h2>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<br>Some more text yaaaaaaay");
		
		response.getWriter().append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
