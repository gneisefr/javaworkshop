package de.pentasys.ws.javaframeworks.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.pentasys.ws.javaframeworks.business.service.AppointmentService;
import de.pentasys.ws.javaframeworks.business.service.impl.aop.LoggerProxy;

@Controller
@ComponentScan
public class AopController {

	@Autowired
	@Qualifier("appointment service")
	AppointmentService appService;

	@Autowired
	@Qualifier("appointment service decorator")
	AppointmentService appServiceDecorator;

	@Autowired
	@Qualifier("aop service")
	AppointmentService aopService;

	@RequestMapping(value = "/aop/decorator", method = RequestMethod.GET)
	public String byDecorator() {
		appServiceDecorator.addAppointment(null);
		appServiceDecorator.removeAppointment(null);
		return "aop";
	}

	@RequestMapping(value = "/aop/dynProxy", method = RequestMethod.GET)
	public String byDynProxy() {
		appService = (AppointmentService) LoggerProxy.newInstance(this.appService);
		appService.addAppointment(null);
		appService.removeAppointment(null);
		return "aop";
	}

	@RequestMapping(value = "/aop/aspectJ", method = RequestMethod.GET)
	public String byAspectJ() {
		aopService.addAppointment(null);
		aopService.removeAppointment(null);
		return "aop";
	}

}
