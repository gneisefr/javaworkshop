package com.pentasys.design.pattern.state;

import java.io.IOException;
import java.io.InputStreamReader;

public class StateDisc {
	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		int ch;
		Chain chain = new Chain();
		while (true) {
			System.out.print("Press 'Enter'");
			ch = is.read();
			ch = is.read();
			chain.pull();
		}
	}
}