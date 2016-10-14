package de.pentasys.ws.javaframeworks.persistence.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import de.pentasys.ws.javaframeworks.persistence.GenericDAO;
import de.pentasys.ws.javaframeworks.persistence.GenericJpaDAO;
import de.pentasys.ws.javaframeworks.persistence.admin.model.User;

@Repository
public interface UserDAO extends GenericJpaDAO<User, String> {

	/**
	 * {@inheritDoc}
	 * 
	 * @see GenericDAO#getPrimaryKey(java.lang.Object)
	 */
	public abstract String getPrimaryKey(User persistentObject);

	/**
	 * Suche alle Benutzer.
	 * 
	 * @return alle Benutzer
	 */
	public abstract List<User> findAll();

}