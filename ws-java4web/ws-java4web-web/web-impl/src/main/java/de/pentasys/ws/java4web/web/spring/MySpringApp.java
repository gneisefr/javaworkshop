package de.pentasys.ws.java4web.web.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MySpringApp {

	@Bean
	InjectedSpringBean mockInjectedSpringBean() {
		return new InjectedSpringBean() {
			public String getMyInjectedProperty() {
				return "Hello injected World!";
			}
		};
	}

	public String startSpring() {
		StartSpringBean startSpringBean;
		ApplicationContext context = new AnnotationConfigApplicationContext(MySpringApp.class);
		String hello = null;
		try {
			startSpringBean = context.getBean(StartSpringBean.class);
			hello = startSpringBean.getHello();
		} catch (BeansException e) {
			e.printStackTrace();
		} finally {
			((ConfigurableApplicationContext)context).close();
		}
		return hello;
	}
}
