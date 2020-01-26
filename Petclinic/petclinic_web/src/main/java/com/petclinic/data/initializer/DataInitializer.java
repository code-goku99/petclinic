package com.petclinic.data.initializer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petclinic.model.Owner;
import com.petclinic.model.PetType;
import com.petclinic.model.Vet;
import com.petclinic.service.OwnerService;
import com.petclinic.service.PetTypeService;
import com.petclinic.service.VetService;

@Component
public class DataInitializer implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	//@Autowired By default these get autowired
	public DataInitializer(OwnerService ownerService, VetService vetService,
			PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}



	@Override
	public void run(String... args) throws Exception {

		PetType tRex=new PetType();
		tRex.setName("T-rex");
		petTypeService.save(tRex);
		
		PetType whale=new PetType();
		whale.setName("Whale");
		petTypeService.save(whale);
		
		
		Owner owner = new Owner();
		owner.setFirstName("Jones");
		owner.setLastName("Thompson");
		
		ownerService.save(owner);
		
		Vet vet = new Vet();
		vet.setFirstName("Arnold");
		vet.setLastName("Huges");
		 
		vetService.save(vet);
		
		System.out.println("Loaded Owners --vets ");
	}
	

}
