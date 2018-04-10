package com.ln.web.baselet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Baselet
 */
// @WebServlet(description = "Base servlet with login n stuff", urlPatterns = {
// "/Baselet" })
public class Baselet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Baselet() {
		super();
		System.out.println("In Base constructor.");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
//		String htmlput = "\n<!DOCTYPE html>\n"
//				+ "<html>\n" + "<head>\n" + "<meta charset=\"ISO-8859-1\">\n"
//				+ "<title>I am a title</title>\n" + "</head>\n" + "<body>\n" + "<h3>Login</h3>\n"
//				+ "<form action=\"NotCats\" method=\"GET\">\n"
//				+ "Username: <input type=\"text\" name=\"first_name\">\n" + "<br />\n"
//				+ "Password: <input type=\"text\" name=\"last_name\" />\n"
//				+ "<input type=\"submit\" value=\"Submit\" />\n" + "</form>\n" + "</body>\n" + "</html>\n";
//		response.getWriter().append(htmlput);
		System.out.println("In base servlet.");
		System.out.println(request.getRemoteAddr());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
