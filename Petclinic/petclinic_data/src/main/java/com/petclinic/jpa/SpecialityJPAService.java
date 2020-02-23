package com.petclinic.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.Speciality;
import com.petclinic.repository.SpecialityRepo;
import com.petclinic.service.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialityJPAService implements SpecialityService {

	public final SpecialityRepo srepo;
	
	
	public SpecialityJPAService(SpecialityRepo srepo) {
		this.srepo = srepo;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<>();
		this.srepo.findAll().forEach(specialities :: add);
		return specialities;
	}

	@Override
	public Speciality findById(Long id) {
		// TODO Auto-generated method stub
		return this.srepo.findById(id).orElse(new Speciality());
	}

	@Override
	public Speciality save(Speciality entity) {
		return this.srepo.save(entity);
	}

	@Override
	public void delete(Speciality object) {
		 this.srepo.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		 this.srepo.deleteById(id);
	}

}
