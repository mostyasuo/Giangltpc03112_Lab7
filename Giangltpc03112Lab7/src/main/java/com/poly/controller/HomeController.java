package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home/index")
	public String index() {
		return "home/index";
	}

	@RequestMapping("/home/about")
	public String about() {
		System.out.println("About");
		System.out.println("About");
		System.out.println("About");
		System.out.println("About");
		System.out.println("About");
		System.out.println("About");
		System.out.println("About");
		return "home/about";
	}
}