package model;

import java.util.LinkedList;

public class Player {
	private int golds;
	private int healthPoints;
	private LinkedList<Battler> hand;
	private Shop shop;
    private String name;

    public Player(){
        this.golds=0;
        this.healthPoints=0;
        hand = new LinkedList<Battler>();
        shop = new Shop();
        name = "";
    }

    public Player(int golds, int healthPoints, String name){		
        this.golds=golds;
        this.healthPoints = healthPoints;
        hand = new LinkedList<Battler>();
        shop = new Shop();
        this.name = name;
    }

    public int getGolds(){
        return this.golds;
    }

    public int getHealthPoints(){
        return this.healthPoints;
    }

    public LinkedList<Battler> getHand(){
        return this.hand;
    }

    public Shop getShop(){
        return this.shop;
    }

    public String getName(){
        return this.name;
    }

    public int buy(int shopPosition){
        return 0;
    }

    public int dismiss(Battler battler){
        return 0;
    }

    public int refreshShop(){
        return 0;
    }

    public int freezeShop() {
        return 0;
    }
}