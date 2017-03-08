package de.pentasys.ws.javaframeworks.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.jasypt.hibernate4.type.EncryptedStringType;

/**
 * Basisklasse für alle Datenviewer Entitäten.
 */
@TypeDef(name = "encryptedString", typeClass = EncryptedStringType.class, parameters = {
		@Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") })
@MappedSuperclass
public class BaseEntity implements Serializable {

	/**
	 * SUID
	 */
	private static final long serialVersionUID = 6550396188480276003L;

	/** The Constant ID_LENGTH. */
	protected static final int ID_LENGTH = 40;

	/** The Constant SHORT_LENGTH. */
	protected static final int SHORT_LENGTH = 20;

	/** The Constant NORMAL_LENGTH. */
	protected static final int NORMAL_LENGTH = 40;

	/** The Constant FULL_LENGTH. */
	protected static final int FULL_LENGTH = 255;

	/** The Constant MAX_LENGTH. */
	protected static final int MAX_LENGTH = 4000;

	/**
	 * Datenbank ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = ID_LENGTH, name = "id", unique = true)
	private String id;

	/** The created. */
	@Column(name = "CREATED", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date created;
	// public abstract void setIdInternal(PK id);

	/** The modified. */
	@Column(name = "LAST_UPD")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date modified;

	/** The created by. */
	@Column(name = "CREATED_BY", length = SHORT_LENGTH, updatable = false, nullable = true)
	protected String createdBy;

	/** The modified by. */
	@Column(name = "LAST_UPD_BY", length = SHORT_LENGTH, nullable = true)
	protected String modifiedBy;

	/** The version. */
	@Version
	@Column(name = "VERSION_", columnDefinition = "INTEGER default 1")
	protected Long version;

	/**
	 * Konstruktor.
	 */
	protected BaseEntity() {
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
	 * Pre persist.
	 */
	@PrePersist
	protected void prePersist() {
		this.created = new Date();
		this.modified = this.created;
		this.modifiedBy = this.createdBy;

	}

	/**
	 * Pre update.
	 */
	@PreUpdate
	protected void preUpdate() {
		this.modified = new Date();
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
		BaseEntity other = (BaseEntity) obj;
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