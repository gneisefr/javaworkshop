package com.pentasys.ws.java4web.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

@lombok.Getter
@lombok.Setter
@lombok.ToString(exclude = { "password" })
public class User extends AbstractBusinessObject {

	private static final long serialVersionUID = 1L;

	private String name;

	private String firstname;
	
	@JsonIgnore
	private String password;

	private String email;

	private boolean active;

	private Group group;

}
