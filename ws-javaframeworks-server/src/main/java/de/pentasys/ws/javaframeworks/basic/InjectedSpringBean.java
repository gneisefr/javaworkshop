package de.pentasys.ws.javaframeworks.basic;

public class InjectedSpringBean {

	private String myInjectedProperty;

	public String getMyInjectedProperty() {
		return myInjectedProperty;
	}

	public void setMyInjectedProperty(String myInjectedProperty) {
		this.myInjectedProperty = myInjectedProperty;
	}

	public InjectedSpringBean() {
		System.out.println("Konstruktor von InjectedSpringBean");
	}

}
