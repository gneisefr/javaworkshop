package de.pentasys.ws.javaframeworks.persistence.model;

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
@lombok.Getter
@lombok.Setter
@lombok.EqualsAndHashCode(of = { "id" })
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

}