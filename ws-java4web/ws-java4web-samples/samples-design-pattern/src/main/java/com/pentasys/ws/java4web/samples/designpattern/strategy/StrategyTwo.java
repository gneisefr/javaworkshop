package com.pentasys.ws.java4web.samples.designpattern.strategy;

public class StrategyTwo {
	
	private static StragetyContext ctx;

	public static void main(String[] args) {
		ctx = new StragetyContext(new AlgorithmusTwo());
		System.out.println("----------------------------------------");
		System.out.println(ctx.text());

	}

}
