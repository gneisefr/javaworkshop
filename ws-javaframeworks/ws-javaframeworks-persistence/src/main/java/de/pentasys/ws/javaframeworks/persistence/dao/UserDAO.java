package de.pentasys.ws.javaframeworks.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import de.pentasys.ws.javaframeworks.persistence.GenericDAO;
import de.pentasys.ws.javaframeworks.persistence.GenericJpaDAO;
import de.pentasys.ws.javaframeworks.persistence.model.UserEntity;

@Repository
public interface UserDAO extends GenericJpaDAO<UserEntity, String> {

	/**
	 * {@inheritDoc}
	 * 
	 * @see GenericDAO#getPrimaryKey(java.lang.Object)
	 */
	public abstract String getPrimaryKey(UserEntity persistentObject);

	/**
	 * Suche alle Benutzer.
	 * 
	 * @return alle Benutzer
	 */
	public abstract List<UserEntity> findAll();

}