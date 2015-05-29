package org.lompo.softwares.softready.commons.domain;

import java.util.List;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The UpdateTypeProperty entity, allows us to handle variable list of properties for
 * each updatetype.
 * @author LOMPO
 *
 */
@Entity
public class UpdateTypeProperty {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UPDATETYPEPROPERTY_ID")
	private long updateTypePropertyId;
	
	private String propertyName;
	private String propertyValue;
	
	/**
	 * One to many relationship between a property and the updateTypes that use it
	 */
	@ManyToOne
	@JoinColumn(name="UPDATETYPE_ID", nullable=false)
	private UpdateType updateType;
	
	public UpdateType getUpdateType() {
		return updateType;
	}
	public void setUpdateType(UpdateType updateType) {
		this.updateType = updateType;
	}
	public long getUpdateTypePropertyId() {
		return updateTypePropertyId;
	}
	public void setUpdateTypePropertyId(long updateTypePropertyId) {
		this.updateTypePropertyId = updateTypePropertyId;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	
	

}
