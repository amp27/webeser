package org.deu.eser.model.dao;

import java.util.List;

import org.deu.eser.model.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {

	public List<Document> findByName(String name);
}
