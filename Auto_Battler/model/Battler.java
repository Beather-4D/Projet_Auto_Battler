package model;

public class Battler {
	private String name;
	private int rank;
	private int attack;
	private int healthPoints;
	private Tribes tribe;
	
	public Battler(){
		this.name = "Battler";
		this.rank = 1;
		this.attack = 1;
		this.healthPoints = 1;
	}
	
	public Battler(String name, int rank, int attack, int healthPoints, Tribes tribe){
		this.name = name;
		this.rank = rank;
		this.attack = attack;
		this.healthPoints = healthPoints;
		this.tribe = tribe;
	}
	
	//retourne le nom du battler
	public String getName(){
		return name;
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
