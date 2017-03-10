package de.pentasys.ws.javaframeworks.persistence.model;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Die Klasse einer Person.
 */
@Entity
@Table(schema = "myschema")
@Access(AccessType.FIELD)
@NamedQueries(@NamedQuery(name = GroupEntity.FIND_ALL, query = "Select p from GroupEntity p"))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@lombok.Getter
@lombok.Setter
public class GroupEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7286807458462446188L;

	/** Konstante für die NamedQuery. */
	public static final String FIND_ALL = "Group.findAll";

	/** Name der Gruppe. */
	@Basic(optional = false)
	@Column(nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY)
	private List<UserEntity> users;

}
