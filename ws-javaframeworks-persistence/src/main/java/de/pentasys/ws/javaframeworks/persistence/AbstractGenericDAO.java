package de.pentasys.ws.javaframeworks.persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.log4j.Logger;

/**
 * Eine abstrakte Implementierung der Schnittstelle {@link GenericDAO}.
 * 
 * @param <Entity>
 *            Die Klasse der Entit�t
 * @param <PrimaryKey>
 *            Die Klasse des prim�ren Key
 */
public abstract class AbstractGenericDAO<Entity, PrimaryKey extends Serializable>
		implements GenericDAO<Entity, PrimaryKey> {

	/** Der zentrale Logger f�r die DAO's. */
	protected final static Logger logger = Logger.getLogger(GenericDAO.class);

	/** Die Klasse der Entit�t. */
	protected final Class<Entity> entityClass;

	/** Die Klasse des prim�ren Key. */
	protected final Class<PrimaryKey> primaryKeyClass;

	{
		ParameterizedType type = (ParameterizedType) getClass()
				.getGenericSuperclass();
		Type[] actualTypeArguments = type.getActualTypeArguments();

		@SuppressWarnings("unchecked")
		Class<Entity> entityClass = (Class<Entity>) actualTypeArguments[0];
		this.entityClass = entityClass;

		@SuppressWarnings("unchecked")
		Class<PrimaryKey> primaryKey = (Class<PrimaryKey>) actualTypeArguments[1];
		this.primaryKeyClass = primaryKey;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see GenericDAO#remove(java.io.Serializable)
	 */
	public void remove(PrimaryKey key) {
		remove(findByPrimaryKey(key));
	}

}
