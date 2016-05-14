package org.deu.eser.model.dao;

import java.util.List;

import org.deu.eser.model.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	List<Project> findByName(String name);

	List<Project> findByKeywords(String keywords);
}
