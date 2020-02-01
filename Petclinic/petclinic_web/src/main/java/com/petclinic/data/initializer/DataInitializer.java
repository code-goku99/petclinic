package com.petclinic.data.initializer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
import com.petclinic.model.PetType;
import com.petclinic.model.Speciality;
import com.petclinic.model.Vet;
import com.petclinic.service.OwnerService;
import com.petclinic.service.PetTypeService;
import com.petclinic.service.SpecialityService;
import com.petclinic.service.VetService;

@Component
public class DataInitializer implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	


	//@Autowired By default these get autowired
	public DataInitializer(OwnerService ownerService, VetService vetService,
			PetTypeService petTypeService,SpecialityService specialityService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}



	@Override
	public void run(String... args) throws Exception {

		PetType tRex=new PetType();
		tRex.setName("T-rex");
		PetType trexType = petTypeService.save(tRex);
		
		PetType whale=new PetType();
		whale.setName("Whale");
		PetType whaleType = petTypeService.save(whale);
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		radiology = specialityService.save(radiology);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		surgery = specialityService.save(surgery);
		
		Speciality dentist = new Speciality();
		dentist.setDescription("Dentist");
		dentist = specialityService.save(dentist);
		
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
		vet.getSpeciality().add(radiology); 
		
		vetService.save(vet);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Rik");
		vet2.setLastName("oos");
		vet2.getSpeciality().add(surgery);
		vetService.save(vet2);
		
		System.out.println("Loaded Owners --vets ");
	}
	

}
