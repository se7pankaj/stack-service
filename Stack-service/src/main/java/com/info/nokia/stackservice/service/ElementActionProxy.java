package com.info.nokia.stackservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="zuul-api-gateway")
@RibbonClient(name="stack-dbservice")
public interface ElementActionProxy {

	@GetMapping("/stack-dbservice/push/{element}")
	public String pushTheElement
		(@PathVariable("element") Integer from);

	@GetMapping("/stack-dbservice/pop")
	public String popTheElement();
}
