package ssa;

//testing class for enhanced Account class
public class Mainline2 {

	public static void main(String[] args) {
		
		Account checking1 = new Account();
		checking1.setDescription("My personal checking account");
		//checking1.balance = 800.00;
		checking1.deposit(800);		//fixed statement above because can no longer directly access variables
		checking1.print();
		checking1.deposit(300.00);
		checking1.print();
		checking1.withdraw(699.99);
		checking1.print();
		checking1.deposit(149.99);
		checking1.print();
		checking1.withdraw(950.00); // this should fail!
		checking1.print();
		checking1.withdraw(200.00);
		checking1.print(); // balance should be 350
		//
		Account savings1 = new Account("My personal savings account");
		savings1.deposit(1000.00);
		savings1.print();
		savings1.deposit(400.00);
		savings1.print();
		savings1.withdraw(750.00);
		savings1.print();
		savings1.withdraw(250.00);
		savings1.print();
		savings1.deposit(650.00);
		savings1.print(); // balance should be 1050.00
		// the transfer
		checking1.transferFrom(savings1, 100.00); // transfer 100 from savings to checking
		// another account
		Account checking2 = new Account("My slush fund checking account");
		Account checking3 = new Account(1,"my account");
		checking2.deposit(300.00);
		checking2.print();
		checking2.withdraw(150.00);
		checking2.print();
		checking2.deposit(250.00);
		checking2.print();

		/*// more to come. Will be updated during the lab...*/

		// print out all account balances
		System.out.println("Final totals:");
		System.out.println(checking1.print());
		System.out.println(checking2.print());
		System.out.println(savings1.print());
		System.out.println(checking3.print());

		//## Protect the class data
		//For our Account class, we do not want any access to our class data from outside our class. In order to make sure our data cannot be access outside the class, you need to add the access modifier `private` before all the types for the data. It would looks something like this:

		//```java
		  // int id - previously
		  //private int id;


	}

}
