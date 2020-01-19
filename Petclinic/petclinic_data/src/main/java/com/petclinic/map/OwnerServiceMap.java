package com.petclinic.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.petclinic.model.Owner;
import com.petclinic.service.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Owner findById(Long id) {
		 return super.findById(id);
	}

	@Override
	public Owner save(Owner object) {
		return super.save(object,object.getId());
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteByID(id);
	}

	@Override
	public Set<Owner> findAll(){
		return super.findAll();
	}

	@Override
	public Owner findByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
