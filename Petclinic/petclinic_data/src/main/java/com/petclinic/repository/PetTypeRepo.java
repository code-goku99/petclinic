package com.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.petclinic.model.PetType;

public interface PetTypeRepo extends CrudRepository<PetType, Long> {

}
