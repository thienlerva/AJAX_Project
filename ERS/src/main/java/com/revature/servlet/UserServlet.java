package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.BankUser;
import com.revature.pojo.User;
import com.revature.service.BankUserService;
import com.revature.service.UserService;
import org.apache.log4j.Logger;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

	
	static BankUserService uService = new BankUserService();
	
	private static Logger log = Logger.getLogger(UserServlet.class);
	
	//retrieve ALL users as JSON string
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.trace("SERVLET IN USERSERVLET");
		//consult service for data
		List<BankUser> users = uService.getAllUsers();
		//convert to json
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		log.trace("FINDING ALL USERS. JSON: " + json);
		
		//send response
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
		
	}
}
