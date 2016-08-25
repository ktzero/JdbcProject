package ssa;

public class SimulatedBowling {

	private int bowlingScores[][];
	private int totalGames, totalSeries;
	private java.util.Random rnd;
	
	//bowlingScores has variable number of games and 11 spaces
	//10 for frames and 1 for the sum of all frames
	//assuming the frames will not change
	public SimulatedBowling()
	{	
		setConditions();
		totalGames = 3;
		bowlingScores = new int[totalGames][11];
	}
	
	//constructor for a variable amount of games 
	public SimulatedBowling(int numgames)
	{
		setConditions();
		totalGames = numgames;
		bowlingScores = new int[numgames][11];
	}
	
	//set sum to 0 and generate random num generator
	private void setConditions()
	{
		totalSeries = 0;
		rnd = new java.util.Random(new java.util.Date().getTime());
	}
	
	//main method for this class, will go through 10 frames for X amount of games
	//will print out table of games at the end of the method
	public void bowl()
	{
		
		for(int game = 0; game < totalGames; game++)
		{
			int gameTotal = 0;
			for(int frame = 0; frame < 10; frame++)
			{
				int throw1 = getPinsKnockedDown();
				if(throw1 < 10)
				{
					int throw2 = getPinsKnockedDown();
					//if spare
					if(throw1 + throw2 >= 10)
					{	
						bowlingScores[game][frame] = 12;
						gameTotal += 12;
					}
					//no spare nor strike
					else
					{
						bowlingScores[game][frame] = throw1 + throw2;
						gameTotal += throw1 + throw2;
					}
				}
				//strike
				else 
				{
					bowlingScores[game][frame] = 15;
					gameTotal += 15;
				}
			}
			bowlingScores[game][10] = gameTotal;
			totalSeries += gameTotal;
		}
		
		print();
	}
	
	//simulating throwing ball, returns random number between 0-10
	private int getPinsKnockedDown()
	{
		int randomInt = rnd.nextInt(11); // zero to ten
		return randomInt;
	}
	
	//prints out the results of X number of games in table format as 
	//requested by Greg
	private void print()
	{
		System.out.print("Frames  ");
		for(int i = 0; i < 10; i++)
		{
			System.out.printf("%4d ", i+1);
		}
		System.out.println("  Total");
		
		for(int game = 0; game < totalGames; game++)
		{
			System.out.print("Game " + (game + 1) + "  ");
			for(int frame = 0; frame < 10; frame++)
			{
				System.out.printf("%4d ", bowlingScores[game][frame]);
			}
			System.out.println("   " + bowlingScores[game][10]);
		}
		System.out.println("Total Series                                                 " 
				+ totalSeries);
	}
}
