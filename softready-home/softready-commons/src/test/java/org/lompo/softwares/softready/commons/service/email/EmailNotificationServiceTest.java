package org.lompo.softwares.softready.commons.service.email;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations={"classpath:tests-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailNotificationServiceTest {
	
	@Autowired
	EmailNotificationServiceImpl emailService;
	
	@Test
	public void checkCorrectlyWiredTest() throws Exception {
		assertNotNull(emailService);
		assertNotNull(emailService.getMailSender());
		
		
	}

}
