package com.petclinic.map;

import java.util.Set;

import com.petclinic.model.Pet;
import com.petclinic.service.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Pet findById(Long id) {
		 return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		return super.save(object,object.getId());
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteByID(id);
	}

	@Override
	public Set<Pet> findAll(){
		return super.findAll();
	}
	
}

