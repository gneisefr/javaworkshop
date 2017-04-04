package de.pentasys.ws.java4web.business.service;

import java.util.List;

import de.pentasys.ws.java4web.domain.User;

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
	User createUser(String name, String firstname, String password);

	/**
	 * Lege eine Person an.
	 * 
	 * @param person
	 *            der Benutzer
	 * @return die Id des Benutzers
	 */
	User create(User person);

	/**
	 * Löscht den Benutzer
	 * 
	 * @param user
	 */
	void remove(String id);

	User save(User person);

}
