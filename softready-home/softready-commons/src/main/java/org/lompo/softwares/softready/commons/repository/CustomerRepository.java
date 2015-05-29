package org.lompo.softwares.softready.commons.repository;

import java.util.List;

import org.lompo.softwares.softready.commons.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
	List<Customer> findByCompanyName(String companyName);
	
}
