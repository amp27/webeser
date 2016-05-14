package org.deu.eser.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "eser_project")
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private @Column(name = "id") @Id @Expose @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	private @Column(name = "name") String name;
	private @Column(name = "description") String description;
	private @Column(name = "project_keywords") String keywords;
	private @Column(name = "viewers_level") Short viewersLevel;
	private @Column(name = "pstart_date") @Temporal(value = TemporalType.TIMESTAMP) Date startDate;
	private @Column(name = "pend_date") @Temporal(value = TemporalType.TIMESTAMP) Date endDate;

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

	public Short getViewersLevel() {
		return viewersLevel;
	}

	public void setViewersLevel(Short viewersLevel) {
		this.viewersLevel = viewersLevel;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}