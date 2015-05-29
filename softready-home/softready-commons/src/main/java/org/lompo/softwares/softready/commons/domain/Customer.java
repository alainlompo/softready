package org.lompo.softwares.softready.commons.domain;

import java.util.List;
import javax.persistence.Column;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * A reduced Customer entity with only necessary informations for the Update process
 * @author LOMPO
 *
 */
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTOMER_ID")
	private long customerId;
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	private String companyName;
	
	/**
	 * A one to one relationship between a customer and his subscription
	 */
	@OneToOne
	@JoinColumn(name="SUBSCRIPTION_ID", unique = true, nullable=true, updatable=false)
	private Subscription subscription;
	
	/**
	 * A one to many relationship between a customer and his notifications
	 */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="customer", fetch = FetchType.LAZY)
	private List<Notification> notifications;
	
	protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
		
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
	    return String.format(
	            "Customer[id=%d, firstName='%s', lastName='%s']",
	            customerId, firstName, lastName);
	}
	 
	 
	
}
