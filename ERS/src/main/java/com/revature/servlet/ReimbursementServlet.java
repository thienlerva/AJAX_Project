package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Reimbursement;
import com.revature.service.ReimbursementService;

@WebServlet("/reimbursements")
public class ReimbursementServlet extends HttpServlet {

	static ReimbursementService reimService = new ReimbursementService();
	
	private static Logger log = Logger.getLogger(ReimbursementServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		log.trace("SERVLET IN REIMBURSEMENT");
		
		//consult service for data
		List<Reimbursement> reims = reimService.getAllReimbursements();
		System.out.println(reims);
		
		//convert to json
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reims);
		log.trace("FINDING ALL REIMBURSEMENTS IN JSON: " + json);
		
		//send request
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}
}
