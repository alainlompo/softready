package org.lompo.softwares.softready.commons.domain;

import java.util.List;
import javax.persistence.Column;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Possible update type: new version, bug fix, security vulnerability patch, ...
 * @author LOMPO
 *
 */
@Entity
public  class UpdateType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UPDATETYPE_ID")
	private long updateTypeId;
	private String updateTypeName;
	private String updateTypeDescription;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "updateTypes")
	private List<Subscription> subscriptions;
	
	/**
	 * One to many relationship between a type and its properties
	 */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="updateType", fetch = FetchType.LAZY)
	private List<UpdateTypeProperty> properties;
	
	private String updateTypeMessageTemplate;
	
	/**
	 * One to many relationship between a type and the using updates
	 */
	@OneToMany(cascade=CascadeType.ALL, mappedBy="updateType", fetch = FetchType.LAZY)
	private List<Update> updates;
	
	public List<Update> getUpdates() {
		return updates;
	}

	public void setUpdates(List<Update> updates) {
		this.updates = updates;
	}

	public long getUpdateTypeId() {
		return updateTypeId;
	}

	public void setUpdateTypeId(long updateTypeId) {
		this.updateTypeId = updateTypeId;
	}

	public  String getUpdateTypeMessageTemplate() {
		return updateTypeMessageTemplate;	
	}
	
	public void setUpdateTypeMessageTemplate(String updateTypeMessageTemplate) {
		this.updateTypeMessageTemplate = updateTypeMessageTemplate;
	}
		
	public List<UpdateTypeProperty> getProperties() {
		return properties;
	}


	public void setProperties(List<UpdateTypeProperty> properties) {
		this.properties = properties;
	}

	public String getUpdateTypeName() {
		return updateTypeName;
	}
	
	public void setUpdateTypeName(String updateTypeName) {
		this.updateTypeName = updateTypeName;
	}
	
	public String getUpdateTypeDescription() {
		return updateTypeDescription;
	}
	
	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public void setUpdateTypeDescription(String updateTypeDescription) {
		this.updateTypeDescription = updateTypeDescription;
	}
	
}
