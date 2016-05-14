package org.deu.eser.model.dao;

import org.deu.eser.model.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

	Application findById(Integer id);
	
	Application findByName(String name);
	
	Application findByDescription(String description);
}
