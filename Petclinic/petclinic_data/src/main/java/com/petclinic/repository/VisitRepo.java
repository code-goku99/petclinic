package com.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.petclinic.model.Visit;

public interface VisitRepo extends CrudRepository<Visit, Long> {

}
