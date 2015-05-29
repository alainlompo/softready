package org.lompo.softwares.softready.commons.service.email;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.lompo.softwares.softready.commons.domain.Customer;
import org.lompo.softwares.softready.commons.domain.Update;
import org.lompo.softwares.softready.commons.dto.UpdateMessageBodyTemplateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import javax.mail.internet.InternetAddress;

@Component
public class EmailNotificationServiceImpl implements EmailNotificationService {

	@Value("${update.services.email}")
	private String updateServicesEmail;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	VelocityEngine velocityEngine;
	
	public void sendUpdatesNotification(final Update update, final Customer customer) {
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(customer.getEmailAddress());
				message.setFrom(new InternetAddress(updateServicesEmail));
				message.setSubject("Applications updates notification");
				message.setSentDate(new Date());
				Map model = new HashMap();
				
				UpdateMessageBodyTemplateDTO dto
				= UpdateMessageBodyTemplateDTO.buildFrom(update, customer, update.getApplication());
				model.put("newMessage", dto);
				
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, 
						String.format(
					            "Velocity/%s.vm",
					            update.getUpdateType().getUpdateTypeMessageTemplate()),
						"UTF-8", model);
				message.setText(text, true);
				
			}
			
		};
		
		mailSender.send(preparator);
		
	}

	public void sendUpdatesNotifications(final Update update,
			final List<Customer> customers) {
		for (Customer c: customers) {
			sendUpdatesNotification(update, c);
		}
		
	}
	
	public JavaMailSender getMailSender() {
		return mailSender;
	}
	
	public String getUpdateServicesEmail() {
		return updateServicesEmail;
	}

}
