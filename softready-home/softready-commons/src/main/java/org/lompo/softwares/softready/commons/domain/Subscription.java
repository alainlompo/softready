package org.lompo.softwares.softready.commons.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * Model of a Subscription. A subcription can specifiy many update types.
 * @author LOMPO
 *
 */
@Entity
public class Subscription {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SUBSCRIPTION_ID")
	private long subscriptionId;
	
	/**
	 * A one to one relationship between a Subscription and the customer
	 */
	@OneToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="subscription_updatetype", joinColumns= {
			@JoinColumn(name="SUBSCRIPTION_ID", nullable = false)},
			inverseJoinColumns={
			@JoinColumn(name="UPDATETYPE_ID", nullable=false)
	})
	private List<UpdateType> updateTypes;
	
	public long getSubscriptionId() {
		return subscriptionId;
	}
	public void seSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<UpdateType> getUpdateTypes() {
		return updateTypes;
	}
	public void setUpdateTypes(List<UpdateType> updateTypes) {
		this.updateTypes = updateTypes;
	}

}
