package com.pentasys.ws.java4web.business.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.pentasys.ws.java4web.domain.Group;
import com.pentasys.ws.java4web.domain.User;
import com.pentasys.ws.java4web.persistence.model.GroupEntity;
import com.pentasys.ws.java4web.persistence.model.UserEntity;

/**
 * @author radanmar
 *
 */
public abstract class GroupMapperDecorator implements GroupMapper {

	@Autowired
	@Qualifier("delegate")
	private GroupMapper delegate;

	@Autowired
	private UserMapper userMapper;

	@Override
	public Group toGroupBO(GroupEntity entity) {
		Group bo = this.delegate.toGroupBO(entity);
		if (entity.getUsers() != null && !entity.getUsers().isEmpty()) {
			List<User> users = new ArrayList<User>();
			for (UserEntity ue : entity.getUsers()) {
				ue.setGroup(null);
				users.add(userMapper.toUserBO(ue));
			}
			bo.setUsers(users);
		}
		return bo;
	}

	@Override
	public GroupEntity toGroupEntity(Group bo) {
		GroupEntity e = this.delegate.toGroupEntity(bo);
		if (bo.getUsers() != null && !bo.getUsers().isEmpty()) {
			List<UserEntity> users = new ArrayList<UserEntity>();
			for (User ubo : bo.getUsers()) {
				ubo.setGroup(null);
				users.add(userMapper.toUserEntity(ubo));
			}
			e.setUsers(users);
		}
		return e;
	}

}
