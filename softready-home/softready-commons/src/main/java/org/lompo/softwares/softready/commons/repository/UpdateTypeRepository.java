package org.lompo.softwares.softready.commons.repository;

import java.util.List;

import org.lompo.softwares.softready.commons.domain.UpdateType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateTypeRepository extends JpaRepository<UpdateType, Long> {

	List<UpdateType> findByUpdateTypeName(String updateTypeName);
	

}
