package com.pentasys.design.pattern.cor;

public class Chain2 extends CorImpl {

	@Override
	protected void execute(CorContext ctx) {
		ctx.addText(ctx.getText() + "ist ");
		next.process(ctx);
	}

}
