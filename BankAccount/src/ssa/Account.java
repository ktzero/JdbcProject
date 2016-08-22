package ssa;

public class Account {
	// A bank account
	  int accountId; // unique identifier for the account
	  String description; // a user defined name for the account
	  double balance; // the amount in the account.

	  //a blank constructor
	  public Account()
	  { }
	  
	  //constructor to set balance when account is created
	  public Account(double aBalance)
	  {	  balance = aBalance; }
	  
	  // returns the account info as a string
	 public String print() 
	 {
	    return description + ": Account: id is " + accountId 
	      + ", balance is $" + balance; 
	 }
	  // deposit into the account
	  //will return true 
	 public boolean deposit(double amt) 
	 { 	
		 System.out.printf("Deposited $%.2f. ", amt); 
		 balance += amt;
		 currentBalance();
		 return true;
	 }
	 
	  // withdraw from the account, but cannot go negative
	  //will return true for successful withdrawal, or false otherwise
	 public boolean withdraw(double amt) 
	 {
	    if(amt > balance) 
	    {
	    	System.out.println("Insufficient funds!");
	    	currentBalance();
	    	return false;
	    } 
	    else 
	    {
	    	System.out.printf("Withdrew $%.2f. ",amt); 
	    	balance -= amt;
	    	currentBalance();
	    	return true;
	    }
	 }
	  
	 //prints out current balance
	  public void currentBalance()
	  {
		  System.out.printf("%s balance: $%.2f\n",description, balance);
	  }
	  
	  //transfer money from another account
	  public void transfer(double amt, Account otherAcc)
	  {
		  if(otherAcc.withdraw(amt))
		  {
			  deposit(amt);
			  System.out.printf("Successfully transferred $%.2f from %s to %s", 
					  amt, otherAcc.description, description);
		  }
		  else
			  System.out.println("Unable to transfer due to insufficient funds");
	  }
}
