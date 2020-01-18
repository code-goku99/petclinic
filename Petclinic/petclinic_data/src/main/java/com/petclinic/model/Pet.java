package com.petclinic.model;

import java.time.LocalDate;

public class Pet {

	private Long Id;
	private PetType petType;
	private Owner owner;
	private LocalDate bithday;

	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public LocalDate getBithday() {
		return bithday;
	}

	public void setBithday(LocalDate bithday) {
		this.bithday = bithday;
	}

}
