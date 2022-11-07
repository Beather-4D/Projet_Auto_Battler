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