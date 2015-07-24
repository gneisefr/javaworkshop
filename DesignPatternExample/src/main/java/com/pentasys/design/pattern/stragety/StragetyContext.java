package com.pentasys.design.pattern.stragety;

public class StragetyContext {
	
	private Stragety s;

	public String text() {
		return s.text();
	}

	public StragetyContext(Stragety s) {
		super();
		this.s = s;
	}
	

}
