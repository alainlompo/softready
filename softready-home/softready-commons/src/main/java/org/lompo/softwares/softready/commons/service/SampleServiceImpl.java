package org.lompo.softwares.softready.commons.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SampleServiceImpl implements SampleService {

	@Value("${sample_url}")
	private String sampleUrl;
	 
	public String getSampleUrl() {
		return sampleUrl;
	}
	
	public String getGreetings() {
		
		return "Hello world!";
	}

}
