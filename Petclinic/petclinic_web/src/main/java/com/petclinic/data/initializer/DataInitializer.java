package com.petclinic.data.initializer;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
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
		PetType trexType = petTypeService.save(tRex);
		
		PetType whale=new PetType();
		whale.setName("Whale");
		PetType whaleType = petTypeService.save(whale);
		
		
		Owner owner = new Owner();
		owner.setFirstName("Jones");
		owner.setLastName("Thompson");
		owner.setAddress("Miami");
		owner.setCity("Miami");
		owner.setTelephone("0o0o0o0");
		
		Pet jonesPet = new Pet();
		jonesPet.setOwner(owner);
		jonesPet.setName("tranquil");
		jonesPet.setPetType(trexType);
		owner.getPets().add(jonesPet);
		
		ownerService.save(owner);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Sos");
		owner2.setLastName("Thompson");
		owner2.setAddress("Miami");
		owner2.setCity("Miami");
		owner2.setTelephone("0o0o0o0");
		
		Pet thompsonPet = new Pet();
		thompsonPet.setOwner(owner);
		thompsonPet.setName("tranquil");
		thompsonPet.setPetType(trexType);
		owner2.getPets().add(thompsonPet);
		
		
		ownerService.save(owner2);
		
		Vet vet = new Vet();
		vet.setFirstName("Arnold");
		vet.setLastName("Huges");
		 
		vetService.save(vet);
		
		System.out.println("Loaded Owners --vets ");
	}
	

}
