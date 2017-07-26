package com.pentasys.ws.java4web.web.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import com.pentasys.ws.java4web.business.service.AppointmentService;
import com.pentasys.ws.java4web.business.service.impl.aop.LoggerProxy;
import com.pentasys.ws.java4web.web.api.AopController;

@RestController
@ComponentScan
public class AopControllerImpl implements AopController {

	@Autowired
	@Qualifier("appointment service")
	AppointmentService appService;

	@Autowired
	@Qualifier("appointment service decorator")
	AppointmentService appServiceDecorator;

	@Autowired
	@Qualifier("aop service")
	AppointmentService aopService;

	public String byDecorator() {
		appServiceDecorator.addAppointment(null);
		appServiceDecorator.removeAppointment(null);
		return "aop";
	}

	public String byDynProxy() {
		appService = (AppointmentService) LoggerProxy.newInstance(this.appService);
		appService.addAppointment(null);
		appService.removeAppointment(null);
		return "aop";
	}

	public String byAspectJ() {
		aopService.addAppointment(null);
		aopService.removeAppointment(null);
		return "aop";
	}

}
