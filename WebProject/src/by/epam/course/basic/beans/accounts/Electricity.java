package by.epam.course.basic.beans.accounts;

import by.epam.course.basic.beans.rates.Rates;

public class Electricity {
	private int Account_ID;
	private double balanceWatt;
	private double bill;
	
	public Electricity() {
	
	}
	public Electricity(int account_ID, double balanceWatt) {
		Account_ID = account_ID;
		this.balanceWatt = balanceWatt;
		this.bill = balanceWatt * Rates.electricRate;
	}

	public int getAccount_ID() {
		return Account_ID;
	}

	public void setAccount_ID(int account_ID) {
		Account_ID = account_ID;
	}

	public double getBalanceWatt() {
		return balanceWatt;
	}

	public void setBalanceWatt(double balanceWatt) {
		this.balanceWatt = balanceWatt;
	}

	public double getBill() {
		return bill;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Account_ID;
		long temp;
		temp = Double.doubleToLongBits(balanceWatt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(bill);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Electricity other = (Electricity) obj;
		if (Account_ID != other.Account_ID)
			return false;
		if (Double.doubleToLongBits(balanceWatt) != Double.doubleToLongBits(other.balanceWatt))
			return false;
		if (Double.doubleToLongBits(bill) != Double.doubleToLongBits(other.bill))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account wuth ID=" + Account_ID + " has " + balanceWatt + " watts, bill=" + bill;
	}

}
