package de.pentasys.ws.java4web.persistence.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Eine Implementierung der Schnittstelle {@link GenericJpaDAO} für JPA.
 * 
 * @param <Entity>
 *            Die Klasse der Entität
 * @param <PrimaryKey>
 *            Die Klasse des primären Key
 */
public abstract class AbstractGenericJpaDAO<Entity, PrimaryKey extends Serializable>
		extends AbstractGenericDAO<Entity, PrimaryKey>implements GenericJpaDAO<Entity, PrimaryKey> {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * @return Liefert den {@link #entityManager}
	 */
	protected final EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see GenericDAO#create(java.lang.Object)
	 */
	public Entity create(Entity newPersistentObject) {
		entityManager.persist(newPersistentObject);
		return newPersistentObject;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see GenericDAO#save(java.lang.Object)
	 */
	public Entity save(Entity persistentObject) {
		return entityManager.merge(persistentObject);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see GenericDAO#remove(java.lang.Object)
	 */
	public void remove(Entity persistentObject) {
		entityManager.remove(persistentObject);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see GenericDAO#findByPrimaryKey(java.io.Serializable)
	 */
	public Entity findByPrimaryKey(PrimaryKey key) {
		return entityManager.find(entityClass, key);
	}

}
