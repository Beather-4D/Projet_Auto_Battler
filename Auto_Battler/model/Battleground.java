package model;

import java.util.LinkedList;

public class Battleground {
    private LinkedList<Battler> player1Battlers;
    private LinkedList<Battler> player2Battlers;
    
    public Battleground(){
        player1Battlers = new LinkedList<Battler>(); // IA
        player2Battlers = new LinkedList<Battler>(); //Joueur
    }
    
    public LinkedList<Battler> getPlayer1Battlers(){
        return player1Battlers;
    }
    
    public LinkedList<Battler> getPlayer2Battlers(){
        return player2Battlers;
    }
    
    public void addBattler(Battler b, int joueur){
        if(joueur == 1){
            player1Battlers.add(b);
        } else {
            player2Battlers.add(b);
        }
    }
    
    public void startFight(){
        
    }
    
    public void dealDamage(Player player, int damage){
        //inflige les dégâts de la défaite au joueur perdant
        player.reduceHealthPoints(damage);
    }
    
    public int calculateDamageAmount(){
        LinkedList<Battler> survivors;
        if(player1Battlers.size()==0){
            survivors = player2Battlers;
        } else {
            survivors = player1Battlers;
        }
        int sum = 0;
        for(Battler b : survivors){
            sum+=b.getRank();
        }
        return sum;
    }

    public String toString(){
        String rep = "Sélection de  : \n";
        for(Battler b : this.player1Battlers){
            rep += b.toString();
        }
        rep += "\nSélection du joueur 2 : \n";
        for(Battler b : this.player2Battlers){
            rep += b.toString();
        }
        return rep + "\n";
    }
}
