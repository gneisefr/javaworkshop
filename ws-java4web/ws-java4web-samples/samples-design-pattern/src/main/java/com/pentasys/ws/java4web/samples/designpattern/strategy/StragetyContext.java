package com.pentasys.ws.java4web.samples.designpattern.strategy;

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
