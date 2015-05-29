package org.lompo.softwares.softready.commons.domain;

import java.util.List;
import javax.persistence.Column;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;

/**
 * An instance of a Notification 
 * @author LOMPO
 *
 */
@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="NOTIFICATION_ID")
	private long notificationId;
	
	/**
	 * Many to one notification with a customer
	 */
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID", nullable=false, updatable=false)
	private Customer customer;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="notification_update", joinColumns= {
			@JoinColumn(name="NOTIFICATION_ID", nullable = false)},
			inverseJoinColumns={
			@JoinColumn(name="UPDATE_ID", nullable=false)
	})
	private List<Update> updates;
	
	
	public long getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Update> getUpdates() {
		return updates;
	}
	public void setUpdates(List<Update> updates) {
		this.updates = updates;
	}
}
