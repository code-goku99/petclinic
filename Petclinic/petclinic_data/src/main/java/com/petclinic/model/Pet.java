package com.petclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {

	private PetType petType;
	private Owner owner;
	private LocalDate bithday;

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
