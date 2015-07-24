package com.pentasys.design.pattern.cor;

public class Chain3 extends CorImpl {

	@Override
	protected void execute(CorContext ctx) {
		ctx.addText(ctx.getText() + "ein ");
		next.process(ctx);
	}

}
