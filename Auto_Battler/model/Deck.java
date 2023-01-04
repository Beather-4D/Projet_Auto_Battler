package model;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private static ArrayList<Battler> deckBattlers;
    
    public Deck(){
        deckBattlers = new ArrayList<Battler>();
        Battler bilal = new Battler("Bilal",1, 1, 1, Tribes.ORC);
        Battler emilien = new Battler("Emilien",1, 2, 2, Tribes.DWARF);
        Battler baptiste = new Battler("Baptiste",1, 3, 3, Tribes.DWARF);
        Battler mael = new Battler("Mael",1, 4, 4, Tribes.ORC);
        Battler damien = new Battler("Damien",1, 5, 5, Tribes.ORC);
        Battler khassan = new Battler("Khassan",1, 6, 6, Tribes.DWARF);
        Battler khadim = new Battler("Khadim",1, 7, 7, Tribes.ORC);
        Battler rocky = new Battler("Rocky",1,10,10,Tribes.ORC);
        Battler santa = new Battler("Santa",1,100,100,Tribes.DWARF);
        Battler jul = new Battler("Jul",1,2,3,Tribes.ORC);
        Battler lucifer = new Battler("lucifer",1,666,666,Tribes.ORC);
        Battler surcotax = new Battler("surcotax",1,1,1,Tribes.ORC);
        deckBattlers.add(mael);
        deckBattlers.add(baptiste);
        deckBattlers.add(emilien);
        deckBattlers.add(bilal);
        deckBattlers.add(damien);
        deckBattlers.add(khassan);
        deckBattlers.add(khadim);
        deckBattlers.add(rocky);
        deckBattlers.add(santa);
        deckBattlers.add(jul);
        deckBattlers.add(lucifer);
        deckBattlers.add(surcotax);
    }
    
    public static ArrayList<Battler> refreshShop(Shop shop, int tier){
        ArrayList<Battler> rep = new ArrayList<Battler>();
        ArrayList<Battler> base = new ArrayList<Battler>();
        if(shop.getShopBattlers().size()>0){ //remise des battlers du shop
            for(Battler element : shop.getShopBattlers()){
                deckBattlers.add(element);
            }
        }
        for(int i = 0 ; i < deckBattlers.size() ; i++){ //récupération des battlers avec un rank <= au tier du shop du joueur
            Battler b = deckBattlers.get(i);
            //System.out.println(b.getName() + " est de tier " + b.getRank());
            if(b.getRank()<= tier){
                base.add(b);
                deckBattlers.remove(b);
                i--;
            }
        }
        //System.out.println("ICI base.size = " + base.size());
        if(base.size()<=3){ //Si il y a 3 battlers ou moins, on les prend direct
            for(Battler element : base){
                rep.add(element);
            }
            return rep;
        }
        //Si plus que 3 battlers, choix aléatoire
        Random r = new Random();
        ArrayList<Integer> nb = new ArrayList<Integer>();
        for(int i = 0 ; i < 3 ; i++){
            int x = r.nextInt(base.size());
            while(nb.contains(x)){
                x = r.nextInt(base.size());
            }
            rep.add(base.get(x));
            nb.add(x);
            base.remove(x);
        }
        for(Battler b : base){ //remise des battlers non choisis
            deckBattlers.add(b);
        }
        return rep;
    }

    /*public void refreshAllShops(ArrayList<Player> players){      
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
    }*/

    //retourne la liste des battlers
    public static ArrayList<Battler> getDeckBattlers(){
        return deckBattlers;
    }

    //retire un battler du deck
    public static void removeBattler(Battler battler){
        deckBattlers.remove(battler);
    }
}