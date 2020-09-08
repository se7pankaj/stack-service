package com.info.nokia.services.stackdbservice.controller;

import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.nokia.services.stackdbservice.model.ExchangeValue;
import com.info.nokia.services.stackdbservice.service.ExchangeValueRepository;

@RestController
public class DbServiceController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@PostMapping("push/{element}")
	public String pushElementToDb(@PathVariable String element) {
		logger.info("Request received to push the element >>");
		//push element
		ExchangeValue value = new ExchangeValue();
		value.setElement(element);
		repository.save(value);
		logger.info("pushElementToDb end <<");
		return "Element added";
	}
	
	@DeleteMapping("pop")
	public String popElement() {
		logger.info("Request received to pop the element >>");
		List<ExchangeValue> elementList = repository.findAll();
		elementList.sort(Comparator.comparingLong(ExchangeValue::getId));
		repository.delete(elementList.get(0));
		return "poped Element is "+elementList.get(0).getElement();
	}
	@GetMapping("all-elements")
	public List<ExchangeValue> showElement() {
		logger.info("Request received to show the all element >>");
		List<ExchangeValue> elementList = repository.findAll();
		return elementList;
	}
}
