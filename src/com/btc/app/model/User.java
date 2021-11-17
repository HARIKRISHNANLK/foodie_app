package com.btc.app.model;

public class User {
		private int userId;
		private String userName;
		private String password;
		private int age;
		private String userEmail;
		private int phoneNo;
		
		public User()
		{
			
		}

		public User(int userId, String userName,String password, int age, String userEmail, int phoneNo) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.password = password;
			this.age = age;
			this.userEmail = userEmail;
			this.phoneNo = phoneNo;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}
		
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}

		public int getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(int phoneNo) {
			this.phoneNo = phoneNo;
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", age=" + age
					+ ", userEmail=" + userEmail + ", phoneNo=" + phoneNo + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + phoneNo;
			result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
			result = prime * result + userId;
			result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
			User other = (User) obj;
			if (age != other.age)
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (phoneNo != other.phoneNo)
				return false;
			if (userEmail == null) {
				if (other.userEmail != null)
					return false;
			} else if (!userEmail.equals(other.userEmail))
				return false;
			if (userId != other.userId)
				return false;
			if (userName == null) {
				if (other.userName != null)
					return false;
			} else if (!userName.equals(other.userName))
				return false;
			return true;
		}

		
		
		
}