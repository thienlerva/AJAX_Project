package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	
	private static Logger log = Logger.getLogger(LogoutServlet.class);
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		String toTrace = "LOGGING OUT SESSION WITH ATTRIBUTES: \n";
		
		Enumeration<String> atts = session.getAttributeNames();
		while(atts.hasMoreElements()) {
			toTrace += atts.nextElement() + "\n";
		}
		log.trace(toTrace);
		
		
		//invalidate session
		if(session != null) {
			session.invalidate();
			log.trace("INVALIDATING SESSION: " + session.getId());
			
		}
		
		PrintWriter writer = resp.getWriter();
		String out = "You are successfully logged out!";
		out += "<a href=\"login\">Back to Log In page! </a>";
		resp.setContentType("text/html");
		writer.write(out);
				
		
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {}; {};

}
