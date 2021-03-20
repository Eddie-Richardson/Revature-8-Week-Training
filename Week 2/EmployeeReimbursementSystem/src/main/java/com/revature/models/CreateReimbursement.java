package com.revature.models;


public class CreateReimbursement {
	
	private int amount;
	private String description;
	private int authorId;
	private int typeId;
	
	
	public CreateReimbursement() {
		super();
	}

	public CreateReimbursement(int amount, String description, int authorId, int typeId) {
		super();
		this.amount = amount;
		this.description = description;
		this.authorId = authorId;
		this.typeId = typeId;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + authorId;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		CreateReimbursement other = (CreateReimbursement) obj;
		if (amount != other.amount)
			return false;
		if (authorId != other.authorId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CreateReimbursement [amount=" + amount + ", description=" + description + ", authorId=" + authorId
				+ ", typeId=" + typeId + "]";
	}
	
}
