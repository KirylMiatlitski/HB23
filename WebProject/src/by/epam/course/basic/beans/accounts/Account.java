package by.epam.course.basic.beans.accounts;

import by.epam.course.basic.beans.users.User;

public class Account {
	private int account_ID;
	private User user;
	private Electricity electricity;
	private Water water;

	public Account() {

	}

	public int getAccount_ID() {
		return account_ID;
	}

	public void setAccount_ID(int account_ID) {
		this.account_ID = account_ID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Electricity getElectricity() {
		return electricity;
	}

	public void setElectricity(Electricity electricity) {
		this.electricity = electricity;
	}

	public Water getWater() {
		return water;
	}

	public void setWater(Water water) {
		this.water = water;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_ID;
		result = prime * result + ((electricity == null) ? 0 : electricity.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((water == null) ? 0 : water.hashCode());
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
		Account other = (Account) obj;
		if (account_ID != other.account_ID)
			return false;
		if (electricity == null) {
			if (other.electricity != null)
				return false;
		} else if (!electricity.equals(other.electricity))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (water == null) {
			if (other.water != null)
				return false;
		} else if (!water.equals(other.water))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account with ID=" + account_ID + " is  " + user.getFirstName() + " " + user.getLastName();
	}

}
