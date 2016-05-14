package org.deu.eser.model.dao;

import java.util.List;

import org.deu.eser.model.domain.Experiment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperimentRepository extends JpaRepository<Experiment, Long> {

	public List<Experiment> findByName(String name);
}
