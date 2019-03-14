package com.comp645.atm.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/helloworld")
public class HelloWorldController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(@RequestParam String name) {
		return "hello " + name;
	}

}
