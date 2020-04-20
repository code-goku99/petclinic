package com.petclinic.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petclinic.helper.SampleXmlConfHelper;
import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
import com.petclinic.model.PetType;
import com.petclinic.service.OwnerService;
import com.petclinic.service.SupportServiceEgConfiuration;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

	@Autowired
	private SupportServiceEgConfiuration supportService;

	/*
	 * this bean SampleXmlConfHelper is used form xml file by using @Import
	 * annotation at spring boot startup
	 */
	@Autowired
	private SampleXmlConfHelper xmlConf;

	private final OwnerService ownerService;
	
	

	OwnerController(OwnerService ownerService, SupportServiceEgConfiuration supportService) {
		this.supportService = supportService;
		this.ownerService = ownerService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping("/{id}")
	public String getOwnerById( @PathVariable String id,Model map) {
		supportService.testCall();
		System.out.println(xmlConf.xmlHelper() + " Given Id : " + id);
		map.addAttribute("listOfOwner", this.ownerService.findAll());
		return "/owners/index";
	}

	@RequestMapping({  "/index", "/index.html" })
	public String index(Model map) {
		supportService.testCall();
		System.out.println(xmlConf.xmlHelper());
		map.addAttribute("listOfOwner", this.ownerService.findAll());
		return "/owners/index";
	}

	@RequestMapping({ "/find" })
	public String findOwner(Map<String, Object> model) {
		model.put("owner", new Owner());
		return "owners/findOwners";
		// return "notImplemented";
		// return "redirect:/owners/index";
	}

	@GetMapping
	public String processFindForm(Owner owner, BindingResult result, Model model) {
		if (owner.getFirstName() == null) {
			owner.setFirstName(""); 
		}

		List<Owner> results =  this.ownerService.findAllByFirstnameLike(owner.getFirstName());
		if (results.isEmpty()) {
			result.rejectValue("firstName", "notFound", "not found");
			return "owners/findOwners";
		} else if (results.size() == 1) {
			owner = results.iterator().next();
			return "redirect:/owners/" + owner.getId();
		} else {
			model.addAttribute("selections", results);
			return "owners/ownersList";
		}
	}

	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		Owner owner = this.ownerService.findById(Long.valueOf(ownerId));
		mav.addObject(owner);
		return mav;
	}
	
	
	@GetMapping("/new")
	public String initCreationForm(Map<String, Object> model) {
		Owner owner = new Owner();
		model.put("owner", owner);
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/new")
	public String processCreationForm(@Valid Owner owner, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.ownerService.save(owner);
			return "redirect:/owners/" + owner.getId();
		}
	}
	
	@GetMapping("/{ownerId}/edit")
	public String initUpdateOwnerForm(@PathVariable("ownerId") Long ownerId, Model model) {
		Owner owner = this.ownerService.findById(ownerId);
		Pet pet =new Pet();
		PetType petType = new PetType();
		petType.setName("whale");
		pet.setPetType(petType);
		model.addAttribute(owner);
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/{ownerId}/edit")
	public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result,
			@PathVariable("ownerId") Long ownerId) {
		if (result.hasErrors()) {
			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		}
		else {
			owner.setId(ownerId);
			this.ownerService.save(owner);
			return "redirect:/owners/{ownerId}";
		}
	}
	
}
