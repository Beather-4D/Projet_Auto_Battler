package model;

import java.util.ArrayList;

public class Shop {

    private int tier;
    private ArrayList<Battler> shopBattlers;

    public Shop(){
        this.tier = 1;
        this.shopBattlers = new ArrayList<Battler>();
    }


    public void changeBattlers(ArrayList<Battler> battlers){
        this.shopBattlers = battlers;
    }

    public int getTier(){

        return this.tier;
    }

    public void upgradeTier(){
        this.tier++;
    }

    public ArrayList<Battler> getShopBattlers() {
        return this.shopBattlers;
    }
}
