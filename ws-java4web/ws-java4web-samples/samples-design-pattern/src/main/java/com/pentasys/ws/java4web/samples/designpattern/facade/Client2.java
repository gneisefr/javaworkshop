package com.pentasys.ws.java4web.samples.designpattern.facade;

import java.util.Random;

public class Client2 {
	
	public int createRandom(){
		 Random ran = new Random();
		 return ran.nextInt();
	}

}
