package ssa;

public class Mainline {

	private static int transId;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//main keeps track of transactions for all accounts
		//so that transactions between accounts are unique too
		transId = 0;
		Account checking = new Account();
		Account savings = new Account();
		
		checking.accountId = 100;
		checking.description = "My personal checking account";
		checking.balance = 500;
		System.out.println(checking.print());
		
		incrementTransId();
		checking.deposit(500);
		System.out.println(checking.print());
		
		incrementTransId();
		checking.withdraw(600);
		System.out.println(checking.print());
		
		incrementTransId();
		checking.deposit(100);
		incrementTransId();
		checking.withdraw(300);
		System.out.println(checking.print());
		
		incrementTransId();
		checking.withdraw(200);
		System.out.println(checking.print());
		
		savings.accountId = 200;
		savings.description = "My personal savings account";
		savings.balance = 1000;
		System.out.println(savings.print());
		incrementTransId();
		savings.withdraw(750);
		System.out.println(savings.print());
		incrementTransId();
		savings.withdraw(250);
		System.out.println(savings.print());
		incrementTransId();
		savings.deposit(200);
		System.out.println(savings.print());
		
		//Basic assignment
		System.out.println(checking.print());
		System.out.println(savings.print());
		
		//advanced challenge
		System.out.println("\nAdvanced Challenge:");
		incrementTransId();
		checking.transfer(100, savings);
		Account savings2 = new Account(1000);
		
	}
	
	
	//method to increment and print out transaction ID
	private static void incrementTransId()
	{
		transId++;
		System.out.print("Transaction #" + transId + ": ");
	}

}
