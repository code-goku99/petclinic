package com.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petclinic.helper.SampleXmlConfHelper;
import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
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
	
	

	OwnerController(OwnerService ownerService,SupportServiceEgConfiuration supportService){
		this.supportService = supportService;
		this.ownerService = ownerService;
	}

	@RequestMapping("/{id}")
	public String getOwnerById(Model map,@PathVariable String id) {
		supportService.testCall();
		System.out.println(xmlConf.xmlHelper()+" Given Id : "+ id);
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
		//return "notImplemented";
		return "redirect:/owners/index";
	}
	
	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		Owner owner = this.ownerService.findById(Long.valueOf(ownerId));
		mav.addObject(owner);
		return mav;
	}
}
