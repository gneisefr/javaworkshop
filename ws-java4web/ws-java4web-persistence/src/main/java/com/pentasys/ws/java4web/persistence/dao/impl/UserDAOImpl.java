package de.pentasys.ws.java4web.persistence.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.pentasys.ws.java4web.persistence.dao.AbstractGenericJpaDAO;
import de.pentasys.ws.java4web.persistence.dao.UserDAO;
import de.pentasys.ws.java4web.persistence.model.UserEntity;

/**
 * Ein DAO für einen Benutzer.
 * 
 * @param <Entity>
 *            Die Klasse der Entität
 * @param <PrimaryKey>
 *            Die Klasse des primären Key
 */
@Repository
public class UserDAOImpl extends AbstractGenericJpaDAO<UserEntity, String> implements
		UserDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.pentasys.ws.java4web.persistence.dao.IPersonDAO#getPrimaryKey
	 * (de.pentasys.ws.java4web.services.entities.Person)
	 */
	public String getPrimaryKey(UserEntity persistentObject) {
		return persistentObject.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.pentasys.ws.java4web.persistence.dao.IPersonDAO#findAll()
	 */
	@Transactional(readOnly=true)
	public List<UserEntity> findAll() {
		return getEntityManager().createNamedQuery(UserEntity.FIND_ALL, UserEntity.class)
				.getResultList();
	}
	
	public List<UserEntity> findByName() {
		return getEntityManager().createNamedQuery(UserEntity.FIND_BY_NAME, UserEntity.class)
				.getResultList();
	}

}
