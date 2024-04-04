package com.pinks.SpringBootConf.Controler;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

	
	// So the @GetMapping annotaion is same as doGet() method of servlet . 
	// Below method name could be anything, as here foo this would be used by Spring to call when the JSP will ask the value of message variable
	// and this will be executed
	
	
	@GetMapping("greeting")
	public String foo(Map<String, Object> model) 
	{
		// The String variable "message" should be same as what we have given in the jsp ...
		// so here passing in the map as key
	model.put("message", "Abhishek Gupta");
	return "greeting";
	}
}
