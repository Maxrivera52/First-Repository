package com.idat.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MenuControl {
	
	@GetMapping("/")
	public String menu() {
		return "/index";
	}
	@GetMapping("/menu")
	public String menu1() {
		return "/index";
	}
}
