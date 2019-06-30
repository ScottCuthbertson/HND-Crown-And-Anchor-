package assessmentDiceGame;

public abstract class Bet {//done dont mod
	protected String whatOn;
	protected int amount;
	private char typeOfBet;

	public Bet(String whatOn, int amount) {
		this.whatOn = whatOn;
		this.amount = amount;
	}
	
	public Bet(String whatOn, int amount, char typeOfBet) {
		this.whatOn = whatOn;
		this.amount = amount;
		this.typeOfBet = typeOfBet;
	}
	
	public abstract int workOutWinnings(CADice[]Dice);
	
	public abstract String getDisplayBet();

	public String getWhatOn() {
		return whatOn;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public char getTypeOfBet() {
		return typeOfBet;
	}
}
