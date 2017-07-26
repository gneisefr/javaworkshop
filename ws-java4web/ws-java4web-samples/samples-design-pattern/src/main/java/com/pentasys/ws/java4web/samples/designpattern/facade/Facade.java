package com.pentasys.ws.java4web.samples.designpattern.facade;

public class Facade {

	public String createTheGreateText(){
		Client1 c1 = new Client1();
		Client2 c2 = new Client2();
		return c1.createText() + c2.createRandom();
	}
}
