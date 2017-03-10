package de.pentasys.ws.javaframeworks.domain;

@lombok.Getter
@lombok.Setter
@lombok.ToString(exclude = { "password" })
public class User extends AbstractBusinessObject {

	private static final long serialVersionUID = 1L;

	private String name;

	private String firstname;

	private String password;

	private String email;

	private boolean active;

	private Group group;

}
