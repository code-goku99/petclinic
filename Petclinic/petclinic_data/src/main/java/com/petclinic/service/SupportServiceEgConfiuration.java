package com.petclinic.service;

import org.springframework.stereotype.Service;

import com.petclinic.helper.SampleHelper;

@Service
public class SupportServiceEgConfiuration {

	private SampleHelper helper;

	public SupportServiceEgConfiuration(SampleHelper helper) {
		this.helper = helper;
	}
	
	public void testCall() {
		System.out.println(this.helper.isCalled()+"++++++");
	} 
	
}
