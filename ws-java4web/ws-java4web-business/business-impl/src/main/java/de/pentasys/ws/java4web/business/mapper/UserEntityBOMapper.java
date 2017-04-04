package de.pentasys.ws.java4web.business.mapper;

import de.pentasys.ws.java4web.domain.User;
import de.pentasys.ws.java4web.persistence.model.UserEntity;

public final class UserEntityBOMapper extends AbstractEntityBOMapperImpl<User, UserEntity> {

	/** The Constant MANUAL_MAPPED_ATTRIBUTES. */

	private static final String[] MANUAL_MAPPED_ATTRIBUTES = new String[] { "group" };

	/** The instance. */
	private static UserEntityBOMapper instance;

	/**
	 * Instantiates a new User entity bo mapper.
	 */
	private UserEntityBOMapper() {
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
	public void mapBoManual(UserEntity entity, User bo) {
		if ((entity != null) && (bo != null)) {
			if (entity.getGroup() != null) {
				bo.setGroup(GroupEntityBOMapper.getInstance().createBoFromEntity(entity.getGroup()));
			}
		}
	}

	/**
	 * Gets the single instance of UserEntityBOMapper.
	 *
	 * @return single instance of UserEntityBOMapper
	 */
	public static synchronized UserEntityBOMapper getInstance() {
		if (instance == null) {
			instance = new UserEntityBOMapper();
		}
		return instance;
	}

}
