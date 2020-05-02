package com.petclinic.service;

import java.util.List;

import com.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByFirstname(String firstname);

	List<Owner> findAllByFirstnameLike(String firstname);
}
