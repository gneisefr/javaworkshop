package de.pentasys.ws.java4web.business.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import de.pentasys.ws.java4web.domain.Appointment;
import de.pentasys.ws.java4web.domain.User;
import de.pentasys.ws.java4web.persistence.model.AppointmentEntity;
import de.pentasys.ws.java4web.persistence.model.UserEntity;

/**
 * @author radanmar
 *
 */
public abstract class AppointmentMapperDecorator implements AppointmentMapper {
	
	@Autowired
	@Qualifier("delegate")
	private AppointmentMapper delegate;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public Appointment toAppointment(AppointmentEntity entity) {
		Appointment bo = this.delegate.toAppointment(entity);
		if (entity.getMandatoryUsers() != null && !entity.getMandatoryUsers().isEmpty()) {
			List<User> mandatoryUsers = new ArrayList<User>();
			for(UserEntity ue: entity.getMandatoryUsers()){
				mandatoryUsers.add(userMapper.toUserBO(ue));
			}
			bo.setMandatoryUsers(mandatoryUsers);
		}
		return bo;
	}

}
