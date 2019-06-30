package assessmentDiceGame;
public class OrdinaryBet extends Bet {//done dont mod
	public OrdinaryBet(String whatOn, int amount) {
		super(whatOn, amount, 'o');
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
		if (matches >0)
		{
			matches++;
			winnings=matches*amount;
		}
		return winnings;
	}
	@Override
	public String getDisplayBet() {
		String msg = ("Ordinary bet on " + whatOn + " of £" +amount);
		return msg;
	}
}
