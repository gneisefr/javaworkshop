package com.pentasys.ws.java4web.samples.designpattern.factory;

public class Consumer {

	public static void main(String[] args) {
		Factory f = new FactoryImpl();
		Product product = f.createProduct();
		System.out.println("----------------------------------------");
		System.out.println(product.createText());
	}

}
