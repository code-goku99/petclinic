package com.petclinic.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.Pet;
import com.petclinic.repository.PetRepo;
import com.petclinic.service.PetService;

@Service
@Profile("springdatajpa")
public class PetJPAService implements PetService {

	public final PetRepo petRepo;
	
	public PetJPAService(PetRepo petRepo) {
		this.petRepo = petRepo;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		this.petRepo.findAll().forEach(pets :: add);
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		return this.petRepo.findById(id).orElse(new Pet());
	}

	@Override
	public Pet save(Pet entity) {
		return this.petRepo.save(entity);
	}

	@Override
	public void delete(Pet entity) {
		this.petRepo.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		this.petRepo.deleteById(id);
	}

}
