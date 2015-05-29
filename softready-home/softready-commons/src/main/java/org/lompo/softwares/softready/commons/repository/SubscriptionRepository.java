package org.lompo.softwares.softready.commons.repository;

import java.util.List;

import org.lompo.softwares.softready.commons.domain.Customer;
import org.lompo.softwares.softready.commons.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository  extends JpaRepository<Subscription, Long>{

	List<Subscription> findByCustomer(Customer customer);
	
}
