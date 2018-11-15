package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojo.BankUser;
import com.revature.pojo.User;
import com.revature.service.BankUserService;

/*
 * The following annotation eliminates the need for registering
 * the class as a servlet in the web.xml.
 * The servlet takes parameters as well such as load on startup etc
 * If you do not add any parameters, you can simply add the 
 * url-pattern without a param name in the parenthesis 
 * 
 * Note: do NOT use this AND the xml for the same servlet
 * you can use both for different servlets in the same app. but do not 
 * assign more than one url-pattern to the same servlet 
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	static BankUserService uService = new BankUserService();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		// functionality to go back to login.html 
				//REQUEST DISPATCHER
		req.getRequestDispatcher("login.html").forward(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//login functionality here
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println(username + password);
		//consult user service to obtain User with this info
		BankUser user = uService.validateUser(username, password);
		//List<BankUser> user = uService.getAllUsers();
		System.out.println(user);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		
		if(user == null) {
			
			req.getRequestDispatcher("error-login.html").forward(req, resp);
			
		}
		else {
			//successful login
			//add user to session
			HttpSession session = req.getSession();
			//create new session and returns it if none exists
			session.setAttribute("user", user);
			
			
			resp.sendRedirect("home");
		}
		
	
	}
}
