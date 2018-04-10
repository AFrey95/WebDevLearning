package com.ln.web.cats;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ln.web.baselet.Baselet;
import com.ln.web.model.Users;

/**
 * Servlet implementation class TheCats
 */
//@WebServlet("/TheCats")
public class TheCats extends Baselet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TheCats() {
        super();
        System.out.println("In the cats.");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Users[] users = {new Users("Steve", "Gameshow Host", 49),
						 new Users("Bobert", "Accountant", 54),
						 new Users("Lauren", "Student", 22),
						 new Users("Jimbo S.", "Deep Sea Fisherman", 36),
						 new Users("Trisha", "Astronaut", 38),
						 new Users("Caroline", "Psychologist", 47)};
		request.setAttribute("users", users);
		
		String sentence = "Once upon a time, there were a bunch of mice people. The were literally the worst.";
		request.setAttribute("sentence", sentence);
		
		boolean loggedin = false;
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		request.setAttribute("myName", user.toString());
		
		if(user.equals("Andy") && pass.equals("pizza")) {
			loggedin = true;
			String[] roles = {"user", "member", "moderator", "admin"};
			request.setAttribute("roles", roles);
		}
		else {
			loggedin = false;
		}
		
		if(loggedin) {
			request.getRequestDispatcher("/WEB-INF/pages/CatCity.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/WEB-INF/pages/LoginFailed.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
