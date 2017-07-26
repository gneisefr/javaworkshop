package com.pentasys.ws.java4web.samples.designpattern.cor;

public abstract class CorImpl implements Cor {
	
	protected Cor next;
	
	public void process(CorContext ctx){
		this.execute(ctx);
	}

	protected abstract void execute(CorContext ctx);
	
	public void setNext(Cor next){
		this.next = next;
	}
}
