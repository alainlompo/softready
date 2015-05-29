package org.lompo.softwares.softready.commons.repository;

import java.util.List;

import org.lompo.softwares.softready.commons.domain.Application;
import org.lompo.softwares.softready.commons.domain.Update;
import org.lompo.softwares.softready.commons.domain.UpdateType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateRepository extends JpaRepository<Update,Long> {
	
	List<Update> findByUpdateType(UpdateType updateType);
	List<Update> findByApplication(Application application);
	
	

}
