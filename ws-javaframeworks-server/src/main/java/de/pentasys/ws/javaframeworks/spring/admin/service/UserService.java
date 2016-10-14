package de.pentasys.ws.javaframeworks.spring.admin.service;

import java.util.List;

import de.pentasys.ws.javaframeworks.persistence.admin.model.User;

/**
 * Das Interface zum Service Users.
 */
public interface UserService {

	/**
	 * Hole alle Benutzer.
	 * 
	 * @return die Liste der Benutzer
	 */
	List<User> getUsers();

	/**
	 * Hole eine Person.
	 * 
	 * @param id
	 *            die Id eines Benutzers
	 * @return der Benutzer
	 */
	User getUser(String id);

	/**
	 * Lege einen Benutzer an.
	 * 
	 * @param name
	 *            der Name der Benutzer
	 * @param firstname
	 *            der Vorname der Benutzer
	 * @return die Id der Benutzer
	 */
	String createUser(String name, String firstname, String password);

	/**
	 * Lege eine Person an.
	 * 
	 * @param person
	 *            der Benutzer
	 * @return die Id des Benutzers
	 */
	String create(User person);

	/**
	 * Speichere den Benutzer.
	 * 
	 * @param user
	 *            den Benutzer
	 */
	User save(User user);

	/**
	 * Löscht den Benutzer
	 * 
	 * @param user
	 */
	void remove(String id);

}
