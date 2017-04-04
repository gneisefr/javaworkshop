package de.pentasys.ws.java4web.web.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface AopController {

	@RequestMapping(value = "/aop/decorator", method = RequestMethod.GET)
	public String byDecorator();

	@RequestMapping(value = "/aop/dynProxy", method = RequestMethod.GET)
	public String byDynProxy();

	@RequestMapping(value = "/aop/aspectJ", method = RequestMethod.GET)
	public String byAspectJ();

}
