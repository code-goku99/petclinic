package com.petclinic.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.PetType;
import com.petclinic.repository.PetTypeRepo;
import com.petclinic.service.PetTypeService;

@Service
@Profile({"dev","prd"})
public class PetTypeJPAService implements PetTypeService {

	public final  PetTypeRepo petTypeRepo;
	
	
	public PetTypeJPAService(PetTypeRepo petTypeRepo) {
		this.petTypeRepo = petTypeRepo;
	}


	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		this.petTypeRepo.findAll().forEach(petTypes :: add);
		return petTypes;
	}


	@Override
	public PetType findById(Long id) {
		return this.petTypeRepo.findById(id).orElse(new PetType());
	}


	@Override
	public PetType save(PetType object) {
		return this.petTypeRepo.save(object);
	}


	@Override
	public void delete(PetType object) {
		this.petTypeRepo.delete(object);		
	}


	@Override
	public void deleteById(Long id) {
		this.petTypeRepo.deleteById(id);		
	}
}