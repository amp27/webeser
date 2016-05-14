package org.deu.eser.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "eser_experiment")
public class Experiment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private @Column(name = "id") @Id @Expose @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	private @JoinColumn(name = "project_id") Project project;
	private @JoinColumn(name = "specimen_id") Specimen specimen;
	private @Column(name = "name") String name;
	private @Column(name = "description") String description;
	private @Column(name = "experiment_keywords") String keywords;
	private @JoinColumn(name = "contact_user_id") User contactUser;
	private @JoinColumn(name = "creator_user_id") User creatorUser;
	private @Column(name = "creation_dttm") @Temporal(value = TemporalType.TIMESTAMP) Date creationDttm;
	private @Column(name = "last_modification_dttm") @Temporal(value = TemporalType.TIMESTAMP) Date lastModificationDttm;
	private @Column(name = "conduction_dttm") @Temporal(value = TemporalType.TIMESTAMP) Date conductionDttm;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Specimen getSpecimen() {
		return specimen;
	}

	public void setSpecimen(Specimen specimen) {
		this.specimen = specimen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public User getContactUser() {
		return contactUser;
	}

	public void setContactUser(User contactUser) {
		this.contactUser = contactUser;
	}

	public User getCreatorUser() {
		return creatorUser;
	}

	public void setCreatorUser(User creatorUser) {
		this.creatorUser = creatorUser;
	}

	public Date getCreationDttm() {
		return creationDttm;
	}

	public void setCreationDttm(Date creationDttm) {
		this.creationDttm = creationDttm;
	}

	public Date getLastModificationDttm() {
		return lastModificationDttm;
	}

	public void setLastModificationDttm(Date lastModificationDttm) {
		this.lastModificationDttm = lastModificationDttm;
	}

	public Date getConductionDttm() {
		return conductionDttm;
	}

	public void setConductionDttm(Date conductionDttm) {
		this.conductionDttm = conductionDttm;
	}
}
