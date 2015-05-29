package org.lompo.softwares.softready.commons.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

/**
 * made of major.minor.release.debug
 * @author LOMPO
 *
 */
@Embeddable
@Access(AccessType.FIELD)
public class ApplicationVersion {

	
	private String major;
	private String minor;
	private String release;
	private String debug;
	
	public ApplicationVersion() {}
	
	public ApplicationVersion(String major, String minor, String release, String debug) {
		this.major = major;
		this.minor = minor;
		this.release = release;
		this.debug = debug;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getMinor() {
		return minor;
	}
	public void setMinor(String minor) {
		this.minor = minor;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getDebug() {
		return debug;
	}
	public void setDebug(String debug) {
		this.debug = debug;
	}
	
	public String toString() {
		return major +"." + minor + "." + release + "." + debug;
	}
}
