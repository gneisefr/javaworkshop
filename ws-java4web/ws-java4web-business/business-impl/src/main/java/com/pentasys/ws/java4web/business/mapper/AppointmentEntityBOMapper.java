package com.pentasys.ws.java4web.business.mapper;

import java.util.ArrayList;
import java.util.List;

import com.pentasys.ws.java4web.domain.Appointment;
import com.pentasys.ws.java4web.domain.User;
import com.pentasys.ws.java4web.persistence.model.AppointmentEntity;
import com.pentasys.ws.java4web.persistence.model.UserEntity;

public final class AppointmentEntityBOMapper extends AbstractEntityBOMapperImpl<Appointment, AppointmentEntity> {

	/** The Constant MANUAL_MAPPED_ATTRIBUTES. */

	private static final String[] MANUAL_MAPPED_ATTRIBUTES = new String[] { "mandatoryUsers" };

	/** The instance. */
	private static AppointmentEntityBOMapper instance;

	/**
	 * Instantiates a new Appointment entity bo mapper.
	 */
	private AppointmentEntityBOMapper() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.audi.elvis.otdb.business.mapper.EntityBOMapperImpl#
	 * getManualMappedAttributes()
	 */
	@Override
	public String[] getManualMappedAttributes() {
		return MANUAL_MAPPED_ATTRIBUTES;
	}

	@Override
	public void mapBoManual(AppointmentEntity entity, Appointment bo) {
		if ((entity != null) && (bo != null)) {
			List<User> users = new ArrayList<User>();
			if (entity.getMandatoryUsers() != null && !entity.getMandatoryUsers().isEmpty()) {
				for (UserEntity u : entity.getMandatoryUsers()) {
					users.add(UserEntityBOMapper.getInstance().createBoFromEntity(u));
				}
			}
			bo.setMandatoryUsers(users);
		}
	}

	/**
	 * Gets the single instance of AppointmentEntityBOMapper.
	 *
	 * @return single instance of AppointmentEntityBOMapper
	 */
	public static synchronized AppointmentEntityBOMapper getInstance() {
		if (instance == null) {
			instance = new AppointmentEntityBOMapper();
		}
		return instance;
	}

}
