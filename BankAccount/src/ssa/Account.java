package ssa;

public class Account {
	// A bank account
	  private static int idCounter = 1000; //counter that will be used for all Accounts made
	  private int id; // unique identifier for the account
	  private String description; // a user defined name for the account
	  private double balance; // the amount in the account

	  //a blank constructor
	  public Account()
	  { 
		  this.setId();
		  this.setDescription("A default account");
		  this.setBalance(0);
	  }
	  
	  //constructor with String parameter
	  public Account(String description)
	  { 	
		  this.setId();
		  this.setDescription(description);
		  this.setBalance(0);
	  }
	  
	  //will automatically assign an ID if not specified
	  private void setId() {
		  this.setId(idCounter);
		  idCounter++;
	  }
	  
	  //constructor with initial id and description provided
	  public Account(int id, String description)
	  {
		  this.setId(id);
		  this.setDescription(description);
		  this.setBalance(0);
	  }
	  
	  //constructor to set balance when account is created
	  public Account(double aBalance)
	  {	  this.setBalance(aBalance); }
	  
	  // returns the account info as a string
	 public String print() 
	 {
	    return "Account " + id + " balance is " + String.format("$%.2f", getBalance()); 
	 }
	  // deposit into the account
	  //will return true 
	 public boolean deposit(double amt) 
	 { 	
		 if(amt >= 0)
		 {
			 //System.out.printf("Deposited $%.2f. ", amt); 
			 this.setBalance(getBalance() + amt);
			 //currentBalance();
			 return true;
		 }
		 else return false;
	 }
	 
	  // withdraw from the account, but cannot go negative
	  //will return true for successful withdrawal, or false otherwise
	 public boolean withdraw(double amt) 
	 {
	    if(amt > getBalance() || amt < 0) 
	    {
	    	//System.out.println("Insufficient funds in " + this.getDescription() + "!");
	    	//currentBalance();
	    	return false;
	    } 
	    else 
	    {
	    	//System.out.printf("Withdrew $%.2f. ",amt); 
	    	this.setBalance(getBalance() - amt);
	    	//currentBalance(); 
	    	return true;
	    }
	 }
	  
	 //prints out current balance
	  public void currentBalance()
	  {
		  System.out.printf("%s balance: $%.2f\n",getDescription(), this.getBalance());
	  }
	  
	  //transfer money from another account
	  public void transferFrom(Account account, double amount)
	  {
		  if(account.withdraw(amount))
		  {
			  deposit(amount);
			  //System.out.printf("Successfully transferred $%.2f from %s to %s \n", 
				//	  amount, account.getDescription(), description);
		  }
		  //else
			  //System.out.println("Unable to transfer due to insufficient funds in " + account.getDescription());
	  }
	  
	  //setters and getters for each instance variable
	  private void setId(int id) {	this.id = id;	}
	  public int getId() { return id;}

	  public String getDescription() {return description;	}

	  public void setDescription(String description) 
	  {this.description = description;	}

	  public double getBalance() {return balance;	}

	  private void setBalance(double balance) {this.balance = balance;	}
}
