package by.epam.course.basic.beans.accounts;

import by.epam.course.basic.beans.rates.Rates;

public class Water {
	private int Account_ID;
	private double balanceColdWater;
	private double balanceHotWater;
	private double bill;
	
	public Water() {
		
	}
	
	public Water(int account_ID, double balanceColdWater, double balanceHotWater) {
		Account_ID = account_ID;
		this.balanceColdWater = balanceColdWater;
		this.balanceHotWater = balanceHotWater;
		this.bill = balanceColdWater * Rates.coldWaterRate + balanceHotWater * Rates.hotWaterRate;
	}

	public int getAccount_ID() {
		return Account_ID;
	}

	public void setAccount_ID(int account_ID) {
		Account_ID = account_ID;
	}

	public double getBalanceColdWater() {
		return balanceColdWater;
	}

	public void setBalanceColdWater(double balanceColdWater) {
		this.balanceColdWater = balanceColdWater;
	}

	public double getBalanceHotWater() {
		return balanceHotWater;
	}

	public void setBalanceHotWater(double balanceHotWater) {
		this.balanceHotWater = balanceHotWater;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Account_ID;
		long temp;
		temp = Double.doubleToLongBits(balanceColdWater);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(balanceHotWater);
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
		Water other = (Water) obj;
		if (Account_ID != other.Account_ID)
			return false;
		if (Double.doubleToLongBits(balanceColdWater) != Double.doubleToLongBits(other.balanceColdWater))
			return false;
		if (Double.doubleToLongBits(balanceHotWater) != Double.doubleToLongBits(other.balanceHotWater))
			return false;
		if (Double.doubleToLongBits(bill) != Double.doubleToLongBits(other.bill))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account wuth ID=" + Account_ID + " has Cold Water balance=" + balanceColdWater + ", Hot Water balance="
				+ balanceHotWater + ", bill=" + bill;
	}

}
