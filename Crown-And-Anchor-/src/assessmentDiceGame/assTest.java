package assessmentDiceGame;
public class assTest {
	public static void test() {
		Player aPlayer = new Player (); 
		Player bPlayer = new Player ("Scott", 20);
		System.out.println("Player:a default");
		System.out.println("What is the your name? "+aPlayer.getName());
		System.out.println("what is the amount of the stake? "+aPlayer.getStake());
		System.out.println("what is the amount of the banker? "+aPlayer.getBanker());
		System.out.println("Player:b ");	
		System.out.println("What is your name ? "+bPlayer.getName());
		System.out.println("What is the amount of the stake ? "+bPlayer.getStake());
		System.out.println("what is the amount of the banker? "+bPlayer.getBanker());
		bPlayer.incStake(10);	System.out.println("What is the amount of the stake ? "+bPlayer.getStake());
		bPlayer.decStake(5);	System.out.println("What is the amount of the stake ? "+bPlayer.getStake());
		bPlayer.incBanker(10);	System.out.println("What is the amount of the banker ? "+bPlayer.getBanker());
		bPlayer.decBanker(5);	System.out.println("What is the amount of the banker ? "+bPlayer.getBanker());

		System.out.println("");
		CADice aDice = new CADice();
		CADice bDice = new CADice();
		CADice cDice = new CADice();
		System.out.println("Dice :a default");
		System.out.println("What is the number of the dice ?" +aDice.getDiceFace());
		System.out.println("What is the playing card ?" +aDice.getDice());
		System.out.println("Dice :b");
		System.out.println("What is the number of the dice?"+bDice.getDiceFace());
		System.out.println("What is the playing card ?"+bDice.getDice());
		System.out.println("Dice :c");
		System.out.println("What is the number of the dice?"+cDice.getDiceFace());
		System.out.println("What is the playing card ?"+cDice.getDice());
		
		System.out.println("");
		System.out.println("crown bet ordinay");
		OrdinaryBet abet = new OrdinaryBet("Crown ",20);
		System.out.println(abet.getDisplayBet());
		CADice dice[] = new CADice[3];
		dice[0] = new CADice();
		dice[1] = new CADice();		
		dice[2] = new CADice();
		System.out.println("Oridnary bet 3 matches of �20 " + abet.workOutWinnings(dice));
		System.out.println("");
		System.out.println("spade bet ordinay");
		OrdinaryBet bbet = new OrdinaryBet("Spade ",20);
		System.out.println(bbet.getDisplayBet());
		CADice bdice[] = new CADice[3];
		dice[0] = new CADice();
		dice[1] = new CADice();		
		dice[2] = new CADice();		
		System.out.println("Oridnary bet no matches of �20 " + bbet.workOutWinnings(dice));
		System.out.println("");
		System.out.println("crown bet double");
		DoubleOrNothing gbet = new DoubleOrNothing("Crown ",20);
		System.out.println(gbet.getDisplayBet());
		CADice cdice[] = new CADice[3];
		dice[0] = new CADice();
		dice[1] = new CADice();		
		dice[2] = new CADice();	
		System.out.println("Double bet one matches of �20 " + gbet.workOutWinnings(dice));
		System.out.println("");
		System.out.println("anchor bet double");
		DoubleOrNothing hbet = new DoubleOrNothing("Anchor ",20);
		System.out.println(hbet.getDisplayBet());
		CADice ddice[] = new CADice[3];
		dice[0] = new CADice();
		dice[1] = new CADice();		
		dice[2] = new CADice();	
		System.out.println("Double bet one matches of �20 " + hbet.workOutWinnings(dice));
		System.out.println("");
		DoubleOrNothing ibet = new DoubleOrNothing("Spade ",20);
		System.out.println(ibet.getDisplayBet());
		CADice edice[] = new CADice[3];
		dice[0] = new CADice();
		dice[1] = new CADice();		
		dice[2] = new CADice();	
		System.out.println("All-in bet one matches of �20 " + ibet.workOutWinnings(dice));
		System.out.println("");
		Allin jbet = new Allin("Anchor ",20);
		System.out.println(jbet.getDisplayBet());
		CADice fdice[] = new CADice[3];
		dice[0] = new CADice();
		dice[1] = new CADice();		
		dice[2] = new CADice();	
		System.out.println("All-in bet one matches of �20 " + jbet.workOutWinnings(dice));
	}
}

