package com.pentasys.ws.java4web.samples.designpattern.cor;

public interface Cor {

	void process(CorContext ctx);

	void setNext(Cor next);

}
