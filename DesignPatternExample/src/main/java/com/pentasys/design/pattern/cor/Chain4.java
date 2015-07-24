package com.pentasys.design.pattern.cor;

public class Chain4 extends CorImpl {

	@Override
	protected void execute(CorContext ctx) {
		ctx.addText(ctx.getText() + "toller ");
		next.process(ctx);
	}

}
