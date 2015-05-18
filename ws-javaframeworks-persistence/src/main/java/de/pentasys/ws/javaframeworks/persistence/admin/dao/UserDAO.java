package de.pentasys.ws.javaframeworks.persistence.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import de.pentasys.ws.javaframeworks.persistence.AbstractGenericJpaDAO;
import de.pentasys.ws.javaframeworks.persistence.admin.model.User;

/**
 * Ein DAO für einen Benutzer.
 * 
 * @param <Entity>
 *            Die Klasse der Entität
 * @param <PrimaryKey>
 *            Die Klasse des primären Key
 */
@Repository
public class UserDAO extends AbstractGenericJpaDAO<User, String> implements
		IUserDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.pentasys.ws.javaframeworks.persistence.dao.IPersonDAO#getPrimaryKey
	 * (de.pentasys.ws.javaframeworks.services.entities.Person)
	 */
	public String getPrimaryKey(User persistentObject) {
		return persistentObject.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.pentasys.ws.javaframeworks.persistence.dao.IPersonDAO#findAll()
	 */
	public List<User> findAll() {
		return getEntityManager().createNamedQuery(User.FIND_ALL, User.class)
				.getResultList();
	}

}
