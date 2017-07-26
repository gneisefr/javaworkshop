package com.pentasys.ws.java4web.samples.designpattern.state;

abstract class State {
	public void pull(Chain wrapper) {
		wrapper.setState(new Off());
		System.out.println("   turning off");
	}
}