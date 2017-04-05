package com.pentasys.ws.java4web.domain;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class Group extends AbstractBusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	@ApiModelProperty(dataType="java.util.List")
	private List<User> users;

}
