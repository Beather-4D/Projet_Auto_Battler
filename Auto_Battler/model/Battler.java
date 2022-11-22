package model;

public class Battler {
	private int rank;
	private int attack;
	private int healthPoints;
	private Tribes tribe;
	
	public Battler(){
		this.rank = 0;
		this.attack = 0;
		this.healthPoints = 0;
	}
	

	public Battler(int rank, int attack, int healthPoints, Tribes tribe){

		this.rank = rank;
		this.attack = attack;
		this.healthPoints = healthPoints;
		this.tribe = tribe;
	}
	
	//retourne le rang du battler
	public int getRank() {
		return rank;
	}
	
	//change le rang du battler
	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getAttack() {
		return attack;
	}

	public void changeAttack(int number) {
		this.attack += number;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void changeHealthPoints(int number) {
		this.healthPoints += number;
	}
	
	public Tribes getTribe(){
		return this.tribe;
	}
}
