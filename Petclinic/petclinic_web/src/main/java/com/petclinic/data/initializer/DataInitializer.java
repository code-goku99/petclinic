package com.petclinic.data.initializer;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
import com.petclinic.model.PetType;
import com.petclinic.model.Speciality;
import com.petclinic.model.Vet;
import com.petclinic.model.Visit;
import com.petclinic.service.OwnerService;
import com.petclinic.service.PetService;
import com.petclinic.service.PetTypeService;
import com.petclinic.service.SpecialityService;
import com.petclinic.service.VetService;
import com.petclinic.service.VisitService;

@Component
public class DataInitializer implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	private final PetService petService;


	//@Autowired By default these get autowired
	public DataInitializer(OwnerService ownerService, VetService vetService,
			PetTypeService petTypeService,SpecialityService specialityService,VisitService visitService,
			PetService petService) {
		this.visitService = visitService;
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.petService = petService;
	}



	@Override
	public void run(String... args) throws Exception {

		 int count = this.petTypeService.findAll().size();
		 if(count == 0)
		initializeData();
	}



	/**
	 *  Initialize data
	 */
	private void initializeData() {
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
		 ownerService.save(owner);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Sos");
		owner2.setLastName("Thompson");
		owner2.setAddress("Miami");
		owner2.setCity("Miami");
		owner2.setTelephone("0o0o0o0");
		ownerService.save(owner2);
		
		Pet jonesPet = new Pet();
		jonesPet.setOwner(owner);
		jonesPet.setName("tranquil");
		jonesPet.setPetType(trexType);
		owner.getPets().add(jonesPet);
		this.petService.save(jonesPet);
		
		
		
		Pet thompsonPet = new Pet();
		thompsonPet.setOwner(owner);
		thompsonPet.setName("tranquil");
		thompsonPet.setPetType(trexType);
		thompsonPet.setBirthday(LocalDate.of(2016, 9, 23));
		owner2.getPets().add(thompsonPet);
		
		this.petService.save(thompsonPet);
		
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
		
		Visit visit = new Visit();
		visit.setPet(thompsonPet);
		visit.setDescription("Visist 1");
		visitService.save(visit);
		
		System.out.println("Loaded Owners --vets ");
	}
	

}
