package ssa;

public class Checking extends Account{

	private static int lastCheckNbr = 100;
	
	
	public boolean withdraw(double amt)
	{
		lastCheckNbr++;
		return super.withdraw(amt);
	}
	
	public int getLastCheckNbr()
	{return lastCheckNbr;	}
	
	
}
