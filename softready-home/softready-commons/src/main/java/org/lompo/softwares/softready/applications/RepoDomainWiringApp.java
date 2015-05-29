package org.lompo.softwares.softready.applications;

import org.lompo.softwares.softready.commons.domain.Customer;
import org.lompo.softwares.softready.commons.repository.CustomerRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class RepoDomainWiringApp /*implements CommandLineRunner*/ {

	//@Autowired
	static CustomerRepository repository;
	
	public static void main(String[] args) {
		
		 AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		 repository = context.getBean(CustomerRepository.class);
		 
		SpringApplication.run(RepoDomainWiringApp.class, args);
	}
	
	public void run(String... strings) throws Exception {
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Albert", "Einsteinr"));
		repository.save(new Customer("Mahatma", "Ghandi"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Mister", "No"));
		
		// fetch all customers
		System.out.println("Customers found with findAll...");
		System.out.println("-------------------------------");
		for (Customer customer: repository.findAll()) {
			System.out.println(customer);
		}
		
		System.out.println();
		
		// Fecth an individual customer by Id
		Customer customer = repository.findOne(2L);
		System.out.println("Customer found with findOne(2L)");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();
		
		// fetch customers by last name
        System.out.println("Customer found with findByLastName('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Customer bauer : repository.findByLastName("Bauer")) {
            System.out.println(bauer);
        }
		
		
		
		
		
	}
	
	
	

}
