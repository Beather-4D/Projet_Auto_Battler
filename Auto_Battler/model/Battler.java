package model;

public class Battler {
	private int rank;
	private int attack;
	private int healthPoints;
	
	public Battler(){
		this.rank = 0;
		this.attack = 0;
		this.healthPoints = 0;
	}
	
	public Battler(int rank, int attack, int healthPoints){
		this.rank = rank;
		this.attack = attack;
		this.healthPoints = healthPoints;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getAttack() {
		return attack;
	}

	public void changeAttack(int bonus) {
		this.attack += bonus;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void changeHealthPoints(int number) {
		this.healthPoints += number;
	}
	
}
