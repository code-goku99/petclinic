package com.petclinic.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.Visit;
import com.petclinic.repository.VisitRepo;
import com.petclinic.service.VisitService;

@Service
@Profile({"dev","prd"})
public class VisitJPAService implements VisitService {

	private final VisitRepo visitRepo;
	
	public VisitJPAService(VisitRepo visitRepo) {
		this.visitRepo = visitRepo;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		this.visitRepo.findAll().forEach(visits :: add);
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return this.visitRepo.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Visit save(Visit object) {
		return this.visitRepo.save(object);
	}

	@Override
	public void delete(Visit object) {
		this.visitRepo.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		this.visitRepo.deleteById(id);		
	}
	
}
