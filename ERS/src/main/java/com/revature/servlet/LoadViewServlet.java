package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoadViewServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(LoadViewServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String resourcePath = "partials/" + process(req, resp) + ".html";
		req.getRequestDispatcher(resourcePath).forward(req, resp);
		
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		log.info("LOAD VIEW REQUEST SENT TO: " + req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/ERS/home.view":
			return "home";
		case "/ERS/user.view":
			return "users";
		case "/ERS/reimbursement.view":
			return "reimbursements";

		}
		
		return null;
	}

}
