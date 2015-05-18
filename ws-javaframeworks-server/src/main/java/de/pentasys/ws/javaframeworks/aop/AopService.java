package de.pentasys.ws.javaframeworks.aop;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import de.pentasys.ws.javaframeworks.persistence.admin.model.Appointment;
import de.pentasys.ws.javaframeworks.spring.admin.service.AppointmentService;

@Component
@Qualifier("aop service")
public class AopService extends AppointmentService {

	@Override
	public void addAppointment(Appointment app) {
		// TODO Auto-generated method stub
		super.addAppointment(app);
	}

	@Override
	public void removeAppointment(Appointment app) {
		// TODO Auto-generated method stub
		super.removeAppointment(app);
	}

	@Override
	public List<Appointment> getAppointments(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return super.getAppointments(startDate, endDate);
	}

}
