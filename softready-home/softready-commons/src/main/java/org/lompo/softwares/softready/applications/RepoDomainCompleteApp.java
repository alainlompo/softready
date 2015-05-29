package org.lompo.softwares.softready.applications;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lompo.softwares.softready.commons.domain.Application;
import org.lompo.softwares.softready.commons.domain.Customer;
import org.lompo.softwares.softready.commons.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class RepoDomainCompleteApp implements CommandLineRunner {

	static ApplicationRepository appsRepo;
	static CustomerRepository customersRepo;
	static NotificationRepository notificationRepo;
	static SubscriptionRepository subscriptionRepo;
	static UpdateRepository updateRepo;
	static UpdateTypeRepository updateTypeRepo;
	
	public static void main(String[] args) {
		
		 AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		 appsRepo = context.getBean(ApplicationRepository.class);
		 customersRepo = context.getBean(CustomerRepository.class);
		 notificationRepo = context.getBean(NotificationRepository.class);
		 subscriptionRepo = context.getBean(SubscriptionRepository.class);
		 updateRepo = context.getBean(UpdateRepository.class);
		 updateTypeRepo = context.getBean(UpdateTypeRepository.class);
		 
		 SpringApplication.run(RepoDomainCompleteApp.class, args);
		 
	     SpringApplication.run(RepoDomainWiringApp.class, args);
	}
	
	public void run(String... strings) throws Exception {

		// Building customers....
		
		Set<String> firstNamesSet = new HashSet<String>();
		Set<String> lastNamesSet = new HashSet<String>();
		Randomizer randomizer = Randomizer.getInstance();
		for (int i = 0; i <4; i++) {
			firstNamesSet.add(randomizer.oneFirstName());
			lastNamesSet.add(randomizer.oneLastName());
		}
		
		String[] firstNames = firstNamesSet.toArray(new String[0]);
		String[] lastNames = lastNamesSet.toArray(new String[0]);
		for (int i = 0; i < Math.min(firstNames.length, lastNames.length); i++) {
			Customer customer = new Customer(firstNames[i], lastNames[i]);
			customersRepo.saveAndFlush(customer);
			
		}	
		
		// Building applications....
		
		Application myIDELuna = new Application("myIDE", "Luna", "1","0","0","1");
		Application myRDMSLonghornes = new Application("myRDBMS", "LongHornes", "1","0","0","0");
		Application myBusinessSuite = new Application("HyperSuite", "BusinessTank", "1","0","0","0");
		
		appsRepo.saveAndFlush(myIDELuna);
		appsRepo.saveAndFlush(myRDMSLonghornes);
		appsRepo.saveAndFlush(myBusinessSuite);
		
		
		
		
		System.out.println("Printing all customers .....");
		List<Customer> allCustomers = customersRepo.findAll();
		for (Customer c: allCustomers) {
			System.out.println(c);
		}
		
		System.out.println("Printing all applications....");
		List<Application> apps = appsRepo.findAll();
		for (Application app: apps) {
			System.out.println(app);
		}
		
	}
}
