package de.pentasys.ws.javaframeworks.business.service;

import java.util.Date;
import java.util.List;

import de.pentasys.ws.javaframeworks.domain.Appointment;

public interface AppointmentService {

	public void addAppointment(Appointment app);

	public void removeAppointment(Appointment app);

	public List<Appointment> getAppointments(Date startDate, Date endDate);

}
