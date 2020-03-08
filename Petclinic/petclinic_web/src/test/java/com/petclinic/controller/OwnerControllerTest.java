package com.petclinic.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.petclinic.model.Owner;
import com.petclinic.service.OwnerService;
import com.petclinic.service.SupportServiceEgConfiuration;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	MockMvc mockMvc;
	
	@Mock
	OwnerService ownerService;
	
	@Mock
	SupportServiceEgConfiuration conf;
	
	@InjectMocks
	OwnerController controller;
	
	@BeforeEach
	void setUp() throws Exception {
		mockMvc =MockMvcBuilders.standaloneSetup(controller).build();
	}




	@Test
	void testIndex() throws Exception {
		Set<Owner> value = new HashSet<>();
		when(ownerService.findAll()).thenReturn(value);
		doNothing().when(conf).testCall();
		mockMvc.perform(get("/owners/")).andExpect(status().is(200))
		.andExpect(view().name("/owners/index"));
		//.andExpect(model().attribute("listOfOwner", hasItems("")));
	}

	

}
