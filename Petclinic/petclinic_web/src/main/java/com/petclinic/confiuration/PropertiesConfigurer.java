package com.petclinic.confiuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.petclinic.model.FakeDatasource;

@Configuration
@PropertySource(value= {"classpath:data/datasource.properties",
		"classpath:env/jms_dev.properties"})
public class PropertiesConfigurer {

	/*
	 * @Value("${clinic.name}") String username;
	 */
	//this value is getting from environment variables['Run/RunConfigurations/environment tab']
	@Value("${sandeep.env}")
	String username;
	
	@Value("${clinic.password}")
	String password;// from yml file
	
	@Value("${env.type}")
	String url;
	
	//other way to read from environment 
	@Autowired
	Environment environment;
	
	@Bean
	public FakeDatasource getDatasource() {
		FakeDatasource datasource = new FakeDatasource();
		datasource.setName(username);
		datasource.setPassword(password); 
		datasource.setUtl(environment.getProperty("url"));
		System.out.println(">>>>>"+url+"<<<<<<");
		return datasource;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer= new PropertySourcesPlaceholderConfigurer();
		return configurer;
	}
}
