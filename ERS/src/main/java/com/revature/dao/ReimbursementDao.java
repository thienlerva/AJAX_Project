package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDao implements DAO<Reimbursement, Integer> {

	@Override
	public List<Reimbursement> findAll() {
		
		List<Reimbursement> reimb = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String query = "select * from ers_reimbursement";
			
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getInt(1));
				temp.setReimbAmount(rs.getDouble(2));
				temp.setReimbSubmitted(rs.getString(3));
				temp.setReimbResolved(rs.getString(4));
				temp.setReimbDescription(rs.getString(5));
				temp.setReimbStatusId(rs.getInt(6));
				temp.setReimbTypeId(rs.getInt(7));
				reimb.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimb;
	}

	@Override
	public Reimbursement findById(Integer id) {
		
		
		Reimbursement reimb = null;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "select * from ers_reimbursement where reimb_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				reimb = new Reimbursement();
				reimb.setReimbId(rs.getInt(1));
				reimb.setReimbAmount(rs.getDouble(2));
				reimb.setReimbSubmitted(rs.getString(3));
				reimb.setReimbResolved(rs.getString(4));
				reimb.setReimbDescription(rs.getString(5));
				reimb.setReimbStatusId(rs.getInt(6));
				reimb.setReimbTypeId(rs.getInt(7));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reimb;
	}

	@Override
	public Reimbursement save(Reimbursement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement update(Reimbursement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Reimbursement obj) {
		// TODO Auto-generated method stub
		
	}

}
