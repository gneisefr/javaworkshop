package com.pentasys.ws.java4web.samples.designpattern.strategy;

public class StrategyOne {

	private static StragetyContext ctx;

	public static void main(String[] args) {
		ctx = new StragetyContext(new AlgorithmusOne());
		System.out.println("----------------------------------------");
		System.out.println(ctx.text());

	}
}
