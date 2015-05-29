package org.lompo.softwares.softready.commons.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.lompo.softwares.softready.commons.utils.DateHelper;

/**
 * Model representing an instance of an Update. An update may generate many notifications
 * but is targeting only one update type and one particular application
 * @author LOMPO
 *
 */
@Entity
public class Update {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UPDATE_ID")
	private long updateId;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "updates")
	private List<Notification> notifications;

	
	public List<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	/**
	 * One to one relation ship between Update and its type
	 */
	@OneToOne
	@JoinColumn(name="UPDATETYPE_ID", unique = true, nullable=false,updatable=false)
	private UpdateType updateType;
	
	@OneToOne
	@JoinColumn(name="APPLICATION_ID", unique = true, nullable=false, updatable=false)
	private Application application;
	
	private Date publicationDate;
	
	private String updateUrl;
	
	public long getUpdateId() {
		return updateId;
	}
	public void setUpdateId(long updateId) {
		this.updateId = updateId;
	}
	public UpdateType getUpdateType() {
		return updateType;
	}
	public void setUpdateType(UpdateType updateType) {
		this.updateType = updateType;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public String getUpdateUrl() {
		return updateUrl;
	}
	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}
	public Date getPublicationDate() {
		return DateHelper.getDateClone(publicationDate);
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = DateHelper.getDateClone(publicationDate) ;
	}
	
	
	
	
}
