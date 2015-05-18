package de.pentasys.ws.javaframeworks.spring.admin.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.pentasys.ws.javaframeworks.persistence.admin.dao.IUserDAO;
import de.pentasys.ws.javaframeworks.persistence.admin.model.User;

@Service("users")
@Transactional
public class Users implements IUsers {

	@Autowired
	private IUserDAO userDAO;

	@Override
	public List<User> getUsers() {
		return userDAO.findAll();
	}

	@Override
	public User getUser(String id) {
		return userDAO.findByPrimaryKey(id);
	}

	@Override
	public String createUser(String name, String firstname, String password) {
		User p = new User();
		p.setName(name);
		p.setFirstname(firstname);
		return create(p);
	}

	@Override
	public String create(User person) {
		return userDAO.create(person);
	}

	@Override
	public User save(User person) {
		userDAO.save(person);
		return person;
	}

	@Override
	public void remove(String id) {
		userDAO.remove(id);
	}

}
