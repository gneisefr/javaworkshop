package de.pentasys.ws.javaframeworks.persistence.admin.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

import de.pentasys.ws.javaframeworks.persistence.BaseBean;

@Entity
@Table(schema = "myschema")
@Access(AccessType.FIELD)
@NamedQueries(@NamedQuery(name = Appointment.FIND_ALL, query = "from Appointment p"))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Appointment extends BaseBean{

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

	@OneToMany(fetch = FetchType.LAZY, orphanRemoval=true)
	private List<User> mandatoryUsers;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public List<User> getMandatoryUsers() {
		return mandatoryUsers;
	}

	public void setMandatoryUsers(List<User> mandatoryUsers) {
		this.mandatoryUsers = mandatoryUsers;
	}

}
