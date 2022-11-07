package model;

public class Shop {

    private int tier;

    private ArrayList<Battler> shopBattlers;

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
