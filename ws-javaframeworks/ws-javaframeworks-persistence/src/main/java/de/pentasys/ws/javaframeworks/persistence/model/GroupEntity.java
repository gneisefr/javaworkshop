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

import de.pentasys.ws.javaframeworks.persistence.BaseEntity;

/**
 * Die Klasse einer Person.
 */
@Entity
@Table(schema = "myschema")
@Access(AccessType.FIELD)
@NamedQueries(@NamedQuery(name = GroupEntity.FIND_ALL, query = "Select p from GroupEntity p"))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupEntity other = (GroupEntity) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
