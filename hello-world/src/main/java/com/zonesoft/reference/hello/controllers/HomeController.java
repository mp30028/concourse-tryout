package com.zonesoft.reference.hello.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping(value={"","/","/greeting"})
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		
		return "greeting";
	}

	@GetMapping(value={"/login"})
	public String login() {		
		return "login";
	}	

	@GetMapping(value={"/hello"})
	public String hello() {		
		return "hello";
	}		
}