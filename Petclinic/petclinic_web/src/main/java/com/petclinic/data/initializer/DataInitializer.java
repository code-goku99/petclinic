package com.petclinic.data.initializer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petclinic.map.OwnerServiceMap;
import com.petclinic.map.VetServiceMap;
import com.petclinic.model.Owner;
import com.petclinic.model.Vet;
import com.petclinic.service.OwnerService;
import com.petclinic.service.VetService;

@Component
public class DataInitializer implements CommandLineRunner {

	OwnerService ownerService;
	VetService vetService;
	
	DataInitializer(){
		ownerService = new OwnerServiceMap();
		vetService = new VetServiceMap();
	}
	
	@Override
	public void run(String... args) throws Exception {

		Owner owner = new Owner();
		owner.setId(1L);
		owner.setFirstName("Jones");
		owner.setLastName("Thompson");
		
		ownerService.save(owner);
		
		Vet vet = new Vet();
		vet.setId(1L);
		vet.setFirstName("Arnold");
		vet.setLastName("Huges");
		 
		vetService.save(vet);
		
		System.out.println("Loaded Owners --vets ");
	}
	

}
