package com.petclinic.model;

public class FakeDatasource {

	private String name;
	private String password;
	private String utl;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUtl() {
		return utl;
	}
	public void setUtl(String utl) {
		this.utl = utl;
	}
	@Override
	public String toString() {
		return "FakeDatasource [name=" + name + ", password=" + password + ", utl=" + utl + "]";
	}
	
}
