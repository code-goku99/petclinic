package com.petclinic.map;

import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.Owner;
import com.petclinic.service.OwnerService;
import com.petclinic.service.PetService;
import com.petclinic.service.PetTypeService;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private PetTypeService petTypeService;
	
	private PetService petService;


	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner findById(Long id) {
		 return super.findById(id);
	}

	@Override
	public Owner save(Owner object) {
		if(object !=null) {
			if(object.getPets() != null) {
				object.getPets().forEach(pet -> {
				if(pet.getPetType() !=null) {
					if(pet.getPetType().getId() == null) {
						pet.setPetType(petTypeService.save(pet.getPetType()));
					}
				}else {
					throw new RuntimeException("Pet Type cannot be null");
				}
				if(pet.getId() ==null) {
					petService.save(pet);
				}
			});
			}
		}else {
			throw new RuntimeException("Owner cannot be null");
		}
		return super.save(object);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteByID(id);
	}

	@Override
	public Set<Owner> findAll(){
		return super.findAll();
	}

	@Override
	public Owner findByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Owner> findAllByFirstnameLike(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
