package de.pentasys.ws.javaframeworks.web.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import de.pentasys.ws.javaframeworks.business.service.UserService;
import de.pentasys.ws.javaframeworks.domain.User;
import de.pentasys.ws.javaframeworks.web.api.UserController;

@Controller
@ComponentScan
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;

	@Override
	public Model listAll(Model model) {
		model.addAttribute(MODEL_ATTR_USER, new User());
		model.addAttribute(MODEL_ATTR_USERS, this.userService.getUsers());
		return model;
	}

	@Override
	public ModelAndView createUser(User p) {
		if (p.getId() == null || StringUtils.isEmpty(p.getId())) {
			// new user, add it
			this.userService.create(p);
		} else {
			// existing user, call update
			this.userService.save(p);
		}
		return new ModelAndView("redirect:/spring/users");

	}

	@Override
	public ModelAndView removeUser(@PathVariable(REQUEST_PARAM_ID) String id) {
		this.userService.remove(id);
		return new ModelAndView("redirect:/spring/users");
	}

	@Override
	public String showUser(@PathVariable(REQUEST_PARAM_ID) String id, Model model) {
		model.asMap().clear();
		model.addAttribute(MODEL_ATTR_USER, this.userService.getUser(id));
		model.addAttribute(MODEL_ATTR_USERS, this.userService.getUsers());
		return "users";
	}
}