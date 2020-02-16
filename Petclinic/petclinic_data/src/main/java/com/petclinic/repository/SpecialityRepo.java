package com.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.petclinic.model.Speciality;

public interface SpecialityRepo extends CrudRepository<Speciality, Long> {

}
