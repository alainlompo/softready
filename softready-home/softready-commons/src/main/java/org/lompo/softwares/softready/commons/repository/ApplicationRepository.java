package org.lompo.softwares.softready.commons.repository;
import java.util.List;

import org.lompo.softwares.softready.commons.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
	
	List<Application> findByApplicationName(String applicationName);
	List<Application> findByApplicationCodeName(String applicationCodeName);

}
