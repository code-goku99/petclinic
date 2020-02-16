package com.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.petclinic.model.Owner;

public interface OwnerRepo extends CrudRepository<Owner, Long> {

}
