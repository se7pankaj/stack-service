package com.info.nokia.stackservice.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.info.nokia.stackservice.presentation.StackPresentationImpl;

@RestController
public class StackController {

	@Autowired
	private StackPresentationImpl stackPresenationImpl;

	private final static Logger logger = LoggerFactory.getLogger(StackController.class);

	@DeleteMapping("stack/pop/{element}")
	public ResponseEntity<?> popElement(
			@RequestHeader(value = "authorization", defaultValue = "Bearer ") String authorization,
			@PathVariable String element) throws Exception {
		logger.info("Request received to getLocationDetails >>");

		String response = null;
		if (StringUtils.isNotBlank(element)) {
			response = stackPresenationImpl.popElement(Integer.valueOf(element));
		} else {
			return new ResponseEntity<String>("Unprocessable Request", HttpStatus.UNPROCESSABLE_ENTITY);
		}

		if (response == null)
			return ResponseEntity.notFound().build();
		logger.info("popElement method End");

		return ResponseEntity.ok(response);
	}
}
