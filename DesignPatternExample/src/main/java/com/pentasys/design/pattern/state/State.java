package com.pentasys.design.pattern.state;

abstract class State {
	public void pull(Chain wrapper) {
		wrapper.setState(new Off());
		System.out.println("   turning off");
	}
}