package ssa;

public class Mainline {

	public static void main(String[] args) {
		
		SimulatedBowling bowl = new SimulatedBowling();
		bowl.bowl();
		
		System.out.println();
		
		SimulatedBowling bowl2 = new SimulatedBowling(5);
		bowl2.bowl();

	}

}
