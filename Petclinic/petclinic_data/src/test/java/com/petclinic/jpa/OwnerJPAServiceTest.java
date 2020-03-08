package com.petclinic.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.petclinic.model.Owner;
import com.petclinic.repository.OwnerRepo;
import com.petclinic.repository.PetRepo;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

	
	private static final String TEST = "test";
	@Mock
	private OwnerRepo ownerRepo;
	@Mock
	private PetRepo petRepo;
	
	@InjectMocks
	OwnerJPAService jpaservice;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindAll() {
		Set<Owner> findAll = jpaservice.findAll();
	}

	@Test
	void testFindById() {
		Owner own = new Owner();
		own.setId(1L);
		when(ownerRepo.findById(Mockito.any(Long.class))).thenReturn(Optional.of(own));
		Owner owner = jpaservice.findById(1L);
		assertNotNull(owner);
		
	}
	
	@Test
	void testFindByIdNotFound() {
		when(ownerRepo.findById(Mockito.any(Long.class))).thenReturn(Optional.empty());
		Owner owner = jpaservice.findById(2L);
		assertNull(owner);
		
	}


	@Test
	void testFindByFirstname() {
		Owner own = new Owner();
		own.setFirstName(TEST);
		when(ownerRepo.findByFirstName(Mockito.any(String.class))).thenReturn(own);
		Owner owner = jpaservice.findByFirstname(TEST);
		assertEquals(TEST, owner.getFirstName());
	}

}
