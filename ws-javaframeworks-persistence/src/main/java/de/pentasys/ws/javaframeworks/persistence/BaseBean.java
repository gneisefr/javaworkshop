package de.pentasys.ws.javaframeworks.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.jasypt.hibernate4.type.EncryptedStringType;

/**
 * Basisklasse für alle Datenviewer Entitäten.
 */
@TypeDef(name = "encryptedString", typeClass = EncryptedStringType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") })
@MappedSuperclass
public class BaseBean implements Serializable {

	/**
	 * SUID
	 */
	private static final long serialVersionUID = 6550396188480276003L;

	/**
	 * Laenge der Ids
	 */
	protected static final int ID_LENGTH = 40;

	/**
	 * Datenbank ID
	 */
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length = ID_LENGTH, name = "id", unique = true)
	private String id;

	/**
	 * Konstruktor.
	 */
	protected BaseBean() {
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            die ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseBean other = (BaseBean) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(getClass().getSimpleName());
		str.append("[id=").append(id);
		str.append("]");
		return str.toString();
	}

}