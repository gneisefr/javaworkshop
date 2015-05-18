package de.pentasys.ws.javaframeworks.spring.admin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import de.pentasys.ws.javaframeworks.persistence.admin.model.Appointment;

@Component
@Qualifier("appointment service")
public class AppointmentService implements IAppointmentService {

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
