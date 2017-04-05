package com.pentasys.ws.java4web.samples.designpattern.cor;

public class Chain2 extends CorImpl {

	@Override
	protected void execute(CorContext ctx) {
		ctx.addText(ctx.getText() + "ist ");
		next.process(ctx);
	}

}
