package com.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.petclinic.model.Pet;

public interface PetRepo extends CrudRepository<Pet, Long> {

}
