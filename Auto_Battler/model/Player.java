package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player {
	private int golds;
	private int healthPoints;
	private LinkedList<Battler> hand;
	private Shop shop;
    private String name;

    public Player(){
        this.golds=3;
        this.healthPoints=20;
        hand = new LinkedList<Battler>();
        shop = new Shop();
        name = "Player";
    }

    public Player(String name){		
        this.golds=3;
        this.healthPoints = 20;
        hand = new LinkedList<Battler>();
        shop = new Shop();
        this.name = name;
    }

    //renvoie les golds du joueur
    public int getGolds(){
        return this.golds;
    }

    //ajoute des golds au joueur
    public void addGolds(int amount){
        this.golds += amount;
    }

    //retire des golds au joueur
    public void removeGolds(int amount){
        this.golds -= amount;
    }

    //renvoie les HPs du joueur
    public int getHealthPoints(){
        return this.healthPoints;
    }

    //réduit les HPs du joueur
    public void reduceHealthPoints(int amount){
        this.healthPoints -= amount;
    }

    //renvoie la main du joueur
    public LinkedList<Battler> getHand(){
        return this.hand;
    }

    //renvoie le shop du joueur
    public Shop getShop(){
        return this.shop;
    }

    //renvoie le nom du joueur
    public String getName(){
        return this.name;
    }
    //achète un battler du shop
    public void buy(int shopPosition){
        if(this.golds < 3){
            //gestion d'erreur 
        }
        Battler battler = this.shop.getShopBattlers().get(shopPosition);
        this.hand.add(battler);
        this.golds-=3;
    }

    public void dismiss(Battler battler){
        if(hand.contains(battler)==false){
            //gestion d'erreur
        }
        this.hand.remove(battler);
        this.golds++;
    }

    public void refreshShop(){
        ArrayList<Battler> list = this.shop.getShopBattlers();
        //Problème de lien entre game, deck et player
    }

    public void freezeShop() {
        
    }
}