package assessmentDiceGame;

public class Allin extends Bet {

	public Allin(String whatOn, int amount) {
		super(whatOn, amount,'a');
		
	}

	@Override
	public int workOutWinnings(CADice[] di) {
		int matches = 0;
		int winnings = 0;		
		
		for (CADice dice: di) 
		{
			if (dice.getDice().equalsIgnoreCase(whatOn))
			{
				matches++;
			}
		}
		if (matches >=3)
		{
			winnings=10*amount;
		}
		return winnings;
	}

	@Override
	public String getDisplayBet() {
		System.out.println("All in" + whatOn + amount ++);
		return null;
	}

}
