package com.android.entity;

import java.sql.Date;

public class User {

	private String email;

	private String password;

	private String name;

	private int timeLogin;

	private Role role;

	private Date createDate;

	private Date lastSync;

	private boolean isOutOfSync;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTimeLogin() {
		return timeLogin;
	}

	public void setTimeLogin(int timeLogin) {
		this.timeLogin = timeLogin;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastSync() {
		return lastSync;
	}

	public void setLastSync(Date lastSync) {
		this.lastSync = lastSync;
	}

	public boolean isOutOfSync() {
		return isOutOfSync;
	}

	public void setIsOutOfSync(boolean isOutOfSync) {
		this.isOutOfSync = isOutOfSync;
	}

}
