package com.pentasys.ws.java4web.persistence.dao;

import java.io.Serializable;

/**
 * Eine Erweiterung der Schnittstelle {@link GenericDAO} f�r JPA.
 * 
 * @param <Entity>
 *            Die Klasse der Entit�t
 * @param <PrimaryKey>
 *            Die Klasse des prim�ren Key
 * @see de.rahn.db.dao.GenericDAO
 */
public interface GenericJpaDAO<Entity, PrimaryKey extends Serializable> extends
		GenericDAO<Entity, PrimaryKey> {

	// Noch keine spezielle Definitionen.

}
