package com.info.nokia.stackservice.service;

public interface StackService {

	public String pushElement(Integer element) throws Exception;
	public String popElement(Integer element) throws Exception;
	public String peekElement(Integer element) throws Exception;
}
