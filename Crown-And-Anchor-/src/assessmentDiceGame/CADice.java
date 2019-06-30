package assessmentDiceGame;

public class CADice extends Dice{//done dont mod
	public CADice(){
		super();
	}
	public String getDice() {
		switch(getDiceFace()){
		case 1: return "Crown";
		case 2: return "Anchor";
		case 3: return "Diamond";
		case 4: return "Spade";
		case 5: return "Club";
		case 6: return "Heart";
		}
		return null;
	}

}
