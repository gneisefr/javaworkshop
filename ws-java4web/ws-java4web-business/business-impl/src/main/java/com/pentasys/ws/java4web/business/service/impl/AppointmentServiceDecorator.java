package com.pentasys.ws.java4web.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.pentasys.ws.java4web.business.service.AppointmentService;
import com.pentasys.ws.java4web.domain.Appointment;

@Component
@Qualifier("appointment service decorator")
public class AppointmentServiceDecorator implements AppointmentService {

	private static Logger logger = Logger.getLogger(AppointmentServiceDecorator.class);
	private AppointmentService decorated;

	@Override
	public void addAppointment(Appointment app) {
		logger.info("before method: addAppointment (by Decorator)");
		long start = System.nanoTime();
		decorated.addAppointment(app);
		long end = System.nanoTime();
		logger.info(String.format("%s took %d ns (by Decorator)", "addAppointment", (end - start)));
	}

	@Override
	public void removeAppointment(Appointment app) {
		logger.info("before method: removeAppointment (by Decorator)");
		long start = System.nanoTime();
		decorated.removeAppointment(app);
		long end = System.nanoTime();
		logger.info(String.format("%s took %d ns (by Decorator)", "removeAppointment", (end - start)));
	}

	@Override
	public List<Appointment> getAppointments(Date startDate, Date endDate) {
		logger.info("before method: getAppointments (by Decorator)");
		long start = System.nanoTime();
		decorated.getAppointments(startDate, endDate);
		long end = System.nanoTime();
		logger.info(String.format("%s took %d ns (by Decorator)", "getAppointments", (end - start)));
		return new ArrayList<Appointment>();
	}

	public AppointmentService getDecorated() {
		return decorated;
	}

	@Autowired
	@Qualifier("appointment service")
	public void setDecorated(AppointmentService decorated) {
		this.decorated = decorated;
	}

}
