package com.pentasys.ws.java4web.business.service;

import java.util.Date;
import java.util.List;

import com.pentasys.ws.java4web.domain.Appointment;

public interface AppointmentService {

	public void addAppointment(Appointment app);

	public void removeAppointment(Appointment app);

	public List<Appointment> getAppointments(Date startDate, Date endDate);

}
