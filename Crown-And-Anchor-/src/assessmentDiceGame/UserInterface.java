package assessmentDiceGame;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {//error is save game
	private Scanner sc;
	public UserInterface(){//done
		sc = new Scanner(System.in);
	}
	public char getYN() {//done
		System.out.println("Please enter  Y or N");
		while (!sc.hasNext("[yYnN]")) {
			sc.next();
		}return sc.next().toUpperCase().charAt(0);
	}
	public char getTypeOfBet() {//done
		// working on it
		System.out.println("Please enter  a what kind of bet you are placing 1 = ordinary 2 = double or nothing 3 = all in");
		while (!sc.hasNext("[123]")) {
			System.out.println("That's not a vaild option!");
			System.out.println("please enter a kind of bet you are placing 1 = ordinary 2 = double or nothing 3 = all in");
			sc.next();
		}return sc.next().toUpperCase().charAt(0);
	}
	public void displayBetMenu() {//done
		System.out.println("Stuff to do");
		System.out.println("\t 1. Ordinary");
		System.out.println("\t 2. Double or Nothing");
		System.out.println("\t 3. All in");
	}
	public String getSymbol() {//done
		// working on it
		while (!sc.hasNext("[123456]")) {
			System.out.println("That's not a vaild option!");
			sc.next();
		}		
		switch(sc.next().charAt(0)){
		case '1': return "Crown";
		case '2': return "Anchor";
		case '3': return "Diamond";
		case '4': return "Spade";
		case '5': return "Club";
		case '6': return "Heart";
		}
		return null;
	}
	public void displayWhatOnMenu() {//done
		System.out.println("What do you want to bet on");
		System.out.println("\t 1. Crown");
		System.out.println("\t 2. Anchor");
		System.out.println("\t 3.Diamond");
		System.out.println("\t 4.Spade");
		System.out.println("\t 5.Club");
		System.out.println("\t 6.Heart");
	}
	public int getBetAmount() {//done
		System.out.print ("Please enter how much you want to bet £");
		return getNumber();
	}
	public String getName(){//done
		System.out.println("Enter name");
		String name;
		do{
			name = sc.nextLine();
		}while(empty(name));
		return name;
	}
	public boolean empty( final String s ) {
		// Null-safe, short-circuit evaluation.
		return s == null || s.trim().isEmpty();
	}
	public void displayBets(ArrayList<Bet> bets){
	}
	public char getEndRoundOption(){
		System.out.println("Would you like to play again?");
		return getYN();
	}
	public void displayMessage(String msg){
		System.out.println(msg);
	}
	public int getNumber(){//done
		int number;
		do {
			System.out.println(" Please enter a positive number!");
			while (!sc.hasNextInt()) {
				System.out.println("That's not a number!");
				sc.next();
			}
			number = sc.nextInt();
		} while (number <= 0);
		return number;
	} 
	public void saveGame(Player aPlayer) throws IOException{
		String filename = aPlayer.getName().toLowerCase() + ".ser";
		try{
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream outPlayer = new ObjectOutputStream(fileOut);
			outPlayer.writeObject(aPlayer);
			System.out.println("Game saved ...\n");
			outPlayer.close();
			fileOut.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}
