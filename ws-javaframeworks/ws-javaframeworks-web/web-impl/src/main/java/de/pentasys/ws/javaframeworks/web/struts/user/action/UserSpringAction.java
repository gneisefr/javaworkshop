package de.pentasys.ws.javaframeworks.web.struts.user.action;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import de.pentasys.ws.javaframeworks.business.service.UserService;
import de.pentasys.ws.javaframeworks.domain.User;

@Transactional
@Component(value = "userSpringAction")
public class UserSpringAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7854105730940212423L;

	// DI via Spring
	@Autowired
	UserService userService;

	List<User> users;

	User user;

	String userId;

	public String execute() throws Exception {
		users = userService.getUsers();
		return SUCCESS;

	}

	public String createUser() throws Exception {
		if (user != null) {
			if (user.getId() == null || StringUtils.isEmpty(user.getId())) {
				userService.create(user);
			} else {
				userService.save(user);
			}
			user = null;
		}
		users = userService.getUsers();
		return SUCCESS;

	}

	public String edit() throws Exception {
		if (userId != null && !StringUtils.isEmpty(userId)) {
			user = userService.getUser(userId);
		}
		users = userService.getUsers();
		return SUCCESS;

	}

	public String delete() throws Exception {
		if (userId != null && !StringUtils.isEmpty(userId)) {
			userService.remove(userId);
		}
		users = userService.getUsers();
		return SUCCESS;

	}

	public UserService getPersonService() {
		return userService;
	}

	public void setPersonService(UserService personService) {
		this.userService = personService;
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