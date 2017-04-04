package de.pentasys.ws.java4web.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import de.pentasys.ws.java4web.business.service.AppointmentService;
import de.pentasys.ws.java4web.domain.Appointment;

@Component
@Qualifier("appointment service")
public class AppointmentServiceImpl implements AppointmentService {

	@Override
	public void addAppointment(Appointment app) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAppointment(Appointment app) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Appointment> getAppointments(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return new ArrayList<Appointment>();
	}

}
