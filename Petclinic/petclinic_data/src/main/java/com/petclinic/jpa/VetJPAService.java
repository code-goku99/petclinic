package com.petclinic.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.Vet;
import com.petclinic.repository.VetRepo;
import com.petclinic.service.VetService;

@Service
@Profile({"dev","prd"})
public class VetJPAService implements VetService {

	public final VetRepo vetrepo;
	
	public VetJPAService(VetRepo vetrepo) {
		this.vetrepo = vetrepo;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets= new HashSet<>();
		vetrepo.findAll().forEach(vets :: add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return vetrepo.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet entity) {
		return vetrepo.save(entity);
	}

	@Override
	public void delete(Vet entity) {
		vetrepo.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		vetrepo.deleteById(id);
	}
	
	

}
