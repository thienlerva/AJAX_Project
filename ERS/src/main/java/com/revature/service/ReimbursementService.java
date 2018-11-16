package com.revature.service;



import java.util.List;

import com.revature.dao.DAO;
import com.revature.dao.ReimbursementDao;
import com.revature.pojo.Reimbursement;

public class ReimbursementService {

	private static DAO<Reimbursement, Integer> reimDao = new ReimbursementDao();
	
	//get all users
	public List<Reimbursement> getAllReimbursements() {
		
		List<Reimbursement> reim = reimDao.findAll();
		if(reim.size() == 0) return null;
		
		return reim;
	}
	
	public Reimbursement findById(Integer id) {
		Reimbursement reim;
		
		return reim = reimDao.findById(id);
	}
}
