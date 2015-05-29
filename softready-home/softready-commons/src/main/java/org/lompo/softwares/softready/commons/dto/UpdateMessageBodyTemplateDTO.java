package org.lompo.softwares.softready.commons.dto;

import java.io.Serializable;

import org.lompo.softwares.softready.commons.domain.Application;
import org.lompo.softwares.softready.commons.domain.Customer;
import org.lompo.softwares.softready.commons.domain.Update;

public class UpdateMessageBodyTemplateDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7051581088076021568L;
	
	private String customerFirstName;
	private String customerLastName;
	private String customerCompanyName;
	
	private String appCompleteName;
	private String appCompleteVersion;
	
	private String updateUrl;

	
	
	
	
	public UpdateMessageBodyTemplateDTO() {
	}
	
	

	public UpdateMessageBodyTemplateDTO(String customerFirstName,
			String customerLastName, String customerCompanyName,
			String appCompleteName, String appCompleteVersion, String updateUrl) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerCompanyName = customerCompanyName;
		this.appCompleteName = appCompleteName;
		this.appCompleteVersion = appCompleteVersion;
		this.updateUrl = updateUrl;
	}



	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerCompanyName() {
		return customerCompanyName;
	}

	public void setCustomerCompanyName(String customerCompanyName) {
		this.customerCompanyName = customerCompanyName;
	}

	public String getAppCompleteName() {
		return appCompleteName;
	}

	public void setAppCompleteName(String appCompleteName) {
		this.appCompleteName = appCompleteName;
	}

	public String getAppCompleteVersion() {
		return appCompleteVersion;
	}

	public void setAppCompleteVersion(String appCompleteVersion) {
		this.appCompleteVersion = appCompleteVersion;
	}

	public String getUpdateUrl() {
		return updateUrl;
	}

	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public static UpdateMessageBodyTemplateDTO buildFrom(Update update,
			Customer customer,
			Application application
			) {
		
		return new UpdateMessageBodyTemplateDTO(
				customer.getFirstName(),
				customer.getLastName(),
				customer.getCompanyName(),
				application.getApplicationName() + " [" + application.getApplicationCodeName() + "]",
				application.getApplicationVersion().toString(),
				update.getUpdateUrl()
				);
		
	}
	
	
	

}
