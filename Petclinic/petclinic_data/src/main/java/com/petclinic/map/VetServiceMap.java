package com.petclinic.map;

import java.util.Set;

import com.petclinic.model.Vet;
import com.petclinic.service.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	@Override
	public Vet findById(Long id) {
		 return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		return super.save(object,object.getId());
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteByID(id);
	}

	@Override
	public Set<Vet> findAll(){
		return super.findAll();
	}
	
}
