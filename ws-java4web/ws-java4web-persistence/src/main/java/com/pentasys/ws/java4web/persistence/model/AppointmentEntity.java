package com.pentasys.ws.java4web.persistence.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema = "myschema")
@Access(AccessType.FIELD)
@NamedQueries(@NamedQuery(name = AppointmentEntity.FIND_ALL, query = "Select p from AppointmentEntity p"))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@lombok.Getter
@lombok.Setter
public class AppointmentEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1420891171027683314L;

	/** Konstante für die NamedQuery. */
	public static final String FIND_ALL = "Appointment.findAll";

	@Temporal(value = TemporalType.TIME)
	@Column(nullable = false)
	private Date startTime;

	@Temporal(value = TemporalType.TIME)
	@Column(nullable = false)
	private Date endTime;

	@Basic(optional = false)
	@Column(nullable = false)
	private String location;

	@Basic(optional = false)
	@Column(nullable = false)
	private String purpose;

	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
	private List<UserEntity> mandatoryUsers;

}