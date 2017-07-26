package com.pentasys.ws.java4web.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pentasys.ws.java4web.persistence.model.UserEntity;

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