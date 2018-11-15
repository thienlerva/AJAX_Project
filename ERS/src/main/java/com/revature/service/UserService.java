package com.revature.service;



import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.User;

public class UserService {
	
	static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User("Tom", "hank"));
		users.add(new User("Frank", "harris"));
		users.add(new User("Jennifer", "chase"));
	}
	
	//get all users
	public List<User> getUsers() {
		return users;
	}
	
	//get by username
	private User getByUserName(String name) {
		
		User u = users.stream()
				.filter( x -> x.getUsername().equalsIgnoreCase(name))
				.findAny()
				.orElse(null);
		return u;
	}
	
	//validate password by username
	public User validateUser(String name, String password) {
		
		User u = getByUserName(name);
		if(u == null) return null;
		else if(u.getPassword().equals(password)) return u;
		else return null;
	}

}
