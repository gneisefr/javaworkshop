package de.pentasys.ws.javaframeworks.business.mapper;

import java.util.ArrayList;
import java.util.List;

import de.pentasys.ws.javaframeworks.domain.Group;
import de.pentasys.ws.javaframeworks.domain.User;
import de.pentasys.ws.javaframeworks.persistence.model.GroupEntity;
import de.pentasys.ws.javaframeworks.persistence.model.UserEntity;

public final class GroupEntityBOMapper extends AbstractEntityBOMapperImpl<Group, GroupEntity> {

	/** The Constant MANUAL_MAPPED_ATTRIBUTES. */

	private static final String[] MANUAL_MAPPED_ATTRIBUTES = new String[] { "users" };

	/** The instance. */
	private static GroupEntityBOMapper instance;

	/**
	 * Instantiates a new Group entity bo mapper.
	 */
	private GroupEntityBOMapper() {
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
	public void mapBoManual(GroupEntity entity, Group bo) {
		if ((entity != null) && (bo != null)) {
			List<User> users = new ArrayList<User>();
			if (entity.getUsers() != null && !entity.getUsers().isEmpty()) {
				for (UserEntity u : entity.getUsers()) {
					users.add(UserEntityBOMapper.getInstance().createBoFromEntity(u));
				}
			}
			bo.setUsers(users);
		}
	}

	/**
	 * Gets the single instance of GroupEntityBOMapper.
	 *
	 * @return single instance of GroupEntityBOMapper
	 */
	public static synchronized GroupEntityBOMapper getInstance() {
		if (instance == null) {
			instance = new GroupEntityBOMapper();
		}
		return instance;
	}

}
