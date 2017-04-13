package com.iths1122.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Model class of 个人网页使用用户信息表.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
@Entity
public class HsUserinfo implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 主键. */
	@Id
	private String userId;

	/** 昵称. */
	private String nickName;

	/** 登录邮箱. */
	private String email;

	/** 密码. */
	private String password;

	/** 创建时间. */
	private Date createTime;

	/** 激活码. */
	private String activeCode;

	/**
	 * Constructor.
	 */
	public HsUserinfo() {
	}

	/**
	 * Set the 主键.
	 * 
	 * @param userId
	 *            主键
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Get the 主键.
	 * 
	 * @return 主键
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Set the 昵称.
	 * 
	 * @param nickName
	 *            昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * Get the 昵称.
	 * 
	 * @return 昵称
	 */
	public String getNickName() {
		return this.nickName;
	}

	/**
	 * Set the 登录邮箱.
	 * 
	 * @param email
	 *            登录邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the 登录邮箱.
	 * 
	 * @return 登录邮箱
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Set the 密码.
	 * 
	 * @param password
	 *            密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the 密码.
	 * 
	 * @return 密码
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Set the 创建时间.
	 * 
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * Get the 创建时间.
	 * 
	 * @return 创建时间
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * Set the 激活码.
	 * 
	 * @param activeCode
	 *            激活码
	 */
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}

	/**
	 * Get the 激活码.
	 * 
	 * @return 激活码
	 */
	public String getActiveCode() {
		return this.activeCode;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		HsUserinfo other = (HsUserinfo) obj;
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}

}
