package de.pentasys.ws.javaframeworks.domain;

import java.util.List;

public class Group implements BusinessObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private List<User> users; 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
