package com.pentasys.ws.java4web.web.jaxb.user;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A user.
 */
@XmlType(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5172720434163020553L;

	@XmlElement(required = true)
	private String name;

	@XmlElement(required = true)
	private String firstName;

	@XmlElement(required = true)
	private String email;

	@XmlElement(required = true)
	private Boolean active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
