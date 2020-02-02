package com.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petclinic.helper.SampleXmlConfHelper;
import com.petclinic.service.OwnerService;
import com.petclinic.service.SupportServiceEgConfiuration;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	@Autowired
	private SupportServiceEgConfiuration supportService;
	
	/*
	 * this bean SampleXmlConfHelper is used form xml file by using @Import
	 * annotation at spring boot startup
	 */
	@Autowired
	private SampleXmlConfHelper xmlConf;
	
	private final OwnerService ownerService;
	
	OwnerController(OwnerService ownerService){
		this.ownerService = ownerService;
	}

	@RequestMapping({"/:id"})
	public String getOwnerById(Model map,String id) {
		supportService.testCall();
		System.out.println(xmlConf.xmlHelper());
		map.addAttribute("listOfOwner", this.ownerService.findAll());
		return "/owners/index";
	}
	
	
	@RequestMapping({ "","/", "/index", "/index.html" })
	public String index(Model map) {
		supportService.testCall();
		System.out.println(xmlConf.xmlHelper());
		map.addAttribute("listOfOwner", this.ownerService.findAll());
		return "/owners/index";
	}
	
	@RequestMapping({"/find" })
	public String findOwner() {
		return "notImplemented";
	}
	
	
}
