package assessmentDiceGame;

import java.io.Serializable;

public class Player implements Serializable{//done dont mod
	private String name;
	private int stake;
	private int banker;

	public Player(){
		banker =100;
		this.name="";
		this.stake=0;
		}

	public Player(String name,int stake){
		this.name=name;
		this.stake=stake;
		banker =100;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStake() {
		return stake;
	}
	public void decStake(int stake) {
		this.stake-= stake;
	}
	public void incStake(int stake) {
		this.stake+= stake;
	}
	public int getBanker() {
		return banker;
	}
	public void incBanker(int banker){
		this.banker+= banker;
	}
	public void decBanker(int banker) {
		this.banker-= banker;
	}
}
