package org.lompo.softwares.softready.commons.repository;

import java.util.List;

import org.lompo.softwares.softready.commons.domain.Customer;
import org.lompo.softwares.softready.commons.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
	
	List<Notification> findByCustomer(Customer customer);

}
