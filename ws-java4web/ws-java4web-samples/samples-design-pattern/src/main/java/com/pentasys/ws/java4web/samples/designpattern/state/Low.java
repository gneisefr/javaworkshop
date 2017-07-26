package com.pentasys.ws.java4web.samples.designpattern.state;

class Low extends State {
	public void pull(Chain wrapper) {
		wrapper.setState(new Medium());
		System.out.println("   medium speed");
	}
}