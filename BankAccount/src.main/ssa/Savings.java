package ssa;

public class Savings extends Account{

	private double interestRate, minBal, interestAccrued;

	/**
	 * @return the interestAccrued calculated in calcDepositInterest
	 */
	public double getInterestAccrued() {
		return interestAccrued;
	}
	
	/**
	 * @return the minBal
	 */
	public double getMinBal() {	return minBal;	}

	/**
	 * @param minBal the minimum balance to set
	 */
	public void setMinBal(double minBal) {	this.minBal = minBal;	}

	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {	return interestRate;	}

	/**
	 * @param interestRate the interest rate to set
	 */
	public void setInterestRate(double interestRate) {this.interestRate = interestRate;}
	
	//calculates the deposit based of 12 months in a year and the current balance,
	//then deposits the interest into the balance
	//only valid if current balance is greater than the minimum balance
	public void calcDepositInterest(int months)
	{
		if(super.getBalance() >= this.getMinBal())
		{
			double intPerMonth = interestRate / 12;
			double calcInt = intPerMonth * months * super.getBalance();
			super.deposit(calcInt);
			interestAccrued += calcInt;
		}
	}

	//default constructor
	public Savings()
	{
		super();
		this.setInterestRate(0.015);
		this.setMinBal(0);
	}
	
	//constructor with String parameter
	  public Savings(String description)
	  { 	
		  super(description);
		  this.setInterestRate(0.015);
		  this.setMinBal(0);
	  }
	  
	  //constructor with initial id and description provided
	  public Savings(int id, String description)
	  {
		  super(id, description);
		  this.setInterestRate(0.015);
		  this.setMinBal(0);
	  }
	  
	  //prints out the account id and balance from Account class
	  //as well as the total interest acrrued
	  public String print()
	  {
		  return super.print() + " and total interest paid is " 
				  + String.format("$%.2f", this.getInterestAccrued());
	  }
	  
	
}
