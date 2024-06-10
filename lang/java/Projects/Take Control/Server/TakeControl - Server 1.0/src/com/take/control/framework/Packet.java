package com.take.control.framework;

import java.io.Serializable;
import java.util.Vector;

public class Packet implements Serializable {
	private static final long serialVersionUID = 1L;
	public String command;
	public Vector<String> parameters;
	public String clazz;
	
	public Packet(String command, Vector<String> parameters, String clazz)
	{
		this.command = command;
		this.parameters = parameters;
		this.clazz = clazz;
	}
}
