package de.pentasys.ws.javaframeworks.struts.user.action;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import de.pentasys.ws.javaframeworks.persistence.admin.model.User;
import de.pentasys.ws.javaframeworks.spring.admin.service.IUsers;

@Transactional
@Component(value = "userSpringAction")
public class UserSpringAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7854105730940212423L;

	// DI via Spring
	@Autowired
	IUsers personService;

	List<User> users;

	User user;

	String userId;

	public String execute() throws Exception {
		users = personService.getUsers();
		return SUCCESS;

	}

	public String createUser() throws Exception {
		if (user != null) {
			if (user.getId() == null || StringUtils.isEmpty(user.getId())) {
				personService.create(user);
			} else {
				personService.save(user);
			}
			user = null;
		}
		users = personService.getUsers();
		return SUCCESS;

	}

	public String edit() throws Exception {
		if (userId != null && !StringUtils.isEmpty(userId)) {
			user = personService.getUser(userId);
		}
		users = personService.getUsers();
		return SUCCESS;

	}

	public String delete() throws Exception {
		if (userId != null && !StringUtils.isEmpty(userId)) {
			personService.remove(userId);
		}
		users = personService.getUsers();
		return SUCCESS;

	}

	public IUsers getPersonService() {
		return personService;
	}

	public void setPersonService(IUsers personService) {
		this.personService = personService;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}