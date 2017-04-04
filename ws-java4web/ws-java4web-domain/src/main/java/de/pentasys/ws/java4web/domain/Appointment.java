package de.pentasys.ws.java4web.domain;

import java.util.Date;
import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class Appointment extends AbstractBusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -487441404228329049L;

	private Date startTime;

	private Date endTime;

	private String location;

	private String purpose;

	private List<User> mandatoryUsers;

}
