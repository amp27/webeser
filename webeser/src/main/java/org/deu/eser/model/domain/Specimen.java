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
@Table(name = "eser_specimen")
public class Specimen implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private @Column(name = "id") @Id @Expose @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	private @Column(name = "name") String name;
	private @Column(name = "description") String description;
	private @Column(name = "specimen_keywords") String keywords;
	private @Column(name = "viewer_level") Short viewerLevel;
	private @JoinColumn(name = "creator_user_id") User creatorUser;
	private @Column(name = "creation_dttm") @Temporal(value = TemporalType.TIMESTAMP) Date creationDttm;
	private @Column(name = "last_modification_dttm") @Temporal(value = TemporalType.TIMESTAMP) Date lastModificationDttm;
	private @Column(name = "num_of_usage_in_experiments") Integer numOfUsageInExperiments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Short getViewerLevel() {
		return viewerLevel;
	}

	public void setViewerLevel(Short viewerLevel) {
		this.viewerLevel = viewerLevel;
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

	public Integer getNumOfUsageInExperiments() {
		return numOfUsageInExperiments;
	}

	public void setNumOfUsageInExperiments(Integer numOfUsageInExperiments) {
		this.numOfUsageInExperiments = numOfUsageInExperiments;
	}
}
