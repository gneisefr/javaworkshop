package de.pentasys.ws.javaframeworks.persistence;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

/**
 * Ein generische DAO-Schnittstelle f�r eine Entit�t mit einem prim�ren Key.
 * 
 * @param <Entity>
 *            Die Klasse der Entit�t
 * @param <PrimaryKey>
 *            Die Klasse des prim�ren Key
 */
@Repository
public interface GenericDAO<Entity, PrimaryKey extends Serializable> {

	/**
	 * Liefere den prim�ren Key f�r das angegebene Objekt.
	 * 
	 * @param persistentObject
	 *            das persistente Objekt
	 * @return den prim�ren Key
	 */
	PrimaryKey getPrimaryKey(Entity persistentObject);

	/**
	 * Speichere das neue Objekt in der Datenbank.
	 * 
	 * @param newPersistentObject
	 *            das neue persistente Objekt
	 * @return den prim�ren Key
	 */
	PrimaryKey create(Entity newPersistentObject);

	/**
	 * Aktualisiere das ge�nderte Objekt in der Datenbank.
	 * 
	 * @param persistentObject
	 *            das persistente Objekt
	 */
	void save(Entity persistentObject);

	/**
	 * L�sche das persistente Objekt aus der Datenbank.
	 * 
	 * @param persistentObject
	 *            das persistente Objekt
	 */
	void remove(Entity persistentObject);

	/**
	 * L�sche das persistente Objekt aus der Datenbank.
	 * 
	 * @param key
	 *            der prim�re Key
	 */
	void remove(PrimaryKey key);

	/**
	 * Finde das persistente Objekt an Hand seines prim�ren Keys.
	 * 
	 * @param key
	 *            der prim�re Key
	 * @return das persistente Objekt
	 */
	Entity findByPrimaryKey(PrimaryKey key);

}
