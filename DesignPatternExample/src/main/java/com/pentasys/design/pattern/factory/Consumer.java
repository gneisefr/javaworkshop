package com.pentasys.design.pattern.factory;

public class Consumer {

	public static void main(String[] args) {
		Factory f = new FactoryImpl();
		Product product = f.createProduct();
		System.out.println("----------------------------------------");
		System.out.println(product.createText());
	}

}
