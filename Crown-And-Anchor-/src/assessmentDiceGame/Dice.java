package assessmentDiceGame;

public class Dice {//done dont mod

	private int diceFace;

	public Dice(int diceFace) {
		this.diceFace = diceFace;
	}
	public Dice() {
		throwDice();
	}

	public void throwDice(){
		double randomNo=Math.random();
		randomNo=6 * randomNo;
		randomNo++;
		diceFace=(int)randomNo;
	}	
	public int getDiceFace() {
		return diceFace;
	}
}
