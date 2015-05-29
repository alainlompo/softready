package org.lompo.softwares.softready.commons.service;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class SampleServiceTest {
	
	@Autowired
	SampleService service;
	
	@Test
	public void serviceCorrectlyAutowiredTest() throws Exception {
		assertNotNull(service);
		assertEquals("Hello world!", service.getGreetings());
		assertEquals("http://www.google.com", service.getSampleUrl());
	}

}
