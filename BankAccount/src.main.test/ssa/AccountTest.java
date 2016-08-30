package ssa;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		//testing account class, constructor with initial balance
		Account acc = new Account(1000);
		
		//testing desposit, getBal, withdraw, and setDesc methods
		assertEquals(true, acc.deposit(500));
		assertEquals(1500, acc.getBalance(), 0);
		assertEquals(true, acc.withdraw(1000));
		assertEquals(500, acc.getBalance(), 0);
		acc.setDescription("test");
		assertEquals("test", acc.getDescription());
		
		//testing default constructor
		Account acc1 = new Account();
		
		assertEquals(true, acc1.deposit(1500));
		assertEquals(1500, acc1.getBalance(), 0);
		//testing print method
		assertEquals("Account 1001 balance is $1500.00", acc1.print());
		assertEquals(true, acc1.withdraw(1000));
		assertEquals(500, acc1.getBalance(), 0);
		assertEquals("A default account", acc1.getDescription());
		//testing account ID incrementor
		assertEquals(1001, acc1.getId());
		
		//testing transferFrom method
		acc.transferFrom(acc1, 100);
		assertEquals(400, acc1.getBalance(),0);
		assertEquals(600, acc.getBalance(),0);
		
		//testing constructor with description
		Account acc2 = new Account("another account");
		
		assertEquals(1002, acc2.getId());
		assertEquals("another account", acc2.getDescription());
		
		//testing constructor with initial ID and description
		Account acc3 = new Account(44,"even another account");
		
		assertEquals(44, acc3.getId());
		assertEquals("even another account", acc3.getDescription());
		assertEquals("Account 44 balance is $0.00", acc3.print());
		
		//=============
		//savings tests, testing set/getInterestRate and calcDeposit
		Savings save = new Savings();
		assertEquals(.015, save.getInterestRate(),0);
		assertEquals(true, save.deposit(1000));
		save.calcDepositInterest(4);
		assertEquals(1005, save.getBalance(),0);
		save.setInterestRate(.04);
		assertEquals(.04, save.getInterestRate(), 0);
		
		//=========
		//checkings tests, checking that check properly increments
		Checking check = new Checking();
		assertEquals(100, check.getLastCheckNbr());
		check.deposit(1000);
		check.withdraw(100);
		assertEquals(101, check.getLastCheckNbr());
		
	}

}
