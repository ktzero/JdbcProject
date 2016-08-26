package ssa;

public class Score {

	private boolean spare, strike;
	private int firstThrow, secondThrow, thirdThrow, score;
	
	
	public Score()
	{
		spare = false;
		strike = false;
		firstThrow = 0;
		secondThrow = 0;
		thirdThrow = 0;
		score = 0;
	}

	public boolean isSpare() {	return spare;	}

	public void setSpare(boolean spare) {	this.spare = spare;	}

	public boolean isStrike() {	return strike;	}

	public void setStrike(boolean strike) {	this.strike = strike;	}

	public int getFirstThrow() {	return firstThrow;	}

	public void setFirstThrow(int firstThrow) {		this.firstThrow = firstThrow;	}

	public int getSecondThrow() {	return secondThrow;	}

	public void setSecondThrow(int secondThrow) {	this.secondThrow = secondThrow;	}

	public int getScore() {	return score;	}

	public void setScore(int score) {	this.score = score;	}

	public int getThirdThrow() {	return thirdThrow;	}

	public void setThirdThrow(int thirdThrow) {		this.thirdThrow = thirdThrow;	}
	
	
	
	
}
