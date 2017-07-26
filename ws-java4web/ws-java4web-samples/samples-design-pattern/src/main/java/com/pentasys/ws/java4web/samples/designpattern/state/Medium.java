package com.pentasys.ws.java4web.samples.designpattern.state;

class Medium extends State {
	public void pull(Chain wrapper) {
		wrapper.setState(new High());
		System.out.println("   high speed");
	}
}