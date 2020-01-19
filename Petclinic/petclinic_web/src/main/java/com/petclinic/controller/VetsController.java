package com.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetsController {

	@RequestMapping({ "","/", "/index", "/vets.html" })
	public String index() {
		return "/vets/index";
	}
}
