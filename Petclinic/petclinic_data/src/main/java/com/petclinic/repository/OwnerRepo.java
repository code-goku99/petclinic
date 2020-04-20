package com.petclinic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.petclinic.model.Owner;

public interface OwnerRepo extends CrudRepository<Owner, Long> {

	Owner findByFirstName(String name);
	
	List<Owner> findAllByFirstNameContains(String firstname);
}
