package de.pentasys.ws.javaframeworks.web.servlets;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StartBeanJSP {

	public String getDateString() {
		return (new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss"))
				.format(new Date()) + " h";
	}

}
