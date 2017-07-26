package com.pentasys.ws.java4web.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD:ws-java4web/ws-java4web-business/business-impl/src/main/java/de/pentasys/ws/java4web/business/service/impl/UserServiceImpl.java
import de.pentasys.ws.java4web.business.mapper.UserMapper;
import de.pentasys.ws.java4web.business.service.UserService;
import de.pentasys.ws.java4web.domain.User;
import de.pentasys.ws.java4web.persistence.dao.UserDAO;
import de.pentasys.ws.java4web.persistence.model.UserEntity;
=======
import com.pentasys.ws.java4web.business.mapper.UserEntityBOMapper;
import com.pentasys.ws.java4web.business.service.UserService;
import com.pentasys.ws.java4web.domain.User;
import com.pentasys.ws.java4web.persistence.dao.UserDAO;
import com.pentasys.ws.java4web.persistence.model.UserEntity;
>>>>>>> 908f242d3ca7c84f3f50ec4545ec90e94740cf86:ws-java4web/ws-java4web-business/business-impl/src/main/java/com/pentasys/ws/java4web/business/service/impl/UserServiceImpl.java

@Service("users")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserMapper mapper;

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		List<UserEntity> entities = userDAO.findAll();
		for (UserEntity ue : entities) {
			users.add(mapper.toUserBO(ue));
		}
		return users;
	}

	@Override
	public User getUser(String id) {
		UserEntity ue = userDAO.findByPrimaryKey(id);
		return mapper.toUserBO(ue);
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
		return mapper.toUserBO((userDAO.create(mapper.toUserEntity(person))));
	}

	@Override
	public User save(User person) {
		UserEntity entity = mapper.toUserEntity(person);
		return mapper.toUserBO((userDAO.save(entity)));
	}

	@Override
	public void remove(String id) {
		userDAO.remove(id);
	}

}
