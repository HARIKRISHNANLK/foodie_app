package com.btc.app.model;


public class Restaurant 
{
	private int RestaurantId;
	private String RestaurantName;
	private String Location;
	private String Type;
	private String Category;


	public Restaurant() {
	}


	public Restaurant(int RestaurantId, String RestaurantName, String Location, String Type, String Category) {
		super();
		this.RestaurantId = RestaurantId;
		this.RestaurantName = RestaurantName;
		this.Location = Location;
		this.Type = Type;
		this.Category = Category;
	}


	public int getRestaurantId() {
		return RestaurantId;
	}


	public void setRestaurantId(int RestaurantId) {
		this.RestaurantId = RestaurantId;
	}


	public String getRestaurantName() {
		return RestaurantName;
	}


	public void setRestaurantName(String RestaurantName) {
		this.RestaurantName = RestaurantName;
	}
	
	public String getLocation() {
		return Location;
	}


	public void setLocation(String Location) {
		this.Location = Location;
	}
	
	public String getType() {
		return Type;
	}


	public void setType(String Type) {
		this.Type = Type;
	}
	


	public String getCategory() {
		return Category;
	}


	public void setCategory(String Category) {
		this.Category = Category;
	}


	@Override
	public String toString() {
		return "Employee [RestaurantId=" + RestaurantId + ", RestaurantName=" + RestaurantName + ", Location=" + Location +", Type=" + Type + ", Category="
				+ Category + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Location == null) ? 0 : Location.hashCode());
		result = prime * result + ((Type == null) ? 0 : Type.hashCode());
		result = prime * result + RestaurantId;
		result = prime * result + ((RestaurantName == null) ? 0 : RestaurantName.hashCode());
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
		Restaurant other = (Restaurant) obj;
		if (Location == null) {
			if (other.Location != null)
				return false;
		} else if (!Location.equals(other.Location))
			return false;
		if (Type == null) {
			if (other.Type != null)
				return false;
		} else if (!Type.equals(other.Type))
			return false;
		if (RestaurantId != other.RestaurantId)
			return false;
		if (RestaurantName == null) {
			if (other.RestaurantName != null)
				return false;
		} else if (!RestaurantName.equals(other.RestaurantName))
			return false;
		return true;
	}	
}