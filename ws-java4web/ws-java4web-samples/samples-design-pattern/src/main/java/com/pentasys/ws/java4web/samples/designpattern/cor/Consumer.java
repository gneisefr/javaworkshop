package com.pentasys.ws.java4web.samples.designpattern.cor;

public class Consumer {

	public static void main(String[] args) {
		CorContext ctx = new CorContext();
		ctx.addText("test: ");
		
		Cor c1 = new Chain1();
		Cor c2 = new Chain2();
		Cor c3 = new Chain3();
		Cor c4 = new Chain4();
		Cor c5 = new Chain5();
		
		c1.setNext(c2);
		c2.setNext(c3);
		c3.setNext(c4);
		c4.setNext(c5);
		
		c1.process(ctx);

		System.out.println("----------------------------------------");
		System.out.println(ctx.getText());

		
	}

}
