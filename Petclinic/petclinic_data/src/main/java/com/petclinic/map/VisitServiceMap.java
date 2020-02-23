package com.petclinic.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.petclinic.model.Visit;
import com.petclinic.service.PetService;
import com.petclinic.service.VisitService;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService{


	public final PetService petService;

	public VisitServiceMap(PetService petService) {
		this.petService = petService;
		
	}

	@Override
	public Visit findById(Long id) {
		 return super.findById(id);
	}

	@Override
	public Visit save(Visit object) {
		if(object !=null) {
			if(object.getPet() == null || object.getPet().getOwner().getId() == null ||
					object.getPet().getId() == null) {
				throw new RuntimeException("Invalid Visit");
			}
		}
		return super.save(object);
	}

	@Override
	public void delete(Visit object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteByID(id);
	}

	@Override
	public Set<Visit> findAll(){
		return super.findAll();
	}

	
	


}
