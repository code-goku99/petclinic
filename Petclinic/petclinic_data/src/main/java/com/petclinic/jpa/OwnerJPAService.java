package com.petclinic.jpa;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.Owner;
import com.petclinic.repository.OwnerRepo;
import com.petclinic.repository.PetRepo;
import com.petclinic.service.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerJPAService implements OwnerService {

	private final OwnerRepo ownerRepo;
	private final PetRepo petRepo;
	
	
	public OwnerJPAService(OwnerRepo ownerRepo,PetRepo petRepo) {
		this.petRepo = petRepo;
		this.ownerRepo = ownerRepo;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> ownerList = new HashSet<>();
		//this.ownerRepo.findAll().forEach(owner -> ownerList.add(owner));
		this.ownerRepo.findAll().forEach(ownerList :: add);
		return ownerList;
	}

	@Override
	public Owner findById(Long id) {
		Optional<Owner> owner = this.ownerRepo.findById(id);
		/*
		 * if(owner.isPresent()) { return owner.get(); }
		 */
		return  owner.orElse(null);
	}

	@Override
	public Owner save(Owner entity) {
		return ownerRepo.save(entity);
	}

	@Override
	public void delete(Owner object) {
		ownerRepo.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		ownerRepo.deleteById(id);		
	}

	@Override
	public Owner findByFirstname(String firstname) {
		return ownerRepo.findByFirstName(firstname);
	}

	@Override
	public List<Owner> findAllByFirstnameLike(String firstname) {
		// TODO Auto-generated method stub
		return ownerRepo.findAllByFirstNameContains(firstname);
	}

}
