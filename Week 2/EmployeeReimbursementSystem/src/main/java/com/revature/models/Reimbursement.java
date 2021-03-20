package com.revature.models;

import java.sql.Timestamp;

public class Reimbursement {
	
	private int id;
	private int amount;
	private String submitted;
	private String resolved;
	private String description;
	private String receipt;
	private int authorId;
	private int resolverId;
	private int statusId;
	private int typeId;
	
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", receipt=" + receipt + ", authorId=" + authorId + ", resolverId="
				+ resolverId + ", statusId=" + statusId + ", typeId=" + typeId + "]";
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + authorId;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + resolverId;
		result = prime * result + statusId;
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
		result = prime * result + typeId;
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
		Reimbursement other = (Reimbursement) obj;
		if (amount != other.amount)
			return false;
		if (authorId != other.authorId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (resolverId != other.resolverId)
			return false;
		if (statusId != other.statusId)
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public int getAmount() {
		return amount;
	}





	public void setAmount(int amount) {
		this.amount = amount;
	}





	public String getSubmitted() {
		return submitted;
	}





	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}





	public String getResolved() {
		return resolved;
	}





	public void setResolved(String resolved) {
		this.resolved = resolved;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public String getReceipt() {
		return receipt;
	}





	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}





	public int getAuthorId() {
		return authorId;
	}





	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}





	public int getResolverId() {
		return resolverId;
	}





	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}





	public int getStatusId() {
		return statusId;
	}





	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}





	public int getTypeId() {
		return typeId;
	}





	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}



	
	
	


	public Reimbursement(int id, int amount, String submitted, String resolved, String description, String receipt, int authorId, int resolverId, int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

}
