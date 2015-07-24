package com.pentasys.design.pattern.adapter;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface Target {

	String operation() throws ClientProtocolException, IOException;

}
