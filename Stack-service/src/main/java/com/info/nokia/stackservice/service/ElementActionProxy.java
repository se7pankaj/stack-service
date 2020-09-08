package com.info.nokia.stackservice.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="zuul-api-gateway")
@RibbonClient(name="stack-dbservice")
public interface ElementActionProxy {

	@PostMapping("/stack-dbservice/push/{element}")
	public String pushTheElement
		(@PathVariable("element") Integer element);

	@DeleteMapping("/stack-dbservice/pop")
	public String popTheElement();
	
	@GetMapping("/stack-dbservice/all-elements")
	public List<?> showAllElement();
}
