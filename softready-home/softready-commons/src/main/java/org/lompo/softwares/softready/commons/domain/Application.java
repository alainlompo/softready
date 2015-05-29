package org.lompo.softwares.softready.commons.domain;

import java.util.List;
import javax.persistence.Column;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Application entity that represents an application to update
 * @author LOMPO
 *
 */
@Entity
public class Application {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="APPLICATION_ID")
	private long applicationId;
	private String applicationName;
	private String applicationCodeName;
	@Embedded
	private ApplicationVersion applicationVersion;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="application", fetch = FetchType.LAZY)
	private List<Update> updates;
	
	public Application() {}
	
	public Application(String applicationName, String applicationCodeName) {
		this.applicationName = applicationName;
		this.applicationCodeName = applicationCodeName;
	}
	
	public Application(String applicationName, String applicationCodeName, ApplicationVersion applicationVersion) {
		this(applicationName, applicationCodeName);
		this.applicationVersion = applicationVersion;
	}
	
	public Application(String applicationName, String applicationCodeName, String major, String minor, String release, String debug) {
		this(applicationName, applicationCodeName);
		this.applicationVersion = new ApplicationVersion(major,minor, release, debug);		
	}
	
	public long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getApplicationCodeName() {
		return applicationCodeName;
	}
	public void setApplicationCodeName(String applicationCodeName) {
		this.applicationCodeName = applicationCodeName;
	}
	public ApplicationVersion getApplicationVersion() {
		return applicationVersion;
	}
	public void setApplicationVersion(ApplicationVersion applicationVersion) {
		this.applicationVersion = applicationVersion;
	}
	public List<Update> getUpdates() {
		return updates;
	}
	public void setUpdates(List<Update> updates) {
		this.updates = updates;
	}
	
	public String toString() {
		return applicationName +  "[Code Name: " + applicationCodeName + "]" + "Version:" + applicationVersion;
	}

}
