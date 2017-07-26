package com.pentasys.ws.java4web.samples.designpattern.state;

class Off extends State {
	public void pull(Chain wrapper) {
		wrapper.setState(new Low());
		System.out.println("   low speed");
	}
}