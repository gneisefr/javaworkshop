package com.pentasys.ws.java4web.samples.designpattern.cor;

public class Chain5 extends CorImpl {

	@Override
	protected void execute(CorContext ctx) {
		ctx.addText(ctx.getText() + "Text");
	}

}
