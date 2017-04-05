package com.pentasys.ws.java4web.samples.designpattern.factory;

public class FactoryImpl implements Factory {

	public Product createProduct(){
		Class<?> class1 = null;
		try {
			class1 = Class.forName("com.pentasys.design.pattern.factory.ProductImpl");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			return (Product) class1.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
