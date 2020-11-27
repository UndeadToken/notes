package com.take.control.framework;

import java.io.Serializable;

public class ResponsePacket implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String response;
	
	public ResponsePacket(String response)
	{
		this.response = response;
	}
}
