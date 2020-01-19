package com.petclinic.confiuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.petclinic.helper.SampleHelper;

@Configuration
public class ApplicationConfigurer {

	@Bean
	public SampleHelper provideSampleHelperBean() {
		return new SampleHelper();
	}
}
