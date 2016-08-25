package ssa;

public class Score {

	boolean spare, strike;
	int score;
	
	public Score()
	{
		spare = false;
		strike = false;
		score = 0;
	}

	public boolean isSpare() {	return spare;	}

	public void setSpare(boolean spare) {	this.spare = spare;	}

	public boolean isStrike() {	return strike;	}

	public void setStrike(boolean strike) {	this.strike = strike;	}

	public int getScore() {	return score;	}

	public void setScore(int score) {	this.score = score;	}
	
	
}
