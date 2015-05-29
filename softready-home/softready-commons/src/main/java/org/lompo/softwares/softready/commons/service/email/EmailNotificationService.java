package org.lompo.softwares.softready.commons.service.email;

import java.util.List;

import org.lompo.softwares.softready.commons.domain.Update;
import org.lompo.softwares.softready.commons.domain.Customer;

public interface EmailNotificationService {

	void sendUpdatesNotification(final Update update, final Customer customer);
	void sendUpdatesNotifications(final Update update, final List<Customer> customers);
}
