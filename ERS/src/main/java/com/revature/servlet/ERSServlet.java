package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.log4j.Logger;


@WebServlet("/test")
public class ERSServlet extends GenericServlet {

	private static Logger log = Logger.getLogger(ERSServlet.class);

	static int counter = 0;
	
	@Override
	public void init() throws ServletException {
		log.trace("INITIALIZE HELLO SERVLET");
	}
	
	@Override
	public void destroy() {
		log.trace("DESTROYING SERVLET");
	}
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		String text = "<h1>HELLO ERS</h1>"
				 + "<br>" 
				+ "This is a response from the HELLOSERVLET"
				+ "<br>"
				+ "<i>Request #" + ++counter + "</i>";
		out.write(text);
		
	}
	
}
