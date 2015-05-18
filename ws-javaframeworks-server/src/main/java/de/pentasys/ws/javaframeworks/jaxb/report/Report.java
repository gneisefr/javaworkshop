package de.pentasys.ws.javaframeworks.jaxb.report;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import de.pentasys.ws.javaframeworks.jaxb.user.User;

/**
 * The base report.
 */
@XmlRootElement
@XmlType(name = "Report", propOrder = { "reportDate", "reportType", "users" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Report implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3475007133434435021L;

	@XmlAttribute(required = true)
	private String id;

	@XmlElement(required = true)
	private Date reportDate;

	@XmlElement(required = true)
	private ReportType reportType;

	@XmlElementWrapper(name = "users")
	@XmlElement(name = "user")
	private List<User> users;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public ReportType getReportType() {
		return reportType;
	}

	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
