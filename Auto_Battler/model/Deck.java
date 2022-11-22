package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Deck {
    private static ArrayList<Battler> deckBattlers;
    
    public Deck(){
        deckBattlers = new ArrayList<Battler>();
        Battler bilal = new Battler(1, 1, 1, Tribes.ORC);
        Battler emilien = new Battler(2, 2, 2, Tribes.DWARF);
        Battler baptiste = new Battler(3, 3, 3, Tribes.DWARF);
        Battler mael = new Battler(4, 4, 4, Tribes.ORC);
        Battler damien = new Battler(5, 5, 5, Tribes.ORC);
        Battler khassan = new Battler(6, 6, 6, Tribes.DWARF);
        Battler khadim = new Battler(7, 7, 7, Tribes.ORC);
        deckBattlers.add(mael);
        deckBattlers.add(baptiste);
        deckBattlers.add(emilien);
        deckBattlers.add(bilal);
        deckBattlers.add(damien);
        deckBattlers.add(khassan);
        deckBattlers.add(khadim);
    }
    
    public static LinkedList<Battler> refreshSingleShop(Shop shop){
        LinkedList<Battler> rep = new LinkedList<Battler>();
        for(Battler element : shop.getShopBattlers()){
            deckBattlers.add(element);
        }
        Random r = new Random();
        ArrayList<Integer> nb = new ArrayList<Integer>();
        for(int i = 0 ; i < 3 ; i++){
            int x = r.nextInt(deckBattlers.size());
            while(nb.contains(x)){
                x = r.nextInt(deckBattlers.size());
            }
            rep.add(deckBattlers.get(x));
            nb.add(x);
        }
        return rep;
    }

    public void refreshAllShops(ArrayList<Player> players){      
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