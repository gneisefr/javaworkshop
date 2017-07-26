package com.pentasys.ws.java4web.business.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.pentasys.ws.java4web.domain.User;
import com.pentasys.ws.java4web.persistence.model.UserEntity;

/**
 * @author radanmar
 *
 */
public abstract class UserMapperDecorator implements UserMapper {
	
	@Autowired
	@Qualifier("delegate")
	private UserMapper delegate;
	
	@Autowired
	private GroupMapper groupMapper;

	@Override
	public User toUserBO(UserEntity entity) {
		User bo = this.delegate.toUserBO(entity);
		if (entity.getGroup() != null) {
			entity.getGroup().setUsers(null);
			bo.setGroup(groupMapper.toGroupBO(entity.getGroup()));
		}
		return bo;
	}
	
	@Override
	public UserEntity toUserEntity(User bo) {
		UserEntity e = this.delegate.toUserEntity(bo);
		if (bo.getGroup() != null) {
			bo.getGroup().setUsers(null);
			e.setGroup(groupMapper.toGroupEntity(bo.getGroup()));
		}
		return e;
	}

}
