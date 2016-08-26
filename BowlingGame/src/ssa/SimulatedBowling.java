package ssa;

public class SimulatedBowling {

	//private int bowlingScores[][];
	private Score[][] bowlingScores;
	private int totalGames, totalSeries;
	private java.util.Random rnd;
	
	//bowlingScores has variable number of games and 11 spaces
	//10 for frames and 1 for the sum of all frames
	//assuming the frames will not change
	public SimulatedBowling()
	{	
		totalGames = 3;
		//bowlingScores = new int[totalGames][11];
		bowlingScores = new Score[totalGames][11];
		setConditions();
	}
	
	//constructor for a variable amount of games 
	public SimulatedBowling(int numgames)
	{
		totalGames = numgames;
		//bowlingScores = new int[totalGames][11];
		bowlingScores = new Score[totalGames][11];
		setConditions();
	}
	
	//set sum to 0 and generate random num generator
	private void setConditions()
	{
		totalSeries = 0;
		rnd = new java.util.Random(new java.util.Date().getTime());
		for(int i = 0; i < totalGames; i++)
		{
			for (int j = 0; j < 11; j++)
				bowlingScores[i][j] = new Score();
		}
	}
	
	//main method for this class, will go through 10 frames for X amount of games
	//will print out table of games at the end of the method
	public void bowl()
	{
		//run through bowling to get the base scores
		getInitialScores();
		
		//run through the scores to adjust for spares and strikes
		calculateScores();
		
		//print out scores in table format
		print();
	}
	
	private void getInitialScores()
	{
		int throw1 = 0, throw2 = 0, throw3 = 0;
		for(int game = 0; game < totalGames; game++)
		{
			//int gameTotal = 0;
			//only go through first 9 frames because 10th frame is special
			for(int frame = 0; frame < 9; frame++)
			{
				throw1 = getPinsKnockedDown(10);
				bowlingScores[game][frame].setFirstThrow(throw1);
				if(throw1 < 10)
				{
					throw2 = getPinsKnockedDown((10 - throw1));
					bowlingScores[game][frame].setSecondThrow(throw2);
					//if spare
					if(throw1 + throw2 >= 10)
					{	
						//bowlingScores[game][frame] = 12;
						bowlingScores[game][frame].setSpare(true);
						//gameTotal += 12;
					}
					//no spare nor strike
					//for pro challenge, do nothing here
					else
					{
						//bowlingScores[game][frame] = throw1 + throw2;
						//gameTotal += throw1 + throw2;
					}
				}
				//strike
				else 
				{
					//bowlingScores[game][frame] = 15;
					//gameTotal += 15;
					bowlingScores[game][frame].setStrike(true);
				}
			}
			//bowlingScores[game][10] = gameTotal;
			//totalSeries += gameTotal;
			
			//special case for the tenth frame
			throw1 = this.getPinsKnockedDown(10);
			bowlingScores[game][9].setFirstThrow(throw1);
			if(throw1 < 10)
			{
				throw2 = this.getPinsKnockedDown((10 - throw1));
				bowlingScores[game][9].setSecondThrow(throw2);
				if(throw1 + throw2 >= 10)	//spare then throw again but no need to calculate
				{
					throw3 = this.getPinsKnockedDown(10);
					bowlingScores[game][9].setThirdThrow(throw3);
				}
			}
			else
			{
				bowlingScores[game][9].setStrike(true);
				throw2 = this.getPinsKnockedDown(10);
				bowlingScores[game][9].setSecondThrow(throw2);
				bowlingScores[game][9].setSpare(true);
				throw3 = this.getPinsKnockedDown(10);
				bowlingScores[game][9].setThirdThrow(throw3);
				
			}
			
			
		}
	}
	
	private void calculateScores()
	{
		for(int game = 0; game < totalGames; game++)
		{
			for(int frame = 0; frame < 9; frame++)
			{
				if(bowlingScores[game][frame].isStrike())
				{
					if(!bowlingScores[game][frame+1].isStrike())
					{
						bowlingScores[game][frame].setScore(bowlingScores[game][frame].getFirstThrow() +
								bowlingScores[game][frame].getSecondThrow() + bowlingScores[game][frame + 1].getFirstThrow()
								+ bowlingScores[game][frame + 1].getSecondThrow());
					}
					else
					{
						bowlingScores[game][frame].setScore(bowlingScores[game][frame].getFirstThrow() +
								bowlingScores[game][frame].getSecondThrow() + bowlingScores[game][frame + 1].getFirstThrow()
								+ bowlingScores[game][frame + 2].getFirstThrow());
						if(frame == 8)
							bowlingScores[game][frame].setScore(bowlingScores[game][frame].getScore() +
									bowlingScores[game][frame + 1].getSecondThrow());
					}
				}
				else if(bowlingScores[game][frame].isSpare())
				{
					bowlingScores[game][frame].setScore(bowlingScores[game][frame].getFirstThrow() +
							bowlingScores[game][frame].getSecondThrow() + bowlingScores[game][frame + 1].getFirstThrow());
				}
				else
					{bowlingScores[game][frame].setScore(bowlingScores[game][frame].getFirstThrow() + bowlingScores[game][frame].getSecondThrow());}
				
				if(frame > 0)
					bowlingScores[game][frame].setScore(bowlingScores[game][frame - 1].getScore() + bowlingScores[game][frame].getScore());
			}
			//check 10th frame
				bowlingScores[game][9].setScore(bowlingScores[game][9].getFirstThrow() + bowlingScores[game][9].getSecondThrow() 
						+ bowlingScores[game][9].getThirdThrow() + bowlingScores[game][8].getScore());
		}
	}
	
	//simulating throwing ball, returns random number between 0 to the number passed in (inclusive)
	private int getPinsKnockedDown(int randomNum)
	{
		int randomInt = rnd.nextInt((randomNum + 1)); // zero to ten
		return randomInt;
		//return 10;
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
				System.out.printf("%4d ", bowlingScores[game][frame].getScore());
			}
			System.out.println("   " + bowlingScores[game][10]);
		}
		System.out.println("Total Series                                                 " 
				+ totalSeries);
		//print out spares and strikes
		for(int game = 0; game < totalGames; game++)
		{
			System.out.println("");
			for(int frame = 0; frame < 10; frame++)
			{
				System.out.printf("Strike: %b, Spare: %b, First Score: %d, Second Score: %d\n", 
						bowlingScores[game][frame].isStrike(), bowlingScores[game][frame].isSpare(),
						bowlingScores[game][frame].getFirstThrow(), bowlingScores[game][frame].getSecondThrow());
			}
			System.out.println(bowlingScores[game][9].getThirdThrow());
		}
	}
	
	
}
