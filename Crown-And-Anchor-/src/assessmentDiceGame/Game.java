package assessmentDiceGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Game {

	private Player player;;
	private CADice[] dice;
	private List<Bet> bets=new ArrayList<>();
	private UserInterface ui;


	public Game(){
		ui=new UserInterface();
		getPlayer();
		dice = new CADice[3];
		for( int i=0; i<3; i++ )
			dice[i] = new CADice();
	}
	private void getPlayer() {//done
		String name = ui.getName();
		String filename = name.toLowerCase() + ".ser";
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream inPlayer = new ObjectInputStream(fileIn);
			player = (Player)inPlayer.readObject();
			inPlayer.close();
			fileIn.close();
			System.out.println("Do you want to use your saved game? y/n" );
			if(ui.getYN()!='Y'){
				System.out.println("what is your stake?");
				int stake=ui.getNumber();
				player=new Player(name,stake);
			}
		}catch(FileNotFoundException e) {//if no file found get stake
			System.out.println("what is your stake?");
			int stake=ui.getNumber();
			player=new Player(name,stake);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Play() throws IOException {
		char play; 
		do{
			placeBets();
			throwDice();
			workOutWinnings();
			updatePlayerStake();
			if(player.getBanker() > 0 && player.getStake() >0 )
				play = ui.getEndRoundOption();
			else play='N';
		}while(play=='Y');
		ui.saveGame(player);
	}		
	public void placeBets()  {//done
		bets.clear();		
		char betAgain ='N';
		do{
			ui.displayBetMenu();
			char type = ui.getTypeOfBet();
			ui.displayWhatOnMenu();
			String what = ui.getSymbol();
			System.out.println("How much would you like to bet ?");
			int amount = ui.getNumber();
			//check their stake is >= amount
			if (player.getStake() >= amount){
				player.decStake(amount);
				player.incBanker(amount);
				switch(type){
				case '1':  OrdinaryBet bet = new OrdinaryBet(what,amount);
				bets.add(bet); break;
				case '2': DoubleOrNothing bet2 =new DoubleOrNothing(what,amount);
				bets.add(bet2); break;
				case '3': Allin bet3 =new Allin(what,amount);
				bets.add(bet3); break;
				}
				System.out.println("You have chosen to bet £" +amount+ " good luck with your bet.");
			}
			else{
				System.out.println("You do not have enough money to bet");
			}
			betAgain = ui.getEndRoundOption();
		}while(betAgain=='Y');

	}
	public void throwDice() {//done
		for( int i=0; i<3; i++ )
			dice[i].throwDice();
		System.out.println("the dice are: " + dice[0].getDice()+ ", " + dice[1].getDice()+ ", " + dice[2].getDice());//displays the dice that have rolled
	}	
	private void workOutWinnings(){//done
		ListIterator<Bet> iter = bets.listIterator();
		while (iter.hasNext()) {
			Bet aBet = (Bet)iter.next();
			int winnings = aBet.workOutWinnings(dice);
			player.incStake(winnings);
			player.decBanker(winnings);
		}
		//display player's stake
		System.out.println("This is your stake "+ player.getStake());
	}
	public List<Bet> getBets() {//done
		return bets;
	}
	private void updatePlayerStake(){
		System.out.println(" Do you want to increase your stake!");
		if(ui.getYN()=='Y')
			player.incStake(ui.getNumber());
	}
}


