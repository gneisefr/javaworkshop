package de.pentasys.ws.java4web.web.api;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.pentasys.ws.java4web.domain.User;

public interface UserController {

	public static final String MODEL_ATTR_USER = "user";
	public static final String MODEL_ATTR_USERS = "users";
	public static final String REQUEST_PARAM_ID = "id";

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Model listAll(Model model);

	// For add and update person both
	@RequestMapping(value = "/users/create/", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute(MODEL_ATTR_USER) User p);

	@RequestMapping(value = "/users/delete/{" + REQUEST_PARAM_ID + "}")
	public ModelAndView removeUser(@PathVariable String id);

	@RequestMapping(value = "users/show/{" + REQUEST_PARAM_ID + "}", method = RequestMethod.GET)
	public String showUser(@PathVariable String id, Model model);

}