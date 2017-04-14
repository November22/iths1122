package com.iths1122.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model class of hs_share.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
@Entity
@Table(name = "hs_share")
public class HsShare implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 主键. */
	@Id
	private String shareId;

	/** 字典表. */
	@JsonIgnore
	@JoinColumn(name = "dictionary_id")
	@ManyToOne(cascade = {CascadeType.MERGE , CascadeType.REFRESH} , fetch = FetchType.LAZY , optional = false)
	private HsDictionary hsDictionary;

	/** 分享的内容. */
	private String content;

	/** 内容出处. */
	private String contenFrom;

	/** 所属用户. */
	private String userId;

	/**
	 * Constructor.
	 */
	public HsShare() {
	}

	/**
	 * Set the 主键.
	 * 
	 * @param shareId
	 *            主键
	 */
	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	/**
	 * Get the 主键.
	 * 
	 * @return 主键
	 */
	public String getShareId() {
		return this.shareId;
	}

	/**
	 * Set the 字典表.
	 * 
	 * @param hsDictionary
	 *            字典表
	 */
	public void setHsDictionary(HsDictionary hsDictionary) {
		this.hsDictionary = hsDictionary;
	}

	/**
	 * Get the 字典表.
	 * 
	 * @return 字典表
	 */
	public HsDictionary getHsDictionary() {
		return this.hsDictionary;
	}

	/**
	 * Set the 分享的内容.
	 * 
	 * @param content
	 *            分享的内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Get the 分享的内容.
	 * 
	 * @return 分享的内容
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * Set the 内容出处.
	 * 
	 * @param contenFrom
	 *            内容出处
	 */
	public void setContenFrom(String contenFrom) {
		this.contenFrom = contenFrom;
	}

	/**
	 * Get the 内容出处.
	 * 
	 * @return 内容出处
	 */
	public String getContenFrom() {
		return this.contenFrom;
	}

	/**
	 * Set the 所属用户.
	 * 
	 * @param userId
	 *            所属用户
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Get the 所属用户.
	 * 
	 * @return 所属用户
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shareId == null) ? 0 : shareId.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		HsShare other = (HsShare) obj;
		if (shareId == null) {
			if (other.shareId != null) {
				return false;
			}
		} else if (!shareId.equals(other.shareId)) {
			return false;
		}
		return true;
	}

}
