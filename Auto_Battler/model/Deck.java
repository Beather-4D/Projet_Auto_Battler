package model;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Battler> deckBattlers;

    public Deck(){
        deckBattlers = new ArrayList<Battler>();
        Battler bilal = new Battler(1,1,1);
        Battler emilien = new Battler(2,2,2);
        Battler baptiste = new Battler(3,3,3);
        Battler mael = new Battler(4,4,4);
        deckBattlers.add(mael);
        deckBattlers.add(baptiste);
        deckBattlers.add(emilien);
        deckBattlers.add(bilal);
    }

    public void refreshShops(){

    }

    public ArrayList<Battler> getDeckBattlers(){
        //retourne la liste des battlers
        return this.deckBattlers;
    }
}