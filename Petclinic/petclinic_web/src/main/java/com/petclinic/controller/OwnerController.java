package com.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petclinic.helper.SampleXmlConfHelper;
import com.petclinic.service.SupportServiceEgConfiuration;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	@Autowired
	private SupportServiceEgConfiuration supportService;
	
	@Autowired
	private SampleXmlConfHelper xmlConf;

	@RequestMapping({ "","/", "/index", "/index.html" })
	public String index() {
		supportService.testCall();
		System.out.println(xmlConf.xmlHelper());
		return "/owners/index";
	}
}
