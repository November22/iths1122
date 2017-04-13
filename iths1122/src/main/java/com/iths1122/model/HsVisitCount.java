package com.iths1122.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Model class of hs_visit_count.
 * 
 * @author iths
 * @version $Id$
 */
@Entity
public class HsVisitCount implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 主键. */
	@Id
	private String vcId;

	/** 访问者的编号. */
	private String visitorNum;

	/** 访问者ip. */
	private String ip;

	/** The set of hs_leave_word. */
	@OneToMany
	private Set<HsLeaveWord> hsLeaveWordSet;

	/**
	 * Constructor.
	 */
	public HsVisitCount() {
		this.hsLeaveWordSet = new HashSet<HsLeaveWord>();
	}

	/**
	 * Set the 主键.
	 * 
	 * @param vcId
	 *            主键
	 */
	public void setVcId(String vcId) {
		this.vcId = vcId;
	}

	/**
	 * Get the 主键.
	 * 
	 * @return 主键
	 */
	public String getVcId() {
		return this.vcId;
	}

	/**
	 * Set the 访问者的编号.
	 * 
	 * @param visitorNum
	 *            访问者的编号
	 */
	public void setVisitorNum(String visitorNum) {
		this.visitorNum = visitorNum;
	}

	/**
	 * Get the 访问者的编号.
	 * 
	 * @return 访问者的编号
	 */
	public String getVisitorNum() {
		return this.visitorNum;
	}

	/**
	 * Set the 访问者ip.
	 * 
	 * @param ip
	 *            访问者ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * Get the 访问者ip.
	 * 
	 * @return 访问者ip
	 */
	public String getIp() {
		return this.ip;
	}

	/**
	 * Set the set of the hs_leave_word.
	 * 
	 * @param hsLeaveWordSet
	 *            The set of hs_leave_word
	 */
	public void setHsLeaveWordSet(Set<HsLeaveWord> hsLeaveWordSet) {
		this.hsLeaveWordSet = hsLeaveWordSet;
	}

	/**
	 * Add the hs_leave_word.
	 * 
	 * @param hsLeaveWord
	 *            hs_leave_word
	 */
	public void addHsLeaveWord(HsLeaveWord hsLeaveWord) {
		this.hsLeaveWordSet.add(hsLeaveWord);
	}

	/**
	 * Get the set of the hs_leave_word.
	 * 
	 * @return The set of hs_leave_word
	 */
	public Set<HsLeaveWord> getHsLeaveWordSet() {
		return this.hsLeaveWordSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vcId == null) ? 0 : vcId.hashCode());
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
		HsVisitCount other = (HsVisitCount) obj;
		if (vcId == null) {
			if (other.vcId != null) {
				return false;
			}
		} else if (!vcId.equals(other.vcId)) {
			return false;
		}
		return true;
	}

}
