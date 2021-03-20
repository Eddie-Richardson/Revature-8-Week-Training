package com.revature.models;

public class LoginTemplate {
	
	public static String username;
	private String password;
	private int roleId;
	
	public LoginTemplate() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		LoginTemplate.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleID(int roleId) {
		this.roleId = roleId;
	}

	public LoginTemplate(String username, String password, int roleId) {
		super();
		LoginTemplate.username = username;
		this.password = password;
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "LoginTemplate [username=" + username + ", password=" + password + ", roleId=" + roleId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + roleId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginTemplate other = (LoginTemplate) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roleId != other.roleId)
			return false;
		if (username == null) {
			if (LoginTemplate.username != null)
				return false;
		} else if (!username.equals(LoginTemplate.username))
			return false;
		return true;
	}

}
