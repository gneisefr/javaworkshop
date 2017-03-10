package de.pentasys.ws.javaframeworks.domain;

@lombok.Getter
@lombok.Setter
@lombok.EqualsAndHashCode(of = { "id", "version" })
@lombok.ToString
public class AbstractBusinessObject implements BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8587363221930228929L;

	private String id;

	private Long version;

}
