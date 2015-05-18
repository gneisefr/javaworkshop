package de.pentasys.ws.javaframeworks.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartSpringBean {
	
	private InjectedSpringBean injectedSpringBean;

	@Autowired
	public StartSpringBean(InjectedSpringBean injectedSpringBean) {
		this.injectedSpringBean = injectedSpringBean;
		System.out.println("Konstruktor von StartSpringBean");
	}

	public String getHello() {
		return injectedSpringBean.getMyInjectedProperty();
	}

}
