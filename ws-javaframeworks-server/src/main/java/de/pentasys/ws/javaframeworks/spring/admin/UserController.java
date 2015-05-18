package de.pentasys.ws.javaframeworks.spring.admin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.pentasys.ws.javaframeworks.persistence.admin.model.User;
import de.pentasys.ws.javaframeworks.spring.admin.service.IUsers;

@Controller
@ComponentScan
public class UserController {

	@Autowired
	private IUsers userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.getUsers());
		return "users";
	}

	// For add and update person both
	@RequestMapping(value = "/users/create/", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") User p) {
		if (p.getId() == null || StringUtils.isEmpty(p.getId())) {
			// new user, add it
			this.userService.create(p);
		} else {
			// existing user, call update
			this.userService.save(p);
		}
		return "redirect:/spring/users";

	}

	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") String id) {

		this.userService.remove(id);
		return "redirect:/spring/users";
	}

	@RequestMapping("/edit/{id}")
	public String editUser(@PathVariable("id") String id, Model model) {
		model.asMap().clear();
		model.addAttribute("user", this.userService.getUser(id));
		model.addAttribute("listUsers", this.userService.getUsers());
		return "users";
	}
}