package model;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private static ArrayList<Battler> deckBattlers;
    
    //constructeur du deck qui créait les battler avec de l'aléatoire dans les nom, attaque et hp
    public Deck(){
        try {
            deckBattlers = new ArrayList<Battler>();
            Random rd = new Random(System.currentTimeMillis());
            int rang = 1;
            for(int i = 0 ; i < 5 ; i++){
                Battler a = new Battler(nomRandom(rd.nextInt(4, 9)), rang, rd.nextInt(rang, rang+3), rd.nextInt(rang, rang+3), Tribes.ORC);
                rd.setSeed(System.currentTimeMillis()+rd.nextInt());
                Battler b = new Battler(nomRandom(rd.nextInt(4, 9)), rang, rd.nextInt(rang, rang+3), rd.nextInt(rang, rang+3), Tribes.DWARF);
                rd.setSeed(System.currentTimeMillis()+rd.nextInt()); 
                Battler c = new Battler(nomRandom(rd.nextInt(4, 9)), rang, rd.nextInt(rang, rang+3), rd.nextInt(rang, rang+3), Tribes.GOBLIN);
                rd.setSeed(System.currentTimeMillis()+rd.nextInt());
                deckBattlers.add(a);
                deckBattlers.add(b);
                deckBattlers.add(c);
                Thread.sleep(5);
            }
            rang++;
            for(int i = 0 ; i < 5 ; i++){
                Battler a = new Battler(nomRandom(rd.nextInt(4, 9)), rang, rd.nextInt(rang, rang+3), rd.nextInt(rang, rang+3), Tribes.DWARF);
                Battler b = new Battler(nomRandom(rd.nextInt(4, 9)), rang, rd.nextInt(rang, rang+3), rd.nextInt(rang, rang+3), Tribes.ORC);
                Battler c = new Battler(nomRandom(rd.nextInt(4, 9)), rang, rd.nextInt(rang, rang+3), rd.nextInt(rang, rang+3), Tribes.GOBLIN);
                deckBattlers.add(a);
                deckBattlers.add(b);
                deckBattlers.add(c);
                Thread.sleep(5);
            }
            rang++;
            for(int i = 0 ; i < 5 ; i++){
                Battler a = new Battler(nomRandom(rd.nextInt(4, 9)), rang, rd.nextInt(rang, rang+3), rd.nextInt(rang, rang+3), Tribes.ORC);
                Battler b = new Battler(nomRandom(rd.nextInt(4, 9)), rang, rd.nextInt(rang, rang+3), rd.nextInt(rang, rang+3), Tribes.DWARF);
                Battler c = new Battler(nomRandom(rd.nextInt(4, 9)), rang, rd.nextInt(rang, rang+3), rd.nextInt(rang, rang+3), Tribes.GOBLIN);
                deckBattlers.add(a);
                deckBattlers.add(b);
                deckBattlers.add(c);
                Thread.sleep(5);
            }
            rang++;
            for(int i = 0 ; i < 5 ; i++){
                Battler a = new Battler(nomRandom(rd.nextInt(4, 9)), rang, rd.nextInt(rang, rang+3), rd.nextInt(rang, rang+3), Tribes.ORC);
                Battler b = new Battler(nomRandom(rd.nextInt(4, 9)), rang,rd.nextInt(rang, rang+3),rd.nextInt(rang, rang+3), Tribes.ORC);
                Battler c = new Battler(nomRandom(rd.nextInt(4, 9)), rang, rd.nextInt(rang, rang+3), rd.nextInt(rang, rang+3), Tribes.GOBLIN);
                deckBattlers.add(a);
                deckBattlers.add(b);
                deckBattlers.add(c);
                Thread.sleep(5);
            }
            rang++;
            for(int k = 0 ; k < 5 ; k++){
                Battler a = new Battler(nomRandom(rd.nextInt(4, 9)), rang,rd.nextInt(rang, rang+3),rd.nextInt(rang, rang+3), Tribes.DWARF);
                Battler b = new Battler(nomRandom(rd.nextInt(4, 9)), rang,rd.nextInt(rang, rang+3),rd.nextInt(rang, rang+3), Tribes.ORC);
                Battler c = new Battler(nomRandom(rd.nextInt(4, 9)), rang, rd.nextInt(rang, rang+3), rd.nextInt(rang, rang+3), Tribes.GOBLIN);
                deckBattlers.add(a);
                deckBattlers.add(b);
                deckBattlers.add(c);
                Thread.sleep(5);
            }
            rang++;
            for(int i = 0 ; i < 5 ; i++){
                Battler a = new Battler(nomRandom(rd.nextInt(4, 9)), rang,rd.nextInt(rang, rang+3),rd.nextInt(rang, rang+3), Tribes.ORC);
                Battler b = new Battler(nomRandom(rd.nextInt(4, 9)), rang,rd.nextInt(rang, rang+3),rd.nextInt(rang, rang+3), Tribes.ORC);
                Battler c = new Battler(nomRandom(rd.nextInt(4, 9)), rang, rd.nextInt(rang, rang+3), rd.nextInt(rang, rang+3), Tribes.GOBLIN);
                deckBattlers.add(a);
                deckBattlers.add(b);
                deckBattlers.add(c);
                Thread.sleep(5);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    //renvoie une chaîne de caractère aléatoire
    private String nomRandom(int nb){
        String voyelle = "aeiouy";
        String consonne = "bcdfghjklmnpqrstvwxz";
        Random rd = new Random(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder(nb);
        for(int i = 0 ; i < nb ; i++){
            if(i%2==0){
                sb.append(consonne.charAt(rd.nextInt(consonne.length())));
            } else {
                sb.append(voyelle.charAt(rd.nextInt(voyelle.length())));
            }            
        }
        return sb.toString();
    }
    
    //change les battlers d'un shop
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
            if(b.getRank()<= tier){
                base.add(b);
                deckBattlers.remove(b);
                i--;
            }
        }
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
    
    //retourne la liste des battlers
    public static ArrayList<Battler> getDeckBattlers(){
        return deckBattlers;
    }
    
}