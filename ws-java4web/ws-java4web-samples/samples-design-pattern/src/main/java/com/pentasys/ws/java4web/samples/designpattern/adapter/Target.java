package com.pentasys.ws.java4web.samples.designpattern.adapter;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface Target {

	String operation() throws ClientProtocolException, IOException;

}
