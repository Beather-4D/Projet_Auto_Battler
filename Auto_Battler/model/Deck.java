package model;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Battler> deckBattlers;
    
    public Deck(){
        deckBattlers = new ArrayList<Battler>();
        Battler bilal = new Battler(1, 1, 1, Tribes.ORC);
        Battler emilien = new Battler(2, 2, 2, Tribes.DWARF);
        Battler baptiste = new Battler(3, 3, 3, Tribes.DWARF);
        Battler mael = new Battler(4, 4, 4, Tribes.ORC);
        deckBattlers.add(mael);
        deckBattlers.add(baptiste);
        deckBattlers.add(emilien);
        deckBattlers.add(bilal);
    }
    
    public void refreshShops(ArrayList<Player> players){      
        for(Player p : players){
            ArrayList<Battler> list = new ArrayList<Battler>();
            ArrayList<Integer> nb = new ArrayList<Integer>();
            Random r = new Random();
            for(int i = 0 ; i < 3 ; i++){
                int x = r.nextInt(deckBattlers.size());
                while(nb.contains(x)){
                    x = r.nextInt(deckBattlers.size());
                }
                list.add(deckBattlers.get(x));
                nb.add(x);
            }
            p.getShop().changeBattlers(list);
            //faire le retrait des battlers du deck
        }
    }
    
    public ArrayList<Battler> getDeckBattlers(){
        //retourne la liste des battlers
        return this.deckBattlers;
    }
}