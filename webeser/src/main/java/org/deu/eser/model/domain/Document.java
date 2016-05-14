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
@Table(name = "eser_document")
public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private @Column(name = "id") @Id @Expose @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	private @Column(name = "related_object_type") Short relatedObjectType;
	private @Column(name = "related_object_id") Integer relatedObjectId;
	private @Column(name = "name") String name;
	private @Column(name = "description") String description;
	private @Column(name = "document_type") String documentType;
	private @Column(name = "document_size") Integer documentSize;
	private @Column(name = "extension") String extension;
	private @JoinColumn(name = "creator_user_id") @Expose User creatorUser;
	private @Column(name = "creation_dttm") @Temporal(value = TemporalType.TIMESTAMP) Date creationDttm;
	private @Column(name = "last_modification_dttm") @Temporal(value = TemporalType.TIMESTAMP) Date lastModificationDttm;
	private @Column(name = "is_plottable") Short isPlottable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getRelatedObjectType() {
		return relatedObjectType;
	}

	public void setRelatedObjectType(Short relatedObjectType) {
		this.relatedObjectType = relatedObjectType;
	}

	public Integer getRelatedObjectId() {
		return relatedObjectId;
	}

	public void setRelatedObjectId(Integer reslatedObjectId) {
		this.relatedObjectId = reslatedObjectId;
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

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public Integer getDocumentSize() {
		return documentSize;
	}

	public void setDocumentSize(Integer documentSize) {
		this.documentSize = documentSize;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
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

	public Short getIsPlottable() {
		return isPlottable;
	}

	public void setIsPlottable(Short isPlottable) {
		this.isPlottable = isPlottable;
	}
}
