package de.pentasys.ws.javaframeworks.persistence.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Die Klasse einer Person.
 */
@Entity
@Table(schema = "myschema")
@Access(AccessType.FIELD)
@NamedQueries({ @NamedQuery(name = UserEntity.FIND_ALL, query = "Select p from UserEntity p"),
		@NamedQuery(name = UserEntity.FIND_BY_NAME, query = "Select p from UserEntity p where p.name = :p_name") })
@Inheritance(strategy = InheritanceType.JOINED)
@lombok.Getter
@lombok.Setter
public class UserEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7286807458462446188L;

	/** Konstante für die NamedQuery. */
	public static final String FIND_ALL = "User.findAll";
	public static final String FIND_BY_NAME = "User.findByName";

	/** Der Name des Benutzers. */
	@Basic(optional = false)
	@Column(nullable = false)
	private String name;

	/** Der Vorname des Benutzers. */
	@Basic
	private String firstname;

	/** Passwort */
	@Basic(optional = false)
	@Column(nullable = false)
	// @Type(type = "encryptedString")
	private String password;

	/** Die E-Mail des Benutzers. */
	@Basic(optional = false)
	@Column(nullable = false)
	private String email;

	@Basic
	private boolean active;

	@ManyToOne(fetch = FetchType.LAZY)
	private GroupEntity group;

}
