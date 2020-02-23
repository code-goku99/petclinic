package com.petclinic.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.Vet;
import com.petclinic.service.SpecialityService;
import com.petclinic.service.VetService;

@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private SpecialityService specialityService;
	
	
	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	@Override
	public Vet findById(Long id) {
		 return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		if(object != null) {
			if(object.getSpeciality().size()>0) {
				object.getSpeciality().forEach(spec -> {
					if(spec.getId() == null) {
						spec = this.specialityService.save(spec);
					}
					
				});
			}
		}else {
			throw new RuntimeException("Speciality cannnot be null");
		}
		return super.save(object);
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
