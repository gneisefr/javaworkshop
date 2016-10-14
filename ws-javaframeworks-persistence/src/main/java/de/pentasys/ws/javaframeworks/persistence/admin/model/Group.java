package de.pentasys.ws.javaframeworks.persistence.admin.model;

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

import de.pentasys.ws.javaframeworks.persistence.BaseBean;

/**
 * Die Klasse einer Person.
 */
@Entity
@Table(schema = "myschema")
@Access(AccessType.FIELD)
@NamedQueries(@NamedQuery(name = Group.FIND_ALL, query = "from Group p"))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Group extends BaseBean {

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
	private List<User> users; 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		Group other = (Group) obj;
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
