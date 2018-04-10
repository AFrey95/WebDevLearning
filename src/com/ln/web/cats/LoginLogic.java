package com.ln.web.cats;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ln.db.DBUtils;
import com.ln.web.baselet.Baselet;
import com.ln.web.model.TabRow;

/**
 * Servlet implementation class LoginLogic
 */
@WebServlet("/LoginLogic")
public class LoginLogic extends Baselet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginLogic() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		System.out.println("Inputs: " + user + ", " + pass);
		
		String reasonFailed = "None.";
		
		DBUtils dbutil = new DBUtils();
		List<TabRow> currUser = new ArrayList<TabRow>();
		List<TabRow> availableUsersInfo = new ArrayList<TabRow>();
		try {
			currUser = dbutil.getUserByUsername(user);
		} catch (SQLException e) {
			reasonFailed = "Your username did not match any in our database or there was a connection error.";
			request.setAttribute("reason", reasonFailed);
			request.getRequestDispatcher("/WEB-INF/pages/LoginFailed.jsp").forward(request, response);

		}
		if(currUser.size() > 0) {
			if(pass.equals(currUser.get(0).getPassword())) {
				//check role and set available info
				if("Teacher".equals(currUser.get(0).getRole())) {
					try {
						availableUsersInfo = dbutil.getAllUsers();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else if("Student".equals(currUser.get(0).getRole())) {
					try {
						availableUsersInfo = dbutil.getUserById(currUser.get(0).getId());
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					availableUsersInfo = null;
				}
					
				//set attributes
				request.setAttribute("User", currUser);
				request.setAttribute("userInfos", availableUsersInfo);
				request.setAttribute("username", user);
				request.setAttribute("role", currUser.get(0).getRole());
				
				//goto login page
				request.getRequestDispatcher("/WEB-INF/pages/Homepage.jsp").forward(request, response);
			}
			else {
				reasonFailed = "Your password is incorrect.";
				request.setAttribute("reason", reasonFailed);
				request.getRequestDispatcher("/WEB-INF/pages/LoginFailed.jsp").forward(request, response);
			}
		}
		else {
			reasonFailed = "We're not sure, but we think your username didn't match any in our database.";
			request.setAttribute("reason", reasonFailed);
			request.getRequestDispatcher("/WEB-INF/pages/LoginFailed.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
