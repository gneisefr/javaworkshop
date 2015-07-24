package com.pentasys.design.pattern.cor;

import java.util.HashMap;

public class CorContext extends HashMap<String, String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void addText(String text){
		this.put("1", text);
	}
	
	public String getText(){
		return this.get("1");
	}

}
