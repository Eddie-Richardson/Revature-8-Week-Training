package com.revature.models;

public class UserUpdate {
	private int id;
	private String updateColumn;
	private String updateInfo;
	
	public UserUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserUpdate(int id, String updateColumn, String updateInfo) {
		super();
		this.id = id;
		this.updateColumn = updateColumn;
		this.updateInfo = updateInfo;
	}

	@Override
	public String toString() {
		return "UserUpdate [id=" + id + ", updateColumn" + updateColumn + ", updateInfo=" + updateInfo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((updateColumn == null) ? 0 : updateColumn.hashCode());
		result = prime * result + ((updateInfo == null) ? 0 : updateInfo.hashCode());
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
		UserUpdate other = (UserUpdate) obj;
		if (id != other.id)
			return false;
		if (updateColumn == null) {
			if (other.updateColumn != null)
				return false;
		} else if (!updateColumn.equals(other.updateColumn))
			return false;
		if (updateInfo == null) {
			if (other.updateInfo != null)
				return false;
		} else if (!updateInfo.equals(other.updateInfo))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUpdateColumn() {
		return updateColumn;
	}

	public void setUpdateColumn(String updateColumn) {
		this.updateColumn = updateColumn;
	}

	public String getUpdateInfo() {
		return updateInfo;
	}

	public void setUpdateInfo(String updateInfo) {
		this.updateInfo = updateInfo;
	}

}
