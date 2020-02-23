package com.petclinic.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.PetType;
import com.petclinic.service.PetTypeService;

@Service
@Profile({"default","map"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService{


	@Override
	public PetType findById(Long id) {
		 return super.findById(id);
	}

	@Override
	public PetType save(PetType object) {
		return super.save(object);
	}

	@Override
	public void delete(PetType object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteByID(id);
	}

	@Override
	public Set<PetType> findAll(){
		return super.findAll();
	}
	

}
