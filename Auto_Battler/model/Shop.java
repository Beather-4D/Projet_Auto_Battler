package model;

import java.util.ArrayList;

public class Shop {
    private int tier;
    private ArrayList<Battler> shopBattlers;

    public Shop(){
        this.tier = 1;
        shopBattlers = new ArrayList<Battler>();
    }

    public void changeBattlers(ArrayList<Battler> battlers){
        this.shopBattlers = battlers;
    }

    public int getTier(){
        return tier;
    }

    public ArrayList<Battler> getShopBattlers() {
        return shopBattlers;
    }
}
