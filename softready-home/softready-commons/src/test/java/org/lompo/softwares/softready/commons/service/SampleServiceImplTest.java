package org.lompo.softwares.softready.commons.service;

import org.junit.Test;

import junit.framework.TestCase;

public class SampleServiceImplTest extends TestCase {
	
	private SampleServiceImpl serviceInstance = new SampleServiceImpl();
	
	@Test
	public void testReadOnce() throws Exception {
		assertEquals ("Hello world!", serviceInstance.getGreetings());
		
	}

}
