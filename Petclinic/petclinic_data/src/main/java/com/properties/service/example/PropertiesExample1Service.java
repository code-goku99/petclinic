package com.properties.service.example;

import org.springframework.stereotype.Service;

import com.petclinic.model.FakeDatasource;

@Service
public class PropertiesExample1Service {

	FakeDatasource datasource;

	public PropertiesExample1Service(FakeDatasource datasource) {
		this.datasource = datasource;
		System.out.println(this.datasource);
	}
	
	
}
