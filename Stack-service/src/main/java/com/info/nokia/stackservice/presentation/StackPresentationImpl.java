package com.info.nokia.stackservice.presentation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.info.nokia.stackservice.controller.StackController;
import com.info.nokia.stackservice.service.ElementActionProxy;

@Service
public class StackPresentationImpl {

	
	private ElementActionProxy proxy;
	private final static Logger logger = LoggerFactory.getLogger(StackController.class);

	

	public String pushElement(@PathVariable Integer element) {

		String response = proxy.pushTheElement(element);

		logger.info("{}", response);
		
		return response;
	}
	
	public String popElement() {

		String response = proxy.popTheElement();

		logger.info("{}", response);
		
		return response;
	}
	
	public List<?> showElements() {

		List response = proxy.showAllElement();

		logger.info("{}", response);
		
		return response;
	}
}
