package com.pentasys.design.pattern.stragety;

public class StrategyOne {

	private static StragetyContext ctx;

	public static void main(String[] args) {
		ctx = new StragetyContext(new AlgorithmusOne());
		System.out.println("----------------------------------------");
		System.out.println(ctx.text());

	}
}
