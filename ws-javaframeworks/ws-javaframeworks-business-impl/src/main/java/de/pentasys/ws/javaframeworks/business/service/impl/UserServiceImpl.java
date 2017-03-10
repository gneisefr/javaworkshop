package de.pentasys.ws.javaframeworks.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.pentasys.ws.javaframeworks.business.mapper.UserEntityBOMapper;
import de.pentasys.ws.javaframeworks.business.service.UserService;
import de.pentasys.ws.javaframeworks.domain.User;
import de.pentasys.ws.javaframeworks.persistence.dao.UserDAO;
import de.pentasys.ws.javaframeworks.persistence.model.UserEntity;

@Service("users")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		List<UserEntity> entities = userDAO.findAll();
		for (UserEntity ue : entities) {
			users.add(UserEntityBOMapper.getInstance().createBoFromEntity(ue));
		}
		return users;
	}

	@Override
	public User getUser(String id) {
		UserEntity ue = userDAO.findByPrimaryKey(id);
		return UserEntityBOMapper.getInstance().createBoFromEntity(ue);
	}

	@Override
	public User createUser(String name, String firstname, String password) {
		User p = new User();
		p.setName(name);
		p.setFirstname(firstname);
		return create(p);
	}

	@Override
	public User create(User person) {
		return UserEntityBOMapper.getInstance()
				.createBoFromEntity(userDAO.create(UserEntityBOMapper.getInstance().createEntityFromBo(person)));
	}

	@Override
	public User save(User person) {
		UserEntity entity = UserEntityBOMapper.getInstance().createEntityFromBo(person);
		return UserEntityBOMapper.getInstance().createBoFromEntity(userDAO.save(entity));
	}

	@Override
	public void remove(String id) {
		userDAO.remove(id);
	}

}
