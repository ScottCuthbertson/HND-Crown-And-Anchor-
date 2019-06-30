package assessmentDiceGame;

public class DoubleOrNothing extends Bet {//should be fine need double check

	public DoubleOrNothing(String whatOn, int amount) {
		super(whatOn, amount,'d');
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
		if (matches >=2)
		{
			winnings=amount*5;
		}
		return winnings;
	}
	@Override
	public String getDisplayBet() {
		System.out.println("Double Or Nothing" + whatOn + amount ++);
		return null;
	}

}
