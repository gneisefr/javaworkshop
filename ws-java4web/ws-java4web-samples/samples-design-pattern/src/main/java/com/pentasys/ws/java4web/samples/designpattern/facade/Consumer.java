package com.pentasys.ws.java4web.samples.designpattern.facade;

public class Consumer {

	public static void main(String[] args) {
		Facade f = new Facade();
		System.out.println("----------------------------------------");
		System.out.println(f.createTheGreateText());
	}

}
