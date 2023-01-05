package model;

import java.util.ArrayList;

public class Shop {
    private int tier;
    private int upgradeCost;
    private ArrayList<Battler> shopBattlers;

    public Shop(){
        this.tier = 1;
        upgradeCost = 5;
        this.shopBattlers = new ArrayList<Battler>();
        shopBattlers = Deck.refreshShop(this, this.tier);
    }

    public void changeBattlers(ArrayList<Battler> battlers){
        this.shopBattlers = battlers;
    }

    public int getTier(){
        return this.tier;
    }

    public void upgradeTier(){
        this.tier++;
        System.out.println("Votre Shop a été amélioré au tier "+this.tier);
    }

    public int getUpgradeCost(){
        return this.upgradeCost;
    }

    public void decreaseUpgradeCost(){
        this.upgradeCost--;
    }

    public void resetUpgradeCost(){
        this.upgradeCost = 5;
    }

    public ArrayList<Battler> getShopBattlers() {
        return this.shopBattlers;
    }

    public String toString(){
        String rep = "Votre Shop (tier "+ this.tier +" upgrade "+ this.upgradeCost +"g) : \n";
        for(Battler b : this.shopBattlers){
            rep += b.toString() + " ";
        }
        rep += "\n";
        return rep;
    }

}
