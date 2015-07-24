package com.pentasys.design.pattern.facade;

public class Consumer {

	public static void main(String[] args) {
		Facade f = new Facade();
		System.out.println("----------------------------------------");
		System.out.println(f.createTheGreateText());
	}

}
