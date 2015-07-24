package com.pentasys.design.pattern.cor;

public interface Cor {

	void process(CorContext ctx);

	void setNext(Cor next);

}
