package com.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petclinic.service.VetService;


@Controller
public class VetsController {

	@Autowired
	private VetService vetService;
	
	@RequestMapping({ "","/vets", "/vets/index", "/vets.html" })
	public String index(Model map) {
		map.addAttribute("vets", vetService.findAll());
		return "/vets/index";
	}
}
