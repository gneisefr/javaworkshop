package de.pentasys.ws.javaframeworks.domain;

import java.util.Date;
import java.util.List;

public class Appointment implements BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -487441404228329049L;

	private Date startTime;

	private Date endTime;

	private String location;

	private String purpose;

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
