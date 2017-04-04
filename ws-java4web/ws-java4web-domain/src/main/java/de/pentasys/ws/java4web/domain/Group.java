package de.pentasys.ws.java4web.domain;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class Group extends AbstractBusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private List<User> users;

}
