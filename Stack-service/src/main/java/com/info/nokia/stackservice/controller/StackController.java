package com.info.nokia.stackservice.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.info.nokia.stackservice.presentation.StackPresentationImpl;

@RestController
public class StackController {

	@Autowired
	private StackPresentationImpl stackPresenationImpl;

	private final static Logger logger = LoggerFactory.getLogger(StackController.class);

	@PostMapping("push/{element}")
	public ResponseEntity<?> pushElement(
			@RequestHeader(value = "authorization", defaultValue = "Bearer ") String authorization,
			@PathVariable String element) throws Exception {
		logger.info("Request received to pop stack element >>");

		String response = null;
		if (StringUtils.isNotBlank(element)) {
			response = stackPresenationImpl.pushElement(Integer.valueOf(element));
		} else {
			return new ResponseEntity<String>("Unprocessable Request", HttpStatus.UNPROCESSABLE_ENTITY);
		}

		if (response == null)
			return ResponseEntity.notFound().build();
		logger.info("popElement method End");

		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("pop")
	public ResponseEntity<?> popElement(
			@RequestHeader(value = "authorization", defaultValue = "Bearer ") String authorization,
			@PathVariable String element) throws Exception {
		logger.info("Request received to pop stack element >>");

		String response = null;
		
			response = stackPresenationImpl.popElement();
			
		if (response == null)
			return ResponseEntity.notFound().build();
		logger.info("popElement method End");

		return ResponseEntity.ok(response);
	}
	
	@GetMapping("elements")
	public ResponseEntity<?> showElements(
			@RequestHeader(value = "authorization", defaultValue = "Bearer ") String authorization) throws Exception {
		logger.info("Request received to show stack element >>");

		List<?> response = null;
		
			response = stackPresenationImpl.showElements();

		if (response == null)
			return ResponseEntity.notFound().build();
		logger.info("popElement method End");

		return ResponseEntity.ok(response);
	}
}
