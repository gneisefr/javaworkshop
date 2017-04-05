package com.pentasys.ws.java4web.samples.designpattern.adapter;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public class Client {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		Target t = new Adapter();
		System.out.println("----------------------------------------");
		System.out.println(t.operation());
	}

}
