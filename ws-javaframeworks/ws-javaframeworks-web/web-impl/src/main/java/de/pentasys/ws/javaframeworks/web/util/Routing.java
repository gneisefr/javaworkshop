package de.pentasys.ws.javaframeworks.web.util;

import org.resthub.web.springmvc.router.Router;
import org.resthub.web.springmvc.router.Router.ActionDefinition;

public class Routing {

	public static String getUrl(String controllerInterface) {
		ActionDefinition action = Router.reverse(controllerInterface);
		return action.url;
	}

}
