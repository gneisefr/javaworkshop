package com.pentasys.ws.java4web.samples.designpattern.cor;

public class Chain1 extends CorImpl {

	@Override
	protected void execute(CorContext ctx) {
		ctx.addText(ctx.getText() + "Dies ");
		next.process(ctx);
	}

}
