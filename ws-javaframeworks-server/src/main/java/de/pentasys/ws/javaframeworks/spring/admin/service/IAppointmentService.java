package de.pentasys.ws.javaframeworks.spring.admin.service;

import java.util.Date;
import java.util.List;

import de.pentasys.ws.javaframeworks.persistence.admin.model.Appointment;

public interface IAppointmentService {

	public void addAppointment(Appointment app);

	public void removeAppointment(Appointment app);

	public List<Appointment> getAppointments(Date startDate, Date endDate);

}
