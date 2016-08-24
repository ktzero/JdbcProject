package ssa;

//testing class for original Account class
public class Mainline {
	
	public static void main(String[] args) {
	
		Savings save = new Savings();
		save.deposit(500);
		save.calcDepositInterest(4);
		System.out.println(save.print());
	}

}
