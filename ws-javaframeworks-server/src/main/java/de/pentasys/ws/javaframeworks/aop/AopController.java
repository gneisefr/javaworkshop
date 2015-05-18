package de.pentasys.ws.javaframeworks.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.pentasys.ws.javaframeworks.spring.admin.service.IAppointmentService;

@Controller
@ComponentScan
public class AopController {

	@Autowired
	@Qualifier("appointment service")
	IAppointmentService appService;

	@Autowired
	@Qualifier("appointment service decorator")
	IAppointmentService appServiceDecorator;

	@Autowired
	@Qualifier("aop service")
	IAppointmentService aopService;

	@RequestMapping(value = "/aop/decorator", method = RequestMethod.GET)
	public String byDecorator() {
		appServiceDecorator.addAppointment(null);
		appServiceDecorator.removeAppointment(null);
		return "aop";
	}

	@RequestMapping(value = "/aop/dynProxy", method = RequestMethod.GET)
	public String byDynProxy() {
		appService = (IAppointmentService) LoggerProxy
				.newInstance(this.appService);
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
